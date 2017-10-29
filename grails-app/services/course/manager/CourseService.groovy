package course.manager

import grails.transaction.Transactional

@Transactional
class CourseService {

    def getAllProjectedCourses() {
        def courses = Course.createCriteria().list {
            projections {
                property('id')
                property('name')
            }
        }
        return courses
    }

    def getCoursesForUser(String username) {
        def courses = Course.withCriteria {
            students {
                eq("username", username)
            }
        }
        return courses
    }

    def getCoursesForUserId(Long id) {
        def courses = Course.withCriteria {
            students {
                eq("id", id)
            }
        }
        return courses
    }

    def getCourse(String username, String courseURL) {
        def course = Course.withCriteria(uniqueResult: true) {
            students {
                eq("username", username)
            }
            eq("url", courseURL)
        }
        return course
    }

    def getCourseProgress(String username, String courseUrl) {
        def progress = StudentProgress.withCriteria(uniqueResult: true) {
            student {
                eq("username", username)
            }
            course {
                eq("url", courseUrl)
            }
        }
    }

    def createCourseProgress(Person user, Course course) {
        def student = Student.findByPerson(user)
        def progress = new StudentProgress(course: course, student: student, lessons: []).save()
        return progress
    }

    def markLesson(String username, String courseName, String lessonName) {
        def lesson = getLessonForCourse(username, courseName, lessonName)
        if (lesson) {
            def studentProgress = getCourseProgress(username, courseName)
            studentProgress.addToLessons(lesson)
            studentProgress.save()
        }
    }

    def hasUserCourse(String username, String courseURL) {
        def course = Course.withCriteria(uniqueResult: true) {
            projections {
                property('url')
            }
            students {
                eq("username", username)
            }
            eq("url", courseURL)
        }
        return course
    }

    def getLessonForCourse(String username, String courseName, String lessonName) {
        def lesson = Lesson.withCriteria(uniqueResult: true) {
            course {
                students {
                    eq("username", username)
                }
                eq("url", courseName)
            }
            eq("url", lessonName)
        }
        return lesson
    }

    def addStudentToCourse(Long userId, Long courseId) {
        def course = Course.get(courseId)
        def student = Student.get(userId)
        if (course && student) {
            course.addToStudents(student)
            course.save()
            log.info("Se asignó el curso ${course.url} al usuario ${student.username}")
        } else {
            log.info("No se encontró estudiante($userId) o curso($courseId)")
            return [message: "No se encontró estudiante($userId) o curso($courseId)"]
        }
    }

    def removeStudentFromCourse(Long userId, Long courseId) {
        def course = Course.get(courseId)
        def student = Student.get(userId)
        if (course && student) {
            course.removeFromStudents(student)
            course.save()
            log.info("Se removio el curso ${course.url} al usuario ${student.username}")
        } else {
            log.info("No se encontró estudiante($userId) o curso($courseId)")
            return [message: "No se encontró estudiante($userId) o curso($courseId)"]
        }
    }

    def findById(Long id) {
        return Course.get(id)
    }


    def createCourse(CreateCourseCommand command) {
        def courseWithSameUrl = Course.findByUrl(command.url)
        if (courseWithSameUrl) {
            log.error("There is another course with the same URL")
            return [error: "There is another course with the same URL"]
        } else {
            def newCourse = new Course(
                    name: command.name,
                    url: command.url,
                    description: command.descript,
                    banner: command.banner,
                    welcome: command.welcome,
                    theoryButton: command.theoryButton,
                    theoryTitle: command.theoryTitle,
                    theory: command.theory
            ).save(flush: true, failOnError: true)

            if (newCourse.hasProperty('id')) {
                log.info("Course created: ${newCourse}")
                return [course: newCourse]
            } else {
                log.error("Can't save new course: ${command.errors}")
                return [error: "Can't save new course: ${command.errors}"]
            }

        }
    }
    
    def removeCourseWithId(Long id) {
        def course = findById(id)
        course.delete(flush: true)
    }


}

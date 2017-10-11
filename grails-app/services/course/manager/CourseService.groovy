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

    def getCourse(String username, String courseURL) {
        def course = Course.withCriteria(uniqueResult: true) {
            students {
                eq("username", username)
            }
            eq("url", courseURL)
        }
        return course
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

    def addStudentToCourse(String userId, String courseId) {
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

    def removeStudentFromCourse(String userId, String courseId) {
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


}

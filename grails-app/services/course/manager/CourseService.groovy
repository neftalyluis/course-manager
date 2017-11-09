package course.manager

import grails.transaction.Transactional

@Transactional
class CourseService {

    def googleCloudStorageService

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
                    theory: command.theory,
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

    def createLesson(CreateLessonCommand command) {
        if (command.validate()) {
            def lessonWithSameUrl = Lesson.findByUrl(command.url)
            def course = Course.get(command.courseId)
            if (lessonWithSameUrl) {

                log.error("There is another Lesson with the same URL")
                return [error: "There is another Lesson with the same URL"]

            } else if (course) {

                def newLesson = new Lesson(
                        name: command.name,
                        body: command.body,
                        url: command.url,
                        course: course,
                        numberLesson: getQuantityOfLessonsForCourse(command.courseId) + 1
                ).save(flush: true)

                if (newLesson.hasProperty('id')) {
                    log.info("Lesson created: ${newLesson}")
                    return [lesson: newLesson]
                } else {
                    log.error("Can't save new lesson: ${command.errors}")
                    return [error: "Can't save new lesson: ${command.errors}"]
                }

            } else {
                log.error("Course not found")
                return [error: "Course not found"]
            }
        } else {
            log.error("Error when creating Lesson, command not valid")
        }
    }

    def removeCourseWithId(Long id) {
        def course = findById(id)
        course.delete(flush: true)
    }

    Long getQuantityOfLessonsForCourse(Long courseId) {
        def totalOfLessons = Lesson.executeQuery("SELECT COUNT(l) FROM Lesson l WHERE l.course.id = :courseId",
                [courseId: courseId],
                [max: 1])
        return totalOfLessons[0] as Long
    }

    def getLesson(Long courseId, Long lessonId) {
        def lesson = Lesson.withCriteria(uniqueResult: true) {
            course {
                eq("id", courseId)
            }
            eq("id", lessonId)
        }
        return lesson
    }

    def getLesson(Long lessonId) {
        return Lesson.get(lessonId)
    }

    def getLessonFiles(Long lessonId) {
        def lessonFiles = LessonFile.withCriteria {
            lesson {
                eq("id", lessonId)
            }
        }
        return lessonFiles
    }

    def getLessonFromLessonFile(Long idLessonFile){
        def lesson = Lesson.withCriteria(uniqueResult: true) {
            lessonFiles {
                eq("id", idLessonFile)
            }
        }
        return lesson
    }

    def getLessonsForCourse(courseId) {
        def lessons = Lesson.withCriteria {
            course {
                eq("id", courseId)
            }
        }
        return lessons
    }

    def removeLesson(Long courseId, Long lessonId) {
        def lesson = getLesson(courseId, lessonId)
        if (lesson) {
            def dayOfLesson = lesson.numberLesson
            lesson.delete(flush: true)
            def lessons = getLessonsForCourse(courseId)
            lessons.each {
                if (it.numberLesson > dayOfLesson) {
                    it.numberLesson--
                    it.save(flush: true)
                }
            }
            log.info("Lesson removed: $lessonId")
            return [error: false]
        } else {
            log.error("Lesson: $lessonId or Course: $courseId not found")
            return [error: "Lesson or Course not found"]
        }
    }

    def updateCourse(UpdateCourseCommand command) {
        def course = Course.get(command.id)
        if (course) {
            course.name = command.name
            course.url = command.url
            course.description = command.descript
            course.banner = command.banner
            course.welcome = command.welcome
            course.theoryButton = command.theoryButton
            course.theoryTitle = command.theoryTitle
            course.theory = command.theory
            course.save(flush: true, failOnError: true)
            return [course: course]
        } else {
            return [error: "No se encontro curso con id: $command.id"]
        }
    }

    def updateLesson(UpdateLessonCommand command) {
        def lesson = Lesson.get(command.id)
        if (lesson) {
            lesson.name = command.name
            lesson.body = command.body
            lesson.url = command.url
            lesson.save(flush: true, failOnError: true)
            return [lesson: lesson]
        } else {
            return [error: "No se encontro curso con id: $command.id"]
        }
    }

    def addFileToLesson(Long lessonId, byte[] file, String contentType, String filename) {
        def lesson = Lesson.get(lessonId)
        if (lesson) {
            def bucket = "cursos/${lesson.course.url}/${lesson.url}/${filename}"
            log.info("Uploading file $filename")
            def uploadedFile = googleCloudStorageService.replaceObject(bucket, file, contentType)
            if (uploadedFile) {
                log.info("Signing file $filename")
                def signedUrl = googleCloudStorageService.getUrlForObject(bucket)
                log.info("Saving URL $signedUrl")
                def newLessonFile = new LessonFile(
                        lesson: lesson,
                        fileURL: signedUrl,
                        bucket: bucket,
                        name: filename).save(flush: true, failOnError: true)
                return newLessonFile
            } else {
                return [error: "Ocurrio un Error, intenta mas tarde"]
            }
        } else {
            return [error: "No se encontro leccion con id: $lessonId cuando se trata de agregar archivo"]
        }
    }

    //Debe de haber un epdo raro aqui, supongo que es con la relacion de Leccion
    def removeFileLesson(Long fileLessonId) {
        def fileLesson = LessonFile.get(fileLessonId)
        if (fileLesson) {
            def result = googleCloudStorageService.removeObject(fileLesson.bucket)
            log.info("Bucket removed $fileLesson.bucket")
            if (result) {
                def lesson = getLessonFromLessonFile(fileLessonId)
                lesson.removeFromLessonFiles(fileLesson)
                fileLesson.delete(flush: true, failOnError: true)
                log.info("FileLesson entity removed with id $fileLessonId ")
            } else {
                log.info("Can't remove LessonFileEntity with id $fileLessonId")
                return [error: "No se pudo eliminar LessonFile con if $fileLessonId"]
            }
        } else {
            log.info("No fileLessonId Found: $fileLessonId")
            return [error: "No se encontro Archivo de Leccion con id: $fileLessonId cuando se trata de eliminar archivo"]
        }
    }

    def addLessonImageToLesson(Long lessonId, byte[] file, String contentType, String filename) {
        def lesson = Lesson.get(lessonId)
        if (lesson) {
            log.info("Removing bucket for Lesson Photo $lesson.headerPhotoBucket")
            googleCloudStorageService.removeObject(lesson.headerPhotoBucket)
            def bucket = "cursos/${lesson.course.url}/${lesson.url}/${filename}"
            log.info("Uploading file $filename")
            def uploadedFile = googleCloudStorageService.replaceObject(bucket, file, contentType)
            if (uploadedFile) {
                log.info("Signing file $filename")
                def signedUrl = googleCloudStorageService.getUrlForObject(bucket)
                log.info("Saving URL $signedUrl")
                lesson.headerPhoto = signedUrl
                lesson.headerPhotoBucket = bucket
                lesson.save(flush: true)
                return lesson
            } else {
                return [error: "Ocurrio un Error, intenta mas tarde"]
            }
        } else {
            return [error: "No se encontro leccion con id: $lessonId cuando se trata de agregar archivo"]
        }
    }

    def addCoursePhoto(Long courseId, byte[] file, String contentType, String filename) {
        def course = Course.get(courseId)
        if (course) {
            log.info("Removing bucket for Course Photo $course.coursePhotoBucket")
            googleCloudStorageService.removeObject(course.coursePhotoBucket)
            def bucket = "cursos/${course.url}/${filename}"
            log.info("Uploading file $filename")
            def uploadedFile = googleCloudStorageService.replaceObject(bucket, file, contentType)
            if (uploadedFile) {
                log.info("Signing file $filename")
                def signedUrl = googleCloudStorageService.getUrlForObject(bucket)
                log.info("Saving URL $signedUrl")
                course.coursePhoto = signedUrl
                course.coursePhotoBucket = bucket
                course.save(flush: true)
                return course
            } else {
                return [error: "Ocurrio un Error, intenta mas tarde"]
            }
        } else {
            return [error: "No se encontro leccion con id: $courseId cuando se trata de agregar archivo"]
        }
    }

    def addLessonsPhoto(Long courseId, byte[] file, String contentType, String filename) {
        def course = Course.get(courseId)
        if (course) {
            log.info("Removing bucket for Course/Lessons Photo $course.lessonPhoto")
            googleCloudStorageService.removeObject(course.lessonPhotoBucket)
            def bucket = "cursos/${course.url}/${filename}"
            log.info("Uploading file $filename")
            def uploadedFile = googleCloudStorageService.replaceObject(bucket, file, contentType)
            if (uploadedFile) {
                log.info("Signing file $filename")
                def signedUrl = googleCloudStorageService.getUrlForObject(bucket)
                log.info("Saving URL $signedUrl")
                course.lessonPhoto = signedUrl
                course.lessonPhotoBucket = bucket
                course.save(flush: true)
                return course
            } else {
                return [error: "Ocurrio un Error, intenta mas tarde"]
            }
        } else {
            return [error: "No se encontro leccion con id: $courseId cuando se trata de agregar archivo"]
        }
    }

    def addTheoryPhoto(Long courseId, byte[] file, String contentType, String filename) {
        def course = Course.get(courseId)
        if (course) {
            log.info("Removing bucket for Theory Photo $course.theoryPhoto")
            googleCloudStorageService.removeObject(course.theoryPhotoBucket)
            def bucket = "cursos/${course.url}/${filename}"
            log.info("Uploading file $filename")
            def uploadedFile = googleCloudStorageService.replaceObject(bucket, file, contentType)
            if (uploadedFile) {
                log.info("Signing file $filename")
                def signedUrl = googleCloudStorageService.getUrlForObject(bucket)
                log.info("Saving URL $signedUrl")
                course.theoryPhoto = signedUrl
                course.theoryPhotoBucket = bucket
                course.save(flush: true)
                return course
            } else {
                return [error: "Ocurrio un Error, intenta mas tarde"]
            }
        } else {
            return [error: "No se encontro leccion con id: $courseId cuando se trata de agregar archivo"]
        }
    }

    def addFileCourse(Long courseId, byte[] file, String contentType, String filename) {
        def course = Course.get(courseId)
        if (course) {
            def bucket = "cursos/${course.url}/${filename}"
            log.info("Uploading file $filename")
            def uploadedFile = googleCloudStorageService.replaceObject(bucket, file, contentType)
            if (uploadedFile) {
                log.info("Signing file $filename")
                def signedUrl = googleCloudStorageService.getUrlForObject(bucket)
                log.info("Saving URL $signedUrl")
                def newCourseFile = new CourseFile(
                        course: course,
                        fileURL: signedUrl,
                        bucket: bucket,
                        name: filename).save(flush: true, failOnError: true)
                return newCourseFile
            } else {
                return [error: "Ocurrio un Error, intenta mas tarde"]
            }
        } else {
            return [error: "No se encontro curso con id: $courseId cuando se trata de agregar archivo"]
        }
    }

    def removeFileCourse(Long fileLessonId) {
        def fileLesson = CourseFile.get(fileLessonId)
        if (fileLesson) {
            def result = googleCloudStorageService.removeObject(fileLesson.bucket)
            log.info("Bucket removed $fileLesson.bucket")
            if (result) {
                fileLesson.delete(flush: true)
                log.info("FileLesson entity removed with id $fileLessonId ")
            } else {
                log.info("Can't remove LessonFileEntity with id $fileLessonId")
                return [error: "No se pudo eliminar CourseFile con id $fileLessonId"]
            }
        } else {
            log.info("No fileLessonId Found: $fileLessonId")
            return [error: "No se encontro Archivo de curso con id: $fileLessonId cuando se trata de eliminar archivo"]
        }
    }

}

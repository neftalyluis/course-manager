package course.manager

import grails.converters.JSON


class CourseManagerController {

    def courseService

    def index() {
        [courses: Course.findAll()]
    }

    def checkCourse() {
        def course = courseService.findById(params.long('id'))
        if (course) {
            courseService.getQuantityOfLessonsForCourse(params.long('id'))
            [course: course]
        } else {
            redirect uri: "/notFound"
        }
    }

    def create() {

    }

    def createCourse(CreateCourseCommand command) {
        def result = courseService.createCourse(command)
        if (!result.error) {
            flash.message = "Curso Creado"
            redirect(action: 'checkCourse', params: [id: result.course.id])
        } else {
            flash.error = "Ocurrio un error, intente en otro momento"
            redirect(action: 'index')
        }

    }

    def remove() {
        def courseId = params.long('id')
        if (courseId) {
            courseService.removeCourseWithId(courseId)
            log.info("Removing course with id $courseId")
            flash.message = "Se elimino el curso $params.id"
            redirect action: 'index'
        } else {
            log.error("No Id when calling action remove")
            flash.error = "Ocurrio un error, intenta de nuevo"
            redirect action: 'index'
        }
    }

    def updateCourse() {

    }


    def checkLesson() {
        Long courseId = params.long('courseId')
        Long lessonId = params.long('lessonId')
        if (courseId && lessonId) {
            def lesson = courseService.getLesson(courseId, lessonId)
            if (lesson) {
                response.status = 200
                render([lesson: lesson] as JSON)
            } else {
                response.status = 404
                render([error: "Not found"] as JSON)
            }
        } else {
            response.status = 400
            render([error: "Bad request"] as JSON)
        }

    }

    def checkFilesForLesson() {
        Long lessonId = params.long('lessonId')
        if (lessonId) {
            def lessonFiles = courseService.getLessonFiles(lessonId)
            if (lessonFiles) {
                render([lessonFiles: lessonFiles] as JSON)
            } else {
                response.status = 404
                render([error: "Not found"] as JSON)
            }
        } else {
            response.status = 400
            render([error: "Bad request"] as JSON)
        }
    }

    def addLessonToCourse(LessonCommand command) {
        def result = courseService.createLesson(command)
        if (!result.error) {
            flash.message = "Curso Creado"
            redirect(action: 'checkLesson', params: [id: result.lesson.id])
        } else {
            flash.error = "Ocurrio un error, intente en otro momento"
            redirect(action: 'index')
        }

    }
    //fffuck TODO
    def removeLessonFromCourse() {

    }

    def updateLesson() {

    }

}

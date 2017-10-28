package course.manager

class CourseManagerController {

    def courseService

    def index() {
        [courses: Course.findAll()]
    }

    def checkCourse() {
        def course = courseService.findById(params.long('id'))
        if (course) {
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
            def course = courseService.findById(courseId)
            course.delete()
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

    }

    //fffuck TODO
    def addLessonToCourse() {

    }
    //fffuck TODO
    def removeLessonFromCourse() {

    }

    def updateLesson() {

    }

}

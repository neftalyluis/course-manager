package course.manager

class CourseManagerController {

    def courseService

    def index() {
        [courses: Course.findAll()]
    }

    def checkCourse() {
        def course = courseService.findById(params.long('id'))
        [course: course]
    }

    def create() {

    }

    def remove() {
        def course = courseService.findById(params.long('id'))
        course.delete()
        flash.message = "Se elimino el estudiante $params.id"
        forward action: 'index'
    }

    def updateCourse() {

    }

    //fffuck TODO
    def addLessonToCourse() {

    }
    //fffuck TODO
    def removeLessonFromCourse() {

    }

}

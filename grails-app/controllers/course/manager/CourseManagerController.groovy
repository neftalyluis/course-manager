package course.manager

class CourseManagerController {

    def checkCourse() {

    }

    def index() {
        def courses = Course.findAll()
        [courses: courses]
    }

    def create() {

    }

    def remove() {

    }

    def updateCourse() {

    }

    def addLessonToCourse() {

    }

    def removeLessonFromCourse() {

    }

}

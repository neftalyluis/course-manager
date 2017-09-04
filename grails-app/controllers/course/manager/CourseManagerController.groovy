package course.manager

class CourseManagerController {

    def index() { 
        def courses = Course.findAll()
        [courses: courses]
    }
    
    def crear() {
    }
}

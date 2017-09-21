package course.manager


class CourseInterceptor {

    def springSecurityService
    def courseService

    CourseInterceptor() {
        match(controller: "course").excludes(action: "info").excludes(action: "courses")
    }

    boolean before() {
        def username = springSecurityService.currentUser?.username

        //We obtain the course url by splitting by slash and remove all null elements
        def course = request.forwardURI.split("/").findAll()[1]

        if (courseService.hasUserCourse(username, course)) {
            return true
        } else {
            view = "info"
        }
    }
}

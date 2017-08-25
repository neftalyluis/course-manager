package course.manager

class CoursePermissionInterceptor {

    def springSecurityService
    def courseService

    CoursePermissionInterceptor() {
        match(controller: "course").excludes(action: "info")
    }

    boolean before() {
        def username = springSecurityService.currentUser?.username

        println "interceptor $username"
        if (courseService.getCoursesForUser()) {
            return true
        } else {
            view = "info"
        }
    }

}

package course.manager

class CoursePermissionInterceptor {

    def springSecurityService

    CoursePermissionInterceptor() {
        match(controller: "course").excludes(action: "info")
    }

    boolean before() {
        def username = springSecurityService.currentUser?.username
        println "interceptor $username"
        if (username) {
            return true
        } else {
            view = "info"
        }
    }

}

package course.manager

import grails.plugin.springsecurity.SpringSecurityService
import groovy.transform.CompileStatic

@CompileStatic
class CourseInterceptor {

    SpringSecurityService springSecurityService
    CourseService courseService

    CourseInterceptor() {
        match(controller: "course").excludes(action: "info").excludes(action: "courses").excludes(action: "newLayout")
    }

    boolean before() {
        Person user = (Person) springSecurityService.getCurrentUser()
        String username = user.getUsername()

        //We obtain the course url by splitting by slash and remove all null elements
        String course = request.forwardURI
        course = course.split("/").findAll()[1]

        if (courseService.hasUserCourse(username, course)) {
            return true
        } else {
            view = "info"
        }
    }
}

package course.manager

import grails.plugin.springsecurity.SpringSecurityService
import groovy.transform.CompileStatic

@CompileStatic
class LessonInterceptor {

    SpringSecurityService springSecurityService
    CourseService courseService

    LessonInterceptor() {
        match(controller: "course")
                .excludes(action: "info")
                .excludes(action: "courses")
                .excludes(action: "lessons")
                .excludes(action: "theory")
                .excludes(action: "welcome")
    }

    boolean before() {
        Person user = (Person) springSecurityService.getCurrentUser()
        String username = user.getUsername()

        //We obtain the lesson url by splitting by slash and remove all null elements
        String lesson = request.forwardURI
        lesson = lesson.split("/").findAll()[3]

        if (courseService.getLessonWithURL(lesson)) {
            return true
        } else {
            def forward = request.forwardURI
            def referrer = request.getHeader('referer')
            log.error("El usuario ${username} trató de ingresar a la URL $forward desde $referrer")
            view = "info"
        }
    }
}
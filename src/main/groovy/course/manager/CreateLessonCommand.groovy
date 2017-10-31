package course.manager

import grails.validation.Validateable

class CreateLessonCommand implements Validateable {

    String name
    String body
    String url
    Long courseId

    static constraints = {
        name blank: false
        body blank: false
        url blank: false
    }

}

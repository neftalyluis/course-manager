package course.manager

import grails.validation.Validateable

class UpdateStudentCommand implements Validateable {

    Long studentId
    String name
    String email
    String description

    static constraints = {
        name blank: false
        email blank: false
        description blank: false
    }

}

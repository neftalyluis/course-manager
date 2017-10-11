package course.manager

import grails.validation.Validateable

class UpdateStudentCommand implements Validateable {

    String name
    String username
    String password
    String passwordConfirmation
    String urlAvatar
    String description

    static constraints = {
        name blank: false
        username blank: false
        password blank: false, minSize: 5
        passwordConfirmation blank: false, validator: {val, obj -> val == obj.passwordConfirmation}
    }

}

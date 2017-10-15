package course.manager

import grails.validation.Validateable

class StudentAndPersonCommand implements Validateable {

    String name
    String password
    String passwordConfirmation
    String email
    String description


    static constraints = {
        name blank: false
        email blank: false
        description blank: false
        password blank: false, minSize: 5
        passwordConfirmation validator: {
            val, obj -> obj.password == val
        }
    }


}

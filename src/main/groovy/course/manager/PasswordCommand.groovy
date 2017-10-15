package course.manager

import grails.validation.Validateable

class PasswordCommand implements Validateable {
    String password
    String passwordConfirmation
    Long id
    
    static constraints = {
        password blank: false, minSize: 5
        passwordConfirmation validator: {
            val, obj -> obj.password == val
        }
        
    }
	
}


package course.manager

import grails.validation.Validateable

class StudentAndPersonCommand implements Validateable {

    String name
    String username
    String password
    String urlAvatar
    String description
    def courseList = []


    static constraints = {
        name blank: false
        username blank: false
        password blank: false, minSize: 5
    }


}

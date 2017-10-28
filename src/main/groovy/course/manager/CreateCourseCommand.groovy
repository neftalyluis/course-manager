package course.manager

import grails.validation.Validateable

class CreateCourseCommand implements Validateable {

    String name
    String url
    String descript
    String banner
    String welcome
    String theoryButton
    String theoryTitle
    String theory

    static constraints = {
        name blank: false
        url blank: false
        descript blank: false
        banner blank: false
        welcome blank: false
        theoryButton blank: false
        theoryTitle blank: false
        theory blank: false
    }

}

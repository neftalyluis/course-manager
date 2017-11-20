package course.manager

class Lead {

    String email
    Date submitted

    static constraints = {
        email email: true, unique: true, blank: false
    }
}

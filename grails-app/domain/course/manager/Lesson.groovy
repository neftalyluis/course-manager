package course.manager

class Lesson {
    
    String name
    String body
    String headerPhoto
    Long order

    static constraints = {
        name blank: false
        body blank: false
        headerPhoto blank: false
        order blank: false
    }
}

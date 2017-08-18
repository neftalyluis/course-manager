package course.manager

class Student {

    static hasMany = [courses: Course]
    String name
    String username
    String urlAvatar
    String description

    static constraints = {
    }
}
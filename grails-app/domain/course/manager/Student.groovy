package course.manager

class Student {

    String name
    String username
    String urlAvatar
    String description

    static belongsTo = [person: Person]

    static constraints = {
        username blank: false, unique: true

    }
}
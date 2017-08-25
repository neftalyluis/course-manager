package course.manager

class Course {

    static hasMany = [lessons: Lesson, students: Student]
    String name
    String description
    String banner
    String welcome
    String theoryButton
    String coursePhoto
    String lessonPhoto
    String theory
    String theoryTitle
    String info


    static constraints = {

        name blank: false
        description blank: false
        banner blank: false
        welcome blank: false
        theoryButton blank: false
        coursePhoto blank: false
        lessonPhoto blank: false
        theory blank: false
        theoryTitle blank: false
        info blank: false

    }
}

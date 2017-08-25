package course.manager

class Lesson {

    static hasMany = [lessonFiles: LessonFile]
    String name
    String body
    String headerPhoto
    Long numeration

    static constraints = {
        name blank: false
        body blank: false
        headerPhoto blank: false
        numeration blank: false
    }
}

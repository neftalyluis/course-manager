package course.manager

class Lesson {

    static hasMany = [lessonFiles: LessonFile]
    //Cascading
    static belongsTo = [course: Course]
    String name
    String body
    String headerPhoto = ""
    String url
    Long numberLesson

    static constraints = {
        name blank: false
        body blank: false
        url blank: false
    }

    //Agregamos este mapping para que H2 y chance MySQL no la hagan de a pedo
    static mapping = {
        body sqlType: "text"
        headerPhoto sqlType: "text"
    }
}

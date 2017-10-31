package course.manager

class Lesson {

    static hasMany = [lessonFiles: LessonFile]
    //Cascading
    static belongsTo = [course: Course]
    String name
    String body
    String headerPhoto = ""
    String url
    //Orden de la leccion respecto a las otras lecciones
    Lesson afterLesson
    Long numberLesson
    static constraints = {
        name blank: false
        body blank: false
        url blank: false
        afterLesson nullable: true
    }

    static mappedBy = [afterLesson: "none"]

    //Agregamos este mapping para que H2 y chance MySQL no la hagan de a pedo
    static mapping = {
        body sqlType: "text"
        headerPhoto sqlType: "text"
    }
}

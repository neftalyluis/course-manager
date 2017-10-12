package course.manager

class LessonFile {

    //Cascading
    static belongsTo = [lesson: Lesson]
    String fileURL
    //The url on bucket for Cloud Storage
    String bucket
    String name
    //Indicates if the file is from Cloud Storage
    Boolean local = false

    static constraints = {
        fileURL blank: false
        name blank: false
    }

    //Agregamos este mapping para que no la haga de a pedo H2 e incluso MySQL
    static mapping = {
        fileURL sqlType: "text"
    }
}

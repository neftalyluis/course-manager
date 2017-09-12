package course.manager

class LessonFile {

    //Cascading
    static belongsTo = [lesson: Lesson]
    String fileURL
    String name

    static constraints = {
        fileURL blank: false
        name blank: false
    }
}

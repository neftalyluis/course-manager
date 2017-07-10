package course.manager

class LessonFile {
    
    String fileURL
    String name

    static constraints = {
        fileURL blank: false
        name blank: false
    }
}

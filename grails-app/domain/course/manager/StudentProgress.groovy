package course.manager

class StudentProgress {

    Student student
    Course course
    static hasMany = [lessons: Lesson]


    static constraints = {
    }
}

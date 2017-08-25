package course.manager

import grails.transaction.Transactional

@Transactional
class CourseService {

    def getCoursesForUser(String username) {
        def student = Student.findByUsername(username)
        return student.courses
    }

    def getAllLessonsForCourse(String username, String courseName) {
        def student = Student.findByUsername(username)
        def course = Course.findByNameAndStudents(courseName, [student] as Set)
        return course.lessons
    }

    def getLessonForCourse(String username, String courseName, String lessonName) {
        def student = Student.findByUsername(username)
        def course = Course.findByNameAndStudents(courseName, [student] as Set)
        def lesson = Lesson.findByNameAndCourse(lessonName, course)
        return lesson
    }

    def getCourse(String username, String courseName) {
        def student = Student.findByUsername(username)
        def course = Course.findByNameAndStudents(courseName, [student] as Set)
        return course
    }


}

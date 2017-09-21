package course.manager


class CourseController {

    def springSecurityService
    def courseService

    def courses() {
        def username = springSecurityService.currentUser.username
        def courses = courseService.getCoursesForUser(username)
        [courses: courses]
    }

    def lessons(String idCurso) {
        def username = springSecurityService.currentUser?.username
        def course = courseService.getCourse(username, idCurso)
        [course: course]
    }

    def info(String idCurso) {
        def username = springSecurityService.currentUser?.username
        def course = courseService.getCourse(username, idCurso)

        [info: course.info]
    }

    def theory(String idCurso) {
        def username = springSecurityService.currentUser?.username
        def course = courseService.getCourse(username, idCurso)

        [theory: course.theory]
    }

    def welcome(String idCurso) {
        def username = springSecurityService.currentUser?.username
        def course = courseService.getCourse(username, idCurso)

        [welcome: course.welcome, course: idCurso]
    }

    def getLesson(String idCurso, String idLeccion) {
        def username = springSecurityService.currentUser?.username
        def lesson = courseService.getLessonForCourse(username, idCurso, idLeccion)

        [lesson: lesson]
    }

}

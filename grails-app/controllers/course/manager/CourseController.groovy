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
        def progress = courseService.getCourseProgress(username, idCurso)
        if (!progress) {
            progress = courseService.createCourseProgress(springSecurityService.currentUser, course)
        }
        [course: course, progress: progress, layout: course.newLayout]
    }

    def info(String idCurso) {
        def username = springSecurityService.currentUser?.username
        def course = courseService.getCourse(username, idCurso)

        [info: course.info]
    }

    def theory(String idCurso) {
        def username = springSecurityService.currentUser?.username
        def course = courseService.getCourse(username, idCurso)

        [theory: course.theory, layout: course.newLayout]
    }

    def welcome(String idCurso) {
        def username = springSecurityService.currentUser?.username
        def course = courseService.getCourse(username, idCurso)

        [welcome: course.welcome, course: idCurso, layout: course.newLayout]
    }

    def getLesson(String idCurso, String idLeccion) {
        def username = springSecurityService.currentUser?.username
        def lesson = courseService.getLessonForCourse(username, idCurso, idLeccion)
        def course = courseService.getCourse(username, idCurso)

        [lesson: lesson, courseUrl: idCurso, layout: course.newLayout]
    }

    def markLesson(String idCurso, String idLeccion) {
        def username = springSecurityService.currentUser?.username
        courseService.markLesson(username, idCurso, idLeccion)

        redirect(uri: "/cursos/${idCurso}/lecciones/")
    }

    def newLayout() {

    }

}

package course.manager

class CourseController {

    def springSecurityService

    def courses() {
    }

    def lessons(String idCurso) {
        println idCurso
    }

    def info(String idCurso) {
        println "info $idCurso"

    }

    def theory(String idCurso) {
        println idCurso

    }

    def welcome(String idCurso) {
        println idCurso

    }

    def getLesson(String idCurso, String idLeccion) {
        println idCurso
        println idLeccion
    }

}

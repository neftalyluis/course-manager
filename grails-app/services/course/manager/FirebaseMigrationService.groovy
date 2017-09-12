package course.manager

import grails.transaction.Transactional
import groovy.json.JsonSlurper

@Transactional
class FirebaseMigrationService {

    def process(InputStream jsonFirebase) {
        def json = null
        try {
            json = new JsonSlurper().parse(jsonFirebase)
        } catch (all) {
            log.info("Invalid File for JSON Parsing: ${all}")
        }
        if (json) {
            def courseList = []
            json.cursos.each {
                courseList << createCourse(it)
            }

            return [result: true, courses: courseList]
        } else {
            return [result: false, message: "Bad JSON File"]
        }
    }

    def createCourse(courseNode) {
        def course = new Course(name: courseNode.value.nombre, description: courseNode.value.descripcion,
                theory: courseNode.value.teoria, theoryButton: courseNode.value.botonTeoria,
                theoryTitle: courseNode.value.teoriaTitulo, url: courseNode.key, welcome: courseNode.value.bienvenida, info: "TEST", banner: "TEST", coursePhoto: courseNode.value.fotoCursos, lessonPhoto: courseNode.value.fotoLecciones)
        def lessons = []
        courseNode.value.lecciones.each {
            lessons << createLesson(it, course)
        }
        course.lessons = lessons
        if (!course.save()) {
            course.errors.allErrors.each {
                println it
            }
        }
        log.info("Created Course ${course.name} with ${course.lessons.size()} Lessons")
        return course
    }

    def createLesson(lessonNode, courseEntity) {
        def files = []
        lessonNode.value.archivos.each {
            files << new LessonFile(name: it, fileURL: it)
        }
        return new Lesson(name: lessonNode.value.nombre, url: lessonNode.key, headerPhoto: lessonNode.value.header,
                body: lessonNode.value.cuerpo, numberLesson: lessonNode.value.id, lessonFiles: files, course: courseEntity)
    }
}

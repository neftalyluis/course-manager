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
                log.error("error = ${it.getField()},  ${it.getDefaultMessage()}")
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

    def recoverUsersFromCLI() {
        def firebaseProjectId = "amor-a-mi-d48eb"
        def outputFileRoute = "/Users/macmini-vinco/auth.json"
        def firebaseBinaryRoute = "/Users/macmini-vinco/.nvm/versions/node/v6.11.3/bin/firebase"
        def stdOutput = new StringBuilder(), stdError = new StringBuilder()
        def proc = ["/bin/sh", "-c", "${firebaseBinaryRoute} auth:export ${outputFileRoute} --project ${firebaseProjectId}"].execute()
        proc.consumeProcessOutput(stdOutput, stdError)
        proc.waitForOrKill(30000)
        if (stdError) {
            log.error("Can´t import from Firebase CLI: ${stdError}")
        } else {
            log.info("Firebase CLI response: ${stdOutput}")
            def jsonFile = new File(outputFileRoute)
            if (jsonFile.exists()) {
                def jsonObject = new JsonSlurper().parse(jsonFile)
                return createUsers(jsonObject)
            } else {
                log.error("Error on the File specified: ${outputFileRoute}, Firebase CLI responses: ${stdOutput}, ${stdError}")
            }
        }
    }

    def createUsers(jsonObject) {
        def usersList = []
        jsonObject.users.each {
            if (!Person.findByUsername(it.email)) {
                def personObj = new Person(username: it.email, password: it.salt, accountCreated: new Date()).save(failOnError: true)
                new Student(name: "Editar", username: it.email, urlAvatar: "Editar", description: "Editar", person: personObj).save(failOnError: true)
                usersList << personObj
            }
        }
        return usersList
    }

}

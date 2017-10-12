package course.manager

import grails.transaction.Transactional
import groovy.json.JsonSlurper

@Transactional
class FirebaseMigrationService {

    def googleCloudStorageService

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
        def coursePhoto = googleCloudStorageService.getUrlForObject("cursos/${courseNode.key}/${courseNode.value.fotoCursos}")
        def lessonPhoto = googleCloudStorageService.getUrlForObject("cursos/${courseNode.key}/${courseNode.value.fotoLecciones}")
        def course = new Course(name: courseNode.value.nombre, description: courseNode.value.descripcion,
                theory: courseNode.value.teoria, theoryButton: courseNode.value.botonTeoria,
                theoryTitle: courseNode.value.teoriaTitulo, url: courseNode.key, welcome: courseNode.value.bienvenida, info: "TEST", banner: "TEST", coursePhoto: coursePhoto, lessonPhoto: lessonPhoto)
        def lessons = []
        courseNode.value.lecciones.sort { it.value.id }.each {
            if (lessons.empty) {
                lessons << createLesson(it, course, null)
            } else {
                lessons << createLesson(it, course, lessons.last())
            }
        }
        lessons.eachWithIndex { item, index ->
            item.numberLesson = index + 1
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

    def createLesson(lessonNode, courseEntity, previousLesson) {
        def files = []
        lessonNode.value.archivos.each {
            def bucket = "cursos/${courseEntity.url}/${lessonNode.key}/${it}"
            def urlFromBlob = googleCloudStorageService.getUrlForObject(bucket)
            files << new LessonFile(name: it, fileURL: urlFromBlob, bucket: bucket)
        }
        def urlHeaderPhoto = googleCloudStorageService.getUrlForObject("cursos/${courseEntity.url}/${lessonNode.key}/${lessonNode.value.header}")
        return new Lesson(name: lessonNode.value.nombre, url: lessonNode.key, headerPhoto: urlHeaderPhoto,
                body: lessonNode.value.cuerpo, afterLesson: previousLesson, lessonFiles: files, course: courseEntity)
    }

    def recoverUsersFromCLI(String firebaseProjectId, String outputFileRoute, String firebaseBinaryRoute) {
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

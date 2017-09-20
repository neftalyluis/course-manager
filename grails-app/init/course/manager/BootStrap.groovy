package course.manager

class BootStrap {

    def grailsApplication
    def springSecurityService
    def firebaseMigrationService

    def init = { servletContext ->

        if (!Course.count()) {
            log.info("No Courses Found, making bootstrapping from 18/09/17 backups")
            def filePath = "resources/firebase.json"
            def streamJson = grailsApplication.getParentContext().getResource("classpath:$filePath").getInputStream()
            firebaseMigrationService.process(streamJson)

        }

        if (!Student.count() && !Person.count()) {
            log.info("No Student and Persons found, making request to Firebase")
            def result = firebaseMigrationService.recoverUsersFromCLI()
            log.info("Persisted ${result.size()} new Students From Firebase API")
        }

        def adminRole = new Authority(authority: "ROLE_ADMIN").save()
        def admin = new Person(username: "admin", password: "test", accountCreated: new Date()).save(flush: true, failOnError: true)
        def adminWithRole = PersonAuthority.create(admin, adminRole, true)
        def adminStudentMock = new Student(username: admin.username, name: "admin", person: admin, urlAvatar: "urlavatar", description: "description")
        if (!adminStudentMock.save()) {
            adminStudentMock.errors.allErrors.each {
                log.error("error = ${it.getField()},  ${it.getDefaultMessage()}")
            }
        }

        def userRole = new Authority(authority: "ROLE_STUDENT").save()
        def user = new Person(username: "student", password: "test", accountCreated: new Date()).save(flush: true, failOnError: true)
        def userWithRole = PersonAuthority.create(user, userRole, true)
        def userStudentMock = new Student(username: user.username, name: "user", person: user, urlAvatar: "urlavatar", description: "description")
        if (!userStudentMock.save()) {
            userStudentMock.errors.allErrors.each {
                log.error("error = ${it.getField()},  ${it.getDefaultMessage()}")
            }
        }

        def listStudents = [adminStudentMock, userStudentMock]
        for (def course in Course.list()) {
            course.students = listStudents
            course.save(failOnError: true)
        }

        for (String url in [
                '/', '/error', '/index', '/index.gsp', '/**/favicon.ico',
                '/**/js/**', '/**/css/**', '/**/images/**',
                '/login', '/login.*', '/login/*',
                '/logout', '/logout.*', '/logout/*', '/firebaseMigration/*', '/cursos/**', '/**']) {
            new Requestmap(url: url, configAttribute: 'permitAll').save(failOnError: true)
        }

        springSecurityService.clearCachedRequestmaps()

    }

    def destroy = {
    }
}

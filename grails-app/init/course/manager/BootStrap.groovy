package course.manager

import grails.util.Environment


class BootStrap {

    def grailsApplication
    def springSecurityService

    def init = { servletContext ->

        if(Environment.current != Environment.PRODUCTION) {

            def adminRole = new Authority(authority: "ROLE_ADMIN").save()
            def admin = new Person(username: "admin", password: "test", accountCreated: new Date()).save(flush: true, failOnError: true)
            def adminWithRole = PersonAuthority.create(admin, adminRole, true)
            def adminStudentMock = new Student(username: admin.username, name: "admin", person: admin, urlAvatar: "", bucket: "bucket", description: "description")
            if (!adminStudentMock.save()) {
                adminStudentMock.errors.allErrors.each {
                    log.error("error = ${it.getField()},  ${it.getDefaultMessage()}")
                }
            }

            def userRole = new Authority(authority: "ROLE_STUDENT").save()
            def user = new Person(username: "student", password: "test", accountCreated: new Date()).save(flush: true, failOnError: true)
            def userWithRole = PersonAuthority.create(user, userRole, true)
            def userStudentMock = new Student(username: user.username, name: "user", person: user, urlAvatar: "", bucket: "bucket", description: "description")
            if (!userStudentMock.save()) {
                userStudentMock.errors.allErrors.each {
                    log.error("error = ${it.getField()},  ${it.getDefaultMessage()}")
                }
            }
            def adminWithStudentRole = PersonAuthority.create(admin, userRole, true)

            def listStudents = [adminStudentMock, userStudentMock]
            for (def course in Course.list()) {
                course.students = listStudents
                course.save(failOnError: true)
            }

            for (String url in [
                    '/', '/error', '/index', '/index.gsp', '/**/favicon.ico',
                    '/**/js/**', '/**/css/**', '/**/images/**',
                    '/login', '/login.*', '/login/*',
                    '/logout', '/logout.*', '/logout/*', '/recoverPassword/**', '/landings/**', "/ebook-gratis/**", "/testimonios/**"]) {
                new Requestmap(url: url, configAttribute: 'permitAll').save(failOnError: true)
            }

            for (String url in ['/course/**', '/cursos/**', '/perfil/**', '/profile/**']) {
                new Requestmap(url: url, configAttribute: 'ROLE_STUDENT').save(failOnError: true)
            }

            for (String url in ['/courseManager/**', '/firebaseMigration/**', '/student/**', '/dbconsole/**', '/leads/**']) {
                new Requestmap(url: url, configAttribute: 'ROLE_ADMIN').save(failOnError: true)
            }

            springSecurityService.clearCachedRequestmaps()

        }
    }

    def destroy = {
    }
}

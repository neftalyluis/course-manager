package course.manager

class BootStrap {

    def springSecurityService

    def init = { servletContext ->

        def adminRole = new Authority(authority: "ROLE_ADMIN").save()
        def admin = new Person(username: "admin", password: "test").save()
        def adminWithRole = PersonAuthority.create(admin, adminRole, true)


        def userRole = new Authority(authority: "ROLE_STUDENT").save()
        def user = new Person(username: "student", password: "test").save()
        def userWithRole = PersonAuthority.create(user, userRole, true)

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

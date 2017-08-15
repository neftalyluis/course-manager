package course.manager

class BootStrap {

    def springSecurityService

    def init = { servletContext ->

        def userRole = new Authority(authority: "admin").save()
        def admin = new Person(username: "admin", password: "test").save()
        def roleandUser = PersonAuthority.create(admin, userRole, true)

        for (String url in [
                '/', '/error', '/index', '/index.gsp', '/**/favicon.ico',
                '/**/js/**', '/**/css/**', '/**/images/**',
                '/login', '/login.*', '/login/*',
                '/logout', '/logout.*', '/logout/*', '/firebaseMigration/*']) {
            new Requestmap(url: url, configAttribute: 'permitAll').save(failOnError: true)
        }

        springSecurityService.clearCachedRequestmaps()

    }
    def destroy = {
    }
}

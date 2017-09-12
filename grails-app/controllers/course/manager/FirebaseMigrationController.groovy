package course.manager

/**
 * Controlador que maneja
 */
class FirebaseMigrationController {

    def firebaseMigrationService

    static allowedMethods = [index: "GET", processJSON: "POST"]

    def index() {

    }

    def processJSON() {
        def jsonfile = request.getFile('firebase')
        if (jsonfile.empty) {
            flash.message = 'file cannot be empty'
            render(view: 'uploadForm')
            return
        }

        def result = firebaseMigrationService.process(jsonfile.inputStream)

        [json: result]
    }
}

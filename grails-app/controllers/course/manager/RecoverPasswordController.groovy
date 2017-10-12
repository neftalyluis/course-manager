package course.manager

import grails.converters.JSON
import org.apache.commons.validator.routines.EmailValidator

class RecoverPasswordController {

    def recoverPasswordService

    def index() {

    }

    def notification() {
        def validator = EmailValidator.getInstance()
        if (params.email) {

            recoverPasswordService.sendMail(params.email)

            flash.message = "Si el mail que especificaste existe en nuestro sistema, te enviaremos una liga para cambiar tu contraseña"
            redirect(action: 'index')
        } else {
            response.status = 400
            render([message: "BadRequest"] as JSON)
        }
    }

    def redeem() {
        if (params.token) {
            def username = recoverPasswordService.validToken(params.token)
            if (username) {
                [token: params.token, username: username]
            } else {
                flash.message = "El link no existe o ya no es valido, intenta nuevamente"
                redirect(action: 'index')
            }
        } else {
            response.status = 400
            render([message: "BadRequest"] as JSON)
        }
    }

    def changePassword() {
        if (params.token && params.password && params.password.size() > 5 && recoverPasswordService.validToken(params.token)) {
            if (recoverPasswordService.redeemToken(params.password, params.token)) {
                flash.message = "Se ha cambiado la contraseña"
                redirect(controller: 'login', action: 'index')
            } else {
                flash.message = "Ha ocurrido un error, intenta nuevamente"
                redirect(action: 'index')
            }
        } else {
            flash.message = "El link no existe o ya no es valido, intenta nuevamente"
            redirect(action: 'index')
        }
    }

}

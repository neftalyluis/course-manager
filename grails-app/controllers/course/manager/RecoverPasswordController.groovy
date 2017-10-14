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
            flash.message = "Por favor ingresa tu email"
            redirect(action: 'index')
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
        if (params.token && recoverPasswordService.validToken(params.token)) {
            if (params.password && params.password.size() > 5 && params.passwordConfirmation && params.passwordConfirmation == params.password) {
                if (recoverPasswordService.redeemToken(params.password, params.token)) {
                    flash.message = "Se ha cambiado la contraseña"
                    redirect(controller: 'login', action: 'auth')
                } else {
                    flash.error = "Ha ocurrido un error, intenta nuevamente"
                    redirect(action: 'index')
                }
            } else {
                flash.error = "Las contraseñas no coinciden o son de una longitud menor a 5 caracteres"
                redirect(action: 'redeem', params: [token: params.token])
            }
        } else {
            flash.error = "El link no existe o ya no es valido, intenta nuevamente"
            redirect(action: 'index')
        }
    }

}

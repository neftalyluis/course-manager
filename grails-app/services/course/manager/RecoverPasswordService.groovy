package course.manager

import grails.transaction.Transactional

import static java.util.UUID.randomUUID

@Transactional
class RecoverPasswordService {

    def createToken(Person person) {
        def today = new Date()
        def token = new RecoverPassword(creationDate: today, expirationDate: today.next(), toChange: person, token: randomUUID() as String)
        token.save()
        return token
    }

    def sendMail(String email) {
        def person = Person.findByUsername(email)
        if (person) {
            def tokenEntity = createToken(person)
            if (tokenEntity.id) {
                log.info "Email sent to ${tokenEntity.toChange.username}"
            } else {
                log.info "Can't create token: $tokenEntity"
            }
        } else {
            log.info "Student not found with Email: $email"
        }

    }

    def redeemToken(String newPassword, String token) {
        def tokenEntity = RecoverPassword.findByToken(token)
        def user = tokenEntity.toChange

        if (tokenEntity) {
            tokenEntity.redeemed = true
            tokenEntity.save()
            user.password = newPassword
            user.save()
            log.info "Password changed for ${user.username}"
            return true
        } else {
            log.warn "Error when changing password for ${user.username}"
            return false
        }
    }

    def validToken(String token) {
        def tokenEntity = RecoverPassword.findByToken(token)
        if (tokenEntity && tokenEntity.expirationDate.after(new Date()) && !tokenEntity.redeemed) {
            return tokenEntity.toChange.username
        } else {
            return false
        }
    }
}

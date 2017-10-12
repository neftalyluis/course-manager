package course.manager

class RecoverPassword {

    Date creationDate
    Date expirationDate
    String token
    Person toChange
    Boolean redeemed = false

    static constraints = {
    }
}

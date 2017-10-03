package course.manager

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class Person implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    Date accountCreated = new Date()
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Authority> getAuthorities() {
        (PersonAuthority.findAllByPerson(this) as List<PersonAuthority>)*.authority as Set<Authority>
    }

    static constraints = {
        password blank: false, password: true
        username blank: false, unique: true
    }

    static mapping = {
        password column: '`password`'
    }
}

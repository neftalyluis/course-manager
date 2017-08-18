package course.manager

import grails.transaction.Transactional
import groovy.json.JsonSlurper

@Transactional
class FirebaseMigrationService {

    def process(String jsonFirebase) {
        try {
            def mapJson = new JsonSlurper().parseText(jsonFirebase)
        } catch (all) {
            println "invalido"
        }
    }
}

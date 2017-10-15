/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.manager

import grails.transaction.Transactional

/**
 *
 * @author neftaly
 */
@Transactional
class StudentService {

    def getAll() {
        return Student.list()
    }

    def findById(Long id) {
        return Student.get(id)
    }

    def findByUsername(String username) {
        return Student.findByUsername(username)
    }

    def createPersonAndStudent(StudentAndPersonCommand command) {

        def person = new Person(
            password: command.password,
            username: command.email).save()
        
        def authority = Authority.findByAuthority("ROLE_STUDENT")
        def personAuth = PersonAuthority.create(person, authority)
        

        def newStudent = new Student(name: command.name,
            username: command.email,
            urlAvatar: "test",
            bucket: 'test',
            description: command.description,
            person: person
        )

        return [student: newStudent.save(flush: true)]

    }

    def updatePersonAndStudent(UpdateStudentCommand command) {

        def student = Student.get(command.studentId)
        def person = student.person
        if (student) {
            student.name = command.name
            student.username = command.email
            person.username = command.email
            student.description = command.description
            student.save()
            person.save()
        } else {
            return [message: "No se encontro Estudiante con nombre de usuario: $command.username"]
        }

    }
    
    def updatePassword(PasswordCommand command) {

        def student = Student.get(command.id)
        def person = student.person
        if (student) {
            person.password = command.password
            person.save()
            log.info "Se actualiza password de estudiante ${student.username}"
        } else {
            return [message: "No se encontro Estudiante con nombre de usuario: $command.username"]
        }

    }
    
    def removePersonandStudent(Long id) {
        def student = Student.get(id)
        def person = Person.findByUsername(student.username)
        log.info("Se remueve Estudiante con ID: $id y usuario $student.username")
        PersonAuthority.removeAll(person)
        student.delete()
        person.delete()
    }
}


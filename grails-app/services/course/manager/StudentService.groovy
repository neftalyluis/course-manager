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

        def student = Student.findByUsername(command.username)
        if (student) {


        } else {
            return [message: "No se encontro Estudiante con nombre de usuario: $command.username"]
        }

    }
}


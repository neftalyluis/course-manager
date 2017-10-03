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

        def newStudent = Student(name: command.name,
                username: command.username,
                urlAvatar: command.urlAvatar,
                description: command.description,
                person: new Person(
                        password: command.password,
                        username: command.username).save()
        ).save()

        if (command.courseList) {
            for (courseId in command.courseList) {
                def course = Course.get(courseId)
                if (course) {
                    course.students << newStudent
                    course.save()
                }
            }
        }

        return [student: newStudent]

    }
}


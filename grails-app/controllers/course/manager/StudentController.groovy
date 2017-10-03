/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.manager

/**
 *
 * @author neftaly
 */
class StudentController {

    def studentService
    def courseService

    def index() {
        [students: studentService.getAll()]
    }

    def checkStudent() {
        def student = studentService.findById(params.long('id'))
        [courses: courseService.getAllProjectedCourses(), student: student, ]
    }

    def create(StudentAndPersonCommand command) {
        if (command == null) {
            render status: HttpStatus.NOT_FOUND
            return
        }

        if (command.hasErrors()) {
            flash.error = command.errors
            render view: 'create'
            return
        }

        def newStudent = studentService.createPersonAndStudent(command)

        if (newStudent.id) {
            redirect(action: 'checkStudent', params: [id: newStudent.id])
        } else {
            flash.error = "Ocurrio un error, intente nuevamente"
            return
        }
    }

    def remove() {
        def student = studentService.findById(params.id)
        student.delete()
        flash.message = "Se elimino el estudiante $params.id"
        forward action: 'index'
    }

    def updateStudent() {

    }

    def addStudentToCourse() {

    }

    def removeStudentFromCourse() {

    }
}


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
        [courses: courseService.getAllProjectedCourses(), student: student]
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
            flash.message = "Usuario Creado"
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
    //TODO
    def updateStudent(UpdateStudentCommand command) {

        if (command == null) {
            render status: HttpStatus.NOT_FOUND
            return
        }

        if (command.hasErrors()) {
            flash.error = command.errors
            render view: 'create'
            return
        }

        def result = studentService.updatePersonAndStudent(command)

        if (!result.message) {
            flash.message = "Usuario Actualizado"
            redirect(action: 'checkStudent', params: [id: newStudent.id])
        } else {
            flash.error = "Ocurrio un error, intente nuevamente"
            return
        }

    }

    def addStudentToCourse() {
        def student = params.long('student')
        def courseUrl = params.long('course')
        if (student && courseUrl) {
            def result = courseService.addStudentToCourse(student, courseUrl)
            if (result.message) {
                flash.error = result.message
                forward action: 'index'
            } else {
                flash.message = "Se añadio el usuario al curso"
                forward action: 'index'
            }
        } else {
            flash.error = "Error al asignar curso: no se encontraron parametros {$student} -  {$courseUrl}"
            forward action: 'index'
        }
    }

    def removeStudentFromCourse() {
        def student = params.long('student')
        def courseUrl = params.long('course')
        if (student && courseUrl) {
            def result = courseService.removeStudentFromCourse(student, courseUrl)
            if (result.message) {
                flash.error = result.message
                forward action: 'index'
            } else {
                flash.message = "Se removio el usuario del curso"
                forward action: 'index'
            }
        } else {
            flash.error = "Error al remover curso: no se encontraron parametros {$student} -  {$courseUrl}"
            forward action: 'index'
        }
    }
}


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
        def id = params.long('id')
        if (id) {
            def student = studentService.findById(params.long('id'))
            def courses = courseService.getCoursesForUserId(params.long('id'))
            def notAddedCourses = Course.list() - courses
            [courses: courses, student: student, notAddedCourses: notAddedCourses]
        } else {
            log.info "No esta parametro Id cuando se ejecuta checkStudent"
            redirect(action: "index")
        }
    }

    def create(StudentAndPersonCommand command) {
        if (command == null) {
            render status: HttpStatus.NOT_FOUND
            return
        }

        if (command.hasErrors() || studentService.findByUsername(command.email)) {
            flash.error = command.errors ?: "Ya existe un Estudiante con el mismo email"
            log.info(command.errors ? "El command tuvo errores" : "Ya existe un Estudiante con el mismo email")
            redirect(action: 'index')
            return
        }

        def newStudent = studentService.createPersonAndStudent(command).student

        if (newStudent.id) {
            flash.message = "Usuario Creado"
            redirect(action: 'checkStudent', params: [id: newStudent.id])
        } else {
            log.error("Error when creating Student ${newStudent.errors}")
            flash.error = "Ocurrio un error, intente en otro momento"
            redirect(action: 'index')
        }
    }

    def remove() {
        studentService.removePersonandStudent(params.long('id'))
        flash.message = "Se elimino el estudiante $params.id"
        redirect action: 'index'
    }

    def updateStudent(UpdateStudentCommand command) {

        if (command == null) {
            render status: HttpStatus.NOT_FOUND
            return
        }

        if (command.hasErrors()) {
            flash.error = command.errors
            redirect(action: 'checkStudent', params: [id: command.studentId])
            return
        }

        log.info "Se actualiza estudiante con datos ${command.dump()}"
        def result = studentService.updatePersonAndStudent(command)
        
        if (!result.hasProperty('message')) {
            flash.message = "Usuario Actualizado"
            redirect(action: 'checkStudent', params: [id: command.studentId])
        } else {
            flash.error = "Ocurrio un error, intente nuevamente"
        }

    }
    
    def updatePasswordForStudent(PasswordCommand command) {
        if (command == null) {
            render status: HttpStatus.NOT_FOUND
            return
        }

        if (command.hasErrors()) {
            flash.error = command.errors
            redirect(action: 'checkStudent', params: [id: command.id])
            return
        }

        def result = studentService.updatePassword(command)
        
        if (!result.hasProperty('message')) {
            flash.message = "Contraseña de Usuario Actualizada"
            redirect(action: 'checkStudent', params: [id: command.id])
        } else {
            flash.error = "Ocurrio un error, intente nuevamente"
        }
    }

    def addStudentToCourse() {
        def student = params.long('student')
        def courseUrl = params.long('course')
        if (student && courseUrl) {
            def result = courseService.addStudentToCourse(student, courseUrl)
            if (result.hasProperty('message')) {
                flash.error = result.message
                redirect action: 'checkStudent', params: [id: student]
            } else {
                flash.message = "Se añadio el usuario al curso"
                redirect action: 'checkStudent', params: [id: student]
            }
        } else {
            flash.error = "Error al asignar curso: no se encontraron parametros {$student} -  {$courseUrl}"
            redirect action: 'checkStudent', params: [id: student]
        }
    }

    def removeStudentFromCourse() {
        def student = params.long('student')
        def courseUrl = params.long('course')
        if (student && courseUrl) {
            def result = courseService.removeStudentFromCourse(student, courseUrl)
            if (result.hasProperty('message')) {
                flash.error = result.message
                redirect action: 'checkStudent', params: [id: student]
            } else {
                flash.message = "Se removio el usuario del curso"
                redirect action: 'checkStudent', params: [id: student]
            }
        } else {
            flash.error = "Error al remover curso: no se encontraron parametros {$student} -  {$courseUrl}"
            redirect action: 'checkStudent', params: [id: student]
        }
    }
}


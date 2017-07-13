package course.manager

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LessonController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Lesson.list(params), model:[lessonCount: Lesson.count()]
    }

    def show(Lesson lesson) {
        respond lesson
    }

    def create() {
        respond new Lesson(params)
    }

    @Transactional
    def save(Lesson lesson) {
        if (lesson == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (lesson.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond lesson.errors, view:'create'
            return
        }

        lesson.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lesson.label', default: 'Lesson'), lesson.id])
                redirect lesson
            }
            '*' { respond lesson, [status: CREATED] }
        }
    }

    def edit(Lesson lesson) {
        respond lesson
    }

    @Transactional
    def update(Lesson lesson) {
        if (lesson == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (lesson.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond lesson.errors, view:'edit'
            return
        }

        lesson.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'lesson.label', default: 'Lesson'), lesson.id])
                redirect lesson
            }
            '*'{ respond lesson, [status: OK] }
        }
    }

    @Transactional
    def delete(Lesson lesson) {

        if (lesson == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        lesson.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'lesson.label', default: 'Lesson'), lesson.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lesson.label', default: 'Lesson'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

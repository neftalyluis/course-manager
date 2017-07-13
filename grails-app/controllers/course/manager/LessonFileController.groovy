package course.manager

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LessonFileController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LessonFile.list(params), model:[lessonFileCount: LessonFile.count()]
    }

    def show(LessonFile lessonFile) {
        respond lessonFile
    }

    def create() {
        respond new LessonFile(params)
    }

    @Transactional
    def save(LessonFile lessonFile) {
        if (lessonFile == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (lessonFile.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond lessonFile.errors, view:'create'
            return
        }

        lessonFile.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lessonFile.label', default: 'LessonFile'), lessonFile.id])
                redirect lessonFile
            }
            '*' { respond lessonFile, [status: CREATED] }
        }
    }

    def edit(LessonFile lessonFile) {
        respond lessonFile
    }

    @Transactional
    def update(LessonFile lessonFile) {
        if (lessonFile == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (lessonFile.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond lessonFile.errors, view:'edit'
            return
        }

        lessonFile.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'lessonFile.label', default: 'LessonFile'), lessonFile.id])
                redirect lessonFile
            }
            '*'{ respond lessonFile, [status: OK] }
        }
    }

    @Transactional
    def delete(LessonFile lessonFile) {

        if (lessonFile == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        lessonFile.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'lessonFile.label', default: 'LessonFile'), lessonFile.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lessonFile.label', default: 'LessonFile'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

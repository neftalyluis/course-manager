package course.manager

class LandingsController {

    def testimony() {}

    def ebook() {

        if (request.method == 'POST') {
            log.info "Creating lead with email: ${params.email}"
            if (Lead.findByEmail(params.email)) {
                return [withEmail: true]
            } else {
                def lead = new Lead(email: params.email, submitted: new Date()).save()
                return [withEmail: lead.id]
            }
        }
        return [withEmail: false]
    }
}
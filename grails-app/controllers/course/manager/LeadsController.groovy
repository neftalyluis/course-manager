package course.manager

class LeadsController {

    def index() {
        [leads: Lead.findAll()]
    }
}

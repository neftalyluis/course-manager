package course.manager

class UpdateCourseCommand extends CreateCourseCommand {

    Long id

    static constraints = {
        importFrom CreateCourseCommand
        //B stuff
    }
}

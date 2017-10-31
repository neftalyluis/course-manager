package course.manager

class UpdateLessonCommand extends CreateLessonCommand {

    Long id

    static constraints = {
        importFrom CreateLessonCommand
        //B stuff
    }
}

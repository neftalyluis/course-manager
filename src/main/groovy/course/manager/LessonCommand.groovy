package course.manager

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

class LessonCommand implements Validateable {

    String name
    String body
    MultipartFile headerPhoto
    String url
    Long numberLesson
    Long courseId
    List<MultipartFile> lessonFiles

}

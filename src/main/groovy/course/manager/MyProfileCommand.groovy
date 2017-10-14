package course.manager

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

class MyProfileCommand implements Validateable {

    MultipartFile profileImage
    Long id
    Integer version

}

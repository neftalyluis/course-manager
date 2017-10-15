package course.manager

import grails.transaction.Transactional

@Transactional
class ProfileService {

    def googleCloudStorageService
    def springSecurityService

    def setProfilePhoto(byte[] file, String contentType, String originalFilename) {
        def bucket = "perfiles/${springSecurityService.currentUser?.username}"
        def photo = googleCloudStorageService.replaceObject(bucket, file, contentType)
        if (photo) {
            def signedUrl = googleCloudStorageService.getUrlForObject(bucket)
            def student = Student.findByUsername(springSecurityService.currentUser.username)
            student.bucket = bucket
            student.urlAvatar = signedUrl
            student.save()
            return student
        } else {
            [error: "Ocurrio un Error, intenta mas tarde"]
        }
    }


    def getCurrentAvatarUrl() {
        def student = Student.findByUsername(springSecurityService.currentUser.username)

        return student.urlAvatar
    }
}

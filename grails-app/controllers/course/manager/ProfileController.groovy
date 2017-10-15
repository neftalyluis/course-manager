package course.manager

class ProfileController {

    def profileService

    def index() {
        [avatar: profileService.getCurrentAvatarUrl()]
    }

    def updateProfilePic() {
        def profilePhoto = request.getFile('profilePhoto')
        if (profilePhoto.empty) {
            flash.message = 'No se envio imagen'
            redirect(action: 'index')
        } else {
            def result = profileService.setProfilePhoto(profilePhoto.bytes, profilePhoto.contentType, profilePhoto.originalFilename)
            if (result.hasProperty('error')) {
                flash.message = "Nueva imagen de perfil subida correctamente"
                redirect(action: 'index')
            } else {
                flash.error = "Ocurrio un error, intenta mas tarde"
                redirect(action: 'index')
            }
        }
    }
}

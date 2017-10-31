package course.manager

class StudentTagLib {
    def springSecurityService
    static defaultEncodeAs = [taglib: 'none']
    static namespace = "profile"
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def avatar = {
        def student = Student.findByUsername(springSecurityService.currentUser?.username)
        out << """<img src="${student.urlAvatar?:"/assets/avatar.png"}" style="width: 35px; height: 35px;"/>"""
    }
}

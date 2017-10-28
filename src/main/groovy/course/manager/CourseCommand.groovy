package course.manager

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

class CourseCommand implements Validateable {

    String name
    //Texto de descripcion del curso
    String description
    //Texto de Curso Finalizado
    String banner
    //Texto de bienvenida
    String welcome
    //Texto del boton de teoria
    String theoryButton
    //URL de la foto de pagina de curso, url
    MultipartFile coursePhoto
    //URL de la foto de pagina de lecciones, url
    MultipartFile lessonPhoto
    //Texto de pagina de teoria
    String theory
    //Titulo de pagina de teoria
    String theoryTitle
    //Texto de pagina de informacion, no está en Firebase
    String info
    //URL para uso en parametros
    String url

}

package course.manager

class Course {

    static hasMany = [lessons: Lesson, students: Student]
    String name
    //Texto de descripcion del curso
    String description
    //Ni idea
    String banner
    //Texto de bienvenida
    String welcome
    //Texto del boton de teoria
    String theoryButton
    //URL de la foto de pagina de curso
    String coursePhoto
    //URL de la foto de pagina de lecciones
    String lessonPhoto
    //Texto de pagina de teoria
    String theory
    //Titulo de pagina de teoria
    String theoryTitle
    //Texto de pagina de informacion
    String info
    //URL para uso en parametros
    String url


    static constraints = {

        name blank: false
        description blank: false
        banner blank: false
        welcome blank: false
        theoryButton blank: false
        coursePhoto blank: false
        lessonPhoto blank: false
        theory blank: false
        theoryTitle blank: false
        info blank: false
        url blank: false

    }
}

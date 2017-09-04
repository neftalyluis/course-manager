<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <script src="https://cdn.ckeditor.com/4.7.2/standard/ckeditor.js"></script>
    </head>
    <body>
        <div class="header" style="min-height: 400px; height: 400px;" ng-style="{'background-image':headerImage}">
            <div class="header-op">
                <div class="header-content">
                    <div class="header-content-inner">
                        <h1 id="homeHeading" style="margin-top: 150px; color: #fff; font-family: 'Raleway', sans-serif; font-size: 50px; font-weight: bold;">CURSOS</h1>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
        <section>
            <div class="container">
                <h2>Crear nuevo Curso</h2>
                <form>
    <!--String name
    String descriptionNombre del Curso
    String banner
    String welcome
    String theoryButton
    String coursePhoto
    String lessonPhoto
    String theory
    String theoryTitle
    String info-->
                    
                    <div class="form-group">
                        <label for="name">Nombre del Curso:</label>
                        <input type="text" class="form-control" id="name">
                    </div>
                    <div class="form-group">
                        <label for="description">Texto del Banner:</label>
                        <input type="text" class="form-control" id="description">
                    </div>
                    
                    <div class="form-group">
                        <textarea name="editor1"></textarea>
                    </div>
                </form>
            </div>
        </section>
        
    <g:javascript>
        CKEDITOR.replace( 'editor1' );
    </g:javascript>
    </body>    
</html>
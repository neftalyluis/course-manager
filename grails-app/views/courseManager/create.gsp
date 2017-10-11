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
                <h1 id="homeHeading"
                    style="margin-top: 150px; color: #fff; font-family: 'Raleway', sans-serif; font-size: 50px; font-weight: bold;">CURSOS</h1>
                <hr>
            </div>
        </div>
    </div>
</div>
<section>
    <div class="container">
        <h2>Crear nuevo Curso</h2>

        <form>
 
            <div class="form-group">
                <label for="name">Nombre del Curso:</label>
                <input type="text" class="form-control" id="name">
            </div>

            <div class="form-group">
                <label>Texto de descripcion del curso</label>
                <textarea name="descript"></textarea>
            </div>
              <div class="form-group">
                <label>Texto de Curso Finalizado</label>
                <textarea name="banner"></textarea>
            </div>
            <div class="form-group">
                <label>Texto de bienvenida</label>
                <textarea name="welcome"></textarea>
            </div>
              <div class="form-group">
                <label>Texto de pagina de teoria </label>
                <textarea name="theory"></textarea>
            </div>
             <div class="form-group">
                <label for="theoryButton">Texto del boton de teoria :</label>
                <input type="text" class="form-control" id="theoryButton">
            </div>
             <div class="form-group">
                <label for="coursePhoto">URL de la foto de pagina de curso :</label>
                <input type="text" class="form-control" id="coursePhoto">
            </div>
             <div class="form-group">
                <label for="theoryTitle">Titulo de pagina de teoria :</label>
                <input type="text" class="form-control" id="theoryTitle">
            </div>
             <div class="form-group">
                <label for="url">URL para uso en parametros  :</label>
                <input type="text" class="form-control" id="url">
            </div>
        </form>ss
    </div>
</section>

<g:javascript>
    CKEDITOR.replace('descript');
    CKEDITOR.replace('banner');
    CKEDITOR.replace('welcome');
    CKEDITOR.replace('theory');
</g:javascript>
</body>
</html>
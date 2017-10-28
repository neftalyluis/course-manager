<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
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

<div class="modal fade" id="deleteLessonModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>

                <h3 class="modal-title text-center">¿Estás seguro de querrer borrar el usuario?</h3>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary  " data-dismiss="modal">Si, quiero borrar.</button>
                <button type="button" class="btn btn-primary " data-dismiss="modal">No, quiero seguir.</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalCrearCurso" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h1>Crear nuevo Curso</h1>
            </div>

            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="name">Nombre del Curso:</label>
                        <input type="text" class="form-control" id="name">
                    </div>

                    <div class="form-group">
                        <label>Texto de descripcion del curso</label>
                        <textarea name="descript" style="min-width: 100%"></textarea>
                    </div>

                    <div class="form-group">
                        <label>Texto de Curso Finalizado</label>
                        <textarea name="banner" style="min-width: 100%"></textarea>
                    </div>

                    <div class="form-group">
                        <label>Texto de bienvenida</label>
                        <textarea name="welcome" style="min-width: 100%"></textarea>
                    </div>

                    <div class="form-group">
                        <label>Texto de pagina de teoria</label>
                        <textarea name="theory" style="min-width: 100%"></textarea>
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
                </form>
            </div>

            <div class="modal-footer">
                <button class="btn btn-primary">Crear curso</button>
                <button type="button" class="btn btn-primary" data-toggle="modal"
                        data-target="#modalConfirmacionCerrar">Cerrar</button>
            </div>
        </div>
    </div>

</div>

<section>
    <div class="container">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 col-md-8 col-sm-6 ">
                    <h1 class="text-left">${course.name} <small>Nombre</small></h1>

                    <h2 class="text-left">${course.url} <small>URL del Curso</small></h2>
                </div>
            </div>

            <div class="row text-center">
                <div class="btn-group">
                    <button type="button" class="btn btn-primary">Modificar nombre o URL del Curso</button>
                    <button type="button" class="btn btn-primary">Modificar texto de descripcion</button>
                    <button type="button" class="btn btn-primary">Modificar texto de finalizacion</button>
                    <button type="button" class="btn btn-primary">Modificar texto de bienvenida</button>
                    <button type="button" class="btn btn-primary">Modificar texto de la pagina de Teoria</button>
                    <button type="button" class="btn btn-primary">Modificar texto de pagina de informacion</button>
                    <button type="button" class="btn btn-primary">Modificar imagenes del Curso</button>
                </div>
            </div>

            <div class="row">
                <!--Este div lo hice solo para que hubiera un espacio a la hora de hacerlo responsivo, si no te convence lo quito-->
                <div class="invisible">...</div>
                <!--Aquí empieza la tabla -->
                <div class="container-fluid ">
                    <table class="table table-responsive">
                        <thead>
                        <tr>
                            <th>Día</th>
                            <th>Nombre</th>
                            <th>URL</th>
                            <th>Acciones</th>
                        </tr>
                        </thead>
                        <tbody>
                        <g:if test="${course.lessons}">
                            <g:each var="lesson" in="${course.lessons.sort { it.numberLesson }}">
                                <tr>
                                    <td>${lesson.numberLesson}</td>
                                    <td>${lesson.name}</td>
                                    <td>${lesson.url}</td>
                                    <td>
                                        <div class="btn-toolbar">
                                            <button class="btn btn-primary" data-toggle="modal"
                                                    data-target="#modalCrearCurso">Modificar Leccion</button>
                                            <button class="btn btn-primary" data-toggle="modal"
                                                    data-target="#myModal">Borrar Leccion
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            </g:each>
                        </g:if>
                        <g:else>
                            <tr>
                                <td align="center">Este curso no tiene ninguna leccion <a data-toggle="modal"
                                                                                          data-target="#agregarLeccion">Crea uno</a>
                                </td>
                            </tr>
                        </g:else>
                        </tbody>
                    </table>
                </div>
            </div><!--Div row-->
        </div><!--Container-fluid-->
    </div>
</section>
</body>
</html>

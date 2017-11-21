<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <script src="https://cdn.ckeditor.com/4.7.2/full-all/ckeditor.js"></script>
</head>

<body>
<div class="header" style="min-height: 400px; height: 400px;">
    <div class="header-op">
        <div class="header-content">
            <div class="header-content-inner">
                <h1 id="homeHeading"
                    style="margin-top: 150px; color: #fff; font-family: 'Raleway', sans-serif; font-size: 50px; font-weight: bold;">${course.name}</h1>
                <hr>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalQuitarLeccion" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <g:form action="removeLessonFromCourse">
                <input type="hidden" name="lessonId" id="inputRemoveLessonId" value="#">
                <input type="hidden" name="courseId" id="inputRemoveLessonIdCourse" value="${course.id}">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>

                    <h3 class="modal-title text-center" id="titleRemoveLesson"></h3>
                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Si, quiero borrar.</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">No, quiero seguir.</button>
                </div>
            </g:form>
        </div>
    </div>
</div>

<div class="modal fade" id="modalEditarLeccion" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h1 id="tituloEditarLeccion"></h1>
            </div>

            <g:uploadForm action="updateLesson" name="addLessonForm">
                <div class="modal-body">
                    <div class="form-group">
                        <label>Nombre de la Lecion:</label>
                        <input id="nombreModificarLeccion" name="name" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>URL de la leccion:</label>
                        <input id="urlModificarLeccion" name="url" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>Texto de la Leccion</label>
                        <textarea id="textoModificarLeccion" name="body" style="min-width: 100%"></textarea>
                    </div>

                    <input type="hidden" name="courseId" value="${course.id}">
                    <input type="hidden" id="idLeccion" name="id" value="#">

                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Actualizar leccion</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#modalEditarLeccion">Cerrar</button>
                </div>
            </g:uploadForm>
        </div>
    </div>

</div>

<div class="modal fade" id="modalEditarCurso" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h1>Editar Curso</h1>
            </div>
            <g:uploadForm action="updateCourse" name="updateCourseForm">
                <div class="modal-body">
                    <input type="hidden" name="id" value="${course.id}">

                    <div class="form-group">
                        <label for="name">Nombre del Curso:</label>
                        <input type="text" name="name" class="form-control" value="${course.name}">
                    </div>

                    <div class="form-group">
                        <label>Texto de descripcion del curso</label>
                        <textarea name="descript" style="min-width: 100%">${course.description}</textarea>
                    </div>

                    <div class="form-group">
                        <label>Texto de Curso Finalizado</label>
                        <textarea name="banner" style="min-width: 100%">${course.banner}</textarea>
                    </div>

                    <div class="form-group">
                        <label>Texto de bienvenida</label>
                        <textarea name="welcome" style="min-width: 100%">${course.welcome}</textarea>
                    </div>

                    <div class="form-group">
                        <label>Texto de pagina de teoria</label>
                        <textarea name="theory" style="min-width: 100%">${course.theory}</textarea>
                    </div>

                    <div class="form-group">
                        <label for="theoryButton">Texto del boton de teoria:</label>
                        <input type="text" name="theoryButton" class="form-control" value="${course.theoryButton}">
                    </div>


                    <div class="form-group">
                        <label for="theoryTitle">Titulo de pagina de teoria:</label>
                        <input type="text" name="theoryTitle" class="form-control" value="${course.theoryTitle}">
                    </div>

                    <div class="form-group">
                        <label for="url">URL para uso en parametros:</label>
                        <input type="text" name="url" class="form-control" value="${course.url}">
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Actualizar curso</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#modalEditarCurso">Cerrar</button>
                </div>
            </g:uploadForm>
        </div>
    </div>

</div>

<div class="modal fade" id="modalCrearLeccion" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h1>Crear nueva Leccion</h1>
            </div>

            <g:uploadForm action="addLessonToCourse" name="addLessonForm">
                <div class="modal-body">
                    <div class="form-group">
                        <label>Nombre de la Lecion:</label>
                        <input name="name" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>URL de la leccion:</label>
                        <input name="url" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>Texto de la Leccion</label>
                        <textarea name="body" style="min-width: 100%"></textarea>
                    </div>

                    <input type="hidden" name="courseId" value="${course.id}">

                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Crear leccion</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#modalCrearLeccion">Cerrar</button>
                </div>
            </g:uploadForm>

        </div>
    </div>

</div>

<div class="modal fade" id="modalCambiarImagenLecciones" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h1>Subir nuevo Archivo</h1>
            </div>

            <g:uploadForm action="updateLessonsPhoto">
                <div class="modal-body">
                    <div class="row">
                        <img class="img-thumbnail" src="${course.lessonPhoto}" style="height:250px;max-width: 100%;">
                    </div>

                    <div class="form-group">
                        <label>Imagen:</label>
                        <input type="file" name="file" class="form-control">
                    </div>

                    <input type="hidden" name="courseId" value="${course.id}">

                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Subir archivo</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#modalCambiarImagenLecciones">Cerrar</button>
                </div>
            </g:uploadForm>

        </div>
    </div>
</div>

<div class="modal fade" id="modalCambiarImagenCursos" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h1>Subir nuevo Archivo</h1>
            </div>

            <g:uploadForm action="updateCoursePhoto">
                <div class="modal-body">
                    <div class="row">
                        <img class="img-thumbnail" src="${course.coursePhoto}" style="height:250px;max-width: 100%;">
                    </div>

                    <div class="form-group">
                        <label>Imagen:</label>
                        <input type="file" name="file" class="form-control">
                    </div>

                    <input type="hidden" name="courseId" value="${course.id}">

                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Subir archivo</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#modalCambiarImagenCursos">Cerrar</button>
                </div>
            </g:uploadForm>

        </div>
    </div>
</div>

<div class="modal fade" id="modalCambiarImagenTeoria" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h1>Subir nuevo Archivo</h1>
            </div>

            <g:uploadForm action="updateTheoryPhoto">
                <div class="modal-body">
                    <div class="row">
                        <img class="img-thumbnail" src="${course.theoryPhoto}" style="height:250px;max-width: 100%;">
                    </div>

                    <div class="form-group">
                        <label>Imagen:</label>
                        <input type="file" name="file" class="form-control">
                    </div>

                    <input type="hidden" name="courseId" value="${course.id}">

                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Subir archivo</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#modalCambiarImagenTeoria">Cerrar</button>
                </div>
            </g:uploadForm>

        </div>
    </div>
</div>

<section>

    <div class="container">
        <g:if test="${flash.error}">
            <div class="alert alert-danger">${flash.error}</div>
        </g:if>
        <g:if test="${flash.message}">
            <div class="alert alert-success">${flash.message}</div>
        </g:if>
    </div>

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
                    <button type="button" id="botonModalCrearLeccion" data-toggle="modal"
                            data-target="#modalCrearLeccion" class="btn btn-primary">Crear nueva Leccion</button>
                    <button type="button" data-toggle="modal"
                            data-target="#modalEditarCurso" class="btn btn-primary">Modificar textos de Curso</button>
                    <button type="button" data-toggle="modal"
                            data-target="#modalCambiarImagenLecciones" class="btn btn-primary">Cambiar imagen de Lecciones</button>
                    <button type="button" data-toggle="modal"
                            data-target="#modalCambiarImagenCursos" class="btn btn-primary">Cambiar imagen de Cursos</button>
                    <button type="button" data-toggle="modal"
                            data-target="#modalCambiarImagenTeoria" class="btn btn-primary">Cambiar imagen de Teoria</button>
                </div>
            </div>

            <div class="row text-center">
                <div class="btn-group">
                </div>
            </div>

            <div class="row text-center">
                <div class="btn-group">
                    <g:link action="checkCourseFiles" params="[courseId: course.id]" type="button" class="btn btn-primary">Modificar Archivos de Descripcion General</g:link>
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
                                    <td class="hidden">${lesson.id}</td>
                                    <td>${lesson.name}</td>
                                    <td>${lesson.url}</td>
                                    <td>
                                        <div class="btn-toolbar">
                                            <button class="btn btn-primary modalEditarLeccion" data-toggle="modal"
                                                    data-target="#modalEditarLeccion">Modificar Leccion</button>
                                            <button class="btn btn-primary modalQuitarLeccion" data-toggle="modal"
                                                    data-target="#modalQuitarLeccion">Borrar Leccion
                                            </button>
                                            <g:link class="btn btn-primary" action="checkFiles"
                                                    params="[lessonId: lesson.id]">Ver Archivos</g:link>
                                        </div>
                                    </td>
                                </tr>
                            </g:each>
                        </g:if>
                        <g:else>
                            <tr>
                                <td align="center">Este curso no tiene ninguna leccion <a data-toggle="modal"
                                                                                          data-target="#modalCrearLeccion">Crea uno</a>
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
<asset:script type="text/javascript">

    CKEDITOR.plugins.addExternal( 'base64image', '/assets/base64image/', 'plugin.js' );
    CKEDITOR.replaceAll(function( textarea, config ) {
        config.extraPlugins = 'base64image';
    });

    $('#botonModalCrearLeccion').click(function () {
        $("#addLessonForm").validate({
            rules: {
                name: "required",
                url: "required",
                body: "required"
            },
            messages: {
                name: "Por favor ingresa un Nombre",
                url: "Por favor ingresa una URL",
                body: "Por favor ingresa el contenido de la leccion"
            },
            submitHandler: function (form) {
                form.submit();
            }
        });
    })

    $('.modalQuitarLeccion').click(function () {
        var lessonId = $(this).parent().parent().prev().prev().prev().text()
        var lessonName = $(this).parent().parent().prev().prev().text()
        $('#inputRemoveLessonId').val(lessonId)
        $('#titleRemoveLesson').text("¿Estás seguro de querer borrar la leccion: " + lessonName + "?")
    })

    $('.modalEditarLeccion').click(function () {
        var lessonName = $(this).parent().parent().prev().prev().text()
        var lessonId = $(this).parent().parent().prev().prev().prev().text();
        var courseId = ${course.id};
        $('#tituloEditarLeccion').text("Editar Leccion " + lessonName)

        $.post('${createLink(action: 'checkLesson')}', { courseId: courseId, lessonId : lessonId},
            function(returnedData){
                $('#nombreModificarLeccion').val(returnedData.lesson.name)
                $('#urlModificarLeccion').val(returnedData.lesson.url)
                CKEDITOR.instances['textoModificarLeccion'].setData(returnedData.lesson.body);
                $('#idLeccion').val(returnedData.lesson.id)
            }).fail(function(){
                  console.log("error");
            });
    })

    $("#updateCourseForm").validate({
        rules: {
            name: "required",
            url: "required",
            descript: "required",
            banner: "required",
            welcome: "required",
            theoryButton: "required",
            theoryTitle: "required",
            theory: "required"
        },
        messages: {
            name: "Por favor ingresa un Nombre",
            url: "Por favor ingresa una url",
            descript: "Por favor ingresa una Descripcion",
            banner: "Por favor ingresa una Descripcion",
            welcome: "Por favor ingresa una Descripcion",
            theoryButton: "Por favor ingresa una Descripcion",
            theoryTitle: "Por favor ingresa una Descripcion",
            theory: "Por favor ingresa una Descripcion"
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
</asset:script>
</body>
</html>

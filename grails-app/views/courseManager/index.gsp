<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="header" style="min-height: 400px; height: 400px;">
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

<div class="modal fade" id="deleteCourse" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <g:form action="remove">
                <input type="hidden" name="id" id="inputRemoveCourse" value="#">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>

                    <h3 class="modal-title text-center" id="titleRemoveCourse"></h3>
                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Si, quiero borrar.</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">No, quiero seguir.</button>
                </div>
            </g:form>
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
        <div class="btn-group">
            <g:link class="btn btn-primary" controller="courseManager" action="create">Crear Nuevo Curso</g:link>
        </div>

        <h2>Todos los cursos</h2>
        <table class="table table-striped" id="cursos">
            <thead>
            <tr>
                <th>Nombre</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <g:if test="${courses}">
                <g:each in="${courses}" var="course">
                    <tr>
                        <td class="hidden">${course.id}</td>
                        <td>${course.name}</td>
                        <td>
                            <div class="btn-toolbar">
                                <g:link action="checkCourse" params="[id: course.id]"
                                        class="btn btn-primary">Ver detalle</g:link>
                                <button class="btn btn-primary modalQuitarCurso" data-toggle="modal"
                                        data-target="#deleteCourse">Borrar</button>
                            </div>
                        </td>
                    </tr>
                </g:each>
            </g:if>
            <g:else>
                <tr>
                    <td colspan="2">No hay cursos</td>
                </tr>
            </g:else>
            </tbody>
        </table>
    </div>
</section>
<g:javascript>
    $(document).ready(function () {

        $('.modalQuitarCurso').click(function () {
            var courseId = $(this).parent().parent().prev().prev().text()
            var courseName = $(this).parent().parent().prev().text()
            $('#inputRemoveCourse').val(courseId)
            $('#titleRemoveCourse').text("¿Estás seguro de querer borrar el curso: " + courseName + "?")
        })
    });
</g:javascript>
</body>
</html>
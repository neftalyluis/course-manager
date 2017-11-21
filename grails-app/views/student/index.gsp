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

<div class="modal fade" id="removeStudent" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <g:form action="remove">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h3 id="titleRemoveStudent" class="modal-title text-center">¿Estás seguro de querrer borrar el usuario?</h3>
                <input id="inputRemoveStudent" type="hidden" name="id" value="#">
            </div>

            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Si, quiero borrar.</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">No, quiero seguir.</button>
            </div>           
            </g:form>
        </div>
    </div>
</div>

<div class="modal fade" id="modalCrearEstudiante" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h1>Crear nuevo estudiante</h1>
            </div>

            <g:form name="createStudent" action="create">
                <div class="modal-body">

                    <div class="form-group">
                        <label>Nombre</label>
                        <input type="text" class="form-control" name="name">
                    </div>

                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" class="form-control" name="email">
                    </div>

                    <div class="form-group">
                        <label>Contraseña</label>
                        <input type="password" class="form-control" id="password" name="password">
                    </div>

                    <div class="form-group">
                        <label>Confirmar contraseña</label>
                        <input type="password" class="form-control" name="passwordConfirmation">
                    </div>

                    <div class="form-group">
                        <label>Descripción</label>
                        <textarea class="form-control" name="description"></textarea>
                    </div>
                    
                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Crear estudiante</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal"
                            data-target="#modalConfirmacionCerrar">Cerrar</button>
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
            <button class="btn btn-primary" id="openModalCreate" data-toggle="modal"
                    data-target="#modalCrearEstudiante">Crear nuevo estudiante</button>
        </div>

        <h2>Estudiantes</h2>
        <table class="table table-striped" id="students">
            <thead>
            <tr>
                <th>Nombre</th>
                <th>Email</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <g:if test="${students}">
                <g:each in="${students}" var="student">
                    <tr>
                        <td class="hidden">${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.username}</td>
                        <td>
                            <div class="btn-toolbar">
                                <g:link class="btn btn-primary" action="checkStudent"
                                        params="[id: student.id]">Ver Detalle</g:link>
                                <button class="btn btn-primary modalQuitarEstudiante" data-toggle="modal"
                                        data-target="#removeStudent">Borrar</button>
                            </div>
                        </td>
                    </tr>
                </g:each>
            </g:if>
            <g:else>
                <tr>
                    <td colspan="2">No hay Estudiantes</td>
                </tr>
            </g:else>
            </tbody>
        </table>
    </div>
</section>
<asset:script type="text/javascript">
    $(document).ready(function () {
        $('#students').DataTable();
    });
    
    $('.modalQuitarEstudiante').click(function () {
        var studentId = $(this).parent().parent().prev().prev().prev().text()
        var studentName = $(this).parent().parent().prev().prev().text()
        $('#inputRemoveStudent').val(studentId)
        $('#titleRemoveStudent').text("¿Estás seguro de querer eliminar el estudiante " + studentName + "?")
    })

    $('#openModalCreate').click(function () {
        $("#createStudent").validate({
            rules: {
                name: "required",
                description: "required",
                email: {
                    required: true,
                    email: true
                },
                password: {
                    required: true,
                    minlength: 5
                },
                passwordConfirmation: {
                    equalTo: "#password"
                }
            },
            messages: {
                name: "Por favor ingresa un Nombre",
                description: "Por favor ingresa una Descripcion",
                password: {
                    required: "Por favor ingresa una contraseña",
                    minlength: "La contraseña debe tener una longitud mayor a 5 caracteres"
                },
                passwordConfirmation: {
                    equalTo: "Las contraseñas no son iguales"
                },
                email: "Por favor ingresa un email valido"
            },
            submitHandler: function (form) {
                form.submit();
            }
        });
    });
</asset:script>
</body>
</html>
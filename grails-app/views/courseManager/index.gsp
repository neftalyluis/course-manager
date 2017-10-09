<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
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
    <section>
        <div class="container">
            <div class="btn-group">
                <g:link class="btn btn-primary" controller="courseManager" action="crear">Crear Nuevo Curso</g:link>
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
                                    <td>${course.name}</td> 
                                    <td>Doe</td>
                                    <td>
                                        <div class="btn-toolbar">
                                            <button class="btn btn-primary">Ver detalle</button>
                                            <button class="btn btn-primary" >Borrar</button>
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
$('#cursos').DataTable();
});
</g:javascript>
</body>
</html>
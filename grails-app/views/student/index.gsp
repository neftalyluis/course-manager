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

    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h3 class="modal-title text-center" >¿Estás seguro de querrer borrar el usuario?</h3>
                </div>
               <div class="modal-footer">
                   <button type="button" class="btn btn-primary  " data-dismiss="modal">Si, quiero borrar.</button>
                   <button type="button" class="btn btn-primary " data-dismiss="modal" >No, quiero seguir.</button>
               </div>
            </div>
        </div>
    </div>

    <section>
        <div class="container">
            <div class="btn-group">
                <g:link class="btn btn-primary" controller="courseManager" action="crear">Crear Nuevo Estudiante</g:link>
            </div>

            <h2>Estudiantes</h2>
            <table class="table table-striped" id="students">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Nombre de Usuario</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <g:if test="${students}">
                        <g:each in="${students}" var="student">
                            <tr>
                                <td>${student.name}</td>
                                <td>${student.username}</td>
                                <td>
                                    <div class="btn-toolbar">
                                        <g:link  class="btn btn-primary"  action="checkStudent" params="[id: student.id]">Ver Detalle</g:link>
                                        <button class="btn btn-primary" data-toggle="modal"  data-target="#myModal">Borrar</button>
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
<g:javascript>
$(document).ready(function () {
$('#cursos').DataTable();
});
</g:javascript>                                                                                        
</body>
</html>
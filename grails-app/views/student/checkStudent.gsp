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
    <section>
        <div class="container-fluid">
           <div class="row">
                <div class=" col-12 col-md-4 col-sm-6 " style="max-width: 60%";>
                    <img src="/assets/kobayashi.jpg" class="img-responsive " style="max-width: 100%;">
                </div>
                <div class="col-12 col-md-8 col-sm-6 ">
                    <h1 class="text-left">${student.name}<small>  Nombre</small></h1> 
                    <h2 class="text-left">${student.username}<small>  Nombre de usuario</small></h2>
                    <h2 class="text-left">${student.description}<small>  Descripción</small></h2>
                </div>
            </div><!--Div row-->
        </div><!--Container-fluid-->
           <!--Este div lo hice solo para que hubiera un espacio a la hora de hacerlo responsivo, si no te convence lo quito-->
               <div class="invisible">...</div>
               <!--Aquí empieza la tabla -->
        <div class="container-fluid ">
            <div class="row">
                <table class="table  " >
                     <thead>
                       <tr>
                         <th>Nombre</th>
                         <th>Nombre del curso </th>
                         <th>URL</th>
                       </tr>
                     </thead>
                     <tbody>
                       <tr>
                         <td>nombreEjemplo</td>
                         <td>cursoEjemplo</td>
                         <td>urlEjemplo</td>
                         <td>
                            <div class="btn-toolbar">
                                <g:link class="btn btn-primary">Ver detalle</g:link>
                                    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">Borrar </button>
                                </div>
                            </td>
                       </tr>
                     </tbody>
                   </table>

            </div>
        </div>
    </section>
</body>
</html>
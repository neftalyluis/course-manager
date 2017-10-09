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
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 col-md-4 col-sm-6">
                  <img src="/assets/kobayashi.jpg" class="img-responsive " style="max-width: 100%; ">
                </div>

                <div class="col-12 col-md-8 col-sm-6 ">
                    <h1 class="text-left">name<small>  name</small></h1>
                    <h3 class="text-left">description<small>  description</small></h3>
                    <h3 class="text-left">banner<small>  banner</small></h3>
                    <h3 class="text-left">welcome<small>  welcome</small></h3>
                    <h3 class="text-left">theoryButton<small>  theoryButton</small></h3>
                    <h3 class="text-left">coursePhoto<small>  coursePhoto</small></h3>
                    <h3 class="text-left">lessonPhoto<small>  lessonPhoto</small></h3>
                    <h3 class="text-left">theory<small>  theory</small></h3>
                    <h3 class="text-left">theoryTitle<small>  theoryTitle</small></h3>
                    <h3 class="text-left">info<small>  info</small></h3>
                    <h3 class="text-left">url<small>  url</small></h3>
                </div>
    <!--Este div lo hice solo para que hubiera un espacio a la hora de hacerlo responsivo, si no te convence lo quito-->
               <div class="invisible">...</div>
               <!--Aquí empieza la tabla -->
                <div class="container-fluid table-responsive">       
                   <table class="table">
                     <thead>
                       <tr>
                         <th>Nombre</th>
                         <th>Lección </th>
                         <th>URL</th>
                       </tr>
                     </thead>
                     <tbody>
                       <tr>
                         <td>nombreEjemplo</td>
                         <td>lecciónEjemplo</td>
                         <td>urlEjemplo</td>
                         <td>
                            <div class="btn-toolbar">
                                <g:link class="btn btn-primary">Ver Detalle</g:link>
                                    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">Borrar</button>
                                </div>
                            </td>
                       </tr>
                     </tbody>
                   </table>
                   </div>
            </div><!--Div row-->
        </div><!--Container-fluid-->
    </section>
</body>
</html>

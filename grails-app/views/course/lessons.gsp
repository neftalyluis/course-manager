<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="header head-calendar head-h"
     style="min-height: 400px; background: url(../images/ejercicios-calendario.jpg);" ng-init="openBienvenidaModal()">
    <div class="header-op ttl-padding" style="height: auto; padding: 173px; max-height: 400px;">
        <button class="btn btn-primary btn-xl" style="font-size: 18px; background: #da2d7d;"
                ng-click="verTeoria()">{{curso.botonTeoria}}</button>
        <!-- Trigger the modal with a button -->
        <button class="btn btn-primary btn-xl" data-toggle="modal" data-target="#myModal" id="bienvenidaModal"
                style="display: none;">{{curso.botonBienvenida}}</button>

        <div id="felicitacionModal" class="modal fade modal-transparent" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="carta">
                            <!-- TODO: FALTA AGREGAR ESTO DESDE FIREBASE-->
                            <h2 class="text-center"
                                style="color: #f391c5;text-transform: uppercase;">¡Felicidades por haber concluído tu programa!</h2>

                            <p style="color: black;">Gracias por permitirme ser tu guía durante estos 30 días en un proceso tan maravilloso de amor a ti.</p>

                            <p style="color: black;">Estoy feliz que hayas concluido tu programa porque sé que tendrás hermosos cambios en la forma de amarte y valorarte.</p>

                            <p style="color: black;">Deseo de corazón que este cambio tan bonito de amor propio, perdure para siempre en tu corazón.</p>

                            <p style="color: black;">Recuerda que mientras más te ames a ti misma, más te amarán los demás y mejores relaciones personales tendrás.</p>

                            <p style="color: black;">Te deseo un futuro lleno de amor, paz, abundancia y felicidad.</p>

                            <p style="color: #f391c5;">“Qué el amor por ti misma te acompañe toda la vida”</p>

                            <p class="text-center"
                               style="font-size: 25px;text-align: center; font-family: 'Great Vibes', cursive;color: black;">
                                Con amor, tu coach Paola Vega
                                <i class="fa fa-heart" style="color: #da2d7d;"></i>
                            </p>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-info" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<div class="container less-space-top" style="padding-top: 40px;">
    <h3 style="text-transform: uppercase; color: #f391c5; text-align: center;">Recomendaciones generales</h3>

    <div ta-bind="text" ng-model="curso.descripcion"></div>

    <div class="content-calendar">
        <h1 style="color: #fff; background: #da2d7d; padding-top: 20px; font-weight: bold; ">MI CALENDARIO DE EJERCICIOS</h1>
        <ol class="calendar mig-mov" start="6" style="height: 600px">
            <li id="thismonth">
                <ul ng-repeat="leccion in curso.lecciones | toArray | orderBy:'id'" class="pointer">
                    <a ng-click="verLeccion(leccion.ruta)">
                        <li style="cursor: pointer;">
                            <p>{{leccion.nombre}}</p>

                            <div ng-show="checked[cursoId][leccion.ruta]" class="pull-left"
                                 style="display: inline-block;"><i class="fa fa-check-square-o fa-2x"></i></div>

                            <div class="pull-right numero-cal" style="display: inline-block;">{{leccion.id}}</div>
                        </li>
                    </a>
                </ul>
            </li>
        </ol>

    </div>
</div>
</body>
</html>
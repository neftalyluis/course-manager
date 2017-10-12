<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="header head-calendar head-h"
     style="min-height: 400px; background: url(${assetPath(src: 'ejercicios-calendario.jpg')});">
    <div class="header-op ttl-padding" style="height: auto; padding: 173px; max-height: 400px;">
        <button class="btn btn-primary btn-xl"
                style="font-size: 18px; background: #da2d7d;">${course.theoryButton}</button>
        <!-- Trigger the modal with a button -->
        <button class="btn btn-primary btn-xl" data-toggle="modal" data-target="#myModal" id="bienvenidaModal"
                style="display: none;"></button>

        <div id="felicitacionModal" class="modal fade modal-transparent" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="carta">
                            <div>${raw(course.banner)}</div>
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

    <div>${raw(course.description)}</div>

    <div class="content-calendar">
        <h1 style="color: #fff; background: #da2d7d; padding-top: 20px; font-weight: bold; ">MI CALENDARIO DE EJERCICIOS</h1>
        <ol class="calendar mig-mov" start="6" style="height: 600px">
            <li id="thismonth">
                <ul class="pointer">
                    <g:each in="${course.lessons.sort { it.numberLesson }}" var="lesson">
                        <a href="/cursos/${course.url}/lecciones/${lesson.url}">
                            <li style="cursor: pointer;">
                                <p>${lesson.name}</p>

                                <g:if test="${progress.lessons.contains(lesson)}">
                                    <div class="pull-left"
                                         style="display: inline-block;"><i class="fa fa-check-square-o fa-2x"></i></div>
                                </g:if>

                                <div class="pull-right numero-cal"
                                     style="display: inline-block;">${lesson.numberLesson}</div>
                            </li>
                        </a>
                    </g:each>
                </ul>
            </li>
        </ol>

    </div>
</div>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
    <g:if test="${layout}">
        <meta name="layout" content="amorami"/>
    </g:if>
    <g:else>
        <meta name="layout" content="main"/>
    </g:else>
</head>

<body>
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
<header class="not-home" style="background: url('${course.lessonPhoto ?: "/assets/autoestima.jpg"}');">
    <div class="header-content">
        <div class="header-content-inner">
            <a href="/cursos/${course.url}/teoria" class="btn btn-primary btn-xl page-scroll">${course.theoryButton}</a>
        </div>
    </div>
</header>

<section>
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-sm-12 col-xs-12">
                <h2 class="page-title">Recomendaciones Generales</h2>
                ${raw(course.description)}
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-sm-12 col-xs-12">
                <div id="calendar-wrap">

                    <div id="calendar">
                        <div class="weekdays">
                            <h2 class="calendar-title">Mi calendario de ejercicios</h2>
                        </div>

                        <ul class="days">
                            <g:each in="${course.lessons.sort { it.numberLesson }}" var="lesson">
                                <li class="day">
                                    <a href="/cursos/${course.url}/lecciones/${lesson.url}">
                                        <div class="date">${lesson.numberLesson}</div>
                                        <g:if test="${progress.lessons.contains(lesson)}">
                                            <div class="pull-left"
                                                 style="display: inline-block;"><i
                                                    class="fa fa-check-square-o fa-2x"></i></div>
                                        </g:if>
                                        <div class="event">
                                            <div class="event-desc">${lesson.name}</div>
                                        </div>
                                    </a>
                                </li>
                            </g:each>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
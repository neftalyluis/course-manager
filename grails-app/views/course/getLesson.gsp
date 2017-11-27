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

<header class="not-home" style="background: url('${lesson.headerPhoto ?: "/assets/autoestima.jpg"}');">
    <div class="header-content">
        <div class="header-content-inner">
            <h1 id="homeHeading">${lesson.name}</h1>
        </div>
    </div>
</header>

<section>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-xs-12">${raw(lesson.body)}</div>

            <div class="col-lg-4 col-xs-12">
                <a class="btn btn-primary" style="margin-bottom: 20px;"
                   href="/cursos/${courseUrl}/lecciones/${lesson.url}/marcar">Marcar como completado</a>

                <p>Número de ejercicios por día:</p>

                <div class="exe-number">${lesson.lessonFiles.size()}</div>


                <g:each in="${lesson.lessonFiles}" var="file">
                    <button class="btn btn-primary" style="margin: 20px ; display: block;">
                        <a download href="${file.fileURL}" style="color: #fff;text-decoration: none;">${file.name}</a>
                    </button>
                </g:each>
            </div>
        </div>
    </div>
</section>
</body>
</html>
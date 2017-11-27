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

<header class="not-home" style="background: url('${course.theoryPhoto ?: "/assets/autoestima.jpg"}');">
    <div class="header-content">
        <div class="header-content-inner">
            <h1 id="homeHeading">${course.theoryTitle}</h1>

        </div>
    </div>
</header>
<section>

    <div class="container" style="padding-top: 40px; padding-bottom: 100px;">
        ${raw(course.theory)}
    </div>

    <div class="container text-center">
        <div class="list-group">
            <g:each in="${course.courseFiles.sort()}" var="file">
                <a class="btn btn-primary " download href="${file.fileURL}">${file.name}</a>
            </g:each>
        </div>
    </div>

    <p class="text-center" style="font-size: 25px;text-align: center; font-family: 'Great Vibes', cursive;">
        Con cariño tu coach Paola Vega
        <i class="fa fa-heart" style="color: #da2d7d;"></i>
    </p>

    <div class="container">
        <div class="row">
            <a href="/cursos/${course.url}/lecciones" class="pull-right btn btn-primary">Ir a ejercicios</a>
        </div>
    </div>
</section>

</body>
</html>
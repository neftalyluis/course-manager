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
<div class="header" style="min-height: 400px; height: 400px;">
    <div class="header-op">
        <div class="header-content">
            <div class="header-content-inner">
                <h1 id="homeHeading"
                    style="margin-top: 150px; color: #fff; font-family: 'Raleway', sans-serif; font-size: 50px; font-weight: bold;">${lesson.name}</h1>
                <hr>
            </div>
        </div>
    </div>
</div>

<div class="container" style="padding-top: 100px; padding-bottom: 100px;">
    <div class="row">
        <div class="col-md-9">
            <p>${raw(lesson.body)}</p>
        </div>

        <div class="col-md-12">
            <div style="margin-top: 70px; padding-left: 15px;">
                <div class="row exe-buttons" style="padding: 15px;">
                    <p>Número de ejercicios por día:</p>
                    <div style="border-radius: 100%; width: 30px; height: 30px ; margin-left: 20px;margin-bottom: 20px; background: #da2d7d; color: #fff; padding: 4px 11px; font-weight: bold;">${lesson.lessonFiles.size()}</div>
                    <a class="btn btn-primary" style="margin: 20px " href="/cursos/${courseUrl}/lecciones/${lesson.url}/marcar">Marcar como completado</a>
                </div>

                <div>
                    <g:each in="${lesson.lessonFiles}" var="file">
                        <button class="btn btn-primary" style="margin: 20px ">
                            <a download href="${file.fileURL}"
                               style="color: #fff;text-decoration: none;">${file.name}</a>
                        </button>
                    </g:each>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
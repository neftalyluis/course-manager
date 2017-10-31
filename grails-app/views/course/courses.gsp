<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<div style="min-height: 400px; height: 400px; background: url(${assetPath(src: 'boblioteca.jpg')});">
    <div class="header-op op-mob" style="height: 400px">
        <div class="header-content">
            <div class="header-content-inner">
                <h1 id="homeHeading" class="text-center"
                    style="margin-top: 150px; color: #fff; font-family: 'Raleway', sans-serif; font-size: 50px; font-weight: bold;">Mis programas</h1>
                <hr>
            </div>
        </div>
    </div>
</div>

<div class="container" style="padding-bottom: 100px; padding-top: 100px;">
    <div class="row">
        <g:each var="course" in="${courses}">
            <div class="col-sm-4">
                <div>
                    <h3 class="text-center" style="color: #da2d7d;">${course.name}</h3>
                    <img src="${course.coursePhoto ?: assetPath(src: '/portfolio/thumbnails/2-2.jpg')}"
                         style="max-width: 100%; height: auto;">
                    <button class="btn btn-primary"
                            style="margin-left: 120px; margin-top: 20px;"><a href="/cursos/${course.url}/bienvenida"
                                                                             style="color: #fff; text-decoration: none;">Iniciar</a>
                    </button>
                </div>
            </div>
        </g:each>
    </div>
</div>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<header class="not-home">
    <div class="header-content">
        <div class="header-content-inner">
            <h1 id="homeHeading">Mis Programas</h1>

        </div>
    </div>
</header>
<section id="">
    <div class="container">
        <div class="row">
            <g:each var="course" in="${courses}">
                <div class="col-lg-4 col-sm-6 col-xs-12">
                    <h3 class="text-center" style="color: #E32A76;">${course.name}</h3>
                    <img src="${course.coursePhoto ?: assetPath(src: '/portfolio/thumbnails/2-2.jpg')}"
                         class="img-curso-id">
                    <a href="/cursos/${course.url}/bienvenida"
                       class="btn btn-primary course-button btn-xl text-center">Iniciar</a>
                </div>
            </g:each>
        </div>
    </div>
</section>
</body>
</html>
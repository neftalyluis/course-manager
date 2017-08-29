<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<div style="min-height: 400px; height: 400px; background: url(images/boblioteca.jpg);">
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
    <div class="row" ng-repeat="curso in cursos">
        <div class="col-sm-4">
            <div>
                <h3 class="text-center" style="color: #da2d7d;">{{curso.nombre}}</h3>
                <img src="images/portfolio/thumbnails/2-2.jpg" style="max-width: 100%; height: auto;">
                <button class="btn btn-primary" ng-click="verCurso(curso.$id)"
                        style="margin-left: 120px; margin-top: 20px;"><a
                        style="color: #fff; text-decoration: none;">Iniciar</a></button>
            </div>
        </div>
    </div>
</body>
</html>
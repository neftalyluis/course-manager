<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Amor a mi 2.0</title>
    <asset:stylesheet src="amorami2application.css"/>
    <link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Great+Vibes|Parisienne" rel="stylesheet">
    <link rel="icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon"/>
    <asset:javascript src="application.js"/>
    <g:layoutHead/>

</head>
<body>
<img src="/assets/flower.png" class="flor-top" alt="...">
<div class="container main-content">
    <h1 class="title-2" style="text-align: center;">Amor a mi 2.0 <sub>by Paola Vega</sub></h1>
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid pink-bar">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a href="/" class="navbar-brand page-scroll">
                    <img src="${assetPath(src: 'logo.jpg')}" class="logo-menu">
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right" style="margin-top: 20px;">
                    <sec:ifLoggedIn>
                        <li>
                            <div style="margin: 15px; width: 35px; height: 35px;">
                                <profile:avatar/>
                            </div>
                        </li>
                        <li style="margin-top: 10px;"><g:link controller="profile">Perfil</g:link></li>
                        <li style="margin-top: 10px;"><a href="/cursos">Mis Programas</a></li>
                    </sec:ifLoggedIn>
                    <sec:ifAllGranted roles='ROLE_ADMIN'>
                        <li style="margin-top: 10px;"><g:link controller="courseManager">Gestionar Cursos</g:link></li>
                        <li style="margin-top: 10px;"><g:link controller="student">Gestionar Usuarios</g:link></li>
                    </sec:ifAllGranted>
                    <sec:ifLoggedIn>
                        <li style="margin-top: 10px;"><g:link controller="logout">Cerrar Sesion</g:link></li>
                    </sec:ifLoggedIn>
                    <sec:ifNotLoggedIn>
                        <li style="margin-top: 10px;"><g:link controller="login">Iniciar Sesion</g:link></li>
                    </sec:ifNotLoggedIn>

                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <div class="memeo">
        <g:layoutBody/>
    </div>
</div>
<footer>
    Derechos de autor <i class="fa fa-copyright"></i> 2017 Paola Vega
</footer>
</body>
</html>

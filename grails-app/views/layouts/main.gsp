<!doctype html>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <title>Coach Paola Vega - Amor a mi</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <asset:stylesheet src="application.css"/>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Great+Vibes|Parisienne" rel="stylesheet">
    <link rel="icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon"/>
    <asset:javascript src="application.js"/>
    <g:layoutHead/>

</head>

<body id="page-top">
<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
  your browser</a> to improve your experience.</p>
<![endif]-->
<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid pink-bar">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand page-scroll" href="#!">
                <img src="${assetPath(src: 'logo.jpg')}" class="logo-menu">
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right" style="margin-top: 20px;">
                <sec:ifLoggedIn>
                    <li>
                        <div style="margin: 15px; width: 35px; height: 35px;">
                            <img style="width: 35px; height: 35px;"/>
                        </div>
                    </li>
                    <li style="margin-top: 10px;"><a href="#">Perfil</a></li>
                    <li style="margin-top: 10px;"><a href="#">Mis Programas</a></li>
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

<footer>Derechos de autor <i class="fa fa-copyright"></i> 2017 Paola Vega</footer>
</body>

</html>

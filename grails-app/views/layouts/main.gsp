<!doctype html>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <title>Coach Paola Vega - Yo en amor</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon"/>
    <script src="https://cdn.logrocket.io/LogRocket.min.js" crossorigin="anonymous"></script>
    <script>window.LogRocket && window.LogRocket.init('coach-paola-vega/amor-a-mi');</script>
</head>

<body id="page-top">
<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand page-scroll" href="/">Yo en amor</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <sec:ifLoggedIn>
                    <li>
                        <a href="#" class="page-scroll"><profile:avatar/></a>
                    </li>
                    <li><g:link class="page-scroll" controller="profile">Perfil</g:link></li>
                    <li><a href="/cursos">Mis Programas</a></li>
                </sec:ifLoggedIn>
                <sec:ifAllGranted roles='ROLE_ADMIN'>
                    <li><g:link class="page-scroll" controller="courseManager">Gestionar Cursos</g:link></li>
                    <li><g:link class="page-scroll" controller="student">Gestionar Usuarios</g:link></li>
                </sec:ifAllGranted>
                <sec:ifLoggedIn>
                    <li><g:link class="page-scroll" controller="logout">Cerrar Sesion</g:link></li>
                </sec:ifLoggedIn>
                <sec:ifNotLoggedIn>
                    <li><g:link class="page-scroll" controller="login">Iniciar Sesion</g:link></li>
                </sec:ifNotLoggedIn>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<g:layoutBody/>

<footer style="background-color: #E32A76; color: #fff; padding: 30px;">
    <p>Derechos de autor <i class="fa fa-copyright"></i> 2017 Paola Vega</p>
</footer>
<asset:stylesheet src="application.css"/>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
      integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Great+Vibes|Parisienne" rel="stylesheet">
<asset:javascript src="application.js"/>
<g:layoutHead/>
<asset:deferredScripts/>
</body>

</html>

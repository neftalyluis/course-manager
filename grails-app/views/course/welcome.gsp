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
<section>
    <div class="container">
        <div class="row">
            <div class="carta" style="background-image: url(${assetPath(src: 'bienvenida.jpg')});">
                ${raw(welcome)}
            </div>
        </div>

        <div class="row">
            <a href="/cursos/${course}/lecciones" class="pull-right btn btn-primary">Ir a ejercicios</a>
        </div>
    </div>
</section>

</body>
</html>
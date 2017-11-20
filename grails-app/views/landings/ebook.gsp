<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>E-Book Gratis</title>
</head>

<body>
<div class="row yellow-bar" >
    <div class="col-md-12">
        <h3 class="text-center">Logra la relación de pareja que deseas con el ebook</h3>
        <h2 class="text-center" style="text-transform: uppercase;"><span style="color: #da2d7d;">tips para que un hombre se comprometa contigo </span><span style="color: blue;">¡100% gratis!</span></h2>
    </div>
</div>
<g:if test="${withEmail}">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <h2 style="color: #da2d7d;" class="text-center">¡Gracias por darte de alta!</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8">
                <h3>Descarga aquí tu ebook gratis</h3>
                <div class="row">
                    <div class="col-md-6">
                        <img src="/assets/portada.jpg" class="ebook-img">
                    </div>
                    <div class="col-md-6">
                        <a download href="https://firebasestorage.googleapis.com/v0/b/amor-a-mi-d48eb.appspot.com/o/ebooks%2FEBOOK%20DESCARGABLE%20PARA%20HACER%20QUE%20UN%20HOMBRE%20SE%20COMPROMETA%20CONTIGO%20Coach%20Paola%20Vega%2028%20de%20octubre%20%20(1).pdf?alt=media&token=71e6daba-4413-4373-94db-4eb31ca5083c"  class="btn btn-xl btn-primary pull-right">Descargar <br>Ebook</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <p class="text-center" style="color: #da2d7d;">Gracias por descargar mi ebook <b style="text-transform: uppercase;">Tips para que un hombre se comprometa contigo</b> Si de verdad quieres lograr tener una relación sana y duradera lo antes posible, te recomiendo conozcas mis programas y servicios en <a href="https://amorami.soy" style="color: blue;"> amorami.soy </a> </p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <img src="/assets/logo.jpg" class="logo-ebook">
                <h4 class="text-center" style="color: blue;">20% de descuento en proceso de coaching personalizado</h4>
                <p class="text-center" style="color: #da2d7d;">Una vez que conozcas como puedes hacer que un hombre se comprometa contigo, tal vez deseas avanzar rápido hacia una relación de pareja con ayuda personalizada.<br>Si esto es lo que deseas, descubre como:</p>
                <ul class="text-center" style="color: #da2d7d;">
                    <li>-Determinar a tu hombre ideal</li>
                    <li>-Romper las barreras que te impiden atraer a tu hombre ideal</li>
                    <li>-Explota tus cualidades para atraer mejores hombres de forma natural</li>
                    <li>-Hacer un plan para encontrar a tu hombre ideal en poco tiempo</li>
                </ul>
            </div>
        </div>
    </div>
</g:if>
<g:else>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-xs-12">
                <img src="/assets/portada.jpg" class="ebook-img">
            </div>
            <div class="col-md-6 col-xs-12">
                <div class="pk-bg" style="padding: 15px; margin-bottom: 10px;">
                    <p class="pk-bg">Usando los tips de este ebook conseguirás que un hombre se comprometa contigo. En el cual revelo los mejores TIPS que he descubierto y puesto en practica con resultados maravillosos. En sintesis aprenderás:</p>
                    <ul class="pk-bg">
                        <li>-Como detectar si un hombre esta listo para el compromiso.</li>
                        <li>-Como saber si tu verdaderamente estas lista para el compromiso</li>
                        <li>-Los mejores TIPS para que un hombre se quiera comprometer contigo cuando estas soltera, o en una relación de pareja.</li>
                    </ul>
                </div>
                <div style="padding-bottom: 30px;">
                    <g:form action="ebook">
                        <p>Consigue el ebook gratis pulsando aquí, solo tienes que darte de alta con tu email</p>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" name="email" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="button" class="btn btn-primary" value="Obtener E-book gratis"/>
                        </div>
                    </g:form>
                    <p style="margin-top: 10px;">Estas a punto de descubrir los secretos para que se comprometan contigo con éxito.</p>
                </div>
            </div>
            <div class="col-md-3 col-xs-12">
                <img src="/assets/logo.jpg" class="ebook-img">
            </div>
        </div>
    </div>
</g:else>
</body>
</html>
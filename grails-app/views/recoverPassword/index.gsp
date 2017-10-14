<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

<section style="padding-bottom: 10px;">
    <div class="container alto-pag">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="row" style="padding-top: 60px; padding-bottom: 50px;">
                    <h1 class="text-center">Recupera tu contraseña</h1>
                </div>

                <g:if test='${flash.message}'>
                    <div class="alert alert-info">
                        <p class="bg-info">${flash.message}</p>
                    </div>
                </g:if>

                <g:if test='${flash.error}'>
                    <div class="alert alert-danger">
                        <p class="bg-danger">${flash.error}</p>
                    </div>
                </g:if>

                <g:form action="notification">
                    <div class="form">
                        <input class="form-control log-inp" placeholder="Email" name="email">
                        <button class="btn btn-primary form-control" type="submit">Reestablecer contraseña</button>
                    </div>
                </g:form>
            </div>
            <div class="col-sm-3"></div>
        </div>
    </div>
</section>
</body>
</html>
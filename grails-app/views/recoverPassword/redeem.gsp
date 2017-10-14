<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

<section>
    <div class="container alto-pag">
        <div class="row">
            <div class="col-sm-3"></div>

            <div class="col-sm-6">
                <div class="row" style="padding-bottom: 50px; padding-top: 60px;">
                    <h1 class="text-center">Reestablecer contraseña</h1>
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

                <g:form action="changePassword">
                    <label>Ingresa tu nueva contraseña</label>
                    <input type="hidden" value="${token}" name="token">
                    <input class="form-control log-inp" type="password" name="password">
                    <label>Confirmar contraseña</label>
                    <input class="form-control log-inp" type="password" name="passwordConfirmation">
                    <button class="btn btn-primary form-control" type="submit">Enviar</button>
                </g:form>
            </div>

            <div class="col-sm-3"></div>
        </div>
    </div>
</section>
</body>
</html>
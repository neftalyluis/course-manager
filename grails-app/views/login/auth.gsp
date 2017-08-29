<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

<div class="container alto-pag">
    <div class="row" style="margin-top: 46px;">
        <div class="col-sm-3"></div>

        <div class="col-sm-6">
            <div class="row" style="padding-top: 60px; padding-bottom: 50px; margin-left: -20px; ">
                <div class="col-sm-3"></div>

                <div class="col-sm-6">
                    <h1 class="text-center">Inicia sesión</h1></div>
            </div>

            <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" class="cssform"
                  autocomplete="off">
                <div class="form">

                    <g:if test='${flash.message}'>
                        <div class="alert alert-danger">
                            <p class="bg-danger">${flash.message}</p>
                        </div>
                    </g:if>


                    <label>Usuario:</label>
                    <input class="form-control log-inp" required name="${usernameParameter ?: 'username'}" type="text">
                    <label>Contraseña:</label>
                    <input class="form-control log-inp" required name="${passwordParameter ?: 'password'}"
                           type="password">
                    <input type="checkbox" class="chk" name="${rememberMeParameter ?: 'remember-me'}" id="remember_me"
                           <g:if test='${hasCookie}'>checked="checked"</g:if>/>
                    <label for="remember_me"><g:message code='springSecurity.login.remember.me.label'/></label>

                    <p class="text-muted"
                       style="font-size: 12px;">*Tu usuario y contraseña te serán asignados al adquirir el programa.</p>
                    <button type="submit"
                            class="btn btn-primary pull-right">${message(code: 'springSecurity.login.button')}</button>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
</html>
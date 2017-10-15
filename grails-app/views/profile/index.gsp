<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Firebase</title>
</head>

<body>
<section>
    <div class="container alto-pag">
        <div class="row">
            <div class="col-sm-3"></div>

            <div class="col-sm-6">
                <div class="row" style="padding-top: 60px; padding-bottom: 50px;">
                    <h1 class=""></h1>
                </div>

                <g:uploadForm action="updateProfilePic">
                    <div>
                        <div style="border: solid 3px #da2d7d; padding: 10px; height: 225px; width: 225px; margin: 10px 15%;"
                             class="paola">
                            <div style=" height: 200px; width: 200px; ">
                                <g:if test="${avatar}">
                                    <img id="thumbProfile" src="${avatar}" width="200" height="200"
                                         style="border-radius: 100%;"/>
                                </g:if>
                                <g:else>
                                    <img id="thumbProfile" src="#" width="200" height="200"
                                         style="border-radius: 100%;"/>
                                </g:else>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Personaliza tu Perfil</label>

                        <div>
                            <input type="file" id="inputPhoto" name="profilePhoto" accept="image/*"/><br/>
                        </div>
                    </div>
                    <button class="btn btn-primary btn-lg" style="margin-left: 30%;" type="submit">Subir Foto</button>
                </g:uploadForm>
            </div>

            <div class="col-sm-3"></div>
        </div>
    </div>
</section>
<g:javascript>

    function readURL(input) {

        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#thumbProfile').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#inputPhoto").change(function () {
        readURL(this);
    });
</g:javascript>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Firebase</title>
</head>

<body>

<div class="header" style="min-height: 400px; height: 400px;" ng-style="{'background-image':headerImage}">
    <div class="header-op">
        <div class="header-content">
            <div class="header-content-inner">
                <h1 id="homeHeading"
                    style="margin-top: 150px; color: #fff; font-family: 'Raleway', sans-serif; font-size: 50px; font-weight: bold;">Firebase Backup</h1>
                <hr>
            </div>
        </div>
    </div>
</div>
<section>
    <div class="container">
        <g:uploadForm action="processJSON">
            <div class="form-group">
                <label for="file">Inserta aquí el JSON de Firebase</label>
                <input type="file" name="firebase" class="form-control" id="file"/>
            </div>

            <div class="form-group">
                <input type="submit"/>
            </div>
        </g:uploadForm>
    </div>
</section>
</body>
</html>
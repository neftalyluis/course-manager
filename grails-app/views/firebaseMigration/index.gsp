<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Firebase</title>
</head>
<body>
<div class="container">
    <g:form name="sendJSON" url="[action: 'processJSON', controller: 'firebaseMigration']">
        <div class="form-group">
            <label for="json">Inserta aquí el JSON de Firebase</label>
            <input type="textarea" name="payload" class="form-control" id="json" />
        </div>
        <g:submitButton name="processJSON" class="btn btn-primary" value="Subir"/>
    </g:form>
</div>
</body>
</html>
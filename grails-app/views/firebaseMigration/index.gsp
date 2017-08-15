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
            <textarea class="form-control" id="json"></textarea>
        </div>
        <g:submitButton name="Subir" class="btn btn-primary" value="processJSON"/>
    </g:form>
</div>
</body>
</html>
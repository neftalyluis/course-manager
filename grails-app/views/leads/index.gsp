<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
</head>

<body>
<header class="not-home">
    <div class="header-content">
        <div class="header-content-inner">
            <h1 id="homeHeading">Leads que han descargado el ebook</h1>
        </div>
    </div>
</header>
<section>
    <div class="container">

        <h2>Leads</h2>
        <table class="table table-striped" id="leads">
            <thead>
            <tr>
                <th>Email</th>
                <th>Fecha de envio</th>
            </tr>
            </thead>
            <tbody>
            <g:if test="${leads}">
                <g:each in="${leads}" var="lead">
                    <tr>
                        <td>${lead.email}</td>
                        <td>${lead.submitted}</td>
                    </tr>
                </g:each>
            </g:if>
            <g:else>
                <tr>
                    <td colspan="2">No hay Leads</td>
                </tr>
            </g:else>
            </tbody>
        </table>
    </div>
</section>
</body>
</html>
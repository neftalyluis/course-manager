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
<div class="h-leccion"
     style="min-height: 400px; height: 400px; background: url('${course.theoryPhoto ?: "/assets/autoestima.jpg"}');">
    <div class="header-op op-mob" style="height: 400px">
        <div class="header-content">
            <div class="header-content-inner">
                <h1 id="homeHeading" class="text-center"
                    style="margin-top: 150px; color: #fff; font-family: 'Raleway', sans-serif; font-size: 40px; font-weight: bold;">${course.theoryTitle}</h1>
                <hr>
            </div>
        </div>
    </div>
</div>

<section>

    <div class="container" style="padding-top: 40px; padding-bottom: 100px;">
        ${raw(course.theory)}
    </div>

    <div class="container text-center">
        <div class="list-group">
            <g:each in="${course.courseFiles}" var="file">
                <a class="btn btn-primary " download href="${file.fileURL}">${file.name}</a>
            </g:each>
        </div>
    </div>

    <p class="text-center" style="font-size: 25px;text-align: center; font-family: 'Great Vibes', cursive;">
        Con cariño tu coach Paola Vega
        <i class="fa fa-heart" style="color: #da2d7d;"></i>
    </p>
</section>

</body>
</html>
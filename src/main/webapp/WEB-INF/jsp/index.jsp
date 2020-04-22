<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation bar -->
<%@ include file="navbar.jsp" %>
<html>
    <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <link href="<c:url value="/resources/css/index_style.css" />" rel="stylesheet">

        <title>Numista - coin collector</title>

    </head>

    <body>
        <!-- Image slider-->
        <div id="slides" class="carousel slide" data-ride="carousel">
            <ul class="carousel-indicators">
                <li data-target="#slides" data-slide-to="0" class="active"></li>
                <li data-target="#slides" data-slide-to="1"></li>
                <li data-target="#slides" data-slide-to="2"></li>
            </ul>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="<c:url value="/resources/img/carousel-1.jpg" />" >
                    <div class="carousel-caption">
                        <h1 class="display-2">Numista</h1>
                        <button type="button" class="btn btn-primary btn-lg">Get Started</button>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="<c:url value="/resources/img/carousel-2.jpg" />">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="<c:url value="/resources/img/carousel-3.jpg" />">
                </div>
            </div>
        </div>

        <!-- Welcome section-->
        <div class="container-fluid">
            <div class="row jumbotron">
                <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
                    <p class="lead">Numista is a service for coin collectors to organize their numismatic wealth. You can separate coins into groups, groups into other groups and so on. Numista has huge selection of different fetures that help you in gathering!</p>
                </div>
            </div>
        </div>
        <div class="container-fluid padding">
            <div class="row welcome text-center">
                <div class="col-12">
                    <h1 class="dispaly-4">Gather with ease.</h1>
                </div>
                <hr>
                <div class="col-12">
                    <p class="lead">Welcome to Numista - Coin collector. It is a free service for all who love numismatics</p>
                </div>
            </div>
        </div>
    </body>

</html>
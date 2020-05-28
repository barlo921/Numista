<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation bar -->
<%@ include file="navbar.jsp" %>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <script src="../../resources/js/main.js"></script>

        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/numista.css" />" rel="stylesheet">

        <title>Numista - Coin collector</title>
    </head>
    <body>
            <!-- Table Section -->

            <div class="container-fluid table-body">

                <h4>Collection Dashboard</h4>

                <div class="row form-inline">
                    <div class="col header">

                        <div class="row">
                            <div class="col-3 btns">
                                <form class="col-btn" method="get" action="/numista/collection/create">
                                    <button class="btn btn-sm btn-dark btn-main" type="submit">Create Collection</button>
                                </form>
                            </div>
                            <div class="col-2 btns">
                                <form class="coin-btn" method="get" action="/numista/coin/create">
                                    <button class="btn btn-sm btn-dark btn-main" type="submit">Add Coin</button>
                                </form>
                            </div>
                        </div>
                        
                    </div>
                    <div class="col search">
                        <span class="float-right">
                        Search:
                        <input type="text" id="searchInput" class="form-control form-control-sm">
                    </span>
                    </div>
                </div>

                <div class="table-wrapper text-center row">

                    <table class="table table-hover table-responsive-sm table-bordered shadow">
                        <thead class="thead-dark">
                            <tr>
                                <th>Name</th>
                                <th>Collection</th>
                                <th>Sub collection</th>
                                <th>Year</th>
                                <th>Country</th>
                                <th style="width: 40%;">Description</th>
                            </tr>
                        </thead>

                        <tbody id="coinsTable">
                            <c:forEach items="${coins}" var="coin">
                                <jsp:useBean id="coin" scope="page" type="com.barlo.numista.to.CoinTO"/>
                                    <tr>
                                        <td><a href="/numista/coin/update?id=${coin.id}">${coin.name}</a></td>
                                        <td><a href="/numista/collection/update?id=${coin.collection.id}">${coin.collection.name}</a></td>
                                        <td><a href="/numista/collection/update?id=${coin.subcollection.id}">${coin.subcollection.name}</a></td>
                                        <td>${coin.year}</td>
                                        <td>${coin.country}</td>
                                        <td>${coin.description}</td>
                                    </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>

                <!-- Pagination section -->
                <!-- Add later -->

                <!--
                <div class="row form-inline footer">
                    <div class="col">
                        Show &nbsp;
                            <select name="show" id="show" class="form-control form-control-sm">
                                <option value="10">10</option>
                                <option value="25">25</option>
                                <option value="50">50</option>
                                <option value="All">All</option>
                            </select>
                    </div>
                    <div class="col">
                        <nav aria-label="Page navigation">
                            <ul class="pagination justify-content-end">
                                <li class="page-item previous disabled"><a class="page-link" href="#">Previous</a></li>
                                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">4</a></li>
                                <li class="page-item next"><a class="page-link" href="#">Next</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>

                -->

            </div>

    </body>
</html>
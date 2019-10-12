<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/numista_style.css" />" rel="stylesheet">
    <title>Numista - Coin collection service</title>
</head>
<body>
<div class="main_btns">
    <form method="get" action="/numista/collection/create">
        <button type="submit">Create Collection</button>
    </form>
    <form method="get" action="/numista/coin/create">
        <button type="submit">Add coin</button>
    </form>
</div>
<div class="collection">
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Collection</th>
            <th>Sub collection</th>
            <th>Year</th>
            <th>Country</th>
            <th>Description</th>
        </tr>
        </thead>
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
    </table>
</div>
<br/>
</body>
</html>

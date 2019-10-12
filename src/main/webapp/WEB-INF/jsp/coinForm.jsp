<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/main.js"/>"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){

            $("#topLevelCollectionsList").change(function(){

                var collectionId = document.getElementById("topLevelCollectionsList").value;

                $.ajax({
                    url: "/api/collections/get_subcollections",
                    type: "GET",
                    data: {id:collectionId},
                    dataType: 'json',
                    success:function(response){

                        var len = response.length;

                        $("#collectionsList").empty();
                        for( var i = 0; i<len; i++){
                            var id = response[i]['id'];
                            var name = response[i]['name'];

                            $("#collectionsList").append("<option value='"+id+"'>"+name+"</option>");

                        }
                    }
                });
            });

        });
    </script>

    <script type="text/javascript">
        $(document).ready(function () {
            var date = new Date().getFullYear() + 1;
            document.getElementById('coinYear').setAttribute("max", date);
        })
    </script>

    <title>Coin</title>
</head>
<body>
<h3>${coin.isNew() ? 'Add new Coin' : 'Update '}${coin.isNew() ? '' : coin.name}</h3>
<form method="post" action="/numista/coin">
    Coin name<span class="required">*</span>:
    <input type="hidden" name="id" value="${coin.id}">
    <input type="text" name="coinName" value="${coin.name}" required maxlength="50"><br/>

    <!-- Collections filtration part-->
    Collection<span class="required">*</span>:
    <select id="topLevelCollectionsList" name="topLevelCollectionsList" required>
        <c:if test="${coin.isNew()}">
            <option value="" selected="selected">--Select--</option>
        </c:if>
        <c:if test="${!coin.isNew()}">
            <option value="${coin.collection.id}">${coin.collection.name}</option>
        </c:if>
        <c:forEach items="${topLevelCollections}" var="topCollection">
            <c:choose>
                <c:when test="${!coin.isNew()}">
                    <c:if test="${coin.collection.name != topCollection.name}">
                        <option value="${topCollection.id}">${topCollection.name}</option>
                    </c:if>
                </c:when>
                <c:otherwise>
                        <option value="${topCollection.id}">${topCollection.name}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select><br/>

    <!-- Subcollections filtration part -->

    <!-- Checkbox for new or update-->
    <c:choose>
        <c:when test="${coin.isNew() || subcollections==null || coin.subcollection==null}">
            <input type="checkbox" id="subcollectionCheck" name="subcollectionCheck" onclick="showCollectionsList()"/> is Subcollection<br/>
        </c:when>
        <c:otherwise>
            <input type="checkbox" id="subcollectionCheck" name="subcollectionCheck" onclick="showCollectionsList()" checked="checked"/> is Subcollection<br/>
        </c:otherwise>
    </c:choose>

    <!-- Choice box display style for new or update -->
    <c:choose>
        <c:when test="${coin.isNew() || subcollections==null || coin.subcollection==null}">
            <select id="collectionsList" name="collectionsList" style="display: none">
        </c:when>
        <c:otherwise>
            <select id="collectionsList" name="collectionsList" style="display: block">
        </c:otherwise>
    </c:choose>

        <!-- Choice box fill part -->
        <c:if test="${coin.isNew()}">
            <option value="" id="loading">--Choose collection first--</option>
        </c:if>
        <c:if test="${!coin.isNew()}">
            <c:forEach items="${subcollections}" var="subcollection">
                <c:choose>
                    <c:when test="${coin.subcollection.name == subcollection.name}">
                        <option selected="selected" value="${subcollection.id}">${subcollection.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${subcollection.id}">${subcollection.name}</option>
                    </c:otherwise>
                    </c:choose>
            </c:forEach>
        </c:if>
    </select>

    <!-- Other params -->
    Year: <input type="number" name="coinYear" id="coinYear" value="${!coin.isNew() ? coin.year : ''}" min="-9999"> <br/>
    Country: <input type="text" name="coinCountry" value="${coin.country}" maxlength="50"><br/>
    Description: <input type="text" name="coinDescription" value="${coin.description}" maxlength="250"><br/>

    <!-- Buttons -->
    <button type="submit">${coin.isNew() ? 'Add ' : 'Update '}coin</button>
    <button type="button" onclick="window.history.back()">Cancel</button>
</form>
</body>
</html>
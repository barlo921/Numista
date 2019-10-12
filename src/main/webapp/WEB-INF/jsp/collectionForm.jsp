<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/main.js"/>"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>

    <script type="text/javascript">

        $(document).ready(function () {

            var oldName = document.getElementById("collectionName").value;
            var validate = false;

            var form = document.getElementById("updateCollection");

            form.addEventListener("submit", function (event) {

                var name = document.getElementById("collectionName").value;

                if (oldName !== name) {
                    validate = true;
                }

                if (validate) {
                    var validity = true;

                    var div = document.getElementById("ajaxText");
                    div.innerHTML = "";

                    $.ajax({
                        url: "/api/collections/get_unique_name",
                        type: "GET",
                        data: {name:name},
                        dataType: 'text',
                        success:function (response) {
                            if (response === 'false') {
                                validity = false;
                            }
                        },
                        async: false
                    });

                    if (!validity) {
                        div.innerHTML += "Name must be Unique";
                        event.preventDefault();
                    }
                }

            })
        });

    </script>

    <title>Collection</title>
</head>
<body>
<jsp:useBean id="collection" scope="request" class="com.barlo.numista.model.Collection"/>
<h3>${collection.isNew() ? 'Create new collection' : 'Update '}${collection.isNew() ? '' : collection.name}</h3>
<form method="post" id="updateCollection" action="/numista/collection">
    Collection name<span class="required">*</span>:
    <input type="hidden" name="id" id="id" value="${collection.id}">
    <input type="text" value="${collection.name}" name="collectionName" id="collectionName" required maxlength="25"/><br/>

    <!-- Warning messages -->
    <div id="ajaxText" class="ajaxText"></div>

    <!-- Subcollections checkbox filtration part -->
    <c:choose>
        <c:when test="${collection.parentId == null}">
            <c:choose>
                <c:when test="${collection.isNew()}">
                    <input type="checkbox" id="subcollectionCheck" name="subcollectionCheck" onclick="showCollectionsList()"/>
                    is Subcollection<br/>
                    <select form="updateCollection" id="collectionsList" name="subcollectionOf" style="display: none">
                </c:when>
                <c:otherwise>
                    <select form="updateCollection" id="collectionsList" name="subcollectionOf" style="display: none">
                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <input type="checkbox" id="subcollectionCheck" name="subcollectionCheck" onclick="return false;" checked="checked"/> is Subcollection<br/>

            <!-- Subcollections choice box filtration part -->
            <select form="updateCollection" id="collectionsList" name="subcollectionOf" style="display: block">
        </c:otherwise>
    </c:choose>
    <c:forEach items="${collections}" var="collectionFromList">
        <jsp:useBean id="collectionFromList" scope="page" class="com.barlo.numista.model.Collection"/>
        <c:choose>
            <c:when test="${collection.parentId == collectionFromList.id}">
                <option selected="selected">${collectionFromList.name}</option>
            </c:when>
            <c:otherwise>
                <option>${collectionFromList.name}</option>
            </c:otherwise>
        </c:choose>
    </c:forEach>
        </select>
        <br/>

        <!-- Buttons -->
        <button id="submit" type="submit" onkeypress="clearAlert()">${collection.isNew() ? 'Create' : 'Update'}</button>
        <button type="button" onclick="window.history.back()">Cancel</button>
</form>
</body>
</html>

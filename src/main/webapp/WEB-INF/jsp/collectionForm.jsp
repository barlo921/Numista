<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Collection</title>
</head>
<body>
<jsp:useBean id="collection" scope="request" class="com.barlo.numista.model.Collection"/>
<h3>${collection.isNew() ? 'Create new collection' : 'Update '}${collection.isNew() ? '' : collection.name}</h3>
<form method="post" id="updateCollection" action="/numista/collection">
    Collection name:
    <input type="hidden" name="id" value="${collection.id}">
    <input type="text" value="${collection.name}" name="collectionName" required/><br/>
    <c:choose>
        <c:when test="${collection.parentId == null}">
            <c:choose>
                <c:when test="${collection.isNew()}">
                    <input type="checkbox" id="subcollectionCheck" name="subcollectionCheck" onclick="showCollectionsList()"/>
                    Subcollection<br/>
                    <select form="updateCollection" id="collectionsList" name="subcollectionOf" style="display: none">
                </c:when>
                <c:otherwise>
                    <select form="updateCollection" id="collectionsList" name="subcollectionOf" style="display: none">
                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <input type="checkbox" id="subcollectionCheck" name="subcollectionCheck" onclick="return false;" checked="checked"/> Subcollection<br/>
            <select form="updateCollection" id="collectionsList" name="subcollectionOf" style="display: block">
        </c:otherwise>
    </c:choose>
    <c:forEach items="${collections}" var="collectionFromList">
            <jsp:useBean id="collectionFromList" scope="page" class="com.barlo.numista.model.Collection"/>
            <option>${collectionFromList.name}</option>
    </c:forEach>
        </select>
        <br/>
        <button type="submit">${collection.isNew() ? 'Create' : 'Update'}</button>
        <button type="button" onclick="window.history.back()">Cancel</button>
</form>

<script type="text/javascript">
    function showCollectionsList() {
        document.getElementById('collectionsList').style.display = 'none';
        if (document.getElementById('subcollectionCheck').checked) {
            document.getElementById('collectionsList').style.display = 'block';
        }
    }
</script>
</body>
</html>

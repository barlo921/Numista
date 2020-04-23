<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation bar -->
<%@ include file="navbar.jsp" %>
<html>
    <head>
        <title>Numista - Sign Up</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">

        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/login_style.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/index_style.css" />" rel="stylesheet">
    </head>
    <body>
        <div class="modal-dialog text-center">
            <div class="col-sm-9 main-section">
                 <div class="modal-content">
 
                     <div class="col-12 user-img">
                         <img src="<c:url value="/resources/img/face.png" />">
                     </div>
 
                     <div class="col-12 form-input">
                        <c:if test="${error != null}">
                                <div class="alert alert-danger" role="alert">
                                    ${error}
                                </div>
                        </c:if>
                         <form class="form-signup" method="post" action="/signup">
                            <div class="form-group">
                                <input type="email" id="email" name="email" class="form-control" placeholder="E-mail" value="${username != null ? username : ''}" required>
                            </div>
                            <div class="form-group">
                                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                            </div>
                            <div class="form-group-confirm">
                                <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="Confirm Password" required>
                            </div>
                            <button type="submit" class="btn btn-success">Sign Up</button>
                            <button type="reset" class="btn btn-success">Clear</button>
                         </form>
                         <hr>
                     </div>
 
                 </div>
            </div>
        </div> 
    </body>
</html>
<%--@elvariable id="errorMessage" type="String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
    <%@include file="css/bootstrap.min.css"%>
</style>

<script>
    <%@include file="js/jquery.min.js"%>
    <%@include file="js/bootstrap.min.js"%>
    <%@include file="js/custom.js"%>
</script>

<html>
<head>
    <title>Login</title>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
</head>

<fmt:setBundle basename="locale" var="loc"/>
<fmt:message bundle="${loc}" key="local.button.Login" var="Login"/>


<body>

<style>
    #appStatusBtn {
        color: #fff;
        background-color: #28a745;
        border-color: #28a745;
    }
</style>
<nav class="navbar navbar-dark bg-primary">
      <a class="navbar-brand" href="/login">Employee Portal</a>
</nav>

<div class="container" style="margin-top:40px">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <h5 class="card-header">${sign_in_continue}Login</h5>
                <div class="card-body">
                    <form role="form" action="/login" method="post" autocomplete="off">
                            <div class="form-group">
                                    <input class="form-control" placeholder="E-Mail" value='${param.email}' name="email" type="text" autofocus required autocomplete="off" maxlength="255" >
                            </div>
                            <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="${param.password}" autocomplete="off" required maxlength="255">
                            </div>
	                            <c:if test="${not empty errorMessage}">
                                <div class="alert alert-danger">
                                    <strong>
                                        ${errorMessage}
                                    </strong>
                                </div>
                            </c:if>
                            <c:if test="${not empty sucessMessage}">
                                <div class="alert alert-danger">
                                    <strong>
                                        ${sucessMessage}
                                    </strong>
                                </div>
                            </c:if>
                        <center>
                            <div class="form-group">
                                <input type="submit" class="btn btn-md btn-primary" value="${Login}">
                            </div>
                        </center>
                    </form>
                     </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
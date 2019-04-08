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
    <title>Insurance Portal</title>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
</head>

<fmt:setBundle basename="locale" var="loc"/>
<fmt:message bundle="${loc}" key="local.button.Login" var="Login"/>


<body>

<nav class="navbar navbar-dark bg-primary">
    <a class="navbar-brand" href="/insuranceStatus">Insurance Inc.</a>
</nav>

<div class="container" style="margin-top:40px">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <h5 class="card-header">Check Insurance</h5>
                <div class="card-body">
                    <form role="form" action="/login" method="post" autocomplete="off">
                        <div class="form-group">
                            <input class="form-control" placeholder="MBR Applicant Name" name="name" type="text" autofocus required autocomplete="off" maxlength="255" >
                        </div>

                        <div class="form-group">
                            <label for="selectMsid">Select MSID</label>
                            <select class="form-control" id="selectMsid">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <input class="form-control" placeholder="MBR Link" value='${param.email}' name="mbrlink" type="text" autofocus required autocomplete="off" maxlength="255" >
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
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
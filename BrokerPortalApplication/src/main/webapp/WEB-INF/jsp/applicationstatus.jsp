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
<fmt:message bundle="${loc}" key="local.label.get_status" var="get_status"/>

<body>

<nav class="navbar navbar-dark bg-primary">
    <a class="navbar-brand" href="/mortgageapplicationform">Broker Portal</a>
    <button class="btn btn-outline-success" id="appStatusBtn" type="button">Application Status</button>
</nav>

<div class="container" style="margin-top:40px">
<c:if test="${not empty successMessage}">
									<div class="alert alert-success" role="alert">
  <a href="#" class="alert-link">${successMessage}!!</a>
</div>
								</c:if>
<c:if test="${not empty errorMessage}">
                            <div class="alert alert-danger" role="alert">
                                <strong>
                                        ${errorMessage}
                                </strong>
                            </div>
                        </c:if>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>Check Application Status</strong>
                </div>
                <div class="panel-body">
                    <form role="form" action="/applicationstatus" method="post" autocomplete="off">
                        <div class="col-sm-12 col-md-10 col-md-offset-1 ">
                            <div class="form-group">
                                <div class="input-group">
                                      <span class="input-group-addon">
                                          <i class="glyphicon glyphicon-user"></i>
                                      </span>
                                    <input class="form-control" placeholder="E-Mail" value='${param.email}' name="email" type="text" autofocus required autocomplete="off" maxlength="255" >
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                      <span class="input-group-addon">
                                          <i class="glyphicon glyphicon-lock"></i>
                                      </span>
                                    <input class="form-control" placeholder="Application Number" name="applicationNumber" type="text" value="${param.applicationNumber}" autocomplete="off" required maxlength="255">
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn btn-lg btn-primary btn-block" value="Submit">
                            </div>
                        </div>
                    </form>
                     </div>
                 <p style="text-align:right;margin-right: 25px;margin-top: -10px;margin-bottom: 15px">
                     New Member? <a href="/mortgageapplicationform" onClick="">signUp </a> 
                </p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
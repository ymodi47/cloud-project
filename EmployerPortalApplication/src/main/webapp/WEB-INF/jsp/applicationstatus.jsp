<%--@elvariable id="errorMessage" type="String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<style type="text/css">
    <%@include file="css/bootstrap.min.css"%>
    <%@include file="css/bootstrap-formhelpers.min.css"%>
</style>
<script>
    <%@include file="js/jquery.min.js"%>
    <%@include file="js/bootstrap.min.js"%>
    <%@include file="js/bootstrap-formhelpers.min.js"%>
</script>

<html>
<head>
    <title>Login</title>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
</head>

<fmt:setBundle basename="locale" var="loc"/>
<fmt:message bundle="${loc}" key="local.button.Submit" var="Submit"/>

<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Employer Portal</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">               
      
        <li><a href="#">New Member?</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container" style="margin-top:40px">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>${sign_in_continue}Check Status of an Application</strong>
                </div>
                 
                <div class="panel-body">
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
                 
                    <form role="form" action="/applicationstatus" method="post" autocomplete="off">
                        <div class="col-sm-12 col-md-10 col-md-offset-1 ">
                            <div class="form-group">
                                <div class="input-group">
                                      <span class="input-group-addon">
                                          <i class="glyphicon glyphicon-user"></i>
                                      </span>
                                    <input class="form-control" placeholder="Mortage ID" value="" name="link" type="text" autofocus required autocomplete="off" maxlength="255" >
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                      <span class="input-group-addon">
                                          <i class="glyphicon glyphicon-link"></i>
                                      </span>
                                    <input class="form-control" placeholder="Mortage Link" name="applicationNumber" type="text" value="" autocomplete="off" required maxlength="255">
                                </div>
                            </div>
                            	                           
                            <div class="form-group">
                                <input type="submit" class="btn btn-lg btn-primary btn-block" id ="btnGetStatus" value="${Submit}">
                            </div>
                        </div>
                    </form>
                     </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
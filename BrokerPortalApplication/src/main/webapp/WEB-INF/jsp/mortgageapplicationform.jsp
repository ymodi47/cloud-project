<%--@elvariable id="errorMessage" type="String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style type="text/css">
    <%@include file="css/chat.css"%>
    <%@include file="css/bootstrap.min.css"%>
    <%@include file="css/bootstrap-formhelpers.min.css"%>
</style>
<script>
    <%@include file="js/jquery.min.js"%>
    <%@include file="js/avatar.js"%>
    <%@include file="js/bootstrap.min.js"%>
    <%@include file="js/bootstrap-formhelpers.min.js"%>
</script>

<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
</head>

<fmt:setBundle basename="locale" var="loc"/>
<fmt:message bundle="${loc}" key="local.label.sign_up_here" var="sign_up_here"/>

<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Broker Portal</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/applicationstatus">Application Status</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container" style="margin-top:40px">
<c:if test="${not empty successMessage}">
									<div class="alert alert-success" role="alert">
  <a href="#" class="alert-link">${successMessage}!! Your Application number is ${applicationNumber} and link is ${link}.</a>
  <script type="text/javascript">
  //document.mortgageForm.reset();
  </script>
</div>
								</c:if>
<c:if test="${not empty errorMessage}">
                            <div class="alert alert-danger" role="alert">
                                <strong>
                                        ${errorMessage}
                                </strong>
                            </div>
                        </c:if>
                        
    <div class="row centered-form">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>Fill Application form </strong>
                </div>
                <div class="panel-body">
                    <form role="form" name="mortgageForm" action="/mortgageapplicationform" method="post" autocomplete="off">
                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control" placeholder="E-Mail" required maxlength="255" value='${param.email}'>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="firstName" id="firstName" class="form-control" placeholder="First name" required maxlength="255" value='${param.firstName}'>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="lastName" id="lastName" class="form-control" placeholder="Last name" required maxlength="255" value='${param.lastName}'>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="address" id="address" class="form-control" required maxlength="255" placeholder="Address" value='${param.address}'>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="phoneNumber" id="phoneNumber" class="form-control" onkeypress="return isNum(event)" maxlength="10" required placeholder="Phone Number" value='${param.phoneNumber}'>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="employerName" id="employerName" class="form-control" required maxlength="255" placeholder="Employer" value='${param.employerName}'>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="Salary" id="salary" onkeypress="return isNum(event)" maxlength="12" class="form-control" required placeholder="Salary" value='${param.salary}'>
                                </div>
                            </div>
                        </div>
                        <center>
                        <div class="form-group">
                            <input type="submit" style="max-width:150px" class="btn btn-lg btn-primary btn-block" value="Submit" >
                        </div>
                        </center>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
function isNum(evt) {
    evt = (evt) ? evt : window.event;
    var ch = (evt.which) ? evt.which : evt.keyCode;
    if (ch > 31 && (ch < 48 || ch > 57))  {
        return false;
    }
    return true;
}
</script>

</body>
</html>

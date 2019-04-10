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
    <title>Real Estate Status</title>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
</head>

<fmt:setBundle basename="locale" var="loc"/>
<fmt:message bundle="${loc}" key="local.button.Login" var="Login"/>


<body>

<nav class="navbar navbar-dark bg-primary">
    <a class="navbar-brand" href="/status">Real Estate</a>
</nav>


<div class="container" style="margin-top:40px">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <h5 class="card-header">Check application status</h5>
                <div class="card-body">
                    <form role="form" action="/appraiservalue" method="post" autocomplete="off">
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Select MSID</label>
                            <select class="form-control" id="mSID" name="mSID" value='${param.mSID}'>
                                <option value="1" >1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <input type="text" name="mortgageID" id="mortgageID" class="form-control" placeholder="Mortgage ID" required maxlength="255" autocomplete="off" value='${param.mortgageID}'>
                        </div>
                        <div class="form-group">
                            <input type="text" name="applicantName" id="applicantName" class="form-control" placeholder="MBR Applicant Name" required maxlength="255" autocomplete="off" value='${param.applicantName}'>
                        </div>
                        <div class="form-group">
	                            <c:if test="${not empty errorMessage}">
	                                <div class="alert alert-danger">
	                                    <strong>
	                                            ${errorMessage}
	                                    </strong>
	                                </div>
	                            </c:if>
	                            <c:if test="${not empty sucessMessage}">
                                <div class="alert alert-success">
                                    <strong>
                                            ${sucessMessage}
                                    </strong>
                                </div>
                            </c:if>                           
                         </div>
						<div class="form-group">
                                  <center>
                                <input type="submit" class="btn btn-md btn-primary" value="${Login}">
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
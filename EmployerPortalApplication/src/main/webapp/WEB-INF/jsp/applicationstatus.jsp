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
    <title>Application Status</title>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
</head>

<fmt:setBundle basename="locale" var="loc"/>
<fmt:message bundle="${loc}" key="local.button.Submit" var="Submit"/>

<body>

<style>
    .btn-outline-success {
        color: #fff;
        background-color: #28a745;
        border-color: #28a745;
    }
</style>

<nav class="navbar navbar-dark bg-primary">
      <a class="navbar-brand" href="/login">Employee Portal</a>
      <div style="float:right">
		  <button class="btn btn-md- btn-outline-success" onclick="javascript:location.href='/logout'">Logout</button>
	  </div>
</nav>

<div class="modal fade" id="tcModal" tabindex="-1" role="dialog" aria-labelledby="tcModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">

			<div class="modal-header">
				<h5 class="modal-title">Terms and Conditions</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body">
				<p>You agree that provided link, will be used to invoke to verify user details.</p>
			</div>
		</div>
	</div>
</div>

<div class="container" style="margin-top:40px">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <h5 class="card-header">${sign_in_continue}Check application status</h5>
                <div class="card-body">
                
                	<div class="panel-body">
		                  <c:if test="${not empty errorMessage}">
							  <div class="alert alert-danger">
								  <strong>
										  ${errorMessage}
								  </strong>
							  </div>
						  </c:if>

						<c:if test="${not empty successMessage}" >
							<div class="alert alert-success" id="alertMsg">
								<strong>
										${successMessage}
								</strong>
							</div>
						</c:if>
		                 
						<form role="form" action="/applicationstatus" method="post" autocomplete="off">
							<div class="form-group">
								<input class="form-control" placeholder="Mortage ID" value="" name="applicationNumber" type="text" autofocus required autocomplete="off" maxlength="255" >
							</div>

							<div class="form-group">
								<input class="form-control" placeholder="Mortage Link" name="link" type="text" value="" autocomplete="off" required maxlength="255">
							</div>

							<div class="form-check">
								<input class="form-check-input" type="checkbox" id="tcCheckBox">
								<label class="form-check-label" for="tcCheckBox">
									<a href="javascript:void(0);" data-toggle="modal" data-target="#tcModal">Terms & Conditions*</a>
								</label>
							</div>

							<center>
								<div class="form-group">
									<input type="submit" class="btn btn-md btn-primary" id ="btnGetStatus" value="${Submit}" disabled>
								</div>
							</center>
						</form>
					</div>
            	</div>
        	</div>
    	</div>
	</div>
</div>

<script>
	$(document).ready(function() {

		$("#tcCheckBox").on('change',function() {

			if ($(this).is(":checked")) {
				$("#btnGetStatus").removeAttr("disabled");
			} else {
				$("#btnGetStatus").attr("disabled", "disabled");
			}
		});
		$("#alertMsg").fadeTo(2000, 500).slideUp(500, function () {
			$("#alertMsg").slideUp(500);
		});
	});
</script>
</body>
</html>
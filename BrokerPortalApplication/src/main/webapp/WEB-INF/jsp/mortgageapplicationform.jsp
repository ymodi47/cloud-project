<%--@elvariable id="errorMessage" type="String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style>
<%@
include
 
file="css/bootstrap.min.css"%>
</style>

<script>
    <%@include file="js/jquery.min.js"%>
    <%@include file="js/bootstrap.min.js"%>
    <%@include file="js/custom.js"%>
</script>


<html>
<head>
<title>Registration</title>
<meta charset="utf-8" name="viewport"
	content="width=device-width, initial-scale=1">
</head>

<fmt:setBundle basename="locale" var="loc" />
<fmt:message bundle="${loc}" key="local.button.Submit" var="Submit" />
<body>

	<nav class="navbar navbar-dark bg-primary">
		<a class="navbar-brand" href="/mortgageapplicationform">Broker
			Portal</a>
		<button class="btn btn-outline-success" id="appStatusBtn"
			type="button">Application Status</button>
	</nav>

	<div class="container" style="margin-top: 40px">
		<%-- <c:if test="${not empty successMessage}"> --%>
		<!-- <div class="alert alert-success" role="alert"> -->
		<%--   <a href="#" class="alert-link">${successMessage}!! Your Application number is ${applicationNumber} and link is ${link}.</a> --%>
		<!--   <script type="text/javascript"> -->
		<!--   document.mortgageForm.reset(); -->
		<!--   </script> -->
		<!-- </div> -->
		<%-- </c:if> --%>
		<%-- <c:if test="${not empty errorMessage}"> --%>
		<!--                             <div class="alert alert-danger" role="alert"> -->
		<!--                                 <strong> -->
		<%--                                         ${errorMessage} --%>
		<!--                                 </strong> -->
		<!--                             </div> -->
		<%--                         </c:if> --%>

		<div class="row">
			<div class="col-md-6">
				<div class="card">
					<h5 class="card-header">New Applicant</h5>
					<div class="card-body">

						<div class="panel-body">
							<form role="form" name="mortgageForm"
								action="/mortgageapplicationform" method="post"
								autocomplete="off">
								<div class="form-group">
									<input type="text" name="applicantName" id="applicantName"
										class="form-control" placeholder="Applicant Name" required
										maxlength="255" value='${param.applicantName}'>
								</div>
								<div class="form-group">
									<input type="text" name="MortgageValue" id="MortgageValue"
										class="form-control" placeholder="Mortgage Value" required
										maxlength="255" value='${param.MortgageValue}'>
								</div>

								<div class="form-group">
									<select id="mSID" name ="mSID"
										class="form-control" value='${param.mSID}'>
										<option value="">MSID</option>
										<option value="1">ms1</option>
										<option value="2">ms2</option>
										<option value="3">ms3</option>
										<option value="4">ms4</option>
										<option value="5">ms5</option>
									</select>
								</div>

								<div class="form-group">
									<input type="text" name="employerName" id="employerName"
										class="form-control" placeholder="Employer Name" required
										maxlength="255" value='${param.employerName}'>
								</div>
								<div class="form-group">
									<input type="password" name="Pswd" id="Pswd"
										class="form-control checkpw" placeholder="Password" required
										maxlength="15" value='${param.Pswd}'>
								</div>
								<div class="form-group">
									<input type="password" name="conPswd" id="conPswd"
										class="form-control checkpw" placeholder="Confirm Password"
										required maxlength="15">
								</div>

								<div class="form-group">
									<center>
										<input type="submit" style="max-width: 150px"
											id="btnSubmitNew" class="btn btn-md btn-primary"
											value="Submit" disabled="disabled">
									</center>
								</div>

							</form>
						</div>
						<div class="panel-footer">
							<c:if test="${not empty errorMessage}">
								<div class="alert alert-danger">
									<strong> ${errorMessage} </strong>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="card">
					<h5 class="card-header">Existing Applicant</h5>
					<div class="card-body">

						<div class="panel-body">
							<form role="form" action="/login" method="post"
								autocomplete="off">
								<div class="col-sm-12 col-md-10 col-md-offset-1 ">
									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-user"></i>
											</span> <input class="form-control" placeholder="Mortgage ID"
												value='${param.MortgageId}' name="MortgageId" type="text"
												required autocomplete="off" maxlength="255">
										</div>
									</div>
									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-lock"></i>
											</span> <input class="form-control" placeholder="Password"
												name="password" type="password" value="${param.password}"
												autocomplete="off" required maxlength="255">
										</div>
									</div>
									<div class="form-group">
										<center>
											<input type="submit" style="max-width: 150px"
												id="btnSubmitExist" class="btn btn-md btn-primary"
												value="Submit">
										</center>
									</div>
								</div>
							</form>
						</div>
						<div class="panel-footer">
							<c:if test="${not empty errorMessage}">
								<div class="alert alert-danger">
									<strong> ${errorMessage} </strong>
								</div>
							</c:if>
						</div>

					</div>
				</div>
			</div>
		</div>
		<script>
                $(document).ready(function(){
                    $("#appStatusBtn").on('click',function () {
                        window.location.href="/applicationstatus";
                    });

                    $('.checkpw').on('change',function(){
                        if ($('#Pswd').val() == $('#conPswd').val()) {
                            $("#conPswd").css("color", "green");
                            $("#btnSubmitNew").prop('disabled', false);
                        }
                        else
                        {
                            $("#conPswd").css("color", "red");
                            $("#btnSubmitNew").prop('disabled', true);
                        }
                    });
                });
            </script>
</body>
</html>

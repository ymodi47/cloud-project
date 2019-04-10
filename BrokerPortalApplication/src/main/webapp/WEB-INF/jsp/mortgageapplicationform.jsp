<%--@elvariable id="errorMessage" type="String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style>
	<%@include file="css/bootstrap.min.css"%>
</style>

<script>
	<%@include file="js/jquery.min.js"%>
	<%@include file="js/bootstrap.min.js"%>
	<%@include file="js/custom.js"%>
</script>

<script>
    $(document).ready(function(){
        $('#pwalert').hide();
        $("#oldUser").hide();
        $(".formBtn").on('click',function () {
            $("#oldUser").toggle();
            $("#newUser").toggle();
        });
        $("#appStatusBtn").on('click',function () {
            window.location.href="/applicationstatus";
        });

        $('form[name="mortgageForm"]').submit(function(){
            if ($('#Pswd').val() != $('#conPswd').val()) {
                // $("#conPswd").css("color", "green");
                // $("#btnSubmitNew").prop('disabled', false);
                $('#pwalert').show();
                $("#pwalert").fadeTo(2000, 500).slideUp(500, function () {
                    $("#pwalert").slideUp(500);
                });
                return false;
            }
        });

    });
</script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/superagent/2.2.0/superagent.min.js"></script>


<html>
<head>
	<title>Registration</title>
	<meta charset="utf-8" name="viewport"
		  content="width=device-width, initial-scale=1">
</head>

<fmt:setBundle basename="locale" var="loc" />
<body>

<nav class="navbar navbar-dark bg-primary">
	<a class="navbar-brand" href="/mortgageapplicationform">Broker
		Portal</a>
</nav>

<div class="container" style="margin-top: 20px">
	<div class="row">
		<div class="col-md-12">
			<div class="alert alert-danger show" id="pwalert" role="alert">
				Password didn't match! Please check password and confirm password
			</div>
		</div>
        <c:if test="${not empty statusMessage}">
        <div class="col-md-12">
            <div class="alert alert-success" role="alert" role="alert">
                <p>${statusMessage}</p>
            </div>
        </div>
        <script>
            $(document).ready(function(){
                $("#newUser").hide();
                $("#oldUser").show();
            });
        </script>
        </c:if>
		<c:if test="${not empty link}">

			<div class="col-md-12">
				<div class="alert alert-success" role="alert" id="misuccessalert" role="alert">
					<p>Application submitted successfully!!</p>
					<p>Your link is <strong>${link}</strong></p>
					<p>Your mortgage id is <strong>${MortageID}</strong></p>
					<input type="hidden" id="mid1" value="${MortageID}">
					<input type="hidden" id="an1" value="${applicantName}">
					<input type="hidden" id="mv1" value="${mortVal}">
					<input type="hidden" id="mod1" value="${mortID}">
					<input type="hidden" id="emp1" value="${empname}">
				</div>
			</div>
			<script>
				$(document).ready(function(){
					var mid1 = $('#mid1').val();
					var an1 = $('#an1').val();
					var mv1 = $('#mv1').val();
					var mod1 = $('#mod1').val();
					var emp1 = $('#emp1').val();
					function logicappservice(){
						superagent
								.post('https://prod-07.eastus.logic.azure.com:443/workflows/513529114ba645a0962f6c118fd9557b/triggers/manual/paths/invoke?api-version=2016-10-01&sp=%2Ftriggers%2Fmanual%2Frun&sv=1.0&sig=bIRUQ2yAkb2XJarOsaHcE3P8ReIM1cvqmsMDbGYdics')
								.send({
									applicantName: an1,
									MortgageValue: mv1,
									mSID: mod1,
									employerName: emp1,
									MortID:mid1
								})
								.end(function (err, res) {
									if (err || !res.ok) {
										alert('Whoops. Something went wrong.');
									} else {
										$("#oldUser").toggle();
										$("#newUser").toggle();
									}
								});
						return false;
					}
					$(".form-control").val("");
					logicappservice();
				});
			</script>
		</c:if>
	</div>
	<div class="row">
		<div class="col-md-6 offset-md-3" id="newUser">
			<div class="card">
				<h5 class="card-header">New Applicant</h5>
				<div class="card-body">

					<div class="panel-body">
						<form role="form" name="mortgageForm" id="mortgageForm"
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
										class="form-control" value='${param.mSID}' required>
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
								<input type="password" name="password" id="Pswd"
									   class="form-control checkpw" placeholder="Password" required
									   maxlength="15" value='${param.password}'>
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
										   value="Submit">
								</center>
							</div>

							<p>Already a member? <a href="#" class="formBtn">Check Status</a></p>
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

		<div class="col-md-6 offset-md-3" id="oldUser">
			<div class="card">
				<h5 class="card-header">Existing Applicant</h5>
				<div class="card-body">

					<div class="panel-body">
						<form role="form" action="/applicationstatus" method="post" autocomplete="off">
							<div class="col-sm-12 col-md-10 col-md-offset-1 ">
								<div class="form-group">
									<div class="input-group">
											<span class="input-group-addon"> <i
													class="glyphicon glyphicon-user"></i>
											</span> <input class="form-control" placeholder="Mortgage ID" id="applicantID"
														   value='${param.applicantID}' name="applicantID" type="text"
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
							<p>New member? <a href="#" class="formBtn">Registration</a></p>
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
</div>
</body>
</html>

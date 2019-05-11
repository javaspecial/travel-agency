<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Travel-agency</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Travel-agency" />

<%@ page isELIgnored="false"%>
<link rel="shortcut icon"
	href="<spring:url value="/resources/icon/title.png"/>" />

<!-- from cdn server download -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet prefetch'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<!-- from resources folder -->
<script src="<spring:url value="/resources/js/index.js" />"></script>
<script
	src="<spring:url value="/resources/js/ajax.login_registration.js" />"></script>
<link rel="stylesheet"
	href="<spring:url value="/resources/css/style1.css" />">
</head>
<body onload="load();">
	<div class="logmod">
		<div class="logmod__wrapper">
			<div class="logmod__container" style="height: 65%">
				<ul class="logmod__tabs">
					<li data-tabtar="lgm-2"><a href="#">${welcomeMSG}</a></li>
				</ul>
				<div class="logmod__tab-wrapper" id="logmod__container">
					<div class="logmod__tab lgm-2">
						<div class="logmod__form" style="overflow: visible;">
							<form id="loginForm" role="form" ModelAttribute="model_name"
								action="url" method="post">
								<div class="sminputs">
									<label class="custom-padding">Status</label>
									<textarea style="width: 100%" rows="4" class="custom-padding"></textarea>
									<label class="custom-padding">Choose privacy</label><br>
									&nbsp;&nbsp;&nbsp;<input type="radio" name="gender"
										value="male"> Public&nbsp;&nbsp;<input type="radio"
										name="gender" value="female"> Private<br> <label
										class="custom-padding">Chechk in</label><br>

									<!--load list of locations from ModelAndAttribute via UsersController-->
									<!-- using url locations -->
									<select style="width: 100%" class="custom-padding">
										<option value="NONE">--- Select a location ---</option>
										<c:forEach var="location" items="${locations}">
											<option value="${location.locationId}">${location.locationName}</option>
										</c:forEach>
									</select>
								</div>
								<div class="simform__actions">
									<button class="sumbit" name="commit">Post</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
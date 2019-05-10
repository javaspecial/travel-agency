<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<li data-tabtar="lgm-2"><a href="#">Login</a></li>
					<li data-tabtar="lgm-1"><a href="#">Sign Up</a></li>
				</ul>
				<div class="logmod__tab-wrapper" id="logmod__container">
					<div class="logmod__tab lgm-1">
						<div class="logmod__heading">
							<span class="logmod__heading-subtitle">Enter your email
								and password <strong>to sign up</strong>
							</span><span id="signUP" style="color: red">${signUpMSG}</span>
						</div>
						<div class="logmod__form">
							<div class="sminputs">
								<div class="input full">
									<label class="string optional" for="user-name">Email*<small><span
											id="regex"></span></small></label> <input onkeyup="checkEmailValidation()"
										class="string optional" maxlength="255" id="user-email"
										placeholder="shadathcse@gmail.com" type="text" name="email"
										size="50" />
								</div>
							</div>
							<div class="sminputs">
								<div class="input string optional">
									<label class="string optional" for="user-pw">Password *<small><span
											id="showPassword"></span></small></label> <input class="string optional"
										maxlength="20" id="user-pw" placeholder="expected 8********"
										type="password" name="user-pw" size="50"
										onkeyup="checkRepeat()" />
								</div>
								<div class="input string optional">
									<label class="string optional" for="user-pw-repeat">Repeat
										password *<small><span id="message"></span></small>
									</label> <input class="string optional" maxlength="20"
										id="user-pw-repeat" placeholder="expected 8********"
										type="password" size="50" onkeyup="checkRepeat()" />
								</div>
							</div>
							<div class="simform__actions">
								<input type="submit" onclick="submit();" class="sumbit"
									id="submit" name="commit" value="Sign up" />&nbsp;&nbsp;<input
									type=checkbox name="terms_privacy" value="terms_privacy"
									id="terms_privacy" onclick="changeColor()"><a
									class="special" id="terms_privacy_link" href="#"
									target="_blank" role="link"> Terms & Privacy</a>
							</div>
						</div>
					</div>
					<div class="logmod__tab lgm-2">
						<div class="logmod__heading">
							<span class="logmod__heading-subtitle">Enter your email
								and password <strong>to sign in</strong>
							</span><span style="color: red">${loginFailedMSG}</span>
						</div>
						<div class="logmod__form">
							<form id="loginForm" role="form" ModelAttribute="Users"
								action="login" method="post">
								<div class="sminputs">
									<div class="input full">
										<label class="string optional" for="user-name">Email*</label>
										<input type="text" id="name" required="required"
											name="user_name" class="string optional" maxlength="255"
											placeholder="shadathcse@gmail.com" size="50"><input
											type="hidden" id="user_id">
									</div>
								</div>
								<div class="sminputs">
									<div class="input full">
										<label class="string optional" for="user-pw">Password
											*</label> <input type="password" id="email" size="50"
											required="required" placeholder="*****" name="password"
											class="string optional" maxlength="255"> <span
											class="hide-password">Show</span>
									</div>
								</div>
								<div class="simform__actions">
									<button class="sumbit" name="commit">Login</button>
									&nbsp; <a class="special" role="link" href="#">Forgot your
										password? </a>
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
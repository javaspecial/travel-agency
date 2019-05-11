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
<script src="<spring:url value="/resources/js/ajax.post_status.js" />"></script>
<link rel="stylesheet"
	href="<spring:url value="/resources/css/style1.css" />">
</head>
<body>
	<div id="containerDiv" class="logmod" style="overflow-y: auto;">
		<div class="logmod__wrapper">
			<div class="logmod__container" style="height: 65%">
				<ul class="logmod__tabs">
					<li data-tabtar="lgm-2"><a href="#">${userEmail}</a></li>
					<li data-tabtar="lgm-1"><a href="#">Home</a></li>
				</ul>
				<div class="logmod__tab-wrapper" id="logmod__container">
					<div class="logmod__tab lgm-2">
						<div class="logmod__form">
							<div class="sminputs">
								<input type="hidden" id="statusId" name="statusId"
									value="${statusId}"> <input type="hidden"
									id="userEmail" name="userEmail" value="${userEmail}"> <input
									type="hidden" id="userId" name="userId" value="${userId}"><label
									class="custom-padding">Status <span
									id="input_validation" style="color: red; margin-left: 10px;"></span>
								</label>
								<textarea id="statusText" style="width: 100%" rows="4"
									class="custom-padding"></textarea>
								<label class="custom-padding">Choose privacy</label><br>
								&nbsp;&nbsp;&nbsp;<input type="radio" name="privacy"
									value="public" checked> Public&nbsp;&nbsp;<input
									type="radio" name="privacy" value="private"> Private<br>
								<label class="custom-padding">Chechk in</label><br>

								<!--load list of locations from ModelAndAttribute via UsersController-->
								<!-- using url locations -->
								<select id="location" style="width: 100%" class="custom-padding">
									<option value="NONE">--- Select a location ---</option>
									<c:forEach var="location" items="${locations}">
										<option value="${location.locationName}">${location.locationName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="simform__actions">
								<button id="postSaveButton" onclick="postStatus(true);"
									class="sumbit" name="commit">Post Save</button>
								<button id="postUpdateButton" onclick="postStatus(false);"
									class="sumbit" name="commit">Post update</button>
							</div>
						</div>
						<div class="sminputs">
							<h5>Your time line activity:</h5>
							<div class="timeLineStatus">
								<c:forEach var="status" items="${allStatusByUserId}">
									<p>
										<i class="fa fa-user" aria-hidden="true"></i>&nbsp;${status.userName}
										<button onclick="doDeletePost('${status.statusId}');"
											id="${status.statusId}" value="${status.statusId}">Delete
											post</button>
										<button onclick="doEditPost('${status.statusId}');"
											id="${status.statusId}" value="${status.statusId}">Edit
											post</button>
									</p>
									<p>
										<i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;${status.statusDisplayText}
									</p>
									<p>
										<i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp;at&nbsp;${status.statusLocation}
									</p>
									<hr>
								</c:forEach>
								<center>
									<form id="loginForm" role="form" action="logout" method="post">
										<input type="submit" value="Logout" />
									</form>
								</center>
							</div>
						</div>
					</div>
					<div class="logmod__tab lgm-1">
						<div class="logmod__form">
							<div class="sminputs">
								<h5>All status:</h5>
								<div class="timeLineStatus">
									<c:forEach var="status"
										items="${allStatusSortedByPrivacyPublic}">
										<p>
											<i class="fa fa-user" aria-hidden="true"></i>&nbsp;${status.userName}
										</p>
										<p>
											<i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;${status.statusDisplayText}
										</p>
										<p>
											<i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp;at&nbsp;${status.statusLocation}
										</p>
										<hr>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		window.onload = function() {
			//considering there aren't any hashes in the urls already
			if (!window.location.hash) {
				//setting window location
				window.location = window.location + '#loaded';
				//using reload() method to reload web page
				window.location.reload();
			}
		}
	</script>
</body>
</html>
//redirect to login
function redirect() {
	$.ajax({
		type : "GET",
		url : 'index',
		data : "",
		success : function() {
			alert('*Your are redirected to login*');
			location.reload();
		}
	});
};

// post request for registration
function submit() {
	var checked = document.getElementById('terms_privacy').checked;
	var signup_msg = document.getElementById('signUP');
	if (!checked) {
		signup_msg.innerHTML = "You should be checked terms & privacy"
		return;
	}
	$.ajax({
		url : 'registration',
		type : 'POST',
		data : {
			email : $('#user-email').val(),
			password : $('#user-pw').val(),
		},
		success : function(response) {
			if (response.signUpMSG === 'mandetory') {
				signup_msg.innerHTML = "All fields like * is mandetory";
				return false;
			}
			if (response.signUpMSG === 'successfull') {
				redirect();
				return true;
			}
			if (response.signUpMSG === 'notCreated') {
				signup_msg.innerHTML = "Your account was not created!";
				return false;
			}
		},
		error : function(xhr, status, err) {
			alert(err);
			load();
		}
	});
}

// check repeat password
function checkRepeat() {
	if (showPassword()) {
		if (checkRepeatPass()) {
			document.getElementById('submit').disabled = false;
			document.getElementById('message').innerHTML = "Matched";
			document.getElementById('message').style.color = "BLACK";
		} else {
			document.getElementById('submit').disabled = true;
			document.getElementById('message').innerHTML = "Mismatch";
			document.getElementById('message').style.color = "red";
		}
	}
}
function checkRepeatPass() {
	var repeat_password = document.getElementById('user-pw-repeat');
	var password = document.getElementById('user-pw');
	return password.value !== "" && password.value === repeat_password.value;
}
// check email validation
function checkEmailValidation() {
	var txtEmail = document.getElementById('user-email');
	if (regex()) {
		userAlreadyExist();
	} else {
		document.getElementById('regex').innerHTML = "Your email is incorrect";
		document.getElementById('regex').style.color = "red";
		document.getElementById('submit').disabled = true;
	}
}
// user already exist
function userAlreadyExist() {
	var regex = document.getElementById('regex');
	var btnSubmit = document.getElementById('submit');
	$.ajax({
		url : 'existEmail',
		type : 'POST',
		data : {
			email : $('#user-email').val()
		},
		success : function(response) {
			if (response.message === 'exist') {
				regex.innerHTML = "Your email is used";
				regex.style.color = "red";
				btnSubmit.disabled = true;
			} else {
				regex.innerHTML = "Your email is accepted";
				regex.style.color = "BLACK";
				btnSubmit.disabled = false;
			}
		},
		error : function(xhr, status, err) {
			alert(err);
			load();
		}
	});
}
// password as text display
function showPassword() {
	var password = document.getElementById("user-pw").value;
	var showPassword = document.getElementById('showPassword');
	var btnDisable = document.getElementById('submit');
	if (password.length < 8) {
		showPassword.innerHTML = "expected 8********";
		showPassword.style.color = "red";
		btnDisable.disabled = true;
		return false;
	} else {
		showPassword.innerHTML = "Your password is good";
		btnDisable.disabled = false;
		showPassword.style.color = "black";
		return true;
	}
}
// email check regex
function regex() {
	var email = document.getElementById('user-email').value;
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(String(email).toLowerCase());
}
function changeColor() {
	var checked = document.getElementById('terms_privacy').checked;
	if (checked) {
		document.getElementById('terms_privacy_link').style.color = "BLACK";
	} else {
		document.getElementById('terms_privacy_link').style.color = "red";
	}
}

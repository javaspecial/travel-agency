// post request for post a status
function postStatus(saveOrUpdate) {
	var input_validation = document.getElementById('input_validation');

	var statusText = document.getElementById('statusText').value;
	var privacy = document.getElementsByName('privacy');
	var location = document.getElementById("location");
	var locationName = location.options[location.selectedIndex].value;
	var userEmail = document.getElementById('userEmail').value;
	var userId = document.getElementById('userId').value;
	var statuId = $('#statusId').val();

	if (statusText == '') {
		input_validation.innerHTML = "*Write something on status...."
		return;
	}
	if (locationName == 'NONE') {
		input_validation.innerHTML = "*Select a location...."
		return;
	}

	var postPrivacy = '';
	if (privacy[0].checked) {
		postPrivacy = privacy[0].value;
	} else {
		postPrivacy = privacy[1].value;
	}

	var statusURL = '';
	var postStatusDebug = '';
	if (saveOrUpdate === true) {
		statusURL = 'postStatusSave';
		postStatusDebug = '*You are posted on your time line*';
	} else {
		statusURL = 'postStatusUpdate';
		postStatusDebug = '*Your post is updated successfully*';
	}
	$.ajax({
		url : statusURL,
		type : 'POST',
		data : {
			statusId : statuId,
			statusDisplayText : statusText,
			statusLocation : locationName,
			statusPrivacy : postPrivacy,
			userName : userEmail,
			userId : userId,
		},
		success : function(response) {
			if (response.status === 'success') {
				input_validation.innerHTML = postStatusDebug;
				document.getElementById('statusText').value = '';
				privacy[0].checked = true;
				document.getElementById("location").value = 'NONE';
				window.location.reload(1);
				return true;
			} else {
				alert('Unexpected error!');
				return false;
			}
		},
		error : function(xhr, status, err) {
			alert(xhr.responseText);
		}
	});
}

// delete request for post a status
function doDeletePost(statusId) {
	$.ajax({
		url : 'deletePostStatus',
		type : 'POST',
		data : {
			statusId : statusId,
		},
		success : function(response) {
			alert(response.status);
			setTimeout(function() {
				window.location.reload(1);
			}, 0);
		},
		error : function(xhr, status, err) {
			alert(xhr.responseText);
		}
	});
}

// loadStatusById request for a posted status
function doEditPost(statusId) {
	$
			.ajax({
				url : 'editPostStatus',
				type : 'POST',
				data : {
					statusId : statusId,
				},
				success : function(response) {
					document.getElementById('statusText').value = response.status.statusDisplayText;
					if (response.status.statusPrivacy === 'public') {
						document.getElementsByName('privacy')[0].checked = true;
					} else {
						document.getElementsByName('privacy')[1].checked = true;
					}
					document.getElementById("location").value = response.status.statusLocation;
					document.getElementById("statusId").value = response.status.statusId;
					$("#containerDiv").animate({
						scrollTop : 0
					}, "fast");

				},
				error : function(xhr, status, err) {
					alert(xhr.responseText);
				}
			});

}
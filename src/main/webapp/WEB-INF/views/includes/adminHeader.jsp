<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><msg:message code="label.titleName" /></title>

<link href='http://fonts.googleapis.com/css?family=Lato:400,700'
	rel='stylesheet' type='text/css'>
<link href="<c:url value="/resources/css/font_awesome.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/boostrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap_responsive.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet">
<style>
.error, .passwordError, .emailError {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js">
	
</script>
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/boostrap.min.js" />"></script>
<script src="<c:url value="/resources/js/nivo_slider.min.js" />"></script>
<script src="<c:url value="/resources/js/countdown.min.js" />"></script>
<script src="<c:url value="/resources/js/flexnav.min.js" />"></script>
<script src="<c:url value="/resources/js/magnific.min.js" />"></script>
<script src="<c:url value="/resources/js/tweet.min.js" />"></script>
<script src="<c:url value="/resources/js/gmap3.min.js" />"></script>
<script src="<c:url value="/resources/js/wilto_slider.min.js" />"></script>
<script src="<c:url value="/resources/js/mediaelement.min.js" />"></script>
<script src="<c:url value="/resources/js/fitvids.min.js" />"></script>
<script src="<c:url value="/resources/js/mail.min.js.js" />"></script>
<script src="<c:url value="/resources/js/custom.js" />"></script>
<script src="<c:url value="/resources/js/switcher.js" />"></script>

<script type="text/javascript">
	function popupForSingUp(id) {
		$('#' + id).attr("class", "mfp-with-anim mfp-dialog clearfix");
		$("#" + id).parent().attr("class", "mfp-content");
		$("#" + id).parent().parent().attr("class",
				"mfp-container mfp-s-ready mfp-inline-holder");
		$("#" + id + "-parent").attr("class",
				"mfp-bg mfp-move-from-top mfp-ready");
	}

	function popupForTroubleLogginIn(id) {
		$('#error').hide();
		$('#info').hide();
		$('#' + id + '.row-fluid #fpid #username').val('');
		//$('#password-recover-dialog .row-fluid #fpid #username').val('');
		$('#' + id).attr("class", "mfp-with-anim mfp-dialog clearfix");
		$("#" + id).parent().attr("class", "mfp-content");
		$("#" + id).parent().parent().attr("class",
				"mfp-container mfp-s-ready mfp-inline-holder");
		$("#" + id + "-parent").attr("class",
				"mfp-bg mfp-move-from-top mfp-ready");
	}

	function closepopUp(id) {
		$('#' + id).attr("class", "mfp-with-anim mfp-hide mfp-dialog clearfix");
		$("#" + id).parent().attr("class", "");
		$("#" + id).parent().parent().attr("class", "");
		$("#" + id + "-parent").attr("class", "");
	}
	$(function() {
		var result = $('#hasErrors').val();
		if (result) {
			popupForSingUp("register-dialog");
		}
	})
		function doAjaxPost() {
		var name = $('#username').val();
		if(name == ''){
			$('#info').show('slow');
		}else{
		$.ajax({
					type : "GET",
					url : "<c:out value="${pageContext.request.contextPath}/lem/forgotPassword"/>",
					cache : false,
					data : "username=" + name,
					success : function(response) {
						// we have the response
						if (response.status == "SUCCESS") {
							$('#info')
									.html(
											"Please check your email to click the link to reset the password !!!");
							$('#error').hide('slow');
							$('#info').show('slow');
						} else {
							errorInfo = "";
							for (i = 0; i < response.result.length; i++) {
								errorInfo += "<br>"
										+ response.result[i].defaultMessage;
							}
							$('#error').html(errorInfo);
							$('#info').hide('slow');
							$('#error').show('slow');
						}
					},
					error : function(e) {emailError();
						alert('Error: ' + e);
						
					}
				});
		}
	}
	
	function validateLoginDetails(){ 
         $('.emailError').css('display', 'none');
	     $('.passwordError').css('display', 'none');
	    
	     $('#login-form').submit(function() { 
			    if ($('#username_login').val().length == 0  && $('#password_login').val().length == 0) {
			        $('.emailError').css('display', 'block');
			        $('.passwordError').css('display', 'block');
			        return false;
			    }else if ($('#username_login').val().length == 0 ) { 
			        $('.emailError').css('display', 'block'); 
			        return  false;
			    }else if ($('#password_login').val().length == 0 ) { 
			        $('.passwordError').css('display', 'block');
			        return  false;
			    }
			  });
		
	}
	
	function forgotPassword(){ 
		$('.passwordError').css('display', 'none');
		$('#forgot-form').submit(function(){ 
			 if ($('#username').val().length == 0 ) {  
			        $('.passwordError').css('display', 'block');
			        return  false;
			    }
		})
	}
	
	function emailError(){ 
	   popupForTroubleLogginIn("password-recover-dialog");
	}
</script>


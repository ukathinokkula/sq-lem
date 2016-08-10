<%@ include file="/WEB-INF/views/includes/tags-utility.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/passwordscheck.css" />">
<script src="<c:url value="/resources/js/passwordscheck.js" />"></script>

<script type="text/javascript">
function doAjaxPostForResetPassword() {
	    // get the form values
	    var id = $('#userid').val();
	    var username = $('#username').val();
	    var password = $('#password').val();
	    var confirmPassword = $('#confirmPassword').val();
	    
	    $.ajax({
	        type: "POST",
			url : "<c:out value="${pageContext.request.contextPath}/lem/accountInfo/resetPassword"/>",
			cache : false,
	        data: 'id=' + id + '&username' + username + '&password=' + password + '&confirmPassword=' + confirmPassword,
	        success: function(response){
	            // we have the response
	           if(response.status == "SUCCESS"){
	        	   $('#resetPwdInfo').html(response.result);
	        	   $('#pwderror').hide('slow');
                   $('#resetPwdInfo').show('slow');
	           }else{
	                 errorInfo = "";
	                 for(i =0 ; i < response.result.length ; i++){
	                     errorInfo += "<br>" + response.result[i].defaultMessage;
	                 }
	                 $('#pwderror').html("<span>"+errorInfo+"</span>");
	                 $('#resetPwdInfo').hide('slow');
	                 $('#pwderror').show('slow');
	             }
	         },
	         error: function(e){
	             alert('Error: ' + e);
	         }
	    });
	}
</script>

<style type="text/css">
.success {
	color: #009900;
}

</style>


<body>
	<%@ include file="/WEB-INF/views/includes/header-utility.jsp"%>
	<h1>
		<msg:message code="title.accountInfo.updateAccountInfo" />
	</h1>
	<div id="outerContainer">
		<div class="clear">
			<div id="contentContainer">
				<c:set var="user" value="${user}" scope="request"></c:set>
				<div id="pageContent">
					<form:form method="POST" class="dialog-form">
						<table>
						<tr><td>
						<div id="resetPwdInfo" class="success"></div></td></tr>
						<tr><td><div id="pwderror" class="error"></div></td></tr>
							<tr>
								<td><input type="hidden" name="id" id="userid"
									value="<c:out value="${user.id}"/>" /></td>
								<td><input type="hidden" name="username" id="username"
									value="<c:out value="${user.username}"/>" /></td>
							</tr>
							
							<tr>
								<td><label>Password</label></td>
								<td><input type="password" name="password"
									placeholder="My secret password" id="password"></td>
									<td id="result"></td>
							</tr>
							<tr>
								<td><label>Repeat Password</label></td>
								<td><input type="password" name="confirmPassword" id="confirmPassword"
									placeholder="Type your password again"></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="button"
									value='<msg:message code="button.resetPassword.submit"/>'
									class="btn btn-primary" onclick="doAjaxPostForResetPassword()"/></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
			<div class="clear"></div>
		</div>
</body>
</html>
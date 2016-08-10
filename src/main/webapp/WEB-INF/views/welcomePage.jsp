
<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<body>
	<%-- <%@ include file="/WEB-INF/views/includes/header-utility.jsp"%> --%>
	<!-- TOP AREA -->
<h3>Member Login</h3>
	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
        Your login attempt was not successful due to <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
    </c:if>
	<table>
	<form id="login-form" action="<c:url value="/lem/j_spring_security_check" />" method="post" class="dialog-form">
		
			<tr align="center">
				<td><label>E-mail :</label> </td>
				<td>
					<input type="text" name="username" id="username_login"
					placeholder="email@domain.com" size="30" maxlength="20"> 
		    		<span class="emailError" style="display: none;">You must enter a valid email address</span>
		    	</td>
			</tr>
			<tr align="center">
				<td><label>Password :</label></td>
				<td>
					<input type="password" name="password" id="password_login"
					placeholder="My secret password" size="30" maxlength="20"> 
					<span class="passwordError" style="display: none;">You must enter a valid password</span>
				</td>
			</tr>
			<tr align="center">
				<td>
					<input type="checkbox" name="_spring_security_remember_me">
				</td>
				<td>	
					<label class="checkbox">Remember me</label>
				</td>
			</tr>
			<tr align="center">
				<td>
					<input type="submit" value="Sign in" class="btn btn-primary" onclick="validateLoginDetails();">
				</td>				
			</tr>
	</form>
	
	<form action ="${pageContext.request.contextPath}/lem/openSignupPage" method="GET">
		
			<!-- td>
				<a data-effect="mfp-move-from-top" href="#." onclick="popupForSingUp('register-dialog');" class="popup-text">
					<i class="icon-edit"></i>Sign up</a>
				</td> -->
			<tr align="center">
				<td>
					<input type="submit" value="Sign Up" class="btn btn-primary">
				</td>				
			</tr>
	</form>
	<tr>
		<td>
			<a href="<c:out value="${pageContext.request.contextPath}/lem/forgotPassword"/>"
									class="lemLink">
									Forgot password</a>
		</td>
	</tr>
	</table>
	<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
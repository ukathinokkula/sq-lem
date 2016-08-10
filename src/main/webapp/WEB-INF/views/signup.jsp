
<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<body>
	<%-- <%@ include file="/WEB-INF/views/includes/header-utility.jsp"%> --%>
	<!-- TOP AREA -->
<h3>New User Registration</h3>
	<table>
		<div class="row-fluid">
			<form:form action="${pageContext.request.contextPath}/lem/signup" modelAttribute="user" method="POST" class="dialog-form">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<input id="hasErrors" type="hidden" value="${hasErrors}" />
				
				<tr align="center">
					<td><label>E-mail :</label> </td>
					<td>
						<input type="text" name="username" id="username_login" placeholder="email@domain.com" size="30" maxlength="20"> 
			    		<span class="emailError" style="display: none;">You must enter a valid email address</span>
			    	</td>
				</tr>
				<tr align="center">
					<td><label>Password :</label> </td>
					<td>
						<input type="password" name="password" id="password" placeholder="My secret password" size="30" maxlength="20"> 
			    		<span class="passwordError" style="display: none;">You must enter a valid password</span>
			    	</td>
				</tr>
				
				<tr align="center">
					<td><label>Repeat Password :</label> </td>
					<td>
						<input type="password" name="confirmPassword" id="confirmPassword" placeholder="Type your password again" size="30" maxlength="20"> 
			    		<span class="passwordError" style="display: none;">You must enter a valid password</span>
			    	</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Sign up" class="btn btn-primary">
					</td>
				</tr>
				
			</form:form>
		</div>	
	
	</table>
	<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
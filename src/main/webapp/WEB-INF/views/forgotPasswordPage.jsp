<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/views/includes/header-utility.jsp"%>
	<!-- PAGE TITLE -->
	<div class="top-title-area">
		<div class="container">
			<h1 class="title-page">Reset Password</h1>
		</div>
	</div>
	<!-- END PAGE TITLE -->

	<!-- SEARCH AREA -->
	<%@ include file="/WEB-INF/views/includes/searchPage.jsp"%>
	<!-- END SEARCH AREA -->

	<!-- MAIN CONTENT -->
	<div class="container">
		<div class="row">
			<div class="span9">
				<form:form
					action="${pageContext.request.contextPath}/lem/forgotPasswordUpdateDB"
					method="POST" modelAttribute="user">

					<form:errors path="*" cssClass="errorblock" element="div" />

					<c:if test="${not empty passwordChanged}">
						<p class="errorblock">${passwordChanged}</p>
					</c:if>
					<c:if test="${not empty hasErrorsForForgotPassword}">
						<p class="errorblock">${hasErrorsForForgotPassword}</p>
					</c:if>
					<div id="data-entry-form">
						<input type="hidden" name="username" value="${forgotUsername}" /><br />
						<div class="form-entry">
							<label>Password</label> <input type='password' name='password'>
						</div>
						<div class="form-entry">
							<label>Confirm Password</label> <input type='password'
								name='confirmPassword' />
						</div>
						<div class="form-entry">
							<input type="submit" value="Submit" />
						</div>
					</div>


				</form:form>
			</div>
		</div>
	</div>

	<!-- MAIN CONTENT -->
   <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	<div class="clear"></div>
</body>
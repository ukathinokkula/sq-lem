<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<script type="text/javascript">
</script>
<body>
<%@ include file="/WEB-INF/views/includes/adminHeaderUtility.jsp"%>
	<%-- <h1><msg:message code="title.project.addProjectDetails"/></h1> --%>
	<div id="outerContainer">
		<div class="clear">
			<div id="contentContainer">
				<h3>Add Project Details Configuration</h3>
				<div id="pageContent">
					<form:form action ="${pageContext.request.contextPath}/lem/admin/addProjectDetails" method="POST" modelAttribute="projectDetails">
						<table>
							<tr>
								<td><msg:message code="label.admin.projectDetails.projectName"/></td>
                            	<td><input type="text" name="name"/></td>
                            </tr>
                            <tr>
                            	<td><msg:message code="label.admin.projectDetails.description"/></td>
                            	<td><input type="text" name="description"/></td>
                            </tr>
                            <tr><td><msg:message code="label.admin.projectDetails.projectClientName"/></td>
                            	<td><input type="text" name="client" /></td>
                            </tr>
                            
                            <tr><td><msg:message code="label.admin.projectDetails.country"/></td>
                            	<td><input type="text" name="country" /></td>
                            </tr>
                            
                            <tr><td><msg:message code="label.admin.projectDetails.projectStatus"/></td>
	                            <td>
		                            <select id="status" name="status">
										<option value="NONE">Select Project Status</option>
										<option value="1">Active</option>
										<option value="0">Inactive</option>
									</select>
								</td>
                            </tr>
                            
                            <tr><td align="center"><input type="submit" value="<msg:message code="button.project.addProjectDetails"/>" class="btn btn-primary"/></td>
						</table>
					</form:form>

				</div>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
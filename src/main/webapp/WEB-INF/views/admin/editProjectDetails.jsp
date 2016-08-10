<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript">
	 window.onload = function() {
		 
	 	 $(document).ready( function() {
	        $("#status").val(<c:out value="${projectDetails.status}"/>).attr('selected', 'selected');
    } );
	 	 
	}; 
</script>
<body>
<%@ include file="/WEB-INF/views/includes/adminHeaderUtility.jsp"%>
	<%-- <h1><msg:message code="title.projecct.addProjectDetails"/></h1> --%>
	<div id="outerContainer">
		<div class="clear">
			<div id="contentContainer">
				<h3>Edit Project Details Configuration</h3>
				<div id="pageContent">
					<c:set var="projectDetails" value="${projectDetails}" scope="request"></c:set>
					<c:set var="status" value="${projectDetails.status}" scope="request"></c:set>
					<form:form action ="${pageContext.request.contextPath}/lem/admin/editProjectDetails" method="POST" modelAttribute="projectDetails">
						<table>
							<tr><td><input type="hidden" name="id" value="<c:out value="${projectDetails.id}"/>"/></td></tr>
							<tr><td><msg:message code="label.admin.projectDetails.projectName"/></td>
                            	<td><input type="text" name="name" value="<c:out value="${projectDetails.name}"/>"/></td>
                            </tr>
                            <tr><td><msg:message code="label.admin.projectDetails.description"/></td>
                            	<td><input type="text" name="description" value="<c:out value="${projectDetails.description}"/>"/></td>
                            </tr>
                            <tr><td><msg:message code="label.admin.projectDetails.projectClientName"/></td>
                            	<td><input type="text" name="client" value="<c:out value="${projectDetails.client}"/>"/></td>
                            </tr>
                            
                            <tr><td><msg:message code="label.admin.projectDetails.country"/></td>
                            	<td><input type="text" name="country" value="<c:out value="${projectDetails.country}"/>"/></td>
                            </tr>

                            <tr><td><msg:message code="label.admin.projectDetails.projectStatus"/></td>
	                            <td>
		                            <select id="status" name="status" >
										<option value="NONE"/>Select Project Status</option>
										<option value=1>Active</option>
										<option value=0>Inactive</option>
									</select>				                    
								</td>
                            </tr>
                            
                            <tr><td align="center"><input type="submit" value="<msg:message code="button.project.editProjectDetails"/>" class="btn btn-primary"/></td>
						</table>
					</form:form>

				</div>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
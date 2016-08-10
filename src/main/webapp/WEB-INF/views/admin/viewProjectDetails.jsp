
<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<script type="text/javascript">

</script>
<body>

	<%@ include file="/WEB-INF/views/includes/adminHeaderUtility.jsp"%>
	<div id="outerContainer" align="center">
		<div class="clear">
			<div id="contentContainer">
				<form:form action ="${pageContext.request.contextPath}/lem/admin/openAddProjectDetailsPage" method="GET">
					<h3>Project Details Configuration</h3>
					<div id="pageContent">
						<br/>
						<table border="1">
							<tr class="listTitleRow">
								<td><msg:message code="label.project.projectID"/></td>
								<td><msg:message code="label.project.name"/></td>
								<td><msg:message code="label.project.client"/></td>
								<td><msg:message code="label.project.country"/></td>
								<td><msg:message code="label.project.description"/></td>
								<td><msg:message code="label.project.status"/></td>
								<td><msg:message code="label.project.edit"/></td>
							</tr>
							<c:forEach items="${projectList}" var="project">
								<c:set var="projectId" value="${project.id}" scope="request"></c:set>
								<tr>
									<td>${project.id}</td>
									<td>${project.name}</td>
									<td>${project.client}</td>
									<td>${project.country}</td>
									<td>${project.description}</td>
									<td>${project.status}</td>
									<td>
										<a href="<c:out value="${pageContext.request.contextPath}/lem/admin/openEditProjectDetailsPage"/>?projectId=${requestScope.projectId}" 
										class="lemLink">
										${project.name}</a>
									</td>
									
								</tr>
							</c:forEach>
	
						</table>
					</div>
					<br/>
					<div>
						<tr>
							<td></td>							
							<td align="center">
								<input type="submit" value="<msg:message code="button.project.createProject"/>" class="btn btn-primary"/>
							</td							
						</tr>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
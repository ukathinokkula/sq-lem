
<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<body>
	 <%@ include file="/WEB-INF/views/includes/header-utility.jsp"%>
	<!-- TOP AREA -->
	<!-- <h3>Liquidhub Estimation Model</h3> -->
	
	<div id="outerContainer" align="center">
		<div class="clear">
			<div id="contentContainer">
				<h3>Project Estimation Details</h3>
				<div id="pageContent">
					<br/>
					<table border="1">
						<tr class="listTitleRow">
							<th><msg:message code="label.project.projectID"/></th>
							<th><msg:message code="label.project.name"/></th>
							<th><msg:message code="label.project.client"/></th>
							<th><msg:message code="label.project.country"/></th>
							<th><msg:message code="label.project.description"/></th>
							<th><msg:message code="label.project.totalProjectHours"/></th>
							<th><msg:message code="label.project.viewComponents"/></th>
							<th><msg:message code="label.project.manageComponents"/></th>
						</tr>
						<c:forEach items="${projectList}" var="project">
							<c:set var="projectId" value="${project.id}" scope="request"></c:set>
							<tr>
								<td>${project.id}</td>
								<td>${project.name}</td>
								<td>${project.client}</td>
								<td>${project.country}</td>
								<td>${project.description}</td>
								<td>${project.totalProjectHours}</td>
								<td>
									<a href="<c:out value="${pageContext.request.contextPath}/lem/component/componentListByProjectId"/>?projectId=${requestScope.projectId}"
									class="lemLink">
									${project.name}</a>
								</td>
								<td>
									<a href="<c:out value="${pageContext.request.contextPath}/lem/component/manageComponents"/>?projectId=${requestScope.projectId}"
									class="lemLink">
									${project.name}</a>
								</td>
								
							</tr>
						</c:forEach>

					</table>
				</div>

			</div>
		</div>
	</div>
	</br></br>
	<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>
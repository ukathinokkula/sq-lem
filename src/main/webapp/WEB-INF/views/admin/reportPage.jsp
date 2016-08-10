<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>

<script type="text/javascript">

$(function() {
	$('#fromDate').datepicker();
	$('#toDate').datepicker();
});

</script>
<body>
<%@ include file="/WEB-INF/views/includes/adminHeaderUtility.jsp"%>
	<div id="outerContainer">
		<div class="clear">
			<div id="contentContainer">
				<h3><msg:message code="title.report.searchReport"/></h3>
				<div id="pageContent">
					<form:form action ="${pageContext.request.contextPath}/lem/admin/searchReport" method="POST">
						<table>
							<tr>
								<td>Project Name : <input type="text" name="projectName"/></td>
                            </tr>
							<tr>
                            	<td>Total Hours From :<input type="text" name="totalHoursFrom"/></td>
                            	<td>To : <input type="text" name="totalHoursTo"/></td>
                            </tr>
                            <tr>
                            	<td>Projects Created Between :<input type="text" name="fromDate" id="fromDate"/></td>
                            	<td>To : <input type="text" name="toDate" id="toDate"/></td>
                            </tr>
                            
                            <tr><td align="center"><input type="submit" value="<msg:message code="button.report.searchReport"/>" class="btn btn-primary"/></td>
						</table>
					</form:form>

				</div>
		</div>
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
								
							</tr>
						</c:forEach>

					</table>
				</div>

			</div>
		</div>
	</div>
	</div>
	</div>
	</br>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>

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
				<form:form action ="${pageContext.request.contextPath}/lem/admin/openAddEstimation" method="GET">
					<h3>Project Estimation Model Types Configuration</h3>
					<div id="pageContent">
						<br/>
						<table border="1">
							<tr class="listTitleRow">
								<td><msg:message code="label.estimation.id"/></td>
								<td><msg:message code="label.estimation.name"/></td>
								<td><msg:message code="label.estimation.accuracy"/></td>
								<td><msg:message code="label.estimation.description"/></td>
								<td><msg:message code="label.estimation.status"/></td>
								<td><msg:message code="label.estimation.edit"/></td>
							</tr>
							<c:forEach items="${estimationModelTypes}" var="estimation">
								<c:set var="id" value="${estimation.id}" scope="request"></c:set>
								<tr>
									<td>${estimation.id}</td>
									<td>${estimation.name}</td>
									<td>${estimation.accuracy}</td>
									<td>${estimation.description}</td>
									<td>${estimation.status}</td>
									<td>
										<a href="<c:out value="${pageContext.request.contextPath}/lem/admin/openEditEstimation"/>?id=${requestScope.id}" class="lemLink">
										${estimation.name}</a>
									</td>
									
								</tr>
							</c:forEach>
	
						</table>
					</div>
					</br>
					<div>
						<tr>
							<td></td>
							<td align="center">
								<input type="submit" value="<msg:message code="button.estimation.createEstimation"/>" class="btn btn-primary"/>
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
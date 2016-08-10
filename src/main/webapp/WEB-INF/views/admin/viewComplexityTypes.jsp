
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
				<form:form action ="${pageContext.request.contextPath}/lem/admin/openAddComplexityType" method="GET">
					<h3>Project Complexity Types Configuration</h3>
					<div id="pageContent">
						<br/>
						<table border="1">
							<tr class="listTitleRow">
								<td><msg:message code="label.complexityType.id"/></td>
								<td><msg:message code="label.complexityType.complexityType"/></td>
								<td><msg:message code="label.complexityType.hours"/></td>
								<td><msg:message code="label.complexityType.description"/></td>
								<td><msg:message code="label.complexityType.status"/></td>
								<td><msg:message code="label.complexityType.edit"/></td>
							</tr>
							<c:forEach items="${complexityTypes}" var="complexityType">
								<c:set var="id" value="${complexityType.id}" scope="request"></c:set>
								<tr>
									<td>${complexityType.id}</td>
									<td>${complexityType.complexityType}</td>
									<td>${complexityType.hours}</td>
									<td>${complexityType.description}</td>
									<td>${complexityType.status}</td>
									<td>
										<a href="<c:out value="${pageContext.request.contextPath}/lem/admin/openEditComplexityType"/>?id=${requestScope.id}" 
										class="lemLink">${complexityType.complexityType}</a>
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
								<input type="submit" value="<msg:message code="button.complexityType.createComplexityType"/>" class="btn btn-primary"/>
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

<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<%@ page  import="java.awt.*" %>
<%@ page  import="java.io.*" %>
<%@ page  import="org.jfree.chart.*" %>
<%@ page  import="org.jfree.chart.entity.*" %>
<%@ page  import ="org.jfree.data.general.*"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<script type="text/javascript">
	
</script>
<body>

	<%@ include file="/WEB-INF/views/includes/header-utility.jsp"%>
	<div id="outerContainer" align="center">
		<div class="clear">
		<table width="100%">
			<form:form action ="${pageContext.request.contextPath}/lem/component/openAddComponentPage" method="GET">
			
				<div id="contentContainer">
					<h3><msg:message code="title.component.projectComponentList"/></h3>
					<c:set var="projectId" value="${projectId}" scope="request"></c:set>
					<td><input type="hidden" name="projectId" value="${projectId}" id="projectId"/></td>
					<div id="pageContent">
						<br/>
						<table border="1">
							<tr class="listTitleRow">							
								<th><msg:message code="label.component.id"/></th>
								<th><msg:message code="label.component.projectId"/></th>
								<th><msg:message code="label.component.name"/></th>
								<th><msg:message code="label.component.description"/></th>
								<th><msg:message code="label.component.complexityType"/></th>
								<th><msg:message code="label.component.technology"/></th>
								<th><msg:message code="label.component.weightage"/></th>
								<th><msg:message code="label.component.newComponent"/></th>
								<th><msg:message code="label.component.estimationModelType"/></th>
								<th><msg:message code="label.component.accuracy"/></th>
								<th><msg:message code="label.component.totalHours"/></th>
								<th><msg:message code="label.component.componentCount"/></th>
								<th><msg:message code="label.component.edit"/></th>							
							</tr>
							<c:forEach items="${componentList}" var="component">
								<c:set var="id" value="${component.id}" scope="request"></c:set>
								<tr>
									<td>${component.id}</td>
									<td>${component.projectDetails.name}</td>
									<td>${component.name}</td>
									<td>${component.description}</td>
									<td>${component.complexityType.complexityType}</td>
									<td>${component.technology}</td>
									<td>${component.weightage}</td>
									<c:if test="${component.newComponent == 1}"><td>Yes</td></c:if>
									<c:if test="${component.newComponent == 0}"><td>No</td></c:if>
									<td>${component.estimationModelType.name}</td>
									<td>${component.accuracy}</td>
									<td>${component.totalHours}</td>
									<td>${component.componentCount}</td>
									<td>
										<a href="<c:out value="${pageContext.request.contextPath}/lem/component/openEditComponentPage"/>?id=${requestScope.id}" class="lemLink">
										${component.name}</a>
									</td>
									
								</tr>
							</c:forEach>
							<tr>
								<th colspan="13" align="right">Total Project Hours : <c:out value="${totalProjectHours}"/>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;							
								</th>		                
							</tr>
	
						</table>
					</div>
					</br>
					<div>
						<tr>
							<td></td>
							
								<%-- <a href="<c:out value="${pageContext.request.contextPath}/lem/component/openAddComponentPage"/> ?projectId=${projectId}">
									<msg:message code="button.component.createComponent"/>
								</a> --%>
								<td align="center">
									<input type="submit" value="<msg:message code="button.component.createComponent"/>" class="btn btn-primary"/>
								</td>
							
						</tr>
					</div>
	
				</div>
			</div>
			
			<div>
				<table width="70%">
				<img src="${pageContext.request.contextPath}/resources/img/piechart.png" width="600" height="400" border="0" usemap="#chart" >
			</div>
			
			</form:form>
			
		</table>		
	</div>
	
	<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
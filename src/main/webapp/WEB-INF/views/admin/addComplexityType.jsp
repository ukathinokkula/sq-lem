<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<script type="text/javascript">
</script>
<body>
<%@ include file="/WEB-INF/views/includes/adminHeaderUtility.jsp"%>
	<%-- <h1><msg:message code="title.complexityType.addComplexityType"/></h1> --%>
	<div id="outerContainer">
		<div class="clear">
			<div id="contentContainer">
				<h3><msg:message code="title.complexityType.addConfiguration"/></h3>
				<div id="pageContent">
					<form:form action ="${pageContext.request.contextPath}/lem/admin/addComplexityType" method="POST" modelAttribute="complexityType">
						<table>
							<tr>
								<td><msg:message code="label.complexityType.complexityType"/></td>
                            	<td><input type="text" name="complexityType"/></td>
                            </tr>
                            <tr>
                            	<td><msg:message code="label.complexityType.description"/></td>
                            	<td><input type="text" name="description"/></td>
                            </tr>
                            <tr><td><msg:message code="label.complexityType.hours"/></td>
                            	<td><input type="text" name="hours" /></td>
                            </tr>
                            
                            <tr><td><msg:message code="label.complexityType.status"/></td>
	                            <td>
		                            <select id="status" name="status">
										<option value="NONE">Select Complexity Type Status</option>
										<option value="1">Active</option>
										<option value="0">Inactive</option>
									</select>
								</td>
                            </tr>
                            <tr><td><msg:message code="label.complexityType.existingComponentRatio"/></td>
                            	<td><input type="text" name="existingComponentRatio" /></td>
                            </tr>
                            <tr><td align="center"><input type="submit" value="<msg:message code="button.complexityType.addComplexityType"/>" class="btn btn-primary"/></td>
						</table>
					</form:form>

				</div>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript">
	 window.onload = function() {
		 
	 	 $(document).ready( function() {
	        $("#status").val(<c:out value="${complexityType.status}"/>).attr('selected', 'selected');
    } );
	 	 
	}; 
</script>
<body>
<%@ include file="/WEB-INF/views/includes/adminHeaderUtility.jsp"%>
	<%-- <h1><msg:message code="title.complexityType.editComplexityType"/></h1> --%>
	<div id="outerContainer">
		<div class="clear">
			<div id="contentContainer">
				<h3>Edit Project Complexity Type Configuration</h3>
				<div id="pageContent">
					<c:set var="complexityType" value="${complexityType}" scope="request"></c:set>
					<c:set var="status" value="${complexityType.status}" scope="request"></c:set>
					<form:form action ="${pageContext.request.contextPath}/lem/admin/editComplexityType" method="POST" modelAttribute="complexityType">
						<table>
							<tr><td><input type="hidden" name="id" value="<c:out value="${complexityType.id}"/>"/></td></tr>
							<tr><td><msg:message code="label.complexityType.complexityType"/></td>
                            	<td><input type="text" name="complexityType" value="<c:out value="${complexityType.complexityType}"/>"/></td>
                            </tr>
                            <tr><td><msg:message code="label.complexityType.description"/></td>
                            	<td><input type="text" name="description" value="<c:out value="${complexityType.description}"/>"/></td>
                            </tr>
                            <tr><td><msg:message code="label.complexityType.hours"/></td>
                            	<td><input type="text" name="hours" value="<c:out value="${complexityType.hours}"/>"/></td>
                            </tr>
                            
                            <tr><td><msg:message code="label.complexityType.status"/></td>
	                            <td>
		                            <select id="status" name="status" >
										<option value="NONE"/>Select Complexity Type Status</option>
										<option value=1>Active</option>
										<option value=0>Inactive</option>
									</select>				                    
								</td>
                            </tr>
                            <tr><td><msg:message code="label.complexityType.existingComponentRatio"/></td>
                            	<td><input type="text" name="existingComponentRatio" /></td>
                            </tr>
                            <tr><td align="center"><input type="submit" value="<msg:message code="button.complexityType.editComplexityType"/>" class="btn btn-primary"/></td>
						</table>
					</form:form>

				</div>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript">
	 window.onload = function() {
		 
	 	 $(document).ready( function() {
	        $("#status").val(<c:out value="${estimationModelType.status}"/>).attr('selected', 'selected');
    } );
	 	 
	}; 
</script>
<body>
<%@ include file="/WEB-INF/views/includes/adminHeaderUtility.jsp"%>
	<%-- <h1><msg:message code="title.estimation.editEstimationModelType"/></h1> --%>
	<div id="outerContainer">
		<div class="clear">
			<div id="contentContainer">
				<h3>Edit Project Estimation Model Type Configuration</h3>
				<div id="pageContent">
					<c:set var="estimationModelType" value="${estimationModelType}" scope="request"></c:set>
					<c:set var="status" value="${estimationModelType.status}" scope="request"></c:set>
					<form:form action ="${pageContext.request.contextPath}/lem/admin/editEstimation" method="POST" modelAttribute="estimationModelType">
						<table>
							<tr><td><input type="hidden" name="id" value="<c:out value="${estimationModelType.id}"/>"/></td></tr>
							<tr><td><msg:message code="label.estimation.name"/></td>
                            	<td><input type="text" name="name" value="<c:out value="${estimationModelType.name}"/>"/></td>
                            </tr>
                            <tr><td><msg:message code="label.estimation.description"/></td>
                            	<td><input type="text" name="description" value="<c:out value="${estimationModelType.description}"/>"/></td>
                            </tr>
                            <tr><td><msg:message code="label.estimation.accuracy"/></td>
                            	<td><input type="text" name="accuracy" value="<c:out value="${estimationModelType.accuracy}"/>"/></td>
                            </tr>
                            
                            <tr><td><msg:message code="label.estimation.status"/></td>
	                            <td>
		                            <select id="status" name="status" >
										<option value="NONE"/>Select Estimation Status</option>
										<option value=1>Active</option>
										<option value=0>Inactive</option>
									</select>				                    
								</td>
                            </tr>
                            
                            <tr><td align="center"><input type="submit" value="<msg:message code="button.estimationModelType.editEstimationModelType"/>" class="btn btn-primary"/></td>
						</table>
					</form:form>

				</div>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
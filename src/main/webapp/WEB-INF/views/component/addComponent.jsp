<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<script type="text/javascript">
function loadTotalHours() {
	var complexityType = $("#complexityType").val();
	var componentCount = $("#componentCount").val();
	var newComponent = $("#newComponent").val();
	
	if(complexityType.trim().length > 0 && componentCount.trim().length > 0 && newComponent!="") {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "<c:out value="${pageContext.request.contextPath}/lem/component/loadTotalHours"/>",
			cache : false,
			data : 'complexityType=' + complexityType+ '&componentCount='+componentCount+ '&newComponent='+newComponent,
			success : function(response) {
				$('#totalHours').val(response);
				$('#hours').val(response);
			},
			error : function() {
				alert('Error while request..');
			}
		});
	} 
	return false;
}
</script>
<body>
<%@ include file="/WEB-INF/views/includes/header-utility.jsp"%>
	<h3><msg:message code="title.component.addComponentDetails"/></h3>
	<div id="outerContainer">
		<div class="clear">
			<div id="contentContainer">

				<div id="pageContent">
					<form:form action ="${pageContext.request.contextPath}/lem/component/addComponent" method="POST" modelAttribute="componentList">
						<table>
							<tr><td><input type="hidden" name="hours" id="hours"/></td></tr>
                            <tr><td><msg:message code="label.component.componentDetails.name"/></td><td><input type="text" name="name"/></td></tr>
                            <tr><td><msg:message code="label.component.componentDetails.description"/></td><td><input type="text" name="description"/></td></tr>
                            
                            <tr><td><msg:message code="label.component.componentDetails.technology"/></td><td><input type="text" name="technology"/></td></tr>
                            
                            <tr><td><msg:message code="label.component.componentDetails.weightage"/></td><td><input type="text" name="weightage"/></td></tr>
                            
                            <tr><td><msg:message code="label.component.componentDetails.newComponent"/></td>
	                            <td>
		                            <select id="newComponent" name="newComponent"  required="true" onchange="loadTotalHours();">
										<option value="">Select Component Type</option>
										<option value="1">YES</option>
										<option value="0">NO</option>
									</select>
								</td>
                            </tr>
                            <tr><td><msg:message code="label.component.componentDetails.estimationModelType"/></td>
	                            <td>
		                            <select id="estimationModelType" name="estimationModelType.id"  required="true">
										<option value="">Select Estimation Model Type</option>
										<c:forEach var="emt" items="${estimationModelTypeList}">
											<option value="${emt.id}">${emt.name}</option>
										</c:forEach>
									</select>
								</td>
                            </tr>
                            <tr><td><msg:message code="label.component.componentDetails.accuracy"/></td><td><input type="text" name="accuracy"/></td></tr>
                            <tr>
	                            <td><msg:message code="label.component.componentDetails.complexityType"/></td>
	                            <td>
		                            <select id="complexityType" name="complexityType.id" onchange="loadTotalHours();" required="true">
										<option value="">Select Complexity Type</option>
										<c:forEach var="complexityType" items="${complexityTypeList}">
											<option value="${complexityType.id}">${complexityType.complexityType}</option>
										</c:forEach>
									</select>
								</td>
                            </tr>
                            <tr>
                            	<td><msg:message code="label.component.componentDetails.componentCount"/></td>
                            	<td><input id="componentCount" type="text" name="componentCount" onchange="loadTotalHours();" /></td>
                            </tr>
                            <tr>
                            	<td><msg:message code="label.component.componentDetails.totalHours"/></td>
                            	<td><input id="totalHours" type="text" name="totalHours" disabled="disabled"/></td>
                            </tr>
                            
                            <tr><td><input type="hidden" name="projectId" value="<c:out value="${projectId}"/>" /></td></tr>
                            
                            <tr><td align="center"><input type="submit" value="<msg:message code="button.component.addComponent"/>" class="btn btn-primary"/></td></tr>
						</table>
					</form:form>

				</div>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
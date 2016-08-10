<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript">
	window.onload = function() {
		 $(document).ready( function() {
	       	$("#estimationModelType").val(<c:out value="${componentList.estimationModelType.id}"/>).attr('selected', 'selected');
	       	$("#complexityType").val(<c:out value="${componentList.complexityType.id}"/>).attr('selected', 'selected');
	       	$("#newComponent").val(<c:out value="${componentList.newComponent}"/>).attr('selected', 'selected');
		} );
	};
	
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
	<h3><msg:message code="title.component.editComponentDetails"/></h3>
	<div id="outerContainer">
		<div class="clear">
			<div id="contentContainer">

				<div id="pageContent">
					<c:set var="componentList" value="${componentList}" scope="request"></c:set>
					<form:form action ="${pageContext.request.contextPath}/lem/component/editComponent" method="POST" modelAttribute="componentList">
						<table>
							<tr><td><input type="hidden" name="id" value="<c:out value="${componentList.id}"/>"/></td></tr>
							<tr><td><input type="hidden" name="hours" id="hours"/></td></tr>
							<tr><td><input type="hidden" name="projectId" value="<c:out value="${componentList.projectDetails.id}"/>"/></td></tr>
							
							<tr><td><msg:message code="label.component.componentDetails.name"/></td>
                            	<td><input type="text" name="name" value="<c:out value="${componentList.name}"/>"/></td>
                            </tr>
                            <tr><td><msg:message code="label.component.componentDetails.description"/></td>
                            	<td><input type="text" name="description" value="<c:out value="${componentList.description}"/>"/></td>
                            </tr>
                            
                            <tr><td><msg:message code="label.component.componentDetails.technology"/></td>
                            	<td><input type="text" name="technology" value="<c:out value="${componentList.technology}"/>"/></td>
                            </tr>
                            
                            <tr><td><msg:message code="label.component.componentDetails.weightage"/></td>
                            	<td><input type="text" name="weightage" value="<c:out value="${componentList.weightage}"/>"/></td>
                            </tr>
                            <tr><td><msg:message code="label.component.componentDetails.newComponent"/></td>
	                            <td>
		                            <select id="newComponent" name="newComponent" required="true" onchange="loadTotalHours();">
										<option value="">Select Component Type</option>
										<option value="1">Yes</option>
										<option value="0">No</option>
									</select>
								</td>
                            </tr>
                            
							<tr><td><msg:message code="label.component.componentDetails.estimationModelType"/></td>
	                            <td>
		                            <select id="estimationModelType" name="estimationModelType.id"  required="true">
										<option value=""/>Select Estimation Model Type</option>
										<c:forEach var="emt" items="${estimationModelTypeList}">
											<option value="${emt.id}">${emt.name}</option>
										</c:forEach>
									</select>
								</td>
                            </tr>
                            <tr>
                            	<td><msg:message code="label.component.componentDetails.accuracy"/></td>
                            	<td><input type="text" name="accuracy" value="<c:out value="${componentList.accuracy}"/>"/></td>
                            </tr>
                            <tr>
	                            <td><msg:message code="label.component.componentDetails.complexityType"/></td>
	                            <td>
		                            <select id="complexityType" name="complexityType.id" onchange="loadTotalHours();"  required="true">
										<option value="">Select Complexity Type</option>
										<c:forEach var="complexityType" items="${complexityTypeList}">
											<option value="${complexityType.id}">${complexityType.complexityType}</option>
										</c:forEach>
									</select>
								</td>
                            </tr>
                            <tr>
                            	<td><msg:message code="label.component.componentDetails.componentCount"/></td>
                            	<td><input id="componentCount" type="text" name="componentCount" value="<c:out value="${componentList.componentCount}"/>" onchange="loadTotalHours();"/></td>
                            </tr>                            
                            <tr>
                            	<td><msg:message code="label.component.componentDetails.totalHours"/></td>
                            	<td><input id="totalHours" type="text" name="totalHours" value="<c:out value="${componentList.totalHours}"/>" disabled="disabled"/></td>
                            </tr>
                            
                            <tr><td align="center"><input type="submit" value="<msg:message code="button.component.editComponent"/>" class="btn btn-primary"/></td>
						</table>
					</form:form>

				</div>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
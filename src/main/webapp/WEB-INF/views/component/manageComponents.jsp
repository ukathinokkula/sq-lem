<%@ include file="/WEB-INF/views/includes/tags-utility-before-login.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

</head>
<script language="javascript" type="text/javascript" src="http://code.jquery.com/jquery-1.4.1.min.js"></script>
<script language="javascript" type="text/javascript">
    $(function() {
        $("#moveRight,#moveLeft").click(function(event) {
            var id = $(event.target).attr("id");
            var selectFrom = id == "moveRight" ? "#selectedInactiveComponentIds" : "#selectedActiveComponentIds";
            
            var moveTo = id == "moveRight" ? "#selectedActiveComponentIds" : "#selectedInactiveComponentIds";
            var selectedItems = $(selectFrom + " :selected").toArray();
            $(moveTo).append(selectedItems);
            var selectedRights = $("#selectedActiveComponentIds").val();
            $('#selectedActiveComponentIds').val(selectedRights);

            
            var activeComIds = [];
            $('#selectedActiveComponentIds').find('option').map(function() {
            	activeComIds.push($(this).val());
            });
            if(activeComIds.length>0) {
            	loadTotalHours(activeComIds);
            }  else {
            	$('#totalHours').val('0');
            }
          	
        });
    });
    
    function loadTotalHours(activeComIds) {
    	//var ids = $(moveTo).val();
    	$.ajax({
    		type : "post",
    		dataType : "json",
    		url : "<c:out value="${pageContext.request.contextPath}/lem/component/loadTotalHoursByIds"/>",
    		cache : false,
    		data : 'selectedActiveComponentIds=' + activeComIds,
    		success : function(response) {
    			$('#totalHours').val(response);
    		},
    		error : function() {
    			alert('Error while request..');
    		}
    	});

    	return false;
    }
    
   
</script>
<body>
<%@ include file="/WEB-INF/views/includes/header-utility.jsp"%>
	<h3><msg:message code="title.component.manageComponents"/>: <c:out value="${projectName}"/></h3>
	<div id="outerContainer">
		<div class="clear">
			<div id="contentContainer">

				<div id="pageContent">
					<form:form action ="${pageContext.request.contextPath}/lem/component/addManageComponents" method="POST" modelAttribute="componentList">
						<table>
                            
                            <select id="selectedInactiveComponentIds" multiple="multiple" name="selectedInactiveComponentIds" style="width: 250px;height: 300px">
						        <c:forEach var="inactiveComponent" items="${inactiveComponents}">
									<option value="${inactiveComponent.id}">${inactiveComponent.name}</option>
								</c:forEach>
						   </select>
						
						  	<input id="moveRight" type="button" value="Move Right >> " />
						  	<input id="moveLeft" type="button" value="Move Left << " />
						
						  	<select id="selectedActiveComponentIds" multiple="multiple" name="selectedActiveComponentIds" style="width: 250px;height: 300px">
						         <c:forEach var="activeComponent" items="${activeComponents}">
									<option value="${activeComponent.id}">${activeComponent.name}</option>
								</c:forEach>     
						  	</select>
                            
                          	<tr><td><input type="hidden" name="projectId" value="<c:out value="${projectId}"/>" /></td></tr>
                          	<tr><td><input type="hidden" name="selectedActiveComponentIds"/></td></tr>
                          	<tr><td><input type="hidden" name="selectedInactiveComponentIds"/></td></tr>
                            
                          	<tr>
                            	<td><msg:message code="label.component.componentDetails.totalHours"/></td>
                            	<td><input id="totalHours" type="text" name="totalHours" disabled="disabled" value="${totalHours}"/></td>
                           	</tr>
                            
                          	<tr><td align="center"><input type="submit" value="<msg:message code="button.component.addManageComponents"/>" class="btn btn-primary"/></td></tr>
						</table>
					</form:form>

				</div>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
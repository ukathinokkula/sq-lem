<%@ include file="/WEB-INF/views/includes/tags-utility.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
</head>

<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript">

function doAjaxPostForUpdateInfo() {
    // get the form values
   
    var id = $('#updateuserid').val();
    var username = $('#updateusername').val();
    
    $.ajax({
        type: "POST",
		url : "<c:out value="${pageContext.request.contextPath}/lem/accountInfo/resetPassword"/>",
		cache : false,
		 data: {file : formData},
       // data: 'id=' + id + '&username' + username + '&area=' + updatearea + '&postalCode=' + updatepostalCode + '&getOffers=' +updategetOffers,
        success: function(response){
            // we have the response
           if(response.status == "SUCCESS"){
        	   $('#resetPwdInfo').html(response.result);
        	   $('#pwderror').hide('slow');
               $('#resetPwdInfo').show('slow');
           }else{
                 errorInfo = "";
                 for(i =0 ; i < response.result.length ; i++){
                     errorInfo += "<br>" + response.result[i].defaultMessage;
                 }
                 $('#pwderror').html("<span>"+errorInfo+"</span>");
                 $('#resetPwdInfo').hide('slow');
                 $('#pwderror').show('slow');
             }
         },
         error: function(e){
             alert('Error: ' + e);
         }
    });
}

</script>
<body>
	<%@ include file="/WEB-INF/views/includes/header-utility.jsp"%>
	<h3>
		<msg:message code="title.accountInfo.updateAccountInfo" />
	</h3>
	<div id="outerContainer">
		<div class="clear">
			<div id="contentContainer">
				<c:set var="user" value="${user}" scope="request"></c:set>
				<div id="pageContent">
				<form:form id="form_101" class="appnitro"  action="${pageContext.request.contextPath}/lem/accountInfo/updateAccountInfo" modelAttribute="user" method="POST" enctype="multipart/form-data">
								
         <table><tr><td colspan="2">
						    
						</td><td></td></tr>
					<tr><td colspan="2">
					
					</td></tr>
							<tr>
								<td><input type="hidden" name="id" value="<c:out value="${user.id}"/>" id="updateuserid"/></td>
							</tr>
							<tr>
								<td><msg:message code="label.viewAccountInfo.email" /></td>
								<td><input type="text" name="username"
									value="${user.username}" readonly="readonly" id="updateusername"/></td>
									<td> <form:errors path="username" class="error"/></td>
							</tr>
							<tr>
								<td>
								<td><input type="submit"
									value="<msg:message code="button.viewAccountInfo.updateProfile"/>"
									class="btn btn-primary" /></td>
						</table>
					</form:form>

				</div>
			</div>
			<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
			<div class="clear"></div>
		</div>
</body>
</html>
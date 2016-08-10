<%@ include file="/WEB-INF/views/includes/tags-utility.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/views/includes/header-utility.jsp"%>
	<h1>
		<msg:message code="title.accountInfo.viewAccountInfo" />
	</h1>
	<div id="outerContainer">
		<div class="clear">
			<div id="contentContainer">
				<c:set var="user" value="${user}" scope="request"></c:set>
				<div id="pageContent">
					<form:form
						action="${pageContext.request.contextPath}/lem/accountInfo/openUpdateAccountInfo"
						method="POST" modelAttribute="user">
					
         <table><tr><td colspan="2">
						    <%-- <div class="span3 sidebar-left">
			                   <img src="/temp/Accountinfo_tsausers_${user.id}.jpg"/> 
			                <!--   <img src="${imagePath}" />   -->
			                    
               					 <div class="gap gap-small"></div>	
                					<div class="gap gap-small"></div>
            				</div> --%>
						</td></tr>
							<tr>
								<td><msg:message code="label.viewAccountInfo.email" /></td>
								<td>${user.username}</td>
							</tr>
							<tr>
								<td><input type="submit"
									value="<msg:message code="button.viewAccountInfo.editProfile"/>"
									class="btn btn-primary" /></td>
								</tr>
						</table>
						</div>
					</form:form>

				</div>
			</div>
			<%-- <%@ include file="/WEB-INF/views/includes/footer.jsp"%> --%>
			<div class="clear"></div>
		</div>
</body>
</html>
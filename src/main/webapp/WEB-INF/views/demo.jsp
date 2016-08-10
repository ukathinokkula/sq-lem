<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reset Password</title>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
</head>
<body>
	<!-- PAGE TITLE -->
	<div class="top-title-area">
		<div class="container">
			<h1 class="title-page">Listings</h1>
		</div>
	</div>
	<!-- END PAGE TITLE -->

	<!-- SEARCH AREA -->
	<div class="search-area">
		<form id="form_694501" class="appnitro"
			action="${pageContext.request.contextPath}/tsalistings/doSearch"
			method="post">
			<div class="container">
				<div class="row-fluid">
					<div class="span8">
						<label><i class="icon-search"></i>I am searching for</label>
						<div class="search-area-division search-area-division-input">
							<input class="span12" type="text" name="searchFor"
								placeholder="A Cook, A Driver, etc." />
						</div>
					</div>
					<div class="span3">
						<label><i class="icon-map-marker"></i>In</label>
						<div class="search-area-division search-area-division-location">
							<input class="span12" type="text" name="searchIn"
								placeholder="Johannesburg" />
						</div>
					</div>
					<div class="span1">
						<button class="btn btn-block btn-white search-btn" type="submit">Search</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- END SEARCH AREA -->

	<!-- MAIN CONTENT -->
	<div class="container">
		<div class="row">
			<div class="span9">
				<form action="" method="POST" modelAttribute="user">
				    <input type="hidden" name="username" value=""/><br/>
				    
				    
				</form>
			</div>
		</div>
	</div>

	<!-- MAIN CONTENT -->


	<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	<div class="clear"></div>
</body>
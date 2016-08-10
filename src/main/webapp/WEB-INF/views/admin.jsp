<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Source Africa</title>
</head>
<body>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
	<h1>Admin Home Page</h1>

	<div id="outerContainer">
		<div class="clear">
			<jsp:include page="/WEB-INF/views/includes/leftmenu.jsp" />
			<div id="contentContainer">

				<div id="pageContent">

					<p>
						This Policy is a statement of the ways in which we collect, hold
						and use information about individual persons. This Policy applies
						only to information gathered by us from online resources that
						display a link to this Policy and not from any other source. BY
						USING THIS WEBSITE, YOU CONSENT TO THE COLLECTION AND USE OF
						INFORMATION AS SET FORTH IN THIS PRIVACY POLICY. YOU ALSO
						ACKNOWLEDGE THAT NOVARTIS AG MAY PERIODICALLY CHANGE, MODIFY, ADD
						OR REMOVE OR OTHERWISE UPDATE THIS PRIVACY POLICY AT ITS
						DISCRETION, WITHOUT PRIOR NOTIFICATION. It is our intention to
						post any such changes on this page so that you are fully informed
						concerning the types of information we are gathering, how we use
						it, and under what circumstances it may be disclosed.<br /> Our
						privacy policy is easy to find as it is located on our homepage
						and is linked to any part of a site where personal data are
						requested. At such data collection points, further explanation may
						be provided, where appropriate, as to the purposes for which the
						data will be used. This Policy, coupled with any supplementary
						explanation, will tell you how we will treat any data about
						yourself that you voluntarily submit in connection with your use
						of our websites.
					</p>


				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
		<div class="clear"></div>
	</div>

</body>
</html>
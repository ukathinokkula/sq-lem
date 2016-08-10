<div id="leftColumnContainer">
	<div id="topNavContainer">
		<%-- <ul id="topnavlist">

			<div class="menuLinkLogout">
				<li><a href="<%=request.getContextPath() %>/lem/category/">
					Logout</a></li>
			</div>
			<li><a href="<%=request.getContextPath() %>/lem/category/" id="currenttop">Category</a></li>
			<li><a href="<%=request.getContextPath() %>/lem/category/">Category</a></li>
		</ul> --%>

	</div>

	<div id="currentUserBox">
		<b>Current User:</b><br>
		

		<div class="userAccessLevel"><br>
		</div>

		<div class="menuLinkLogout">
			<a href="#"
				onclick="return(window.confirm('Are you sure you want to log out?'));"
				class="breadcrumb">Log out</a>
		</div>

		<div class="menuLinkEditProfile">
			<a href="#"
				class="breadcrumb">Edit my profile</a>
		</div>
	</div>

</div>
<div id="header">
	<div id="headerRight"></div>
	
	<header class="main">
		<div class="container">
			<div class="row">
				<div class="span8">
					<!-- MAIN NAVIGATION -->
					<div id="flexnav-menu-button" class="flexnav-menu-button">
						Menu<span class="touch-button"></span>
					</div>
					<nav>
						<ul data-breakpoint="800" id="flexnav"
							class="nav nav-pills flexnav lg-screen">

							<li><a href="${pageContext.request.contextPath}/lem/login/homePage">
								<msg:message code="label.menu.projectDetails" /></a>
							</li>
						</ul>
					</nav>
					<!-- END MAIN NAVIGATION -->
				</div>
				<div class="span2">
					<!-- LOGIN REGISTER LINKS -->
					<c:choose>
						<c:when test="${username == null}">
							<ul class="login-register">
								<li><a data-effect="mfp-move-from-top" href="#."
									class="popup-text" onclick="popupForSingUp('login-dialog');"><i
										class="icon-signin"></i>Sign in</a></li>
								<li><a data-effect="mfp-move-from-top" href="#."
									onclick="popupForSingUp('register-dialog');" class="popup-text"><i
										class="icon-edit"></i>Sign up</a></li>
							</ul>
						</c:when>
						<c:when test="${username != null}">
							<ul class="login-register">
								<li><a data-effect="mfp-move-from-top" class="popup-text"
									href="<c:url value="/lem/j_spring_security_logout" />"> 
									<!-- <i class="icon-signin"></i> --><msg:message code="label.header.logout" />
								</a>
								<a data-effect="mfp-move-from-top" class="popup-text"
									href="<c:url value="/lem/accountInfo/viewAccountInfo" />">
									<!-- <i class="icon-signin"> --></i><msg:message code="label.header.accountInfo" />
								</a>
								<a data-effect="mfp-move-from-top" class="popup-text"
									href="<c:url value="/lem/accountInfo/openResetPasswordPage" />">
									<!-- <i class="icon-signin"></i> --><msg:message code="label.header.resetPassword" />
								</a>
								</li>
								
							</ul>
						</c:when>
					</c:choose>
				</div>
			</div>
		</div>
		<div id="login-dialog-parent"></div>
		<div>
			<div>
				<div>

					<div id="login-dialog"
						class="mfp-with-anim mfp-hide mfp-dialog clearfix">
						<i class="icon-signin dialog-icon"></i>
						<h3>Member Login</h3>
						<h5>Welcome back, friend. Login to get started</h5>
						<div class="row-fluid">
							<form id="login-form" action="<c:url value="/lem/j_spring_security_check" />"
								method="post" class="dialog-form">
								<label>E-mail</label> <input type="text" name="username" id="username_login"
									placeholder="email@domain.com" class="span12"> 
							    <span class="emailError" style="display: none;">You must enter a valid email address</span>
								
								<label>Password</label>
								<input type="password" name="password" id="password_login"
									placeholder="My secret password" class="span12"> 
								<span class="passwordError" style="display: none;">You must enter a valid password</span>	
								<label
									class="checkbox"> <input type="checkbox"
									name="_spring_security_remember_me">Remember me
								</label> <input type="submit" value="Sign in" class="btn btn-primary" onclick="validateLoginDetails();">
							</form>
						</div>
						<ul class="dialog-alt-links">
							<li><a class="popup-text" href="#register-dialog"
								data-effect="mfp-zoom-out">Not A Member?</a></li>
							<li><a class="popup-text" href="#."
								data-effect="mfp-zoom-out"
								onclick="closepopUp('login-dialog');popupForTroubleLogginIn('password-recover-dialog');">Trouble
									Logging In?</a></li>


						</ul>
						<button class="mfp-close" style="display: block" type="button"
							title="Close (Esc)" onclick="closepopUp('login-dialog');">×</button>
					</div>
				</div>
			</div>
		</div>
		<div id="register-dialog-parent"></div>
		<div>
			<div>
				<div>
					<div id="register-dialog"
						class="mfp-with-anim mfp-hide mfp-dialog clearfix"
						style="padding-top: 10px">
						<i class="icon-edit dialog-icon"></i>
						<h3>Member Register</h3>
						<h5>Ready to get best offers? Let's get started!</h5>
						<div class="row-fluid">
							<form:form action="${pageContext.request.contextPath}/lem/signup"
								modelAttribute="user" method="POST" class="dialog-form">
								<form:errors path="*" cssClass="errorblock" element="div" />
								<input id="hasErrors" type="hidden" value="${hasErrors}" />
								<label>E-mail</label>
								<input type="text" name="username"
									placeholder="email@domain.com" class="span12">
								<label>Password</label>
								<input type="password" name="password"
									placeholder="My secret password" class="span12">
								<label>Repeat Password</label>
								<input type="password" name="confirmPassword"
									placeholder="Type your password again" class="span12">
								<div class="row-fluid">
									<div class="span8">
										<label>Your Area</label> <input type="text" name="area"
											placeholder="Boston" class="span12">
									</div>
									<div class="span4">
										<label>Postal/Zip</label> <input type="text" name="postalCode"
											placeholder="12345" class="span12">
									</div>
								</div>
								<label class="checkbox"> <input type="checkbox"
									name="getOffers" defaultChecked="false" />Get hot offers via
									e-mail
								</label>
								<input type="submit" value="Sign up" class="btn btn-primary">
							</form:form>
						</div>
						<ul class="dialog-alt-links">
							<li><a class="popup-text" href="#login-dialog"
								data-effect="mfp-zoom-out">Already member</a></li>
						</ul>
						<button class="mfp-close" style="display: block" type="button"
							title="Close (Esc)" onclick="closepopUp('register-dialog');">×</button>
					</div>
				</div>
			</div>
		</div>
		<div id="password-recover-dialog-parent"></div>
		<div>
			<div>
				<div>
					<div id="password-recover-dialog"
						class="mfp-with-anim mfp-hide mfp-dialog clearfix">
						<i class="icon-retweet dialog-icon"></i>
						<h3>Password Recovery</h3>
						<h5>Fortgot your password? Don't worry we can deal with it</h5>
						<div class="row-fluid">
							<form id="forgot-form" class="dialog-form" method="GET">
								<div id="info" class="success"></div>
								<div id="error" class="error"></div>
								<label>E-mail</label> <input type="text"
									placeholder="email@domain.com" class="span12" name="username"
									id="username" value="">
									<span class="passwordError" style="display: none;">You must enter a valid Email address</span>
							
									 <input type="submit"
									value="Request new password" class="btn btn-primary"
									onclick="forgotPassword();doAjaxPost()">
									</form>
						</div>
						<button class="mfp-close" style="display: block" type="button"
							title="Close (Esc)"
							onclick="closepopUp('password-recover-dialog');">×</button>
					</div>
				</div>
			</div>
		</div>
		<!-- END LOGIN REGISTER LINKS CONTENT -->
	</header>
</div>

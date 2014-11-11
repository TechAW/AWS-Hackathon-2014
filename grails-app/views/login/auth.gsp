<html>
	<head>
		<meta name='layout' content='main'/>
		<title><g:message code="springSecurity.login.title"/></title>
	</head>

	<body>
		<div id='login'>
			<div class='inner login'>
				<h2><g:message code="springSecurity.login.header"/></h2>

				<g:if test='${flash.message}'>
					<div class='login_message'>${flash.message}</div>
				</g:if>

				<form action='${postUrl}' role="form" method='POST' id='loginForm' class='cssform' autocomplete='off'>
					<div class="form-group">
						<label for='username'><g:message code="springSecurity.login.username.label"/>:</label>
						<input type='text' class="form-control" name='j_username' id='username'/>
					</div>

					<div class="form-group">
						<label for='password'><g:message code="springSecurity.login.password.label"/>:</label>
						<input type='password' class="form-control"  name='j_password' id='password'/>
					</div>

					<div class="checkbox">
						<input type='checkbox' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
						<label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>
					</div>

					<button type='submit' id="submit" class="btn btn-primary">${message(code: "springSecurity.login.button")}</button>
				</form>
			</div>
		</div>
		<script type='text/javascript'>
			<!--
			(function() {
				document.forms['loginForm'].elements['j_username'].focus();
			})();
			// -->
		</script>
	</body>
</html>

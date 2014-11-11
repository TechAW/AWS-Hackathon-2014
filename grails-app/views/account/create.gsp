<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>TheConnMan</title>
	</head>
	<body>
		<div id="page-body" role="main">
			<h3 style="margin-left: 20px;">Create Account</h3>
			<g:if test="${ flash.message }">
				<div class="errors">${ flash.message }</div>
			</g:if>
			<div style="width: 600px; margin: 0 auto;">
				<g:form action="submitCreation">
					<span>Username:</span><g:field type="text" name="username" /><br />
					<span>Password:</span><g:field type="password" name="password" /><br />
					<span>Phone Number:</span><g:field type="text" name="phone" /><br />
					<span>Email:</span><g:field type="text" name="email" /><br />
					<g:submitButton name="submit" value="Create Account" />
				</g:form>
			</div>
		</div>
	</body>
</html>

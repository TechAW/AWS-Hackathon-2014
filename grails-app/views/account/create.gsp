<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>TheConnMan</title>
	</head>
	<body>
		<div id="page-body" role="main">
			<div class='inner login'>
				<h2>Create Account</h2>
				<g:if test="${ flash.message }">
					<div class="errors">${ flash.message }</div>
				</g:if>
				<div>
					<g:form action="submitCreation">
						<div class="form-group">
							<label for='username'>Username:</label>
							<input type='text' class="form-control" name='username' id='username'/>
						</div>
						<div class="form-group">
							<label for='password'>Password:</label>
							<input type='text' class="form-control" name='password' id='password'/>
						</div>
						<div class="form-group">
							<label for='password'>Phone:</label>
							<input type='text' class="form-control" name='phone' id='phone'/>
							<button type="button" class="btn btn-info" onclick="testNumber()">Send a test SMS</button>
						</div>
						<div class="form-group">
							<label for='password'>Email:</label>
							<input type='email' class="form-control" name='email' id='email'/>
						</div>

						<button name="submit" class="btn btn-primary">Create Account</button>
					</g:form>
				</div>
			</div>
		</div>
		<script>
			function testNumber() {
				$.ajax({
					url: "/account/testNumber",
					type: "POST",
					data: {
						number: $('#phone').val()
					}
				})
			}
		</script>
	</body>
</html>

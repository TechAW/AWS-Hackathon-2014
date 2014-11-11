<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>TheConnMan</title>
	</head>
	<body>
		<div id="page-body" role="main" style="margin: 20px;">
			<h1>${ username }'s Profile</h1>
			<h2>Locations</h2>
			<g:each in="${ locations }">
				${ it }
			</g:each>
			<div>
				<h2>Add Location</h2>
				<g:field name="name" type="text" placeholder="Location Name" /><br />
				<span>Latitude:</span><g:field name="lat" type="number" /><br />
				<span>Longitude:</span><g:field name="lng" type="number" /><br />
				<span>Radius:</span><g:field name="radius" type="number" /><br />
				<button onclick="addLocation()">Add Location</button>
			</div>
		</div>
		<script>
			function addLocation() {
				$.ajax({
					url: '/account/addLocation',
					data: {
						name: $('#name').val(),
						lat: $('#lat').val(),
						lng: $('#lng').val(),
						radius: $('#radius').val()
					},
					success: function(data) {
						if (data.success) {
							swal("Success", "Your new location was added successfully.", "success");
						} else {
							swal("Error", data.error, "error");
						}
					}
				})
			}
		</script>
	</body>
</html>

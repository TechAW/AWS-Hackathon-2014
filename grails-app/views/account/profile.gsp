<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>TheConnMan</title>
	</head>
	<body>
		<div id="page-body" role="main">
			<div class="inner">
				<h1>${ username }'s Profile</h1>
				<h2>Locations</h2>
				<table class="location-table">
				<g:each in="${ locations }">
					<tr>
						<td>${ it.name }</td>
						<td>${ it.lat }</td>
						<td>${ it.lon }</td>
					</tr>
				</g:each>
				</table>
				<div>
					<h2>Add Location</h2>
					<div class="form-group">
						<label for="name">Location name</label>
						<input type="text" class="form-control midsized-input" id="name" name="name" placeholder="Home"/>
					</div>
					<div class="form-group">
						<label for="lat">Latitude</label>
						<input type="text" class="form-control midsized-input" id="lat" name="lat"/>
					</div>
					<div class="form-group">
						<label for="radius">Longitude</label>
						<input type="text" class="form-control midsized-input" id="lon" name="lon"/>
					</div>
					<div class="form-group">
						<label for="radius">Your warning radius in meters</label>
						<input type="number" class="form-control midsized-input" id="radius" name="radius" placeholder="500 meters"/>
					</div>
					<button onclick="addLocation()" class="btn btn-primary">Add Location</button>
				</div>
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

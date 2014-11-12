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
				<div class="profile-part">
					<h2>Locations</h2>
					<table class="location-table">
						<thead>
							<tr>
								<th>Location name</th>
								<th class="wide-screen">Latitude</th>
								<th class="wide-screen">Longitude</th>
								<th>Warning radius (meters)</th>
							</tr>
						</thead>
						<tbody>
						<g:each in="${ locations }">
							<tr>
								<td>${ it.name }</td>
								<td class="wide-screen">${ it.lat }</td>
								<td class="wide-screen">${ it.lon }</td>
								<td>${ it.radius }</td>
							</tr>
						</g:each>
						</tbody>
					</table>
				</div>
				<div class="profile-part">
					<h2>Add Location</h2>
					<div class="form-group">
						<label for="name">Location name</label>
						<input type="text" class="form-control midsized-input" id="name" name="name" placeholder="Home"/>
					</div>
					<div class="form-group">
						<label for="address">Address</label>
						<input type="text" class="form-control midsized-input" id="address" name="address" placeholder="Venetian, Las Vegas"/>
						<button type="button" class="btn btn-info" onclick="geocodeAddress()">Compute coordinates</button>
					</div>
					<div class="form-group">
						<label for="lat">Latitude</label>
						<input type="text" class="form-control midsized-input" id="lat" name="lat"/>
					</div>
					<div class="form-group">
						<label for="lng">Longitude</label>
						<input type="text" class="form-control midsized-input" id="lng" name="lng"/>
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
			var geocoder = new google.maps.Geocoder();

			function reloadAfterSuccess() {
				window.location.reload();
			}

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
							window.setTimeout(reloadAfterSuccess(), 2500);
						} else {
							swal("Error", data.error, "error");
						}
					}
				})
			}

			function geocodeAddress() {
				var address = $('#address').val();

				geocoder.geocode( { 'address': address}, function(results, status) {
					if (status == google.maps.GeocoderStatus.OK) {
						$('#lng').val(results[0].geometry.location.lng());
						$('#lat').val(results[0].geometry.location.lat());
/*						map.setCenter(results[0].geometry.location);
						var marker = new google.maps.Marker({
							map: map,
							position: results[0].geometry.location
						}); */
					} else {
						alert('Geocode was not successful for the following reason: ' + status);
					}
				});
			}
		</script>
	</body>
</html>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Atrocity Watch</title>
		<script src="https://maps.googleapis.com/maps/api/js"></script>
	</head>

	<body>
		<header role="main" class="intro">
			<div class="intro-body">
				<h1 class="brand-heading">Tracking</h1>
			</div>
		</header>

		<section>
			<script>
				function update(pos) {
					$.ajax({
						url: '/account/trackMe',
						data: {
							lat: pos.coords.latitude,
							lng: pos.coords.longitude,
						},
						success: function(data) {
							
						}
					})
				}

				$(function() {
					setInterval(function() {
						navigator.geolocation.getCurrentPosition(update)
					}, 5000)
				})
			</script>
		</section>
	</body>
</html>

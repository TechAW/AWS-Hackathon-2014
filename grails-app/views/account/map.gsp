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
				<h1 class="brand-heading">Event Map</h1>
			</div>
		</header>

		<section class="map-section">
			<div id="map_canvas" ></div>
			<script>
				var locs = JSON.parse('${ locations }'.replace(/&quot;/g, '"'));
				var events = JSON.parse('${ events }'.replace(/&quot;/g, '"'));
				
				google.maps.event.addDomListener(window, "load", initializeMap);

				function initializeMap(){
					var mapCanvas = document.getElementById("map_canvas");
					var mapOptions = {
						center: new google.maps.LatLng(36.1228431, -115.1704714),
						zoom: 14,
						mapTypeId: google.maps.MapTypeId.ROADMAP
					}
					var map = new google.maps.Map(mapCanvas, mapOptions);
					locs.forEach(function(d) {
						var cirOptions = {
							strokeColor: '#FF0000',
							strokeOpacity: 0.4,
							strokeWeight: 2,
							fillColor: '#FF0000',
							fillOpacity: 0.2,
							map: map,
							center: new google.maps.LatLng(d.lat, d.lon),
							radius: d.radius / 3.2
						};
						

						// Add the circle for this city to the map.	
						new google.maps.Circle(cirOptions);
					});

					events.forEach(function(d) {
						var marker = new google.maps.Marker({
						      position: new google.maps.LatLng(d.lat, d.lon),
						      map: map
						  });
					})
				}
			</script>
		</section>
	</body>
</html>

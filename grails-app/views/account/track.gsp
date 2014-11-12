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

		<section class="map-section">
			<div id="map_canvas" ></div>
			<script>
				var events = JSON.parse('${ events }'.replace(/&quot;/g, '"'));
				var map, c;
				
				google.maps.event.addDomListener(window, "load", initializeMap);
	
				function initializeMap(){
					var mapCanvas = document.getElementById("map_canvas");
					var mapOptions = {
						center: new google.maps.LatLng(36.1228431, -115.1704714),
						zoom: 19,
						mapTypeId: google.maps.MapTypeId.ROADMAP
					}
					map = new google.maps.Map(mapCanvas, mapOptions);
	
					events.forEach(function(d) {
						addEvent(d);
					})
				}

				function addEvent(event) {
					var marker = new google.maps.Marker({
					      position: new google.maps.LatLng(event.lat, event.lon),
					      map: map,
					      title: event.name
					  });
				}

				function redrawLocation(lat, lng, radius, alert) {
					if (c) {
						c.setMap(null);
					}
					
					var cirOptions = {
							strokeColor: alert ? '#FF0000' : '#00FF00',
							strokeOpacity: 0.4,
							strokeWeight: 2,
							fillColor: alert ? '#FF0000' : '#00FF00',
							fillOpacity: 0.2,
							map: map,
							center: new google.maps.LatLng(lat, lng),
							radius: radius / 3.2
						};
						
					// Add the circle for this city to the map.	
					c = new google.maps.Circle(cirOptions);
					map.setCenter(new google.maps.LatLng(lat, lng))
				}
				
				function update(pos) {
					$.ajax({
						url: '/account/trackMe',
						data: {
							lat: pos.coords.latitude,
							lng: pos.coords.longitude,
						},
						success: function(data) {
							console.log(data)
							redrawLocation(pos.coords.latitude, pos.coords.longitude, data.radius, data.alert)
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

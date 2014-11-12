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
				<h1 class="brand-heading">Atrocity Watch Mobile</h1>
			</div>
		</header>
       
		<section class="map-section">
		  Address:<input type=text id='address' /><button onclick='geocodeAddress()'>Click</button> <div id='result' ></div>
			<div id="map_canvas" ></div>
			<script>
				var citymap = {};

				citymap['losangeles'] = {
					center: new google.maps.LatLng(34.052234, -118.243684),
					population: 3857799
				};
				var cityCircle
				google.maps.event.addDomListener(window, "load", initializeMap);
				var geocoder 
				var map
				function initializeMap(){
					geocoder = new google.maps.Geocoder();
					var mapCanvas = document.getElementById("map_canvas");
					var mapOptions = {
						center: new google.maps.LatLng(36.175,  -115.1363889),
						zoom: 6,
						mapTypeId: google.maps.MapTypeId.ROADMAP
					}
					 map = new google.maps.Map(mapCanvas, mapOptions);
					/* var ctaLayer = new google.maps.KmlLayer({
					 url: 'http://gmaps-samples.googlecode.com/svn/trunk/ggeoxml/cta.kml'
					 });
					 ctaLayer.setMap(map);*/

					// drawing shapes
					var flightPlanCoordinates = [
						new google.maps.LatLng(37.772323, -122.214897),
						new google.maps.LatLng(21.291982, -157.821856),
						new google.maps.LatLng(-18.142599, 178.431),
						new google.maps.LatLng(-27.46758, 153.027892)
					];
					var flightPath = new google.maps.Polyline({
						path: flightPlanCoordinates,
						geodesic: true,
						strokeColor: '#FF0000',
						strokeOpacity: 1.0,
						strokeWeight: 2
					});

					flightPath.setMap(map);
					for (var city in citymap) {
						var cirOptions = {
							strokeColor: '#FF0000',
							strokeOpacity: 0.8,
							strokeWeight: 2,
							fillColor: '#FF0000',
							fillOpacity: 0.35,
							map: map,
							center: citymap[city].center,
							radius:  100000
						};

						// Add the circle for this city to the map.
						cityCircle = new google.maps.Circle(cirOptions);
					}
				}
				function geocodeAddress() {
					
					  var address = $('#address').val();
					  alert(address)
					  geocoder.geocode( { 'address': address}, function(results, status) {
					    if (status == google.maps.GeocoderStatus.OK) {

					    	$('#result').html (results[0].geometry.location.lng() +' '+results[0].geometry.location.lat() ) 
					      map.setCenter(results[0].geometry.location);
					      var marker = new google.maps.Marker({
					          map: map,
					          position: results[0].geometry.location
					      });
					    } else {
					      alert('Geocode was not successful for the following reason: ' + status);
					    }
					  });
				}
			</script>
		</section>
	</body>
</html>

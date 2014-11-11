<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Atrocity Watch</title>			
		<script src="https://maps.googleapis.com/maps/api/js"></script>
		<style>
  #map_canvas {
    width: 99%;
    height: 500px;
    margin : 5px;
    background-color: #CCC;
  }
  </style>
	</head>
	<body>				
					 
		<div id="map_canvas" ></div>
					 	
		<script>
		var citymap = {};
	
		citymap['losangeles'] = {
		  center: new google.maps.LatLng(34.052234, -118.243684),
		  population: 3857799
		};
		var cityCircle
		google.maps.event.addDomListener(window, "load", initializeMap);
			
			function initializeMap(){
			    var mapCanvas = document.getElementById("map_canvas");
			    var mapOptions = {
			      center: new google.maps.LatLng(36.175,  -115.1363889),
			      zoom: 6,
			      mapTypeId: google.maps.MapTypeId.ROADMAP
			    }
			    var map = new google.maps.Map(mapCanvas, mapOptions);
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
			
			</script>
	</body>
</html>

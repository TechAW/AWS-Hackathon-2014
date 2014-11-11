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
					 
		<div id="map_canvas" >test</div>
					 	
		<script>
		
		google.maps.event.addDomListener(window, "load", initializeMap);
			
			function initializeMap(){
			    var mapCanvas = document.getElementById("map_canvas");
			    var mapOptions = {
			      center: new google.maps.LatLng(36.175,  -115.1363889),
			      zoom: 8,
			      mapTypeId: google.maps.MapTypeId.ROADMAP
			    }
			    var map = new google.maps.Map(mapCanvas, mapOptions);
			  }
			
		</script>
	</body>
</html>

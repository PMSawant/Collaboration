<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src='https://maps.googleapis.com/maps/api/js?v=3.exp'></script>
 
<style>
#gmap_canvas img {
	max-width: none !important;
	background: none !important
}
</style>
<script type='text/javascript' >
	function init_map() {
		var myOptions = {
			zoom : 10,
			center : new google.maps.LatLng(18.5176121, 73.84156069999994),
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		map = new google.maps.Map(document.getElementById('gmap_canvas'),
				myOptions);
		marker = new google.maps.Marker({
			map : map,
			position : new google.maps.LatLng(18.5176121, 73.84156069999994)
		});
		infowindow = new google.maps.InfoWindow(
				{
					content : '<strong>sagar arcade</strong><br>goodluck chowk pune<br>'
				});
		google.maps.event.addListener(marker, 'click', function() {
			infowindow.open(map, marker);
		});
		infowindow.open(map, marker);
	}
	google.maps.event.addDomListener(window, 'load', init_map);
</script>
<title>Google Map</title>
</head>
<body>
<br><br><br>
<div style='overflow: hidden; height: 250px; width: 300px;'>
	<div id='gmap_canvas' style='height: 250px; width: 300px;'></div>
	<div><small><a href="http://www.embedgooglemaps.com">Generate your Google map here, quick and easy!</a></small></div>
	<div><small><a href="http://freedirectorysubmissionsites.com/">overview of all web directories 2016</a></small>
	</div> </div>
<div class="row">
    <div class="col-md-4">
      <p>We are Here</p>
      <p><span class="glyphicon glyphicon-map-marker"></span>Pune, India</p>
      <p><span class="glyphicon glyphicon-phone"></span>Phone: +00 00000000</p>
      <p><span class="glyphicon glyphicon-envelope"></span>Email: mail@mail.com</p>
    </div>
    </div>

</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src='https://maps.googleapis.com/maps/api/js?v=3.exp'></script>
<div style='overflow: hidden; height: 250px; width: 300px;'>
	<div id='gmap_canvas' style='height: 250px; width: 300px;'></div>
	<div><small><a href="http://www.embedgooglemaps.com">Generate your Google map here, quick and easy!</a></small></div>
	<div><small><a href="http://freedirectorysubmissionsites.com/">overview of all web directories 2016</a></small>
	</div>
<style>
#gmap_canvas img {
	max-width: none !important;
	background: none !important
}
</style>
</div>
<script type='text/javascript'>
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

<br><br><table>
	<tr>
	<td>Enter Email ID</td>
	<td><input type="text" name="email"></td>
	</tr>

	<tr>
	<td> Mention Comments</td>
	<td><input type="text" name="comments"></td>
	</tr>
	<tr>
		<td><input type="submit" value="send"></td>
	</tr>
</table>
</body>
</html>
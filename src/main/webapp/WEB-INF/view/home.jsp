<%@ include file="include.jsp"%>
<html>
<head>
<title>Oil Transaction Management System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" 	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet" href="resources/css/style.css">
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="resources/js/functions.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>

<script>
	$(document).ready(function() {
		home();
	});
</script>
<head>
<body>
	<div class="panel panel-info center"
		style="width: 1000px; text-align: center; margin-top: 50px">
		<div class="panel-heading" style="text-align: center">
			<div>
				<h3>Oil Transaction System</h3>
			</div>

		</div>
		<div class="panel-body">
			<div id="heading" style="text-align: right"></div>
			<div id="container"></div>
		</div>
	</div>
</body>
</html>
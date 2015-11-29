<%@ include file="include.jsp"%>

<html>
<head>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Oil Transaction Management System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet" href="resources/css/style.css">
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});
	google.setOnLoadCallback(drawChart);

	function drawChart() {

		// Set chart options
		var options = {
			'title' : 'Status : Quantity of Oil',
			'width' : 400,
			'height' : 300
		};
		// Set chart options
		var options2 = {
			'title' : 'Status : Amount Traded',
			'width' : 400,
			'height' : 300
		};
		// Set chart options
		var options3 = {
			'title' : 'Status : Oil Commission Traded',
			'width' : 400,
			'height' : 300
		};

		var options4 = {
			'title' : 'Status : Commission Fees',
			'width' : 400,
			'height' : 300
		};

		var data1 = new google.visualization.DataTable('${chart1Json}');
		var data2 = new google.visualization.DataTable('${chart2Json}');
		var data3 = new google.visualization.DataTable('${chart3Json}');
		var data4 = new google.visualization.DataTable('${chart4Json}');

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.PieChart(document
				.getElementById('chart_div'));
		chart.draw(data1, options);
		var chart2 = new google.visualization.PieChart(document
				.getElementById('chart_div2'));
		chart2.draw(data2, options2);
		var chart3 = new google.visualization.BarChart(document
				.getElementById('chart_div3'));
		chart3.draw(data3, options3);
		var chart4 = new google.visualization.PieChart(document
				.getElementById('chart_div4'));
		chart4.draw(data4, options4);
	}
</script>

</head>

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
			<div id="container">
				<div class="row">
					<div class="col-xs-6" id="chart_div"></div>
					<div class="col-xs-6" id="chart_div2"></div>
				</div>
				<div class="row">
					<div id="chart_div3" class="col-xs-6"></div>
					<div id="chart_div4" class="col-xs-6"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
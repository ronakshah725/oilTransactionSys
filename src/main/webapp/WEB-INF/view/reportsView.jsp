<%@ include file="include.jsp"%>

<html>
      <head>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Oil Transaction Management System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" 	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet" href="resources/css/style.css">
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript">

          google.load('visualization', '1.0', {'packages':['corechart']});
          google.setOnLoadCallback(drawChart);

          function drawChart() {

            // Create the data table.
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Topping');    
            data.addColumn('number', 'Slices');
            data.addRows([
              ['Mushrooms', 3],
              ['Onions', 1],
              ['Olives', 1],
              ['Zucchini', 1],
              ['Pepperoni', 2]
            ]);
            // Create the data table.
            var data2 = new google.visualization.DataTable();
            data2.addColumn('string', 'Topping');
            data2.addColumn('number', 'Slices');
            data2.addRows([
              ['Mushrooms', 3],
              ['Onions', 1],
              ['Olives', 15],
              ['Zucchini', 1],
              ['Pepperoni', 2]
            ]);

            var data3 = new google.visualization.DataTable();
            data3.addColumn('string', 'Year');
            data3.addColumn('number', 'Sales');
            data3.addColumn('number', 'Expenses');
            data3.addRows([
              ['2004', 1000, 400],
              ['2005', 1170, 460],
              ['2006',  860, 580],
              ['2007', 1030, 540]
            ]);



            // Create the data table.
            var data4 = new google.visualization.DataTable();
            data4.addColumn('string', 'Payment Status');    
            data4.addColumn('number', 'Amount');
            data4.addRows([
              ['Mushrooms', 3],
              ['Onions', 1],
              ['Olives', 1],
              ['Zucchini', 1],
              ['Pepperoni', 2]
            ]);

            // Set chart options
            var options = {'title':'${chart4Json}',
                           'width':400,
                           'height':300};
            // Set chart options
            var options2 = {'title':'How Much Pizza You Ate Last Night',
                           'width':400,
                           'height':300};
            // Set chart options
            var options3 = {'title':'Too much pizza',
                           'width':400,
                           'height':300};

            var options4 = {'title':' much pizza',
                           'width':400,
                           'height':300};

            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
            chart.draw(data, options);
            var chart2 = new google.visualization.PieChart(document.getElementById('chart_div2'));
            chart2.draw(data2, options2);
            var chart3 = new google.visualization.BarChart(document.getElementById('chart_div3'));
            chart3.draw(data3, options3);
            var chart4 = new google.visualization.PieChart(document.getElementById('chart_div4'));
            //chart4.draw(data4, options4);
            
            var data22=new google.visualization.DataTable('${chart4Json}');
            chart4.draw(data22, options4);
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
			  <table>
${chart1Json}--
${chart2Json}--
${chart3Json}--
${chart4Json}--
		    <tr>
		      <td ><div id="chart_div"></div></td>
		      <td ><div id="chart_div2"></div></td>
		    </tr>
          <tr>
            <td > <div id="chart_div3"></div></td>
            <td > <div id="chart_div4"></div> </td>
          </tr>
        </table></div>
		</div>
	</div>
</body>
    </html>
<%@ include file="include.jsp"%>
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
            data4.addColumn('string', 'Topping');    
            data4.addColumn('number', 'Slices');
            data4.addRows([
              ['Mushrooms', 3],
              ['Onions', 1],
              ['Olives', 1],
              ['Zucchini', 1],
              ['Pepperoni', 2]
            ]);


            // Set chart options
            var options = {'title':'How Much Pizza I Ate Last Night',
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
            chart4.draw(data4, options4);

          }
        </script>


        <!--Divs that will hold the charts-->
        <table>

		    <tr>
		      <td ><div id="chart_div"></div></td>
		      <td ><div id="chart_div2"></div></td>
		    </tr>
          <tr>
            <td > <div id="chart_div3"></div></td>
            <td > <div id="chart_div4"></div> </td>
          </tr>
        </table>
        


      </body>
    </html>
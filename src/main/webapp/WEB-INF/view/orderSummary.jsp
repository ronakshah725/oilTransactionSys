<%@ include file="include.jsp"%>

<div class="panel panel-info center">

	<div class="panel-heading" style="text-align: center">

		<div>
			<h3>Transaction Summary</h3>
		</div>
		<c:if test="${message!=null}">
		<div>${message}</div>
		</c:if>
	</div>

	<div class="panel-body">
		<div class="row" style="padidng-bottom: 10px; padding-top: 10px">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Check</th>
						<th>#</th>
						<th>Date</th>
						<th>Type</th>
						<th>Quantity</th>
						<th>Status</th>
						<th>Amount($)</th>
						<th>Commission($/lb)</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="Checkbox" /></td>
						<td>1</td>
						<td>11/11/2015 12:11:00</td>
						<td>Sale</td>
						<td>100</td>
						<td>Completed</td>
						<td>15323.00 $</td>
						<td>153.00 $</td>
					</tr>

					<tr style="color: #dd0000">
						<td></td>
						<td>2</td>
						<td>11/11/2015 12:10:00</td>
						<td>Sale</td>
						<td>100</td>
						<td>Cancelled</td>
						<td>15323.00 $</td>
						<td>153.00 $</td>
					</tr>
					<tr style="color: #00B050">
						<td><input type="Checkbox" /></td>
						<td>3</td>
						<td>11/10/2015 12:11:00</td>
						<td>Buy</td>
						<td>100</td>
						<td>Completed</td>
						<td>15323.00 $</td>
						<td>153.00 $</td>
					</tr>

				</tbody>
			</table>
		</div>
		<div class="row"> 
		<div class="xs-col-3">Outstanding balance</div>
		<div class="xs-col-3">${outstandingBalance}</div>
		<div class="xs-col-3"> Total Oil owned:</div>
		<div class="xs-col-3">${totalOilOwned} </div>
		</div>
		<div class="row" style="padidng-bottom: 10px; padding-top: 10px">
			<div class="col-xs-6" style="text-align: center">
				<input type="submit" class="btn btn-danger btn-lg" value="Pay">
			</div>
			<div class="col-xs-6" style="text-align: center">
				<input type="submit" class="btn btn-warning btn-lg" onclick="cancelOrder()" value="Cancel">
			</div>
		</div>
	</div>
</div>




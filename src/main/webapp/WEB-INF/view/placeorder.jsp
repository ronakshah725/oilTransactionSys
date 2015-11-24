<%@ include file="include.jsp"%>

<div class="panel panel-info center"
	style="width: 400px; text-align: center; margin-top: 50px">

	<div class="panel-heading">
		<h3>Place Order</h3>
	</div>

	<div class="panel-body">
		<form name="placeOrderForm">
			<div class="row" style="padding-top: 10px">

				<div class="col-xs-6 left bottom">Commission Type:</div>
				<div class="col-xs-6 left bottom">
					<select name="singleSelect" class="form-control" required
						id="singleSelect" ng-model="commissionType">
						<option value="buy">Oil</option>
						<!-- interpolation -->
						<option value="sell">Cash</option>
					</select>
				</div>
			</div>


			<div class="row" style="padding-top: 10px">
				<div class="col-xs-6 left bottom">Quantity</div>
				<div class="col-xs-6 left">
					<input type="number" class="form-control" required
						ng-model="quantity" />
				</div>
			</div>

			<div class="row" style="padding-top: 10px">
				<div class="col-xs-6 left bottom">Transaction Type:</div>
				<div class="col-xs-6 left top">
					<label> <input type="radio" class="form-control"
						name="transactionType" checked ng-model="transactionType"
						value="buy"> Buy
					</label> <label> <input type="radio" class="form-control"
						name="transactionType" required ng-model="transactionType"
						value="sell"> Sell
					</label>
				</div>
			</div>



			<div class="row top" style="padding-top: 10px">
				<div class="col-xs-12" style="text-align: right">
					<input type="submit" class="btn btn-info" ng-submit="submit()" />
				</div>
			</div>
		</form>
	</div>

</div>



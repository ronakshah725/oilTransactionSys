<%@ include file="include.jsp"%>

<div class="panel panel-info center"
	style="width: 400px; text-align: center; margin-top: 50px">

	<div class="panel-heading">
		<h3>Place Order</h3>
	</div>

	<div class="panel-body">
		<form name="placeOrderForm" id="placeOrderForm">
			<div class="row" style="padding-top: 10px">

				<div class="col-xs-6 left bottom">Commission Type:</div>
				<div class="col-xs-6 left bottom">
					<select   class="form-control" required
						id="commissionType" name="commissionType">
						<option value="Oil">Oil</option>
						<option value="Cash">Cash</option>
					</select>
				</div>
			</div>


			<div class="row" style="padding-top: 10px">
				<div class="col-xs-6 left bottom">Quantity</div>
				<div class="col-xs-6 left">
					<input type="number" class="form-control" required
					id="quantity"	name="quantity" />(Lbs)
				</div>
			</div>
			
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-6 left bottom">Rate applicable</div>
				<div class="col-xs-6 left">
					${oil_price}/Lb
				</div>
			</div>

			<div class="row" style="padding-top: 10px">
				<div class="col-xs-6 left bottom">Transaction Type:</div>
				<div class="col-xs-6 left top">
					<label> <input type="radio" class="form-control"
						name="type" checked id="type"
						value="buy"> Buy
					</label> <label> <input type="radio" class="form-control"
						name="type" required id="type"
						value="sell"> Sell
					</label>
				</div>
			</div>



			<div class="row top" style="padding-top: 10px">
				<div class="col-xs-12" style="text-align: right">
					<input id="placeOrder" name="placeOrder" class="btn btn-info"
					type="button" value="Place Order" onclick="putOrder()" />
				</div>
			</div>
		</form>
	</div>

</div>



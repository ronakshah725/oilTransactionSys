<%@ include file="include.jsp"%>

<div class="panel panel-info center"
	style="width: 700px; text-align: center; margin-top: 50px">
	<div class="panel-heading">
		<h3>Make Payment</h3>
	</div>

	<div class="panel-body">
		<form name="paymentForm">
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-4 left bottom">Amount Due:</div>

				<div class="col-xs-4 left bottom">
					<input type="number" ng-model="amount" required=""
						class="form-control" />
				</div>
				<div class="col-xs-4 left bottom"></div>
			</div>

			<div class="row" style="padding-top: 10px">
				<div class="col-xs-4 left bottom">Credit Card Number</div>

				<div class="col-xs-8 left">
					<div class="row bottom">
						<div class="col-xs-3 left top">
							<input type="number" required="" ng-model="credit1"
								pattern="[0-9]{4}" maxlength="4" class="form-control" />
						</div>

						<div class="col-xs-3 left top">
							<input type="number" required="" ng-model="credit2"
								class="form-control" pattern="[0-9]{4}" />
						</div>

						<div class="col-xs-3 left top">
							<input type="number" required="" ng-model="credit3"
								class="form-control" pattern="[0-9]{4}" />
						</div>

						<div class="col-xs-3 left top">
							<input type="number" required="" ng-model="credit4"
								class="form-control" pattern="[0-9]{4}" />
						</div>
					</div>
				</div>
			</div>
			<div class="row top bottom">
				<div class="col-xs-4 left">CVV number :</div>

				<div class="col-xs-2 left top bottom">
					<input type="number" pattern="[0-9]{3}" class="form-control"
						ng-model="cvvNumber" />
				</div>
				<div class="col-xs-6 left"></div>


			</div>

			<div class="row top bottom">
				<div class="col-xs-4 left">Card expiry date :</div>

				<div class="col-xs-2">
					<select name="singleSelect" class="form-control" required=""
						id="cardExpMonth" ng-model="cardExpMonth">
						<option value="1">1</option>

						<option value="2">2</option>

						<option value="3">3</option>

						<option value="4">4</option>

						<option value="5">5</option>

						<option value="6">6</option>

						<option value="7">7</option>

						<option value="8">8</option>

						<option value="9">9</option>

						<option value="10">10</option>

						<option value="11">11</option>

						<option value="12">12</option>
					</select>
				</div>

				<div class="col-xs-2">
					<select name="singleSelect" class="form-control" required=""
						id="cardExpYear" ng-model="cardExpYear">
						<option value="2015">2015</option>

						<option value="2016">2016</option>

						<option value="2017">2017</option>

						<option value="2018">2018</option>

						<option value="2019">2019</option>

						<option value="2020">2020</option>
					</select>
				</div>
				<div class="col-xs-4"></div>
			</div>
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-4 left bottom">Balance amount used:</div>

				<div class="col-xs-8 left top">100$</div>
			</div>

			<div class="row top" style="padding-top: 10px">
				<div class="col-xs-12" style="text-align: right">
					<input type="submit" name="Pay!" class="btn btn-info"
						ng-submit="submit()" />
				</div>
			</div>
		</form>
	</div>


</div>


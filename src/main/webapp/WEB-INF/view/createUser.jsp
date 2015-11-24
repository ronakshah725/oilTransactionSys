<%@ include file="include.jsp"%>

<div class="panel panel-info center"
	style="width: 500px; text-align: center; margin-top: 50px">

	<div class="panel-heading">
		<h3>Create/Update User</h3>
	</div>

	<div class="panel-body">
		<form name="createUserForm">
			<div class="row" style="padding-top: 10px">

				<div class="col-xs-3 left bottom">User Type:</div>
				<div class="col-xs-5 left bottom">
					<select name="singleSelect" class="form-control" required
						id="singleSelect" ng-model="commissionType">
						<option value="admin">Administrator</option>
						<!-- interpolation -->
						<option value="trader">Trader</option>
						<option value="customer">customer</option>
					</select>
				</div>
				<div class="col-xs-4 left bottom"></div>

			</div>

			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">First Name</div>
				<div class="col-xs-3 left">
					<input type="text" class="form-control" required
						ng-model="firstname" />
				</div>

				<div class="col-xs-3 left bottom">Last Name</div>
				<div class="col-xs-3 left">
					<input type="text" class="form-control" required
						ng-model="lastname" />
				</div>
			</div>
			<hr />

			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">Apartment Number</div>
				<div class="col-xs-6 left">
					<input type="text" class="form-control" required
						ng-model="apartmentnumber" />
				</div>
				<div class="col-xs-3 left bottom"></div>

			</div>

			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">Street</div>
				<div class="col-xs-6 left">
					<input type="text" class="form-control" required ng-model="street" />
				</div>
				<div class="col-xs-3 left bottom"></div>

			</div>



			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">City</div>
				<div class="col-xs-3 left">
					<input type="text" class="form-control" required ng-model="city" />
				</div>

				<div class="row" style="padding-top: 10px">
					<div class="col-xs-3 left bottom">State</div>
					<div class="col-xs-3 left">
						<input type="text" class="form-control" required ng-model="state" />
					</div>

					<div class="col-xs-3 left bottom">zipcode</div>
					<div class="col-xs-3 left">
						<input type="number" class="form-control" required
							ng-model="zipcode" />
					</div>
				</div>

				<hr />


				<div class="row" style="padding-top: 10px">
					<div class="col-xs-3 left bottom">Phone number</div>
					<div class="col-xs-3 left">
						<input type="number" class="form-control" required
							ng-model="phonenumber" />
					</div>

					<div class="col-xs-3 left bottom">Cell phone number</div>
					<div class="col-xs-3 left">
						<input type="number" class="form-control" required
							ng-model="cellphone" />
					</div>
				</div>

				<div class="row" style="padding-top: 10px">
					<div class="col-xs-3 left bottom">Email Id</div>
					<div class="col-xs-9 left">
						<input type="email" class="form-control" required
							ng-model="password" />
					</div>
				</div>
				<hr />

				<div class="row" style="padding-top: 10px">
					<div class="col-xs-3 left bottom">Password</div>
					<div class="col-xs-3 left">
						<input type="password" class="form-control" required
							ng-model="password1" value="Test123" />
					</div>
					<div class="col-xs-3 left bottom">Repeat Password</div>
					<div class="col-xs-3 left">
						<input type="password" class="form-control" required
							ng-model="password2" value="Test123" />
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



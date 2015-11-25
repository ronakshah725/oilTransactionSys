<%@ include file="include.jsp"%>

<div class="panel panel-info center"
	style="width: 500px; text-align: center; margin-top: 50px">

	<div class="panel-heading">
		<h3>Create/Update User</h3>
	</div>

	<div class="panel-body">
		<div style="text-color:#ff0000">${message}</div>
		<form name="createUserForm" id="createUserForm">
			<div class="row" style="padding-top: 10px">

				<div class="col-xs-3 left bottom">User Type:</div>
				<div class="col-xs-5 left bottom">
					<select  class="form-control" required	name="userType" 	id="userType" >
						<option value="ADMIN">Administrator</option>
						<option value="TRADER">Trader</option>
						<option value="CLIENT">customer</option>
					</select>
				</div>
				<div class="col-xs-4 left bottom"></div>

			</div>

			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">First Name</div>
				<div class="col-xs-3 left">
					<input type="text" class="form-control" required
					name="firstName"	id="firstName" value="${userToBeEdited.firstName}" />
				</div>

				<div class="col-xs-3 left bottom">Last Name</div>
				<div class="col-xs-3 left">
					<input type="text" class="form-control" required
					value="${userToBeEdited.lastName}" name="lastName" 	id="lastName" />
				</div>
			</div>
			<hr />

			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">Apartment Number</div>
				<div class="col-xs-6 left">
					<input type="text" class="form-control" required
				value="${userToBeEdited.apartmentNumber}"	name="apartmentNumber"	id="apartmentNumber" />
				</div>
				<div class="col-xs-3 left bottom"></div>

			</div>

			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">Street</div>
				<div class="col-xs-6 left">
					<input type="text" class="form-control" required value="${userToBeEdited.street}" id="street"  name="street" />
				</div>
				<div class="col-xs-3 left bottom"></div>

			</div>



			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">City</div>
				<div class="col-xs-3 left">
					<input type="text" class="form-control" required name="city" id="city" value="${userToBeEdited.city}" />
				</div>

				<div class="row" style="padding-top: 10px">
					<div class="col-xs-3 left bottom">State</div>
					<div class="col-xs-3 left">
						<input type="text" class="form-control" required id="state"  name="state" value="${userToBeEdited.state}" />
					</div>

					<div class="col-xs-3 left bottom">zipcode</div>
					<div class="col-xs-3 left">
						<input type="number" class="form-control" required
							name="zipcode"  id="zipcode" value="${userToBeEdited.zipcode}" />
					</div>
				</div>

				<hr />


				<div class="row" style="padding-top: 10px">
					<div class="col-xs-3 left bottom">Phone number</div>
					<div class="col-xs-3 left">
						<input type="number" class="form-control" required
					value="${userToBeEdited.phoneNumber}"		name="phoneNumber" 	id="phoneNumber" />
					</div>

					<div class="col-xs-3 left bottom">Cell phone number</div>
					<div class="col-xs-3 left">
						<input type="number" class="form-control" required
					value="${userToBeEdited.cellPhoneNumber}"	name="cellPhoneNumber"	id="cellPhoneNumber" />
					</div>
				</div>

				<div class="row" style="padding-top: 10px">
					<div class="col-xs-3 left bottom">Email Id</div>
					<div class="col-xs-9 left">
						<input type="email" class="form-control" required id="emailId"  name="emailId"  value="${userToBeEdited.emailId}"
							  />
					</div>
				</div>
				<hr />

				<div class="row" style="padding-top: 10px">
					<div class="col-xs-3 left bottom">Password</div>
					<div class="col-xs-3 left">
						<input type="password" class="form-control" required
							 name="password1" id="password1" value=""  />
					</div>
					<div class="col-xs-3 left bottom">Repeat Password</div>
					<div class="col-xs-3 left">
						<input type="password" class="form-control" required
						name="password2" 	id="password2"  value="" />
					</div>
				</div>
				<div class="row top" style="padding-top: 10px">
					<div class="col-xs-12" style="text-align: right">
						<input type="submit" class="btn btn-info" onclick="insertOrUpdateUser()" />
					</div>
				</div>
		</form>
	</div>

</div>



<%@ include file="include.jsp"%>
<div class="panel panel-info center"
	style="width: 900px; text-align: center; margin-top: 50px">
	<div class="panel-heading">
		<h3>Search User</h3> (Please note that it performs OR search on all fields)
	</div>
	<div class="panel-body">
		<form name="searchUserForm" id="searchUserForm">
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-2 left bottom">Last name</div>
				<div class="col-xs-2 left">
					<input type="text" class="form-control"   
						name="lastName" id="lastName" />
				</div>
				
				<div class="col-xs-1 left bottom">Apt No:</div>
				<div class="col-xs-2 left">
					<input type="text" class="form-control"    id="apartmentNumber"
						name="apartmentNumber" />
				</div>
				
				<div class="col-xs-1 left bottom">Street:</div>
				<div class="col-xs-2 left">
					<input type="text" class="form-control"   id="street"
						name="street" />
				</div>

				<div class="col-xs-1 left bottom">City</div>
				<div class="col-xs-2 left">
					<input type="text" class="form-control"    name="city"
						id="city" />
				</div>
				<div class="col-xs-1 left bottom">zip</div>
				<div class="col-xs-1 left">
					<input type="number" class="form-control"     name="zipcode"
						id="zipcode" />
				</div>
			</div>
			<hr />
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">Phone number</div>
				<div class="col-xs-3 left">
					<input type="number" class="form-control"  
						name="phoneNumber" id="phoneNumber"   />
				</div>
				<div class="col-xs-3 left bottom">Cell phone number</div>
				<div class="col-xs-3 left">
					<input type="number" class="form-control"   name="cellPhoneNumber" id="cellPhoneNumber" />
				</div>
			</div>
			<hr />
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">Email Id</div>
				<div class="col-xs-4 left">
					<input type="email" class="form-control" name="emailId" id="emailId" />
				</div>
				<div class="col-xs-5 left bottom"></div>
			</div>
			<div class="row top" style="padding-top: 10px">
				<div class="col-xs-12" style="text-align: center">
					<input type="button"  id= "searchUserBtn" value="Search"  name= "searchUserBtn" onclick="executeSearch()" class="btn btn-info" />

				</div>
			</div>
		</form>
	</div>
	<hr />
	<div class="panel panel-info center" id="searchResults" >
		
	</div>
</div>

<%@ include file="include.jsp"%>
<div class="panel panel-info center"
	style="width: 900px; text-align: center; margin-top: 50px">
	<div class="panel-heading">
		<h3>Select User : ${userName}</h3>
	</div>
	<div class="panel-body">
		<form name="searchUserForm" id="searchUserForm">
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-2 left bottom">Last name</div>
				<div class="col-xs-2 left">
					<input type="text" class="form-control" value="1" required id="name"
						name="name" />
				</div>
				
				<div class="col-xs-1 left bottom">Apt No:</div>
				<div class="col-xs-2 left">
					<input type="text" class="form-control" value="1" required id="aptNo"
						name="aptNo" />
				</div>
				
				<div class="col-xs-1 left bottom">Street:</div>
				<div class="col-xs-2 left">
					<input type="text" class="form-control" value="1" required id="street"
						name="street" />
				</div>

				<div class="col-xs-1 left bottom">City</div>
				<div class="col-xs-2 left">
					<input type="text" class="form-control" value="1" required name="city"
						id="city" />
				</div>
				<div class="col-xs-1 left bottom">zip</div>
				<div class="col-xs-1 left">
					<input type="number" class="form-control" value="1" required name="zipCode"
						id="zipCode" />
				</div>
			</div>
			<hr />
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">Phone number</div>
				<div class="col-xs-3 left">
					<input type="number" class="form-control" required
						name="phonenumber" id="phonenumber" value="1" />
				</div>
				<div class="col-xs-3 left bottom">Cell phone number</div>
				<div class="col-xs-3 left">
					<input type="number" class="form-control"  value="1" required name="cellphone" id="cellphone" />
				</div>
			</div>
			<hr />
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">Email Id</div>
				<div class="col-xs-4 left">
					<input type="email" class="form-control" value="a@b.com" required name="email" id="email" />
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

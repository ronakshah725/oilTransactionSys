<%@ include file="include.jsp"%>
<div class="panel panel-info center"
	style="width: 900px; text-align: center; margin-top: 50px">
	<div class="panel-heading">
		<h3>Select User : ${a}</h3>
	</div>
	<div class="panel-body">
		<form name="searchUserForm">
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-2 left bottom">Last name</div>
				<div class="col-xs-2 left">
					<input type="text" class="form-control" required id="name"
						name="name" />
				</div>
				<div class="col-xs-1 left bottom">Address line 1</div>
				<div class="col-xs-2 left">
					<input type="text" class="form-control" required id="addressLine1"
						name="addressLine1" />
				</div>

				<div class="col-xs-1 left bottom">City</div>
				<div class="col-xs-2 left">
					<input type="text" class="form-control" required name="city"
						id="city" />
				</div>
				<div class="col-xs-1 left bottom">zip</div>
				<div class="col-xs-1 left">
					<input type="number" class="form-control" required name="zipcode"
						id="zipcode" />
				</div>
			</div>
			<hr />
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">Phone number</div>
				<div class="col-xs-3 left">
					<input type="number" class="form-control" required
						name="phonenumber" id="phonenumber" />
				</div>
				<div class="col-xs-3 left bottom">Cell phone number</div>
				<div class="col-xs-3 left">
					<input type="number" class="form-control" required name="cellphone" id="cellphone" />
				</div>
			</div>
			<hr />
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-3 left bottom">Email Id</div>
				<div class="col-xs-4 left">
					<input type="email" class="form-control" required name="email" id="email" />
				</div>
				<div class="col-xs-5 left bottom"></div>
			</div>
			<div class="row top" style="padding-top: 10px">
				<div class="col-xs-12" style="text-align: center">
					<input type="submit" class="btn btn-info " value="Search"
						ng-submit="submit()" />
				</div>
			</div>
		</form>
	</div>
	<hr />
	<div class="panel panel-info center">
		<div class="panel-heading">
			<h4>Search Results</h4>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>Address</th>
						<th>Email Id</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>John Smith</td>
						<td>121, crest avenue, Dallas, Texas 75251</td>
						<td>John@gmail.com</td>
						<td><input type="submit" class="btn btn-warning"
							value="Select"></td>
					</tr>
					<tr>
						<td>2</td>
						<td>John Smith</td>
						<td>122, crest avenue, Dallas, Texas 75251</td>
						<td>John2@gmail.com</td>
						<td><input type="submit" class="btn btn-warning"
							value="Select"></td>
					</tr>
					<tr>
						<td>3</td>
						<td>John Smith</td>
						<td>123, crest avenue, Dallas, Texas 75251</td>
						<td>John3@gmail.com</td>
						<td><input type="submit" class="btn btn-warning"
							value="Select"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

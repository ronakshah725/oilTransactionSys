<%@ include file="include.jsp"%>
<div class="panel-heading">
			<h4>Search Results : ${search}</h4>
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
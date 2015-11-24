<%@ include file="include.jsp"%>
<c:if test="${users !=null}">
	<div class="panel-heading">
		<h4>Search Results </h4>
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
				<c:forEach items="${users}" varStatus="loop" var="user">
					<tr>
						<td>${loop.index+1 }</td>
						<td>${user.firstName} ${user.lastName}</td>
						<td>${user.apartmentNumber},${user.street},${user.city},
							${user.state} ${user.zipcode}</td>
						<td>${user.emailId}</td>
						<td><input type="button" class="btn btn-warning"
							onclick="executeSelectUser('${user.emailId}')" value="Select"></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

</c:if>
<c:if test="${users==null}">No Search Results were found. Please change Search parameters and try again.</c:if>
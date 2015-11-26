<%@ include file="include.jsp"%>

<div class="panel panel-info center">

	<div class="panel-heading" style="text-align: center">

		<div>
			<h3>Transaction Summary</h3>
		</div>
		<c:if test="${message!=null}">
			<div>${message}</div>
		</c:if>
	</div>

	<div class="panel-body">
		<div class="row" style="padidng-bottom: 10px; padding-top: 10px">
			<form name="createOrderForm" id="createOrderForm">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Check</th>
							<th>#</th>
							<th>Date</th>
							<th>Type</th>
							<th>Quantity</th>
							<th>Status</th>
							<th>Amount($)</th>
							<th>Commission($/lb)</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${orders}" varStatus="loop" var="order">
							<c:when test="${isCancelled}">
								<tr style="color: #dd0000">
							</c:when>
							<c:otherwise>
								<c:when test="${order.paymentId!=null}">
									<tr style="color: #00B050">
								</c:when>
								<c:otherwise>
									<tr>
								</c:otherwise>
							</c:otherwise>
							<td><input type="Checkbox" id="${order.id}" /></td>
							<td>${loop.index}</td>
							<td>${order.date}</td>
							<td>${order.type}</td>
							<td>${order.quantity}</td>
							<td>${order.amount}</td>
							<td>${order.commissionindollar}${order.commisisioninoil}</td>

							<td><input type="button" class="btn btn-warning"
								onclick="executeSelectUser('${user.emailId}')" value="Select"></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
		</div>
		<div class="row">
			<div class="xs-col-3">Outstanding balance</div>
			<div class="xs-col-3">${outstandingBalance}</div>
			<div class="xs-col-3">Total Oil owned:</div>
			<div class="xs-col-3">${totalOilOwned}</div>
		</div>
		<div class="row" style="padidng-bottom: 10px; padding-top: 10px">
			<div class="col-xs-4" style="text-align: center">

				<input id="loginBtn" name="loginBtn" class="btn btn-info"
					type="button" value="Pay" onclick="makePayment()" />
			</div>
			<div class="col-xs-4" style="text-align: center">
				<input id="order" name="order" class="btn btn-info"
					type="button" value="Place Order" onclick="createOrder()" />
			</div>
			<div class="col-xs-4" style="text-align: center">
				<input id="loginBtn" name="loginBtn" class="btn btn-info"
					type="button" value="Cancel" onclick="cancelOrder()" />
			</div>
		</div>
	</div>
</div>




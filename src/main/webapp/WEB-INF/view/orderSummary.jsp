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
							<th>Amount($)</th>
							<th>Commission($)</th>
							<th>Commission(Lb)</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${orders}" varStatus="loop" var="order">
							<c:choose>
								<c:when test="${order.cancelled}">
									<tr style="color: #dd0000">
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${order.paymentId!=null}">
											<tr style="color: #00B050">
										</c:when>
										<c:otherwise>
											<tr>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
							<td><c:if test="${!order.cancelled}">
									<input type="Checkbox" id="${order.orderId}" />
								</c:if></td>
							<td>${loop.index}</td>
							<td>${order.date}</td>
							<td>${order.type}</td>
							<td>${order.quantity}</td>
							<td>${order.amount}</td>
							<td style="text-align:Center">${order.commissionindollar}</td>
							<td style="text-align:Center">${order.commisisioninoil}</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
		</div>
		<hr/>
		<div class="row">
			<div class="col-xs-2">Account type: </div>
			<div class="col-xs-2"><b style="color:#F4813A;font-size:14pt">${selectedClient.level}</b></div>

			<div class="col-xs-2">Outstanding balance</div>
			<div class="col-xs-2"><b style="color:#1B0EC2;font-size:14pt">${selectedClient.balanceAmount} $</b></div>
			<div class="col-xs-2">Total Oil owned:</div>
			<div class="col-xs-2"><b style="color:#FFCE44;font-size:14pt">${selectedClient.totalOilQuantity} Lb</b></div>
		</div>
		<div class="row" style="padidng-bottom: 10px; padding-top: 10px">
			<div class="col-xs-4" style="text-align: center">

				<input id="loginBtn" name="loginBtn" class="btn btn-info"
					type="button" value="Pay" onclick="makePayment()" />
			</div>
			<div class="col-xs-4" style="text-align: center">
				<input id="order" name="order" class="btn btn-info" type="button"
					value="Place Order" onclick="createOrder()" />
			</div>
			<div class="col-xs-4" style="text-align: center">
				<input id="loginBtn" name="loginBtn" class="btn btn-info"
					type="button" value="Cancel" onclick="cancelOrder()" />
			</div>
		</div>
	</div>
</div>




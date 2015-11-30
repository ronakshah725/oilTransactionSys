<%@ include file="include.jsp"%>

<div class="panel panel-info center">

	<div class="panel-heading" style="text-align: center">

		<div>
			<h3>Transaction Summary</h3>
		</div>
		
	</div>

	<div class="panel-body">
	<c:if test="${message!=null}">
			<div class="row" style="color:#ff0000;text-align:left" ><B> * ${message}</B></div>
		</c:if>
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
							<th>${commission}% Commission($)</th>
							<th>${commission}% Commission(Barrel)</th>
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

			<div class="col-xs-2">Account Credit</div>
			<div class="col-xs-2"><b style="color:#1B0EC2;font-size:14pt">${selectedClient.balanceAmount} $</b></div>
			<div class="col-xs-2">Total Oil owned:</div>
			<div class="col-xs-2"><b style="color:#FFCE44;font-size:14pt">${selectedClient.totalOilQuantity} Barrel</b></div>
		</div>
		<div class="row" style="padidng-bottom: 10px; padding-top: 10px">
			<div class="col-xs-4" style="text-align: center">

	<c:if test="${FEATURE_ACCEPT_PAYMENT!=null}">
				<input id="loginBtn" name="loginBtn" class="btn btn-info"
					type="button" value="Pay" onclick="makePayment()" />
					</c:if>`
			</div>
			<div class="col-xs-4" style="text-align: center">
				<input id="order" name="order" class="btn btn-info" type="button"
					value="Place Order" onclick="createOrder()" />
			</div>
			<div class="col-xs-4" style="text-align: center">
			
	<c:if test="${FEATURE_CANCEL_ORDER!=null}">
				<input id="loginBtn" name="loginBtn" class="btn btn-info"
					type="button" value="Cancel" onclick="cancelOrder()" />
					</c:if>
			</div>
		</div>
	</div>
</div>




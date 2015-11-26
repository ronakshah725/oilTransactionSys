<%@ include file="include.jsp"%>

<div class="panel panel-info center"
	style="width: 700px; text-align: center; margin-top: 50px">
	<div class="panel-heading">
		<h3>Make Payment</h3>
	</div>

	<div class="panel-body">
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-4 left bottom">Balance Amount Used:</div>

				<div class="col-xs-4 left bottom">${balAmount}</div>
				<div class="col-xs-4 left bottom"></div>
			</div>
			<div>
				<form id="paymentForm1"
					action="${pageContext.request.contextPath}/paymentAccepted"
					method="POST">
					<script src="https://checkout.stripe.com/checkout.js"
						class="stripe-button" data-key="pk_test_6pRNASCoBOKtIshFeQd4XMUh"
						data-amount="${amountDue}" data-name="Demo Site"
						data-description="Total Charge" data-image="/128x128.png"
						data-locale="auto">
					</script>
				</form>
			</div>
	</div>


</div>


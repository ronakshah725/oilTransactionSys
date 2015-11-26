<%@ include file="include.jsp"%>
<html>
<head>
<title>Oil Transaction Management System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet" href="resources/css/style.css">
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script>
	function populateTopMenu() {
		$.ajax({
			type : "GET",
			url : "topMenu",
			success : function(data) {
				$("#heading").html(data);
			}
		});
	}

	function login() {
		$.ajax({
			type : "POST",
			url : "login",
			data : $("#loginForm").serialize(),
			success : function(data) {
				$("#container").html(data);
				populateTopMenu();
			}
		});
	}
	function home() {
		$.ajax({
			type : "GET",
			url : "home",
			success : function(data) {
				$("#container").html(data);
				populateTopMenu();
			}
		});
	}
	
	function placeOrder() {
		$.ajax({
			type : "POST",
			url : "placeOrder",
			data: $("#createOrderForm").serialize(),
			success : function(data) {
				$("#container").html(data);
			}
		});
	}
	
	
	
	function executeSearch() {
		$.ajax({
			type : "POST",
			url : "searchUser",
			data : $("#searchUserForm").serialize(),
			success : function(data) {
				$("#searchResults").html(data);
			}
		});
	};
	function executeSelectUser(userId) {
		$.ajax({
			type : "GET",
			url : "selectUser",
			data : "userId=" + userId,
			success : function(data) {
				$("#container").html(data);
			}
		});
	}

	function loadOrders() {
		$.ajax({
			type : "GET",
			url : "loadOrders",
			data : "userId=" + userId,
			success : function(data) {
				$("#container").html(data);
			}
		});
	}

	
	function cancelOrder() {
		var orderIds = "";
		$('input[type="Checkbox"]:checked').each(function() {
			orderIds += this.id + ',';
		});

		$.ajax({
			type : "GET",
			url : "cancelOrder",
			data : "orderIds=" + orderIds,
			success : function(data) {
				$("#container").html(data);
			}
		});
	}

	function createOrder() {
		$.ajax({
			type : "POST",
			url : "createOrder",
			success : function(data) {
				$("#container").html(data);
			}
		});
	}




	
	function makePayment() {
		var orderIds = "";
		$('input[type="Checkbox"]:checked').each(function() {
			orderIds += this.id + ',';
		});
		//Read all checked checkboxes
		$.ajax({
			type : "GET",
			url : "payment",
			data : "orderIds=" + orderIds,
			success : function(data) {
				$("#container").html(data);
			}
		});
	}
	function updateProfile() {
		$.ajax({
			type : "GET",
			url : "editProfile",
			success : function(data) {
				$("#container").html(data);
			}
		});
	}
	function createUser() {
		$.ajax({
			type : "GET",
			url : "createUser",
			success : function(data) {
				$("#container").html(data);
			}
		});
	}
	function insertOrUpdateUser() {
		$.ajax({
			type : "POST",
			url : "insertOrUpdateUser",
			data : $("#createUserForm").serialize(),
			success : function(data) {

				$("#container").html(data);
			}
		});
	}
	function viewReports() {
		//add code here for displaying reports which managers can see.
	}
	$(document).ready(function() {
		home();
	});
</script>
<head>
<body>
	<div class="panel panel-info center"
		style="width: 1000px; text-align: center; margin-top: 50px">
		<div class="panel-heading" style="text-align: center">
			<div>
				<h3>Oil Transaction System</h3>
			</div>

		</div>
		<div class="panel-body">
			<div id="heading" style="text-align: right"></div>
			<div id="container"></div>
		</div>
	</div>
</body>
</html>
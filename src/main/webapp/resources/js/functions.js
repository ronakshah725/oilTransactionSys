
function putOrder() {
	$.ajax({
		type : "POST",
		url : "placeOrder",
		data : $("#placeOrderForm").serialize(),
		success : function(data) {
			$("#container").html(data);
		}
	});
}
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



	function executeSearch() {
		$.ajax({
			type : "POST",
			url : "searchUser",
			data : $("#searchUserForm").serialize(),
			success : function(data) {
				$("#searchResults").html(data);
			}
		});
	}
	
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
			if (orderIds.length === 0) {
				orderIds += this.id;
			} else {
				orderIds += ',' + this.id;
			}
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
			if (orderIds.length === 0) {
				orderIds += this.id;
			} else {
				orderIds += ',' + this.id;
			}

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
		
		$.ajax({
			type : "GET",
			url : "reports",
			success : function(data) {
				alert(data);
				$("#container").html(data);
			}
		});
	}
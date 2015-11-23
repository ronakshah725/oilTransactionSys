<%@ include file="include.jsp" %>
<html>
<head>
<title>Oil Transaction Management System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet" href="resources/css/style.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
$(function() {
$("#submitBtn").click(function(e) {

    $.ajax({
           type: "POST",
           url: "login",
           data: $("#loginForm").serialize(),  
           success: function(data)
           {   alert(data);  
        	   $("#container").html(data);
           }
         });

    e.preventDefault(); // avoid to execute the actual submit of the form.
});
});
</script>
<head>
<body>
	<div class="container" id="container">
		<div class="panel panel-info center"
			style="width: 400px; text-align: center; margin-top: 50px">
			<div class="panel-heading">
				<h3>Login</h3>
			</div>
			<div class="panel-body">
				<form name="loginForm" id="loginForm">
					<div class="row" style="padding-top: 10px">

						<div class="col-xs-6">Username</div>
						<div class="col-xs-6">
							<input type="text" required class="form-control"
								name="userName" id="userName"  />
						</div>
					</div>


					<div class="row" style="padding-top: 10px">
						<div class="col-xs-6">Password</div>
						<div class="col-xs-6">
							<input type="password" class="form-control" required
							id="password" 	name="password" />
						</div>
					</div>

					<div class="row" style="padding: 10px">
						<div class="col-xs-12" style="text-align: right">
							<button  id= "submitBtn" name= "submitBtn" class="btn btn-info" >Login!</button>  
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
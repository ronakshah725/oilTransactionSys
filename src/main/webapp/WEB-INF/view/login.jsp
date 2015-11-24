<%@ include file="include.jsp" %>
<html>
<head>
<title>Oil Transaction Management System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet" href="resources/css/style.css">
<script	src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
$(function() {
$("#loginBtn").click(function(e) {

    $.ajax({
           type: "POST",
           url: "login",
           data: $("#loginForm").serialize(),  
           success: function(data)
           {  
        	   $("#container").html(data);
           }
         });
    e.preventDefault(); // avoid to execute the actual submit of the form.
});
});
</script>

<script>
function executeSearch() {

    $.ajax({
           type: "POST",
           url: "searchUser",
           data: $("#searchUserForm").serialize(),  
           success: function(data)
           {  
           $("#searchResults").html(data);
           }
         });
    
    
};
function executeSelectUser(userId)
{
    $.ajax({
        type: "GET",
        url: "selectUser",
        data: "userId="+userId,  
        success: function(data)
        {  
        $("#container").html(data);
        }
      });
	}
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

						<div class="col-xs-6">Email</div>
						<div class="col-xs-6">
							<input type="text" required class="form-control"
								name="userName" id="userName" value="1"  />
						</div>
					</div>


					<div class="row" style="padding-top: 10px">
						<div class="col-xs-6">Password</div>
						<div class="col-xs-6">
							<input type="password" class="form-control" required
							id="password" 	name="password"  value="1" />
						</div>
					</div>

					<div class="row" style="padding: 10px">
						<div class="col-xs-12" style="text-align: right">
							<button  id= "loginBtn" name= "loginBtn" class="btn btn-info" >Login!</button>  
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
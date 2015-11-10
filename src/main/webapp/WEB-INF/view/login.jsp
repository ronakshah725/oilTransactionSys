<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Oil Transaction Management System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet" href="css/style.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<head>
<body>
	<div class="container">
		<div class="panel panel-info center"
			style="width: 400px; text-align: center; margin-top: 50px">
			<div class="panel-heading">
				<h3>Login</h3>
			</div>
			<div class="panel-body">
				<form name="myForm">
					<div class="row" style="padding-top: 10px">

						<div class="col-xs-6">Username</div>
						<div class="col-xs-6">
							<input type="text" required class="form-control"
								ng-model="userName" />
						</div>
					</div>


					<div class="row" style="padding-top: 10px">
						<div class="col-xs-6">Password</div>
						<div class="col-xs-6">
							<input type="password" class="form-control" required
								ng-model="password" />
						</div>
					</div>

					<div class="row" style="padding: 10px">
						<div class="col-xs-12" style="text-align: right">
							<input type="submit" class="btn btn-info" ng-submit="submit()" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
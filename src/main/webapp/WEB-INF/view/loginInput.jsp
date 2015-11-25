<div class="panel panel-info center"
	style="width: 400px; text-align: center; margin-top: 50px">
	<div class="panel-heading">
		<div>
			<h3>Login</h3>
		</div>
		<div style="color: #ff0000">${message}</div>
	</div>
	<div class="panel-body">
		<form name="loginForm" id="loginForm">
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-6">Email</div>
				<div class="col-xs-6">
					<input type="text" required class="form-control" name="userName"
						id="userName" value="abc@def.com" />
				</div>
			</div>
			<div class="row" style="padding-top: 10px">
				<div class="col-xs-6">Password</div>
				<div class="col-xs-6">
					<input type="password" class="form-control" required id="password"
						name="password" value="123" />
				</div>
			</div>
			<div class="row" style="padding: 10px">
				<div class="col-xs-12" style="text-align: right">
					<input id="loginBtn" name="loginBtn" class="btn btn-info"
						type="button" value="Login!" onclick="login()" />
				</div>
			</div>
		</form>
	</div>
</div>
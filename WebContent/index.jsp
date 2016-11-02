<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Main page</title>
</head>
<body>

	<div>
		<form action="Controller" method="post" name="sign-in">
			<div>
				<input type="hidden" name="command" value="sign-in" />
			</div>

			<div>
				<label for="login">Login:</label>
			</div>
			<div>
				<input type="text" name="login" id="login" />
			</div>

			<div>
				<label for="password">Password:</label>
			</div>
			<div>
				<input type="password" name="password" id="password" />
			</div>

			<div>
				<input type="submit" value="SignIn">
			</div>
		</form>
	</div>
	<div>
		<form action="Controller" method="post" name="registration">
			<div>
				<input type="hidden" name="command" value="go-to-registration" />
			</div>

			<div>
				<input type="submit" value="Register">
			</div>
		</form>
	</div>
</body>
</html>
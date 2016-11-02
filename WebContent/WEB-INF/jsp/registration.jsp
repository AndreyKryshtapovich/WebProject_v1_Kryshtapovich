<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>user registration page</title>
</head>
<body>
	<div>
		<form action="Controller" method="post" name="registration">
			<div>
				<input type="hidden" name="command" value="registration-user" />
			</div>
			<div>
				<label for="firstName">First name:</label>
			</div>
			<div>
				<input type="text" name="firstName" id="firstName" />
			</div>

			<div>
				<label for="lastName">Last name:</label>
			</div>
			<div>
				<input type="text" name="lastName" id="lastName" />
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
				<label for="rep-password">Repeat password:</label>
			</div>
			<div>
				<input type="password" name="rep-password" id="rep-password" />
			</div>
			
			
			<div>
				<label for="sex">Sex:</label>
				</div>
				<div>
				 <select name="sex">
						<option value="M" selected>M</option>
						<option value="F">F</option>
						<option value="Unknown">Unknown</option>
				</select>
				</div>

				<div>
				<label for="e-mail">E-mail:</label>
			</div>
			<div>
				<input type="text" name="e-mail" id="e-mail" />
			</div>

				<div>
				<label for="country">Country:</label>
			</div>
			<div>
				<input type="text" name="country" id="country" />
			</div>

				<div>
				<label for="city">City:</label>
			</div>
			<div>
				<input type="text" name="city" id="city" />
			</div>

			<div>
				<label for="address">Address:</label>
			</div>
			<div>
				<input type="text" name="address" id="address" />
			</div>

			<div>
				<input type="submit" value="Register">
			</div>
		</form>
	</div>
</body>
</html>
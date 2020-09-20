<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en_us">

<head>
<meta charset="ISO-8859-1">
<title>Cambada Forum</title>
<link rel="shortcut icon" href="images/icon.png" type="image/png">

</head>

<body>

	<fieldset>

		<fieldset>

			<header>

				<strong> Welcome to our forum!</strong>
				<p>Please fill all fields to register
				<p>
			</header>

		</fieldset>

		<fieldset>

			<main>

				<p id="registerErrors">${registerError}</p>

				<form method="post" action="RegisterUser" id="register">

					<label for=name>Complete Name</label> <input name="name" id="name"
						required> <br> <label for=email>Email</label> <input
						name="email" id="email" required> <small
						style="color: red">${status}</small> <br /> <label for="login">Login</label>
					<input name="login" id="login" required> <br> <label
						for="password">Password</label> <input name="password"
						id="password" type="password" required>

				</form>

				<br>

				<form method="get" action="login" id="loginscreen"></form>

				<button type="submit" form="register" id="register_user">Register</button>
				<button type="submit" form="loginscreen" id="loginscreen">Go
					back to login screen</button>

			</main>

		</fieldset>

	</fieldset>

</body>
</html>
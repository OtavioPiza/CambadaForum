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

		<fieldset id="header">

			<header>

				<strong> Welcome to our forum!</strong>
				<p>Please login to access the forum and its contents
				<p>
				<form action="about" method="get">
					<button type="submit">About the project</button>
				</form>

			</header>

		</fieldset>

		<fieldset id="body">

			<main>

				<p id="status_message">${status}</p>

				<form method="post" action="do_login" id="do_login">

					<label for="login">Login</label>
					<input name="login" id="login" type="text" required> 
					<br> 
					<label for="password">Password</label>
					<input name="password" id="password" type="password" required>

				</form>

				<form method="get" action="register" id="register"></form>

				<br>

				<button type="submit" form="do_login" id="do_login">Log in</button>
				<button type="submit" form="register" id="register">
					Register a new user</button>

			</main>

		</fieldset>

	</fieldset>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
				<form action="login" method="get">
					<button type="submit">Go back to login screen</button>
				</form>

			</header>

		</fieldset>

		<fieldset id="body">

			<p>
				<strong> Hello!</strong> This forum was originally create as the
				final project for the ITA Fast Development with Advanced Java
				course. Since then, I have expanded the project to include a variety
				of functions to make the forum more useful and user friendly.
				Currently I am working on adding a direct message feature
			<p>
		</fieldset>

	</fieldset>

</body>
</html>
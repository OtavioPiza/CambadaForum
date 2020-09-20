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

	<c:if test="${loged}">

		<fieldset>

			<fieldset>

				<header>

					<strong> Welcome back ${name}!</strong>
					<p>
						You have ${points} points! <br> You gain more points by
						creating new topics and writing comments!
					</p>

					<form method="get" action="logout" id="logout"></form>

					<form method="get" action="new_topic.jsp" id="new_topic"></form>

					<form method="get" action="main" id="main"></form>

					<form method="get" action="topics" id="topics"></form>

					<form method="get" action="ranking" id="ranking"></form>

					<button type="submit" form="logout">Logout</button>
					<button type="submit" form="new_topic">Create new topic</button>
					<button type="submit" form="main">Go to your main page</button>
					<button type="submit" form="topics">See all topics</button>
					<button type="submit" form="ranking">See users ranking</button>

				</header>

			</fieldset>

			<c:if test="${owner}">

				<fieldset>

					<strong>${topic[0]}</strong>

					<p>Please do the necessary edits to the topic's content and
						then commit to the changes!</p>

					<form action="edit_topic" method="post" id="edit_topic">
						<textarea name="content" id="content" required>${topic[1]}</textarea>
					</form>

					<p>by: ${topic[2]}</p>

					<form action="main" method="get" id="cancel"></form>

					<button type="submit" form="edit_topic">Commit to changes</button>
					<button type="submit" form="cancel">Cancel</button>

				</fieldset>

			</c:if>

			<c:if test="${!owner}">

				<fieldset>
					<strong>You are not the owner of this topic!</strong>
					<form action="main" method="get" id="cancel"></form>

					<button type="submit" form="cancel">Go back to your main
						screen to edit your topics</button>

				</fieldset>

			</c:if>

		</fieldset>

	</c:if>

	<c:if test="${!loged}">

		<fieldset>

			<strong> Please login to access forum content!</strong>

			<form method="get" action="login">
				<input type="submit" value="Go back to login screen" />
			</form>

		</fieldset>

	</c:if>

</body>
</html>
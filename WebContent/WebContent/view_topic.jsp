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

			<fieldset>

				<fieldset>

					<strong> ${topic[0]}</strong>
					<p>${topic[1]}</p>
					<p>by: ${topic[2]}</p>

					<c:if test="${owner}">
						<form method="get" action="edit" id="edit_topic"></form>
						<button value="${topic[3]}" name="topic_id" form="edit_topic">
							Edit topic</button>
					</c:if>

				</fieldset>

				<fieldset>

					<strong> Comments: </strong> <strong> <% if(request.getParameter("status") != null) {
					out.println(request.getParameter("status"));
				} %>

					</strong> <strong> ${commentsError}</strong>

					<c:forEach var="comment" items="${comments}" begin="0">

						<fieldset>

							<p>${comment[0]}</p>
							<p>by: ${comment[1]}</p>

						</fieldset>

					</c:forEach>

					<form method="post" action="write_comment">

						<textarea name="comment_content" id="comment_content" required></textarea>
						<br>
						<button value="${topic[3]}" name="topic_id">Post comment</button>

					</form>

				</fieldset>

			</fieldset>

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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--not using spring form, this is a normal form because no dto (no object) if dto will be there then we would have used spring forms  -->
	<form method="post" action="register.do">
		<table>
			<tr>
				<th>Event Name</th>
				<th>Location</th>
				<th>Event Date</th>
				<th>Select</th>
			</tr>
			<c:forEach items="${events}" var="event">
				<tr>
					<td>${event.eventName}</td>
					<td>${event.location}</td>
					<td>${event.eventDate}</td>
					<td><input type="radio" name="evt" value="${event.id}" /></td>
				</tr>
			</c:forEach>
		</table>
		Customer Email : <input type="text" name="email" /> <br />
		<button type="submit">Register</button>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Event Form</h2>
	<form:form action="addEvent.do" commandName="event">
		Event Name<form:input path="eventName" /> <form:errors path="eventName" /> <br/>
		Event Date <form:input path="eventDate" /> <form:errors path="eventDate" /> <br/>
		Event Location <form:input path="location" /> <form:errors path="location" /> <br/>
		<button type="submit"> Add Event</button>
	</form:form>
</body>
</html>
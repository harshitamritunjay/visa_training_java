<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add to Cart</h2>
	<div>
		Welcome ${sessionScope.user}
	</div>
	<form method="post" action="addToCart.do">
	<table>
		<tr>
			<th>Name</th><th>Price</th><th>Select</th>
		</tr>
			<c:forEach items="${products}" var="prd">
			<tr>
				<td>${prd.name}</td><td>${prd.price}</td>
				<td><input type="checkbox" name="prd"/></td>
			</tr>
			
			</c:forEach>
		
	</table>
	<button type="submit"> Add to Cart</button>
	</from>
</body>
</html>
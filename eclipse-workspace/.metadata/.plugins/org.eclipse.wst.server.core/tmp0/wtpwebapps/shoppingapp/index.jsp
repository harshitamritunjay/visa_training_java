<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Shopping Application</h3>
	<div>
		Welcome ${sessionScope.user}
	</div>
	<div>
		${param.msg}
	</div>
	<a href="login.jsp">Login Page</a> <br/>
	<a href="productForm.html">Add Product</a> <br/>
	<a href="listProducts.do">List Products</a>
</body>
</html>
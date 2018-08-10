<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Sample Page</h1>
	<p>Java Server Pages can be used to mix static and dynamic content.<br/>
	JSP will be converted into Servlet by JSP compiler<br/>
	Servlet will then be compiled by javac<br/>
	Compiled Servlet is deployed on servlet engine <br/>
	</p>
	<!-- Scriplets: Small java code statements -->
	<%
		for(int i = 2305;i<=3000;i++){
	%>
		<!-- out.print(i); this is only argument to print function -->
		<%=i %> <br/>
		<!-- for unicode values -->
		&#<%=i %>;<br/>
	<%
		}
	%>
</body>
</html>
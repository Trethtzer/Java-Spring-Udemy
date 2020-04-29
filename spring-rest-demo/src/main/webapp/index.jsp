<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Spring REST DEmo</h2>
	
	<hr>
	
	<a href="${pageContext.request.contextPath}/api/hello">Hello</a>
	<br>
	<a href="${pageContext.request.contextPath}/api/students">Student list</a>
</body>
</html>
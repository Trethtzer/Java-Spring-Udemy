<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Leaders page!</title>
	</head>
	<body>
		<h2> Systems home page</h2>
		
		<hr>
		
		<p>
			We have our annual holiday in the basement like always. Don't forget to bring something to eat!
		</p>
	
		<hr>
		
		<a href="${pageContext.request.contextPath}/">Back to home page</a>
	
	</body>
</html>
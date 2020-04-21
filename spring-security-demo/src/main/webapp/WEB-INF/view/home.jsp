<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Hey welcome to siles bonillas company</title>
	</head>
	<body>
	LOL
	
	<p>
		Welcome to the city boys!!!
	</p>
	
	<hr>	
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role: <security:authentication property="principal.authorities" />
	</p>
	<hr>
	
	<security:authorize access="hasRole('MANAGER')">
		<!--  Add a link to point to /leaders .. this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
			(Only for manager peeps)
		</p>
		
		<hr>
	</security:authorize>
	
	
	<security:authorize access="hasRole('ADMIN')">
		<!--  Add a link to point to /system .. this is for the admins -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(Only for Admin peeps)
		</p>
		
		<hr>
	</security:authorize>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">		
		<input type="submit" value="Logout" />
	</form:form>
	
	</body>
</html>
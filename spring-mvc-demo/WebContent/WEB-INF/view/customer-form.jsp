<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

	<head>
		<title>Guille's Shop</title>
		<style>
			.error {color:red}
		</style>
	</head>

	<body>
	
	<form:form action ="processForm" modelAttribute="customer">
	
		First name: 
		<form:input path="firstName"/>
		<form:errors path="firstName" cssClass="error" />
		<br><br>
		Second name: 
		<form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error" />
		<br><br>
		
		
		
		<input type="submit" value="Submit">
	
	</form:form>
	
	</body>

</html>
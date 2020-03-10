<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

	<head>
		<title>Student Confirmation Form</title>
	</head>

	<body>
	
	<form:form action ="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName"/>
		<br><br>
		Second name: <form:input path="lastName"/>
		<br><br>
		Country: <form:select path="country">
			<form:options items="${student.countryOptions}"/>
		</form:select>
		<br><br>
		Favourite Language:
		<br>
		Java <form:radiobutton path="favouriteLanguage" value="Java"/>
		<br>
		C# <form:radiobutton path="favouriteLanguage" value="C#"/>
		<br>
		PHP <form:radiobutton path="favouriteLanguage" value="PHP"/>
		<br>
		SQL Server <form:radiobutton path="favouriteLanguage" value="SQL Server"/>
		
		<br><br>
		
		Operating Systems:<br>
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		Mac <form:checkbox path="operatingSystems" value="Mac"/>

		
		<input type="submit" value="Submit">
	
	</form:form>
	
	</body>

</html>
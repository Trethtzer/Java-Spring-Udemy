<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

	<head>
		<title>Customer Confirmation Form</title>
	</head>

	<body>
	Customer confirmed.
	<br><br>
	Name: ${customer.firstName} ${customer.lastName}
	<br><br>
	Free passes: ${customer.freePass}
	<br><br>
	Postal Code: ${customer.postalCode}
	<br><br>
	Course Code: ${customer.courseCode}
	</body>


</html>
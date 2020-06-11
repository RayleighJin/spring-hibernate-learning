<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
	<title>Customer Registration Confirmation</title>
</head>
<body>

Here is the customer name: ${customr.firstName} ${customer.lastName}

<br><br>

The free passes: ${customer.freePasses }

<br><br>

Postal Code: ${customer.postalCode }

<br><br>

Course Code: ${customer.courseCode }

<br><br>
</body>
</html>
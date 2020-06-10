<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
	<title>Student Registration Confirmation</title>
</head>
<body>

Here is the student name: ${student.firstName} ${student.lastName}

<br><br>

Country: ${student.country }

<br><br>
Fav Language: ${student.favoriteLanguage }
<br><br>
OS:
<ul>
	<c:forEach var="oss" items="${student.OS }">
	<li> ${oss} </li>
	</c:forEach>
</ul>
</body>
</html>
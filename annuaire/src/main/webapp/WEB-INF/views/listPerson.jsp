<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>List Person</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;    
}
</style>
</head>

<body>

	<div class="container">
		<table style ="width:100%">
			<thead>
				<tr>
					<th>id</th>
					<th>Username</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Mail</th>
					<th>Site Web</th>
					<th>Birthday</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listPerson" items="${listPerson}">
					<tr>
						<td>${listPerson.getId() }</td>
						<td>${listPerson.getUsername() }</td>
						<td>${listPerson.getFirstName() }</td>
						<td>${listPerson.getLastName() }</td>
						<td>${listPerson.getMail() }</td>
						<td>${listPerson.getSite() }</td>
						<td>${listPerson.getBirthday() }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

<a class="btn btn-lg btn-primary btn-block" href="${contextPath}/login" role="button">Login</a>
</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
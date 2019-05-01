<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

<title>Log in with your account</title>

    <link rel="stylesheet" type="text/css" href="${contextPath}/css/common.css" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/material.css" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/datetimepicker.css" />
 	<link rel="stylesheet" type="text/css" href="${contextPath}/css/ripples.min.css" />
 	<link rel="stylesheet" type="text/css" href="${contextPath}/DataTables/datatables.min.css"/>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">
<c:if test="${not empty groups}">
	<table class="table table-striped table-hover table-responsive">
		<thead>
			<tr>
				<th>#</th>
				<th>Nom</th>
				<th>Personnes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="group" items="${groups}">
				<tr>
					<td>${group.getId()}</td>
					<td>${group.getName()}</td>
					<td>
						${fn:length(group.getPersons())} 
						<a href="${pageContext.request.contextPath}/person/list/${group.getId()}"><i class="material-icons">forward</i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
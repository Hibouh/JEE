<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="person" scope="session" class="myapp.Person" >
    <p>Nouvelle personne !</p>   
</jsp:useBean>

<table>
	<tr>
		<td>Name: <%= person.getName()  %></td>
	</tr>
	<tr>
		<td>Id: <%= person.getId()  %></td>
	</tr>
	<tr>
		<td>FirstName: <%= person.getFirstName()  %></td>
	</tr>
</table>
</body>
</html>
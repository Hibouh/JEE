<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="person" class = "myapp.Person" scope = "session"/>
	<form action="Edition" method="POST">
		<label>Id : </label>
       	<input type="number" name="id" size="15" value="<%=person.getId()%>"/><br/>
      	<label>FirstName : </label>
       	<input type="text" name="firstName" size="15" value="<%=person.getFirstName()%>"/><br/>
      	<label>Name : </label>
       	<input type="text" name="name" size="15" value="<%=person.getName()%>"/><br/>
       	<label>Birthday : </label>
       	<input type="date" name="birthday" size="15" value="<%=person.getBirthday()%>"/><br/>
       	<label>Mail : </label>
       	<input type="text" name="mail" size="15" value="<%=person.getFirstName()%>"/><br/>
      	<input type="submit" name="boutonOK" value="Valider"/> 	
    </form>
    
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
		<tr>
		<td>Birthday: <%= person.getBirthday()  %></td>
	</tr>
		<tr>
		<td>Mail: <%= person.getMail()  %></td>
	</tr>
</table>
    
</body>
</html>
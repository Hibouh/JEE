<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="product" scope="session" class="myapp.Product" >
    <p>Nouveau produit !</p>
</jsp:useBean>

<p>Nom:  <%= product.getName()  %></p>
<p>Prix: <%= product.getPrice() %></p>
<p>Desc: <%= product.getDesc()  %></p>

</body>
</html>
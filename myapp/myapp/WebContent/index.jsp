<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.Date"%>

<%!
Date now = new Date();
%>

<p>Aujourd'hui : <%= now %></p>

<%@page import="java.util.Date"%>

<p>Aujourd'hui : <%= new Date() %></p>
</body>
</html>
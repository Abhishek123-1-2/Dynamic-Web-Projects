<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int lid = (int) session.getAttribute("lid");
String make = (String) session.getAttribute("make");
int cost = (int) session.getAttribute("cost");
out.println("Entry<br>");
out.println("Laptop Id"+lid+"Laptop Make"+make+"Laptop Cost"+cost);
out.println("Inserted Data Successfully<br>");


%>
</body>
</html>
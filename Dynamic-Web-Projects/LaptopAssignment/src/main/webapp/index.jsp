<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="lap">
	<label>Enter Laptop Id</label>
	<input type="number" name="lid">
	<br>
	<label>Enter Laptop Make</label>
	<input type="text" name="make">
	<br>
	<label>Enter Laptop Cost</label>
	<input type="text" name="cost">
	<br>
	<input type="submit" value="add" onclick="form.action='add';">
	<input type="submit" value="show" onclick="form.action='show';">
	
</form>
</body>
</html>
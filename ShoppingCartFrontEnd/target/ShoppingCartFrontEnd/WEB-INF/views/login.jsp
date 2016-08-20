<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login Page</title>
</head>
<body>

	
	<br>
	<c:url var="action" value="/login"></c:url>
	<form:form action="${action}" method="post">

	<h1 align="center" style="color: black;">Login Here</h1>
	Please login with your credentials<br>
	<Form action="LoginController" method="post">
		<br> <strong>Username:</strong><input type="text" name="name"><br>
		<br> <strong>Password:</strong><input type="password"name="password"><br> <br>
		 <input type="submit" value="login">&nbsp; 
		 <input type="submit" value="reset">
	</Form>
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login Page</title>
</head>
<body>

	
	<br><br><br><h2 align="center">Please login with your credentials</h2>
	<br> ${message}
	<c:url var="action" value="/login"></c:url>

	<form:form action="${action}" method="post">
		<table align="center">
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td> User Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>

		</table>
	</form:form>	
</body>
</html>
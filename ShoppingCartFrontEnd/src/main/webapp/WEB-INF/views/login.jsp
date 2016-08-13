<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">TV Store</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Login</a></li>
    </ul>
     </div>
</nav>
  
<div class="container">
</div>
<body>
	Please login with your credentials
	<br>
	<c:url var="action" value="/login"></c:url>
	<form:form action="${action}" method="post">

	<h1 align="center" style="color: black;">Login Here</h1>
	<Form action="LoginController" method="post">
		<br> <strong>Username:</strong><input type="text" name="name"><br>
		<br> <strong>Password:</strong><input type="password"name="password"><br> <br>
		 <input type="submit" value="login">&nbsp; 
		 <input type="submit" value="reset">
	</Form>
	</form:form>
</body>
</html>
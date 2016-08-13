<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">TV Store</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Register Now</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
</div>
<body>

	<h2>Please fill the details</h2>
<form:form action="user/register" method="post" commandName="user">
<table>
	<tr>
		<td><form:label path="id">User ID</form:label><br>
		<form:input path="id" required="true" title="id should not be empty" /></td>
	</tr>
	
	<tr>
		<td><form:label path="name">Name</form:label><br>
		<form:input path="name" required="true" title="name should not be empty" /></td>
	</tr>
	
	<tr>
		<td><form:label path="desc">Description</form:label><br>
		<form:input path="desc" required="true" title="desc should not be empty"/></td>
	</tr>
	
	<tr>
	<td><form:label path="mobileno">Mobile No</form:label><br>
	<form:input path="mobileno" required="true" title="mobile no should not be empty "/></td>
	</tr>
	
	<tr>
	<td><form:label path="email">Email ID</form:label><br>
	<form:input path="email" required="true" title="email id should not be empty "/></td>
	</tr>
	
	<tr>
	<td><form:label path="password">Password</form:label><br>
	<form:input path="password" required="true" title="password should not be empty "/></td>
	</tr>

	<tr>
		<td><input type="submit" value="Register" />
		<input type="reset" value="reset" /></td>
	</tr>			 
</table>
</form:form>
</body></html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

<title>Registration Page</title>
</head>
<body>
	<br><br><h2 align="center">Please fill the details</h2>
<form:form action="user/register" method="post" commandName="user" id="form">
<table align="center">
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
	<form:input type="password" path="password" required="true" title="password should not be empty " id="pass"/></td>
	</tr>


	<tr>
	<td><form:label path="">Confirm Password</form:label><br>
	<form:input type="password" path="" required="true" title="password should not be empty " id="c_pass" onblur="confirmPass()" /></td>
	</tr>
	
	
	<tr>
		<td><input type="submit" value="Register" />
		<input type="reset" value="reset" /></td>
	</tr>			 
</table>
</form:form>
<script type="text/javascript">
    function confirmPass() {
        var pass = document.getElementById("pass").value
        var confPass = document.getElementById("c_pass").value
        if(pass != confPass) {
            alert('Wrong confirm password !');
        }
    }
</script>
</body></html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>Registration Page</title>
</head>
<body>
	<br><br><h2 align="center">Please fill the details</h2>
		<form:form modelAttribute="user">
<table align="center">
	<tr>
		<td><form:label path="id">User ID</form:label><br>
		<form:input path="id"  /></td>
		<!-- to display validation messages -->
			<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('id')}" var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>
	</tr>
	
	<tr>
		<td><form:label path="name">Name</form:label><br>
		<form:input path="name" required="true" title="name should not be empty" /></td>
		<!-- to display validation messages -->
			<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('name')}"	var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>
	</tr>
	
	<tr>
		<td><form:label path="desc">Description</form:label><br>
		<form:input path="desc" required="true" title="desc should not be empty"/></td>
			<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('desc')}" var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>
	</tr>
	
	<tr>
	<td><form:label path="mobileno">Mobile No</form:label><br>
	<form:input path="mobileno" required="true" title="mobile no should not be empty "/></td>
	<!-- to display validation messages -->
			<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('mobileno')}" var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>
	</tr>
	
	<tr>
	<td><form:label path="email">Email ID</form:label><br>
	<form:input path="email" required="true" title="email id should not be empty "/></td>
	<!-- to display validation messages -->
			<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('email')}" var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>
	</tr>
	
	<tr>
	<td><form:label path="password">Password</form:label><br>
	<form:input type="password" path="password" required="true" title="password should not be empty " id="pass"/></td>
	<!-- to display validation messages -->
			<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>
	</tr>


	<tr>
	<td><form:label path="">Confirm Password</form:label><br>
	<form:input type="password" path="" required="true" title="password should not be empty " id="c_pass" onblur="confirmPass()" /></td>
	</tr>
	
	
	<tr>
		<td><input name="_eventId_submit" type="submit" value="Submit" />
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

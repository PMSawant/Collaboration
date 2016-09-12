<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="content">
		<fieldset>
			<legend>Confirm Details</legend>
			<a href="${flowExecutionUrl}&_eventId_home">Home</a><br /> <br />
			<form:form  method="post" commandName="user" id="form">
			
				<form:label path="id">User ID :</form:label>${user.id}
					<br />
				<br />
				<form:label path="name"> User Name:</form:label>${user.name}
					<br />
				<br />
				<form:label path="name"> User Desc:</form:label>${user.desc}
					<br />
				<br />
				<form:label path="mobile">Mobile No:</form:label>${user.mobileno}
					<br />
					<br />
				<form:label path="email">Email:</form:label>${user.email}
					<br />
					<br />
				<form:label path="password">Password :</form:label>${user.password}
					<br />
		
				<input name="_eventId_edit" type="submit" value="Edit" />
				<input name="_eventId_submit" type="submit" value="Confirm Details" />
				<br />
			</form:form>
		</fieldset>
	</div>
</body>
</html>
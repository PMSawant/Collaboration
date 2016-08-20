<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<title>Shopping Cart</title>
</head>
<style>
body {
	font: 400 15px/1.8 Lato, sans-serif;
	color: #777;
}
h3, h4 {
	margin: 10px 0 30px 0;
	letter-spacing: 10px;
	font-size: 20px;
	color: #111;
}
.container {
	padding: 80px 120px;
}
.person {
	border: 10px solid transparent;
	margin-bottom: 25px;
	width: 80%;
	height: 80%;
	opacity: 0.7;
}
.person:hover {
	border-color: #f1f1f1;
}
.nav-tabs li a {
	color: #777;
}
.navbar {
	font-family: Montserrat, sans-serif;
	margin-bottom: 0;
	background-color: #2d2d30;
	border: 0;
	font-size: 11px !important;
	letter-spacing: 4px;
	opacity: 0.9;
}
.navbar li a, .navbar .navbar-brand {
	color: #d5d5d5 !important;
}

.navbar-nav li a:hover {
	color: #fff !important;
}
.navbar-nav li.active a {
	color: #fff !important;
	background-color: #29292c !important;
}
.navbar-default .navbar-toggle {
	border-color: transparent;
}
.form-control {
	border-radius: 0;
}
textarea {
	resize: none;
}
p{
color:red;
}
</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand">TV Store</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="index">HOME</a></li>
					<c:choose>
						<c:when test="${empty loggedInUser}">
							<li><a href="loginHere">Login</a></li>
							<li><a href="registerHere">Register</a></li>
						</c:when>
						<c:when test="${not empty loggedInUser}">
					Welcome ${loggedInUser}
				<li><a href="logout">Logout</a></li>
						</c:when>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
	
	<div id="registerHere">
		<c:if test="${isUserClickedRegisterHere==true}">
			<%@ include file="register.jsp"%>
		</c:if>
	</div>
	<div id="loginHere">
		<c:if
			test="${isUserClickedLoginHere==true || invalidCredentials==true}">
			<div id="error">${errorMessage}</div>
			<%@ include file="login.jsp"%>
		</c:if>
	</div>

	<div id="admin">
		<c:if test="${isAdmin==true}">
			<%@ include file="admin.jsp"%>
		</c:if>

		<div id="categories">
			<c:if test="${isAdminClickedCategories==true}">
				<%@ include file="admin.jsp"%>
				<%@ include file="category.jsp"%>
			</c:if>
		</div>

		<div id="products">
			<c:if test="${isAdminClickedProducts==true}">
				<%@ include file="admin.jsp"%>
				<%@ include file="product.jsp"%>
			</c:if>
		</div>

		<div id="suppliers">
			<c:if test="${isAdminClickedSuppliers==true}">
				<%@ include file="admin.jsp"%>
				<%@ include file="supplier.jsp"%>
			</c:if>
		</div>
	</div>
<%@include file="slider.jsp" %>	
</body>
</html>


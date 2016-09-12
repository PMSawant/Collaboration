<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<title>Shopping Cart</title>
</head>
<style>
/* Add a dark background color with a little bit see-through */ 
.navbar {
    margin-bottom: 0;
    background-color: #2d2d30;
    border: 0;
    font-size: 11px !important;
    letter-spacing: 4px;
    opacity:0.9;
}

/* Add a gray color to all navbar links */
.navbar li a, .navbar .navbar-brand { 
    color: black !important;
}

/* On hover, the links will turn white */
.navbar-nav li a:hover {
    color: #fff !important;
}

/* The active link */
.navbar-nav li.active a {
    color: #fff !important;
    background-color:#29292c !important;
}

/* Remove border color from the collapsible button */
.navbar-default .navbar-toggle {
    border-color: transparent;
}

/* Dropdown */
.open .dropdown-toggle {
    color: #fff ;
    background-color: #555 !important;
}

/* Dropdown links */
.dropdown-menu li a {
    color: #000 !important;
}

/* On hover, the dropdown links will turn red */
.dropdown-menu li a:hover {
    background-color: red !important;
}
</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					 <span class="icon-bar"></span>
       				 <span class="icon-bar"></span>
        			<span class="icon-bar"></span> 
      			</button>
				<a class="navbar-brand">TV Store</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="index">HOME</a></li>
					<c:choose>
						<c:when test="${empty loggedInUser}">
							<li><a href="loginHere" > Login</a></li>
							<li><a href="registration">Register</a></li>
							<li><a href="contact">Contact US</a></li>
						</c:when>
						<c:when test="${not empty loggedInUser}">Welcome ${loggedInUser}
						<li><a href="logout">Logout</a></li>
						</c:when>
					</c:choose>
					<c:if test="${isAdmin==false}" >
						<li><a href="myCart"> My Cart </a> ${cartSize}</li>
					</c:if>	
				</ul>
			</div>
		</div>
	</nav>

<div id="contact">
	<c:if test="${isUserClickedContact==true}">
	<%@include file="contact.jsp" %>
	</c:if> 
</div>
	<div>
		<c:if test="${loggedOut==true}">
			<br><br><h2>${logoutMessage}</h2>
		</c:if>
	</div>	
	
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
		</div>
		<div id="User">
		<c:if test="${isAdmin==false}" >
			<%@ include file="User.jsp"%>
		</c:if>
	</div>
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

<div id="displayCart">
		<c:if test="${displayCart==true}">

			<br><br><br><table align="center" >
				<tr>
					<th align="left" width="80">Cart ID</th>
					<th align="left" width="120">Product Name</th>
					<th align="left" width="80">Quantity</th>
					<th align="left" width="80">Price</th>
					<th align="left" width="80">Delete from Cart</th>

				</tr>
				<c:forEach items="${cartList}" var="cart">
					<tr>
						<td align="left">${cart.id}</td>
						<td align="left">${cart.productName}</td>
						<td align="left">${cart.quantity}</td>
						<td align="left">${cart.price}</td>
						<td align="left"><a
							href="<c:url value='/cart/remove/${cart.id}'  />">Delete</a></td>
		
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

<%@include file="slider.jsp"%>
</body>
</html>
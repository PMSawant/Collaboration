
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
<%@ include file="header.jsp" %>
<div>
	<c:choose>
		<c:when test="${empty loggedInUser}">
			<td align="left"><a href="loginHere"> Login here</a></td>
			<td align="right"><a href="registerHere">Register here</a></td>
		</c:when>
		<c:when test="${not empty loggedInUser}">
			<td>Welcome ${loggedInUser},</td>
			<td align="right"><a href="logout"> logout</a></td>
		</c:when>
		</c:choose>
		
<div id="registerHere">
		<c:if test="${isUserClickedRegisterHere==true}">
			<%@ include file="register.jsp"%>
		</c:if>
</div>
<div id="loginHere">
		<c:if test="${isUserClickedLoginHere==true || invalidCredentials==true}">
			<div id = "error">  ${errorMessage} </div>
			<%@ include file="login.jsp"%>
		</c:if>
		
		<c:if test="${loggedOut==true}">
				<td>${logoutMessage}</td>
		</c:if>
</div>
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
<h2>Welcome to TV Store</h2>
</body>
</html>

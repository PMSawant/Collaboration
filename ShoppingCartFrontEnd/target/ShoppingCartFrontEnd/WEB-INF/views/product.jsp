<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="<c:url value="/resources/admin.css" />">

<html>
<head>
<title>Product Page</title>

</head>
<body>
	<h1 align="center">Add a Product</h1>

	<c:url var="addAction" value="/product/add"></c:url>

	<form:form action="${addAction}" commandName="product">
		<table align="center">
			<tr>
				<td><form:label path="id">
						<spring:message text=" Product ID" />
					</form:label></td>
				<c:choose>
					<c:when test="${!empty product.id}">
						<td><form:input path="id" disabled="true" readonly="true" />
						</td>
					</c:when>

					<c:otherwise>
						<td><form:input path="id" pattern=".{6,7}" required="true"
								title="id should contains 6 to 7 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<form:input path="id" hidden="true" />
				<td><form:label path="name">
						<spring:message text="Product Name" />
					</form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>


			<tr>
				<td><form:label path="price">
						<spring:message text="Product Price" />
					</form:label></td>
				<td><form:input path="price" required="true" /></td>
			</tr>

			<tr>
				<td><form:label path="supplier_id">
						<spring:message text="Supplier" />
					</form:label></td>
				<td><form:select path="supplier_id" items="${supplierList}"
						itemValue="name" itemLabel="name" /></td>
			</tr>
			<tr>
				<td><form:label path="category_id">
						<spring:message text="Category" />
					</form:label></td>
				<td><form:select path="category_id" items="${categoryList}"
						itemValue="name" itemLabel="name" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty product.name}">
						<input type="submit" value="<spring:message text="Edit Product"/>" />
					</c:if> <c:if test="${empty product.name}">
						<input type="submit" value="<spring:message text="Add Product"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>



	<h3 align="center">Product List</h3>
	<c:if test="${!empty productList}">
		<table class="tg" align="center">
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="80">Price</th>
				<th width="80">Product Category</th>
				<th width="80">Product Supplier</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.category_id}</td>
					<td>${product.supplier_id}</td>
					<td><a href="<c:url value='product/edit/${product.id}' />">Edit</a></td>
					<td><a href="<c:url value='product/remove/${product.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
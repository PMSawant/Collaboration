<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>
</head>
<body>
		
	<ul id="menu">
		<c:forEach items="${categoryList}" var="category">
			<li><a href="${category.name}">${category.name}</a>
				<ul>
					<c:forEach items="${supplierList}" var="product">

						<li><a href="${product.name}">${product.name}</a>

					</c:forEach>

				</ul></li>
		</c:forEach> 

	</ul>

	<br><br><br>
	<div>
			<table>
				<tr>
					<th align="left" width="100">Product ID</th>
					<th align="left" width="100">Product Name</th>
					<th align="left" width="100">Price</th>
					<th align="left" width="100">Product Category</th>
					<th align="left" width="100">Product Supplier</th>
					
				</tr>
				<c:forEach items="${productList}" var="product">
				<tr>
					<td>${selectedProduct.id}</td>
					<td>${selectedProduct.name}</td>
					<td>${selectedProduct.price}</td>
					<td>${selectedProduct.category_id}</td>
					<td>${selectedProduct.supplier_id}</td>
					</tr>
					</c:forEach>
			</table>
	</div>

</body>
</html>
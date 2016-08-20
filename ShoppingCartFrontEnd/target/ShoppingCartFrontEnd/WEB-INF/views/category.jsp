<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Category</title>

</head>
<body>
	<h1 align="center">Add to the Category</h1>

	<c:url var="addAction" value="/category/add"></c:url>

	<form:form action="${addAction}" commandName="category">
		<table align="center">
			<tr>
				<td align="center">Category ID<form:label path="id" text="ID" >
					</form:label></td>
			
				<c:choose>
					<c:when test="${!empty category.id}">
						<td><form:input path="id" disabled="true" readonly="true" />
						</td>
					</c:when>

					<c:otherwise>
						<td><form:input path="id" required="true" title="id should not br empty" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
			<form:input path="id" hidden="true"  />
				<td>Category Name<form:label path="name" text="Name">
					</form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td>Category Desc<form:label path="desc" text="Description">
					</form:label></td>
				<td><form:input path="desc" required="true" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><c:if test="${!empty category.name}">
						<input type="submit" value="Edit Category">
					</c:if> <c:if test="${empty category.name}">
						<input type="submit" value="Add Category">
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3 align="center">Category List</h3>
	<c:if test="${!empty categoryList}">
		<table class="tg" align="center" >
			<tr>
				<th width="120">Category ID</th>
				<th width="120">Category Name</th>
				<th width="120">Category Desc</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.desc}</td>
					<td><a href="<c:url value='category/edit/${category.id}' />">Edit</a></td>
					<td><a href="<c:url value='category/remove/${category.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
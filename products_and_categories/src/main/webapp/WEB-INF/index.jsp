<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Products and Categories</h1>
	<p>
		<a href="/products/new">New Product</a> | <a href="/categories/new">New Category</a>
	</p>

	<h3>All Products</h3>
	<table class="table">
		<thead>
			<tr>
				<td>Name</td>
				<td>Description</td>
				<td>Price</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allProducts}" var="p">
				<tr>
					<td><a href="products/${p.id}"><c:out value="${p.name}" /></a></td>
					<td><c:out value="${p.description}" /></td>
					<td><c:out value="${p.price}" /></td>
					<td>
						<form action="/products/${p.id}" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<button class="btn btn-danger">Delete</button>
						</form> 
						
					</td>

				</tr>
			</c:forEach>


		</tbody>
	</table>
	
	<h3>All Categories</h3>
		<table class="table">
		<thead>
			<tr>
				<td>Name</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allCategories}" var="c">
				<tr>
					<td><a href="categories/${c.id}"><c:out value="${c.name}" /></a></td>
					<td>
						<form action="/categories/${c.id}" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<button class="btn btn-danger">Delete</button>
						</form> 
						
					</td>

				</tr>
			</c:forEach>


		</tbody>
	</table>

</body>
</html>
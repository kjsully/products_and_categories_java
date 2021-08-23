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
<c:if test="${category.name != null }">

		<div>

			<h1>
				<c:out value="${category.name}" />
			</h1>

			<form action="/categories/${category.id }" method="post">
				Add a product: <br /> <select name="productId">
					<c:forEach items="${products}" var="prod">
						<option value="${prod.id }">${prod.name}</option>

					</c:forEach>
				</select>

				<button class="btn btn-success">Add Product</button>

			</form>

			<hr />
			${category.name } contains the following products: <br />
			<p>
				<c:forEach items="${category.products}" var="cp">
					<li>${cp.name }</li>

				</c:forEach>
			</p>

		</div>

	</c:if>
	
	<a href="/">Home</a>
</body>
</html>
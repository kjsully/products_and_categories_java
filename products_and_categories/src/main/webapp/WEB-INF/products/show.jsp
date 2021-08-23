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
	<c:if test="${product.name != null }">

		<div>

			<h1>
				<c:out value="${product.name}" />
			</h1>

			<form action="/products/${product.id }" method="post">
				Add a category: <br /> <select name="categoryId">
					<c:forEach items="${categories}" var="cat">
						<option value="${cat.id }">${cat.name}</option>

					</c:forEach>
				</select>

				<button>add category</button>

			</form>

			<hr />
			${product.name } is a category of: <br />
			<p>
				<c:forEach items="${product.categories}" var="cc">
					<li>${cc.name }</li>

				</c:forEach>
			</p>

		</div>

	</c:if>
	
	<a href="/">Home</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>
<body>
	<h1>new products</h1>
	<form:form action="/products/new" method="post"
		modelAttribute="product">
		<p>
			<form:label path="name">name:</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="description">description:</form:label>
			<form:errors path="description" />
			<form:textarea path="description" cols="50" rows="3" />
		</p>
		<p>
			<form:label path="price">price:</form:label>
			<form:errors path="price" />
			<form:input path="price" min="0" max="99" />
		</p>

		<button>submit</button>
	</form:form>
	
	<a href="/">Home</a>

</body>
</html>
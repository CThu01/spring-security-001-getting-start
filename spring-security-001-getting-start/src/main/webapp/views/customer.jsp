<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<script src="../resources/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<div class="container mt-4">
		<h1>Customer Home</h1>
		<div>
			<a href="/" class="btn btn-primary">Back</a>  
			<sf:form action="/logout" method="post">
				<button type="submit" class="btn btn-danger mt-4">Log out</button>
			</sf:form> 
		</div>  
	</div>

</body>
</html>
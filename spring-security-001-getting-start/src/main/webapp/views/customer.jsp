<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h6>${loginUser}</h6>
			<div>
				<ul>
					<c:forEach items="authorities" var="authority">
						<li>${authority}</li>
					</c:forEach>
				</ul>
			</div>
			
			<c:url value="/" var="homeLink"></c:url>
			<a href="${ homeLink }" class="btn btn-primary">Back</a> 
			
			<c:url value="customer/address/edit" var="homeEditLink"></c:url>
			<a href="${ homeEditLink }" class="btn btn-primary">Address Edit</a>
			 
			<sf:form action="/logout" method="post" class="mt-2">
				<button type="submit" class="btn btn-danger mt-4">Log out</button>
			</sf:form> 
		</div>  
		
		<div class="mt-4">
			
			<h3>My Address</h3>
				
			<c:choose>
				<c:when test="${ not empty address }">
				
					<table class="table table-striped">
					
						<theader>
							<tr>
								<th>Id</th>
								<th>Email</th>
								<th>Name</th>
								<th>Building</th>
								<th>Street</th>
								<th>Township</th>
								<th>Division</th>
								<th></th>
							</tr>
						</theader>
						
						<tbody>
							<c:forEach items="${ address }" var="addressDto">
								<tr>
									<td>${ addressDto.id }</td>
									<td>${ addressDto.name }</td>
									<td>${ addressDto.email }</td>
									<td>${ addressDto.building }</td>
									<td>${ addressDto.street }</td>
									<td>${ addressDto.township }</td>
									<td>${ addressDto.division }</td>	
									<td>
										<c:url value="customer/address/edit" var="addressEdit">
											<c:param name="id" value="${ addressDto.id }"></c:param>
										</c:url>
										<a href="${ addressEdit }">Edit</a>
									</td>							
								</tr>
							</c:forEach>
						</tbody>
					</table>
				
				</c:when>
				<c:otherwise>
					<div class="alert alert-info">
						<p>There is no address</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

</body>
</html>
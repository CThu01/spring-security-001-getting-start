<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Security</title>

<c:url value="/resources/css/bootstrap.min.css" var="cssBoot"></c:url>
<link rel="stylesheet" href="${ cssBoot }">
<c:url value="/resources/js/bootstrap.bundle.min.js" var="jsBoot"></c:url>
<script src="${ jsBoot }"></script>

</head>
<body>

	<div class="container mt-4">
		<h1>${ form.id == 0? 'Add New Address' : 'Address Edit' }</h1>
		
		<sf:form method="post" modelAttribute="form" class="w-75">
	
			<sf:hidden path="id"/>
			<sf:hidden path="email"/>
			
			<app:form-group label="Address Name">
				<sf:input path="name" cssClass="form-control" placeholder="Enter name"/>	
				<sf:errors path="name" cssClass="text-danger"></sf:errors>		
			</app:form-group>
			
			<div class="row">
				
				<div class="col">
					<app:form-group label="Building Name">
						<sf:input path="building" cssClass="form-control" placeholder="Enter Building Name"/>
						<sf:errors path="building" cssClass="text-danger"></sf:errors>
					</app:form-group>
				</div>
				
				<div class="col">
					<app:form-group label="Street Name">
						<sf:input path="street" cssClass="form-control" placeholder="Enter Street Name"/>
						<sf:errors path="street" cssClass="text-danger"></sf:errors>
					</app:form-group>				
				</div>
				
			</div>
			
			<div class="row">
				
				<div class="col">
					<app:form-group label="Township Name">
						<sf:input path="township" cssClass="form-control" placeholder="Enter Township"/>
						<sf:errors path="township" cssClass="text-danger"></sf:errors>
					</app:form-group>
				</div>
				
				<div class="col">
					<app:form-group label="Division Name">
						<sf:input path="division" cssClass="form-control" placeholder="Enter Division"/>
						<sf:errors path="division" cssClass="text-danger"></sf:errors>
					</app:form-group>				
				</div>
				
			</div>
			
			<div class="mt-4">
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
							
		</sf:form>
		
		<div class="">
			<a href="/" class="btn btn-danger mt-2">Back</a>   
		</div>  
	</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<title>Persons</title>
</head>

<body>
	<div class="body-content container">
		<h3>All Persons</h3>

		<div class="row">
			<div class="list">
				<ul class="list-group">
					<c:forEach var="person" items="${persons}">
						<li class="list-group-item">${person.name}</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<button class="btn btn-default fixed-size" id="toggleFormButton">Add
					person</button>
			</div>
			<div class="form-container col-lg-4" id="formContainer" style="display: none">
				<form:form id="personForm" role="form" method="post" modelAttribute="person">
					<div class="form-group">
						<form:label path="name">Name:</form:label> 
						<form:input path="name"	class="form-control"/>
					</div>
					<div class="form-group">
						<form:label path="age">Age:</form:label> 
						<form:input path="age" class="form-control"/>
					</div>
					<button class="btn btn-default">Submit</button>
				</form:form>
			</div>
		</div>
	</div>

	<script src="<c:url value="/resources/js/persons.js" />"></script>
</body>
</html>
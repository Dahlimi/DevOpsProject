<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Hotels</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/registerhotel.jsp"
					class="btn btnsuccess">Add New Hotel</a>
			</div>
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Address</th>
						<th>Pricing</th>
						<th>Star</th>
						<th>Image</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="hotel" items="${listHotels}">
						<tr>
							<td><c:out value="${hotel.name}" /></td>
							<td><c:out value="${hotel.address}" /></td>
							<td><c:out value="${hotel.pricing}" /></td>
							<td><c:out value="${hotel.star}" /></td>
							<td><c:out value="${hotel.image}" /></td>
							<td><a href="edit?name=<c:out value='${hotel.name}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?name=<c:out
value='${hotel.name}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
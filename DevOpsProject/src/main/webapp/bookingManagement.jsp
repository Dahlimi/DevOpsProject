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
			<h3 class="text-center">List of Bookings</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the bookingregister.jsp page -->
				<a href="<%=request.getContextPath()%>/bookingregister.jsp"
					class="btn">Add New Booking</a>
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Hotel</th>
						<th>Room Number</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="booking" items="${listBookings}">
						<tr>
							<td><c:out value="${booking.name}" /></td>
							<td><c:out value="${booking.hotel}" /></td>
							<td><c:out value="${booking.roomnumber}" /></td>
							<td><c:out value="${booking.startdate}" /></td>
							<td><c:out value="${booking.enddate}" /></td>
							<td><a href="edit?name=<c:out value='${booking.name}'
/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delete?name=<c:out
value='${booking.name}' />">Delete</a>
</td> 
						
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
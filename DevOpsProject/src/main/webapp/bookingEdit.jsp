<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>User Management Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Booking Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/BookingServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>

	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${booking != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${booking == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${booking != null}">
Edit Booking
	</c:if>
						<c:if test="${booking == null}">
Add New Booking
</c:if>
					</h2>
				</caption>

				<c:if test="${booking != null}">
					<input type="hidden" name="oriName"
						value="<c:out
value='${booking.name}' />" />

				</c:if>

				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out
value='${booking.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Hotel Name</label> <input type="text"
						value="<c:out
value='${booking.hotel}' />" class="form-control"
						name="hotel">
				</fieldset>

				<fieldset class="form-group">
					<label>Room Number</label> <input type="text"
						value="<c:out
value='${booking.roomnumber}' />"
						class="form-control" name="roomnumber">
				</fieldset>

				<fieldset class="form-group">
					<label>Start Date</label> <input type="text"
						value="<c:out
value='${booking.startdate}' />"
						class="form-control" name="startdate">
				</fieldset>

				<fieldset class="form-group">
					<label>End Date</label> <input type="text"
						value="<c:out
value='${booking.enddate}' />" class="form-control"
						name="enddate">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				
				</form>
			</div>
		</div>
	</div>


</body>
</html>
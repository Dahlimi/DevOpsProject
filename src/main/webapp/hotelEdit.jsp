<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Hotel Management Application</title>
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
			<a class="navbar-brand"> Hotel Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/HotelServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${hotel != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${hotel == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${hotel != null}">
Edit Hotel
</c:if>
						<c:if test="${hotel == null}">
Add New Hotel
</c:if>
					</h2>
				</caption>
				<c:if test="${hotel != null}">
					<input type="hidden" name="oriName"
						value="<c:out
value='${hotel.name}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Hotel Name</label> <input type="text"
						value="<c:out
value='${hotel.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out
value='${hotel.address}' />" class="form-control"
						name="address">
				</fieldset>
				<fieldset class="form-group">
					<label>Pricing</label> <input type="text"
						value="<c:out
value='${hotel.pricing}' />" class="form-control"
						name="pricing">
				</fieldset>
				<fieldset class="form-group">
					<label>Rating</label> <input type="text"
						value="<c:out
value='${hotel.star}' />" class="form-control"
						name="star">
				</fieldset>
				<fieldset class="form-group">
					<label>Image Link</label> <input type="text"
						value="<c:out
value='${hotel.image}' />" class="form-control"
						name="image">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
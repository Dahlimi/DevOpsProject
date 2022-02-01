<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="BookingRegister" method="post">
		Name: <Input type="text" name="userName">
		Hotel Name: <Input type="text" name="hotelName"> 
		Room Number: <Input type="text" name="roomNumber"> 
		Start Date: <Input type="date" name="startDate">
		End Date: <Input type="date" name="endDate">
		<Input type="submit" value="Call Servlet" />
	</form>
</body>
</html>
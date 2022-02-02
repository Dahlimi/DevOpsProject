<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="HotelRegister" method="post">
        Hotel Name: <Input type="text" name="name">
        Address: <Input type="text" name="address">
        Pricing: <Input type="text" name="pricing">
        Star: <select name="star">
        <option>1-Star</option>
        <option>2-Star</option>
        <option>3-Star</option>
        <option>4-Star</option>
        <option>5-Star</option>
 		</select>
 		Image Link: <Input type="text" name="image">
        <Input type="submit" value="Register Hotel" />
    </form>
</body>
</html>
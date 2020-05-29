<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Reservation</title>
</head>
<body>
<p><b>Choose the restaurant</b></p>
<form method="POST" action="reservation" modelAttribure="reservationDto">
    <c:forEach items="${listOfAllRestaurants}" var="elem">
        <p><input name="restaurant" type="radio" value="${elem.name}"></p>
    </c:forEach>

    <p><b>Choose the date</b></p>
    <input type="date" id="dateAndTime" name="dateAndTime" value="2020-06-01" min="2020-06-01" max="2020-06-14">
    <p><input type="submit" value="Submit"></p>
</form>
</body>
</html>

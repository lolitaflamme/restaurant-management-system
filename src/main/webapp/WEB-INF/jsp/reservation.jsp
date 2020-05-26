<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation</title>
</head>
<body>
<form method="post" action="reservation" modelAttribure="reservationDto">
    <p><b>Choose the restaurant</b></p>
    <p><input name="restaurant" type="radio" value="Victoria">Victoria</p>
    <p><input name="restaurant" type="radio" value="Berezka">Berezka</p>
    <p><input name="restaurant" type="radio" value="Belarus" checked>Belarus</p>
    <p><input name="restaurant" type="radio" value="Belarus" checked>Belarus</p>
    <p><input name="restaurant" type="radio" value="Flower" checked>Flower</p>
    <p><input name="restaurant" type="radio" value="Art" checked>Art</p>
    <p><input name="restaurant" type="radio" value="Valery" checked>Valery</p>

    <p><b>Choose the date</b></p>
    <input type="datetime-local" name="dateAndTime" step="1" required>

    <p><input type="submit" value="Submit"></p>
</form>
</body>
</html>

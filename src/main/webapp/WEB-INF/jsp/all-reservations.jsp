<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>All reservations</title>
</head>
<body>
<table>
    <tr><th>User</th><th>Restaurant name</th><th>Date</th></tr>
    <c:forEach var="emp" items="${msg}">
        <tr>
            <td>${allReservations.user}</td>
            <td>${allReservations.name}</td>
            <td>${allReservations.salary}</td>
        </tr>
    </c:forEach>
</table>
<br/>
</body>
</html>

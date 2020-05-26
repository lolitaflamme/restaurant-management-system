<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<p>Sign up</p>
<br>
<form method="POST" action="sign-up" modelAttribute="userDto">
    <p>Phone number: <input name="phoneNumber" required></p>
    <p>Password: <input type="password" name="password" required></p>
    <p>Age: <input name="age" required></p>
    <p><input type="submit" value="Submit"></p>
</form>
</body>
</html>

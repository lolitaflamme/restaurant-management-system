<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<p>Sign up</p>
<br>
<form method="POST" action="${pageContext.request.contextPath}/signUp" modelAttribute="userDto">
    Phone number:<input type="text" name="phoneNumber">
    Password:<input type="text" name="password">
    <input type="submit" value="Submit"/>
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
<p>Sign in</p>
<br>
<form action="${pageContext.request.contextPath}/user/home" method="post">
    Phone number:<input type="text" name="phoneNumber">
    Password:<input type="text" name="password">
    <input type="submit" value="Submit">
</form>
</body>
</html>

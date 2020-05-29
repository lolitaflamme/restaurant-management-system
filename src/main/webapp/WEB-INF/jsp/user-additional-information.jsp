<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Additional information</title>
</head>
<body>
<p>Additional information:</p>
<br>
    <form method="POST" action="user-additional-information" modelAttribute="userDto">
    <p>Passport number: <input name="passportNumber"></p>
    <p>Identification number: <input name="identificationNumber"></p>
    <p>First name: <input name="firstName"></p>
    <p>Second name: <input name="secondName"></p>
    <p>Gender: <select name="gender">
    <option value="">null</option>
    <option value="1">Male</option>
    <option value="2">Female</option>
    </select>
    <p><input type="submit" value="Submit"></p>
    </form>
</body>
</html>

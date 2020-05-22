<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Additional information</title>
</head>
<body>
<p>Additional information:</p>
<br>
<form:form method="POST" action="additionalInformation" modelAttribute="userDto">
    <form:label path="passportNumber">Passport number</form:label>
    <form:input path="passportNumber"/>
    <form:label path="identificationNumber">Identification number</form:label>
    <form:input path="identificationNumber"/>
    <form:label path="firstName">First name</form:label>
    <form:input path="firstName"/>
    <form:label path="secondName">Second name</form:label>
    <form:input path="secondName"/>
    <form:label path="sex">Sex</form:label>
    <form:input path="sex"/>
    <form:label path="age">Age</form:label>
    <form:input path="age"/>
    <input type="submit" value="Submit"/>
</body>
</html>

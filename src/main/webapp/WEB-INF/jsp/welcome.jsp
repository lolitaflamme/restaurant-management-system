<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Welcome page</title>
</head>
<body>
<div>
    <fmt:message key="label.changeLang" />
</div>
<ul>
    <li><a href="?lang=en_US"><fmt:message key="label.lang.en" /></a></li>
    <li><a href="?lang=ru_RU"><fmt:message key="label.lang.ru" /></a></li>
</ul>
<h2>
    <fmt:message key="label.welcome" />
</h2>
<div>
    <span><fmt:message key="label.content" /></span>
</div>
<a href="sign-up"><fmt:message key="label.button.signup"/></a>
<br>
<a href="sign-in"><fmt:message key="label.button.signin"/></a>
<br>
</body>
</html>
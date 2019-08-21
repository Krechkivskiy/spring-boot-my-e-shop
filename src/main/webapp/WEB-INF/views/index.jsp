<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1> welcome to my site please sign in</h1>
<form action='<spring:url value="/signin"/>' method="post">
    <input type="text" name="email">
    <input type="password" name="password">
    <input  type="submit">
</form>
${loginMessage}
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09.07.2019
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/admin/edit_product" method="post" name="product">
    <input value="${id}" name="id" type="hidden">
    new name<br><input type="text" name="name"><br>
    new description <br><input type="text" name="description"><br>
    new price <br><input type="text" name="price"><br>
    <input type="submit" name="btn"></form>
</body>
<a href="/logout">Выйти</a>
</body>
</html>

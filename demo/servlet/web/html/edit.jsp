<%--
  Created by IntelliJ IDEA.
  User: tom
  Date: 2021/12/5
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="http://localhost:8080/servlet/bookmangerservlet" method="get">
    <input type="hidden" name="action" value="edit">
    <h1>修改图书</h1>
    id <input type="text" name="id" value="${book.id}">
    <br>
    书名<input type="text" name="name" value="${book.name}">
    <br>
    价格<input type="text" name="price" value="${book.price}">
    <br>
    作者<input type="text" name="author" value="${book.author}">
    <br>
    销量<input type="text" name="sales" value="${book.sales}">
    <br>
    存货<input type="text" name="stock" value="${book.stock}">
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>

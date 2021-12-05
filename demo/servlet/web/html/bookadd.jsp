<%--
  Created by IntelliJ IDEA.
  User: tom
  Date: 2021/12/5
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书模块</title>
</head>
<body>
<form action="http://localhost:8080/servlet/bookmangerservlet" method="get">
    <input type="hidden" name="action" value="add">
    <h1>添加图书</h1>
    书名<input type="text" name="name">
    <br>
    价格<input type="text" name="price">
    <br>
    作者<input type="text" name="author">
    <br>
    销量<input type="text" name="sales">
    <br>
    存货<input type="text" name="stock">
    <br>
    <input type="submit" value="提交">
</form>


</body>
</html>

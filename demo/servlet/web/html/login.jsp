<%--
  Created by IntelliJ IDEA.
  User: tom
  Date: 2021/11/27
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<%@include file="/common/menu.jsp"%>
<form action="http://localhost:8080/servlet/userservlet" method="post">
  <input type="hidden" name="action" value="login">
  <label>
    <h1>登陆</h1>
    <span>${requestScope.msg}</span>
    <br>
    用户<input type="text" name="username">

    <br>
    密码<input type="password" name="password">
    <br>
    <input type="submit">
  </label>
</form>
</body>
</html>

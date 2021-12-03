<%--
  Created by IntelliJ IDEA.
  User: tom
  Date: 2021/11/27
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/common/menu.jsp"%>
<form action="http://localhost:8080/servlet/userservlet" method="post">
    <input type="hidden" name="action" value="register">
    <label>
        <h1>注册</h1>
        <span>${requestScope.msg}</span>
        <br>
        用户<input type="text" name="username" value=<%= request.getAttribute("username")==null?"":request.getAttribute("username")%>>
        <br>
        密码<input type="password" name="password">
        <br>
        邮箱<input type="text" name="email">
        <br>
        眼验证码<input type="text" name="code">nbps
        <br>
        <input type="submit">
    </label>
</form>
</body>
</html>

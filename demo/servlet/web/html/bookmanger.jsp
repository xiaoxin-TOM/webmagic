<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tom
  Date: 2021/12/5
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书管理</title>
    <!--
        p240在删除有个删除确认提示，目前因为一些问题没有成功
    !-->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript">
        $(function (){
            ${a.deleteclass}.click(function (){
                return confirm("你确定要删除吗");
                return false;
            })
            }
        )
    </script>
</head>
<body>
<table >
<tr>
    <th>id</th>
    <th>书名</th>
    <th>价格</th>
    <th>已售</th>
    <th>库存</th>
    <th>作者</th>
</tr>
    <c:forEach items="${requestScope.books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.sales}</td>
            <td>${book.stock}</td>
            <td>${book.author}</td>
            <td><a href="http://192.168.1.7:8080/servlet/bookmangerservlet?action=getbook&id=${book.id}">编辑</a></td>
            <td><a class="deleteclass" href="http://192.168.1.7:8080/servlet/bookmangerservlet?action=delete&id=${book.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/servlet/html/bookadd.jsp">添加图书</a>

</body>
</html>

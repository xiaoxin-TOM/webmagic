<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello
<form enctype="multipart/form-data" action="http://localhost:8080/jsp/jspservlet" method="post">
    name<input type="text" name="name">
    <br>
    photo<input type="file" name="photo">
    <br>
    <input type="submit" value="submit">
</form>
</body>
</html>

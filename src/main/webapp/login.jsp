<%--
  Created by IntelliJ IDEA.
  User: 23208
  Date: 2019/11/21
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>登录页</title>
</head>
<body>
<img src="/api/code" alt="">
<form action="/api/login" method="post">
    <label>
        <input type="text" name="code">
    </label>
    <input type="submit" value="登录">
</form>
</body>
</html>

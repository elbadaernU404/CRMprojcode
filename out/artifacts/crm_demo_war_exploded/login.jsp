<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/17 0017
  Time: 上午 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="Login.css"/>
</head>
<body>
<div id="login">
    <h1>Login</h1>
    <form  action="login"  method="get">
        用户名:<input type="text" name="name"><br/>
        密码:<input type="password" name="password"><br/>
        <button class="but" type="submit">登录</button>
    </form>
</div>
</body>
</html>

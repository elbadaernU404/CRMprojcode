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
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="Register.css"/>
</head>
<body>
<div id="register">
    <h1>Register</h1>
    <form  action="register"  method="post">
        用户名:<input type="text" name="name"><br/>
        密码:<input type="password" name="password"><br/>
        <button class="but" type="submit">注册</button>
    </form>
</div>
</body>
</html>

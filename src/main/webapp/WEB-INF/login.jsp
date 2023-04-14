<%--
  Created by IntelliJ IDEA.
  User: 长夜
  Date: 2023/4/10
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页面</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../static/css/login.css" type="text/css">
    <script src="../static/js/login.js"></script>
</head>
<body>
    <h2 style="color: aqua">用户登录</h2>
    <div id="errorMsg">${login_msg}</div>
    <form action="${pageContext.request.contextPath}/user/login_solve" method="post">
        <label for="email">邮箱:</label>
        <input type="text" id="email" name="email" required>

        <label for="password">密码:</label>
        <input type="password" id="password" name="password" required>

        <input type="submit" value="登录">
    </form>
    <div class="im"></div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span style="color: red">${errorMsg}</span>
<%
    session.invalidate();
%>
<h3>登陆页面</h3>
<form action="/login" method="post">
    账号:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>

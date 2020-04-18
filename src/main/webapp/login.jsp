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
    账号:<input type="text" id="username" name="username" required><span id="checkMsg" style='color: red'></span><br>
    密码:<input type="password" name="password" required><br>
    <input type="submit" value="登录">
</form>
<script src="${pageContext.request.contextPath}/webjars/jquery/3.5.0/jquery.min.js"></script>
<script type="text/javascript">
    $("#username").change(function () {
        $.ajax({
            type: "GET",
            url: "/checkUserName",
            data: {username: $("#username").val()},
            success: function (result) {
                $("#checkMsg").text(result ? "√" : "账号不存在");
            }
        });
    });
</script>
</body>
</html>

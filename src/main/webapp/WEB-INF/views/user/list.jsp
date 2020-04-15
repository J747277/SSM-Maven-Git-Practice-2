<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table cellpadding="0" cellspacing="0" border="1" align="center" style="text-align: center">
    <caption>用户列表</caption>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        <th>bornDate</th>
        <th>headImg</th>
        <th>modified</th>
    </tr>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.username}</td>
            <td>${u.password}</td>
            <td><fmt:formatDate value="${u.bornDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${u.headImg}</td>
            <td><a href="">修改</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7"><a href="/user/input">新增</a></td>
    </tr>
</table>
</body>
</html>

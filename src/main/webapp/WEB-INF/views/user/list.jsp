<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <style>
        tr th {
            width: 120px;
        }
    </style>
</head>
<body>
<table cellpadding="0" cellspacing="0" border="1" align="center" style="text-align: center">
    <caption>用户列表，当前登录用户：<span style="color: red">${sessionScope.user_in_session.username}</span></caption>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        <th>bornDate</th>
        <th>headImg</th>
        <th>salary</th>
        <th>grade</th>
        <th>modified</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.username}</td>
            <td>${u.password}</td>
            <td><fmt:formatDate value="${u.bornDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td><img alt="找不到图片${u.headImg}" src="${request.getContextPath}/images/headImg/${u.headImg}" width="100px"
                     height="20px"></td>
            <td>${u.salary}</td>
            <td>${u.gradeId.gradeName}</td>
            <td><a href="/user/input?id=${u.id}">修改</a></td>
            <td><a href="/user/delete?id=${u.id}">删除</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5"><a href="/user/input">新增</a></td>
        <td colspan="5"><a href="/login.jsp">注销</a></td>
    </tr>
</table>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/user/saveOrUpdate" modelAttribute="user">
    <form:hidden path="id"/>
    账号<form:input path="username"/><form:errors path="username" /><br/>
    密码<form:password path="password"  showPassword="true"/><form:errors path="password" /><br/>
    入职<form:input path="bornDate"/><br/>
    头像<form:input path="headImg"/><br/>
    <input type="submit" value="保存"/>
</form:form>
</body>
</html>

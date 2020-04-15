<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/user/saveOrUpdate" modelAttribute="user" enctype="multipart/form-data">
    <form:hidden path="id"/>
    账号<form:input path="username" required="true"/><form:errors path="username" cssStyle="color: red"/><br/>
    密码<form:password path="password" showPassword="true" required="true"/><form:errors path="password" cssStyle="color: red"/><br/>
    入职<form:input path="bornDate"/><br/>
    头像<input type="file" name="headImgFile"><form:hidden path="headImg"/><br/>
    <input type="submit" value="保存"/>
</form:form>
</body>
</html>

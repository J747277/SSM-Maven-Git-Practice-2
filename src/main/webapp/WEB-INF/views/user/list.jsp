<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/list" method="post">
    <table cellpadding="0" cellspacing="0" border="1" align="center" style="text-align: center">
        <caption>用户列表，当前登录用户：<span
                style="color: red">${sessionScope.user_in_session.username}《${sessionScope.user_in_session.gradeId.gradeName}》</span>。<a
                href="/login.jsp">注销登录</a>
        </caption>
        <tr>
            <td colspan="11">
                登录名:<input type="text" name="keyword" value="${sessionScope.uqo.keyword}">&nbsp;
                时间最早:<input type="date" name="beginTime"
                            value="<fmt:formatDate value="${sessionScope.uqo.beginTime}" pattern="yyyy-MM-dd"/>">&nbsp;
                时间最晚:<input type="date" name="endTime"
                            value="<fmt:formatDate value="${sessionScope.uqo.endTime}" pattern="yyyy-MM-dd"/>">&nbsp;
                财富最多:<input type="text" name="maxSalary" value="${sessionScope.uqo.maxSalary}">&nbsp;
                财富最少:<input type="text" name="minSalary" value="${sessionScope.uqo.minSalary}">&nbsp;
                <button type="submit" value="1" name="search">搜索</button>
            </td>
        </tr>
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
            <th>transfer</th>
            <th><label for="selectAll">全选</label><input type="checkbox" id="selectAll"></th>
        </tr>
        <c:forEach items="${pageResult.result}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.username}</td>
                <td>${u.password}</td>
                <td><fmt:formatDate value="${u.bornDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><img alt="找不到图片${u.headImg}" src="${request.getContextPath}/images/headImg/${u.headImg}"
                         width="50px">
                </td>
                <td>${u.salary}</td>
                <td>${u.gradeId.gradeName}</td>
                <td><a href="/user/input?id=${u.id}">修改</a></td>
                <td><a href="/user/delete?ids=${u.id}">删除</a></td>
                <td><a href="/user/transfer?id=${u.id}">转账</a></td>
                <td><input type="checkbox" name="deleteAll" value="${u.id}"></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="10">
                <button type="submit" value="1" name="currentPage">首页</button>
                <button type="submit" value="${pageResult.prevPage}" name="currentPage">上一页</button>
                <button type="submit" value="${pageResult.nextPage}" name="currentPage">下一页</button>
                <button type="submit" value="${pageResult.totalPage}" name="currentPage">尾页</button>
                当前第${pageResult.currentPage}/${pageResult.totalPage}页, 共${pageResult.totalCount}条数据，
                <a href="/user/input">新增用户</a>
            </td>
            <td>
                <button type="button" value="deleteAll" id="deleteAll">deleteAll</button>
            </td>
        </tr>
    </table>
</form>
<script src="${pageContext.request.contextPath}/webjars/jquery/3.5.0/jquery.min.js"></script>
<script type="text/javascript">
    $('input[id="selectAll"]').on("click", function () {
        if ($(this).is(':checked')) {
            $('input[name="deleteAll"]').each(function () {
                $(this).prop("checked", true);
            });
        } else {
            $('input[name="deleteAll"]').each(function () {
                $(this).prop("checked", false);
            });
        }
    });
    $('button[id="deleteAll"]').on("click", function () {
        var deleteAll = [];
        $('input[name="deleteAll"]:checked').each(function () {
            deleteAll.push($(this).val());
        });
        window.location = "/user/delete?ids=" + deleteAll;
    })
</script>
</body>
</html>

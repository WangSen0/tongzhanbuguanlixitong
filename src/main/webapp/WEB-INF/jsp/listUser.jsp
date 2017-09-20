<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/15
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../resources/css/mystylecss.css"/>
    <title>listUser</title>
</head>
<body>
${param.message}<br/>
<div>
<jsp:include page="main.jsp"></jsp:include>
</div>
<div>
    <table>
        <tr>
            <th>ID<th>
            <th>NAME</th>
            <th>PASSWORD</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
    <C:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td><a href="/user/update/${user.id}"><input type="button" value="修改"/></a></td>
            <td><a href="/user/deleteUser/${user.id}"><input type="button" value="删除"/></a></td>
        </tr>
    </C:forEach>
    </table>
</div>
</body>
</html>

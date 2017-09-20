<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/15
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
用户:${sessionScope.user.name}<br/>
<ul>
    <li>档案</li>
        <ul>
            <a href="/person/insert"><li>增加</li></a>
            <a href="/person/select"><li>查询</li></a>
        </ul>
    <li> 用户管理</li>
        <ul>
            <a href="/user/insertUser"><li>添加用户</li></a>
            <a href="/user/listUser"><li>用户列表</li></a>
        </ul>
    <a><li>上传资料</li></a>
</ul>
</body>
</html>

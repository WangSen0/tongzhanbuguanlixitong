<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/14
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/login" method="post">
        <input name="name" type="text"/>
        <input name="password" type="text"/>
        <input type="submit">
    </form>
    ${message}
    <c:if test="${message}!=null">
        ${message}
    </c:if>
</body>
</html>

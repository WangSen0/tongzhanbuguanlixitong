<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/15
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <<link rel="stylesheet" type="text/css" href="../../resources/css/mystylecss.css">
    <title>insertUser</title>
</head>
<body>
<div>
    <jsp:include page="main.jsp"></jsp:include>
</div>
<div>
    <form action="/user/insertUser" method="post">
        姓名：<input type="text" name="name"/><br/>
        密码：<input type="password" name="password"/><br/>
        <input type="submit" value="提交"/>
    </form>
</div>
</body>
</html>

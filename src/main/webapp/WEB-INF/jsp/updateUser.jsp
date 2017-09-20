<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/15
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../resources/css/mystylecss.css"/>
    <title>updateUser</title>
</head>
<body>
${param.message}
<div>
    <jsp:include page="main.jsp"></jsp:include>
</div>
<div>
    <form action="/user/update/${user1.id}" method="post">
        ID：<input type="text" readonly="readonly" value="${user1.id}" name="id"><br/>
        姓名：<input type="text" readonly="readonly" value="${user1.name}" name="name"><br/>
        原始密码：<input type="text" name="password1"><br/>
        新密码：<input type="text" name="password"><br/>
        <input type="submit" value="提交"/>
    </form>
</div>
</body>
</html>

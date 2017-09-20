<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/17
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../resources/css/mystylecss.css"/>
    <title>upload</title>
</head>
<body>
<form action="/person/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br><br>
    <input type="submit" value="上传">
</form>
</body>
</html>

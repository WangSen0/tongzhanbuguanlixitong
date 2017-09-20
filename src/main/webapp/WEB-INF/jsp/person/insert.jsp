<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/17
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../../resources/css/mystylecss.css"/>
    <title>insertPerson</title>
</head>
<body>
${param.message}
<div>
    <jsp:include page="../main.jsp"></jsp:include>
</div>
<div>
<form action="/person/insert" method="post">
    姓名：<input  type="text" name="name"/><br/>
    性别：<input  type="text"name="sex"/><br/>
    出生年月：<input  type="text" name="birthday"/><br/>
    民族：<input  type="text" name="nation"/><br/>
    籍贯：<input  type="text"name="nativeplace"/><br/>
    党派：<input  type="text" name="part"/><br/>
    加入党派时间：<input  type="text" name="parttime"/><br/>
    出生地：<input  type="text" name="location"/><br/>
    参加工作年月;<input  type="text" name="worktime"/><br/>
    健康状况：<input  type="text" name="health"/><br/>
    职称：<input  type="text" name="title"/><br/>
    全日制教育：<input  type="text" name="eduction1"/><br/>
    毕业学校：<input  type="text" name="school1"/><br/>
    在职教育：<input  type="text" name="eduction2"/><br/>
    毕业学校：<input  type="text" name="school2"/><br/>
    现任职务：<input  type="text" name="job"/><br/>
    社会主要兼职：<input  type="text" name="parttimejob"/><br/>
    简历：<input  type="text" name="resume"/><br/>
    推荐理由：<input  type="text" name="reason"/><br/>
    <input type="submit">
</form>
</div>
</body>
</html>

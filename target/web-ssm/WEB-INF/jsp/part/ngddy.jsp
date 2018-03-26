<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/28
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>农工党党员列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="../../../resources/js/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="../../../resources/js/bootstrap.min.js"></script>
    <script src='http://www.ichartjs.com/ichart.latest.min.js'></script>
    <link href="../../../resources/css/mystylecss.css" rel="stylesheet"/>
</head>
<body>
<div>
    <div class="content2">
        <div>
            <jsp:include page="../common/head1.jsp" flush="true"/>
            <p style="background-color:dodgerblue;height: 30px;border-radius: 3px;line-height:30px">
                <span style="color: white;margin-left: 15px" class="glyphicon glyphicon-user">用户名：${user.userName}</span>
                <span style="margin-left: 1020px;color: white;"><a href="javascript:void(0)"  style="color: white" onclick="updatePassword()">修改密码</a></span>
                <span><a style="color: white;margin-left: 30px" href="/user/exit">退出登录</a></span>
            </p>
        </div>
        <span style="color: red">${message}</span>
        <div style="margin-top: 20px;width: 100%">
            <h2 style="padding:15px;border-bottom: 1px solid #dddddd;width: 100%;height: 80px">农工党党员列表</h2>
        </div>
        <div style="width:98%;margin: 0 auto">
            <table style="font-size: 14px" id="table" class="table table-hover table-bordered tbb">
                <thead>
                <th>查看</th>
                <th>工号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>出生日期</th>
                <th>国籍</th>
                <th>民族</th>
                <th>政治面貌</th>
                <th>当前状态</th>
                </thead>
                <tbody id="rows">
                <c:forEach var="person" items="${personList}">
                    <tr>
                        <td><a href="" onclick="window.open('/person/detail2/ngddy/${person.personId}')">查看</a></td>
                        <td>${person.personId}</td>
                        <td>${person.name}</td>
                        <td>${person.sex}</td>
                        <td><fmt:formatDate value="${person.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td>${person.country}</td>
                        <td>${person.nation}</td>
                        <td>${person.politicalStatus}</td>
                        <td>${person.currentStatus}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="margin-bottom: 60px">
            <div style="float: right;margin-bottom: 50px">
                <a href="javascript:void(0)" onclick="previous(${currentPage-1},${pageCount})">上一页</a>
                <a href="javascript:void(0)" onclick="next(${currentPage+1},${pageCount})">下一页</a>
                当前是第<span id="currentPage">${currentPage}</span>页
                共<span id="pageCount">${pageCount}</span>页
                共<span id="totle">${totle}</span>条数据
            </div>
        </div>
        <jsp:include page="../common/footer.jsp" flush="true"/>
    </div>
</div>
<div id="addLight" class="white_content">
    <form style="margin-left: 50px;margin-top: 70px" id="form" action="/user/updatePassword" method="post">
        用户名：<input type="text"  name="userName" value="${user.userName}" readonly/><br/><br/>
        原密码：<input type="text" name="userPassword"/><br/><br/>
        新密码：<input type="text" name="newPassword"/><br/><br/><br/><br/>
        <input type="hidden" name="userAuthority" value="${user.userAuthority}">
        <input type="submit" value="提交">
        <input style="margin-left: 150px" type="button" value="关闭" onclick="document.getElementById('addLight').style.display='none'">
    </form>
</div>
</body>
<script src="../../../resources/js/data.js"></script>
<script src="../../../resources/js/dataformat.js"></script>
<script  src="../../../resources/jquery.tmpl.min.js"></script>
<script>
    function previous(currentPage,pageCount) {
        if(currentPage==0)
            alert("已经是第一页");
        else
            window.location.href="/person/ngddy/"+currentPage;
    }
    function next(currentPage,pageCount) {
        if(currentPage>pageCount)
            alert("已经是最后一页");
        else
            window.location.href="/person/ngddy/"+currentPage;
    }
    function updatePassword() {
        document.getElementById("addLight").style.display="block";
    }
</script>
</html>

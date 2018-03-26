<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/7
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>欢迎首页</title>
    <link rel="stylesheet" href="../../resources/css/mystylecss.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<div class="content2">
    <div>
    <jsp:include page="common/head1.jsp" flush="true"/>
    <p style="background-color:dodgerblue;height: 30px;border-radius: 3px;line-height:30px">
        <span style="color: white;margin-left: 15px" class="glyphicon glyphicon-user">用户名：${user.userName}</span>
        <span style="margin-left: 1020px;color: white;"><a href="javascript:void(0)"  style="color: white" onclick="updatePassword()">修改密码</a></span>
        <span><a style="color: white;margin-left: 30px" href="/user/exit">退出登录</a></span>
    </p>
</div>
    <div style="float:left;margin-left:20px;width: 200px;height: 460px;border-right: 1px solid #dddddd">
        <a  href="/person/addPerson"> <button class="btn-default btn_100">增加信息</button><br/></a>
        <a  href="/person/queryPerson"> <button class="btn-default btn_100">人员列表</button><br/></a>
        <a  href="/information/addPerson"><button class="btn-default btn_100">人员导入</button><br/></a>
        <a  href="/information/updatePerson"><button class="btn-default btn_100">人员更新</button><br/></a>
        <a  href="/user/userList/1"><button class="btn-default btn_100">用户管理</button><br/></a>
    </div>
    <div style="width: 1000px;height: 420px;">
        <span style="color: red">${message}</span>
            <div style="width: 100%;margin-top: 50px;margin-left: 300px;">
                <h3 >
                    数据概览
                </h3>
                <div style="margin-left: 100px;margin-top: 30px">
                    <div style="height: 230px">
                            <div style="float: left;">
                                <p>
                                    民主党派：${minzhuCount}人
                                </p>
                                <div style="margin-left: 30px;">
                                    <p>
                                        民革：
                                        <c:forEach var="property" items="${zggmdgmwyhhyList}">
                                            ${property.name}:${property.value}人&nbsp;&nbsp;
                                        </c:forEach>
                                    </p>
                                    <p>
                                        民盟：
                                        <c:forEach var="property" items="${zgmztmmyList}">
                                            ${property.name}:${property.value}人&nbsp;&nbsp;
                                        </c:forEach>
                                    </p>
                                    <p>
                                        民建：
                                        <c:forEach var="property" items="${zgmzjghhyList}">
                                            ${property.name}:${property.value}人&nbsp;&nbsp;
                                        </c:forEach>
                                    </p>
                                    <p>
                                        民进：
                                        <c:forEach var="property" items="${zgmzcjhhyList}">
                                            ${property.name}:${property.value}人&nbsp;&nbsp;
                                        </c:forEach>
                                    </p>
                                    <p>
                                        农工：
                                        <c:forEach var="property" items="${ngddyList}">
                                            ${property.name}:${property.value}人&nbsp;&nbsp;
                                        </c:forEach>
                                    </p>
                                    <p>
                                        九三：
                                        <c:forEach var="property" items="${jsxssyList}">
                                            ${property.name}:${property.value}人&nbsp;&nbsp;
                                        </c:forEach>
                                    </p>
                                </div>
                            </div>
                        <div style="float: right;width: 500px;">
                            <p>
                                统战团体：${tongzhanCount}人
                            </p>
                            <div style="margin-left: 30px;">
                                <p>
                                    台联：
                                    <c:forEach var="property" items="${tailianList}">
                                        ${property.name}:${property.value}人&nbsp;&nbsp;
                                    </c:forEach>
                                </p>
                                <p>
                                    侨联：
                                    <c:forEach var="property" items="${qiaolianList}">
                                        ${property.name}:${property.value}人&nbsp;&nbsp;
                                    </c:forEach>
                                </p>
                                <p>
                                    无党派：
                                    <c:forEach var="property" items="${wdprsList}">
                                        ${property.name}:${property.value}人&nbsp;&nbsp;
                                    </c:forEach>
                                </p>
                                <p>
                                    归国：
                                    <c:forEach var="property" items="${studyabroadList}">
                                        ${property.name}:${property.value}人&nbsp;&nbsp;
                                    </c:forEach>
                                </p>
                            </div>
                        </div>
                    </div>
                    <p>
                        少数民族：${minorityCount}人
                    </p>
                </div>
            </div>
    </div>
    <jsp:include page="common/footer.jsp" flush="true"/>
    <div id="addLight" class="white_content">
        <form style="margin-left: 50px;margin-top: 70px" id="form" action="/user/updatePassword" method="post">
            用&nbsp;户&nbsp;名&nbsp;：&nbsp;<input type="text"  name="userName" value="${user.userName}" readonly/><br/><br/>
            原&nbsp;密&nbsp;码&nbsp;：&nbsp;<input type="password" name="userPassword"/><br/><br/>
            新&nbsp;密&nbsp;码&nbsp;：&nbsp;<input type="password" name="newPassword"/><br/><br/>
            确认密码&nbsp;：<input type="password" name="newPassword2"/><br/><br/><br/><br/>
            <input type="hidden" name="userAuthority" value="${user.userAuthority}">
            <%--<input type="submit" value="提交">--%>
            <input type="button" value="提交" onclick="modifypassword()"/>
            <input style="margin-left: 150px" type="button" value="关闭" onclick="shutdownmodifypassword()">
        </form>
    </div>
</div><!-- page -->
</body>
<script>
    function updatePassword() {
        document.getElementById("addLight").style.display="block";
    }
    function modifypassword() {
        var str1=document.getElementsByName("newPassword")[0].value;
        var str2=document.getElementsByName("newPassword2")[0].value;
        if(str1!=str2)
            alert("两次输入密码不一样！");
        else
            document.getElementById("form").submit();
    }
    function shutdownmodifypassword() {
        document.getElementsByName("userPassword")[0].value="";
        document.getElementsByName("newPassword")[0].value="";
        document.getElementsByName("newPassword2")[0].value="";
        document.getElementById('addLight').style.display='none'
    }
</script>
</html>

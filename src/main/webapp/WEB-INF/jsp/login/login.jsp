<!--
* @Description:     登录
* @Version:         1.0.0
* @author:          lily(529116421@qq.com)
* @date             2016.10.29
* ==NOTES:=============================================
* v1.0.0(2016.10.29):
初始生成
=====================================================-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="font-size: 15px;background-image:url(../../../resources/image/bg.png);">
<div style="width:1200px;height:300px;margin:0px auto;margin-top:50px;padding:10px;">
        <div style="width:570px;height:150px;margin:0px auto;">
            <h2><img src="../../../resources/image/logo2.png"><span style="color: white">东北师范大学统战成员信息管理系统</span></h2>
        </div>

        <%--<div style="width: 700px;margin: 0 auto;text-align: center">--%>
        <div style="width: 1200px">
            <div style="background-color: whitesmoke;width: 500px;height: 300px;border: 1px solid whitesmoke;margin-left: 360px;text-align: center;border-radius: 7px;">
                <h3 style="text-align: center;margin-top: 40px">欢迎登录</h3>
                <form role="form" method="post" action="/login">
                    <div style="margin: 20px">
                        <label style="width: 80px;">账号</label>
                        <input style="border-radius: 5px" type="text" name="userName"/>
                    </div>
                    <div style="margin: 20px">
                        <label style="width: 80px;">密码</label>
                        <input style="border-radius: 3px" type="password" name="userPassword" />
                    </div>
                    <div style="margin-left: 35px;margin-top: 50px">
                        <input type="submit" style="background-color: #3875d7;border: 0px;color: whitesmoke;width: 200px;font-size: 17px;height: 40px;border-radius: 5px;" value="立即登录"/>
                    </div>
                </form>
            </div>
        <%--</div>--%>
            <i style="margin-left: 800px;color: red">${message}</i>
        </div>
</div>
</body>
</html>
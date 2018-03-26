<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/10
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="../../../resources/js/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../resources/css/mystylecss.css" rel="stylesheet"/>
    <title>用户列表</title>
</head>
<body>
<div class="content2">
    <div>
        <jsp:include page="../common/head1.jsp" flush="true"/>
        <ol class="breadcrumb" style="background-color: dodgerblue">
            <li><a style="color: white" href="/main">首页</a></li>
            <li style="color: white">用户列表</li>
            <span><a style="color: white;margin-left: 1100px" href="/user/exit">退出登录</a></span>
        </ol>
    </div>
    <div style="margin-top: 20px;width: 100%">
        <div style="padding-left:15px;width:100%;border-bottom: 1px solid #dddddd;height: 60px;">
            <h2 style="display: inline"><span onclick="clearSelect()">用户管理</span></h2>
            <span style="color:red;font-size: 15px;margin-left: 1000px;">${message}</span>
        </div>
        <div style="padding: 15px;border-bottom: 1px solid #dddddd;width: 100%;height: 70px">
            <span class="glyphicon glyphicon-search"></span>
            <input id="queryUserName" type="text"/>
            <button class=" btn btn-primary btn-sm wangsen" type="button" onclick="queryUserName()">查询</button>
            <span class="head" style="margin-left: 700px;font-size: 20px">
                <span class="glyphicon glyphicon-user"></span>
                <a href="javascript:void(0)" onclick="document.getElementById('addLight').style.display='block'">添加用户</a>
            </span>
        </div>
        <div id="qwe" style="margin:0px auto;display: none;margin-top: 30px;font-size: 3px;width: 1260px;margin-bottom: 60px;min-height:400">
            <table style="font-size: 14px" id="table" class="table table-hover table-bordered tbb" id="table" class="table table-hover table-bordered tbb">
                <thead>
                <td >用户名</td>
                <td >密码</td>
                <td >权限</td>
                <td >删除</td>
                <td>修改</td>
                </thead>
                <tbody id="rows" class="tbb">
                </tbody>
            </table>
            <jsp:include page="../common/pagination.jsp" flush="true"/>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp" flush="true"/>
</div>
<div id="addLight" class="white_content">
    <form style="margin-left: 50px;margin-top: 50px" action="/user/add" method="post">
        <span class="glyphicon glyphicon-star"></span> 用户名：<input type="text" name="userName"/><br/><br/>
        <span class="glyphicon glyphicon-lock"></span> &nbsp;密码&nbsp;&nbsp;：<input type="text" name="userPassword"><br/><br/>
        <span class="glyphicon glyphicon-exclamation-sign"></span> &nbsp;权限&nbsp;&nbsp;：
        <select name="userAuthority" id="wangsen" style="width: 170px">
            <option></option>
            <option>管理员</option>
        </select>
        <%--<input type="text" name="userAuthority">--%>
        <br/><br/><br/><br/>
        <div>
            <input type="submit" value="添加"/>
            <input style="margin-left: 120px" type="button" value="关闭" onclick="document.getElementById('addLight').style.display='none'">
        </div>
    </form>
</div>
    <div style="display: none" id="updateLight" class="white_content">
        <form style="margin-left: 50px;margin-top: 50px" action="/user/updateUser" method="post">
            <input type="text" id="udapteUserId" style="display:none" name="userId"/>
            <span class="glyphicon glyphicon-star"></span>  用户名：<input type="text" id="userName" readonly="readonly" name="userName"/><br/><br/>
            <span class="glyphicon glyphicon-lock"></span> &nbsp;密码&nbsp;&nbsp;：<input type="text" id="userPassword" name="userPassword"><br/><br/>
            <span class="glyphicon glyphicon-exclamation-sign"></span> &nbsp;权限&nbsp;&nbsp;：
            <select id="userAuthority" name="userAuthority" style="width: 170px">
                <option></option>
                <option>管理员</option>
            </select>
            <%--<input type="text" id="userAuthority" name="userAuthority">--%>
            <br/><br/>
            <br/><br/>
            <div style="margin-left: 30px">
                <input type="submit" value="修改"/>
                <input style="margin-left: 120px" type="button" value="关闭" onclick="document.getElementById('updateLight').style.display='none'">
            </div>
        </form>
    </div>
    <script id="myTemplate" type="text/x-jquery-tmpl">
        <tr>
            <td>${'${'}userName}</td>
            <td>${'${'}userPassword}</td>
            <td>${'${'}userAuthority}</td>
            <td><button type="button" class="user_btn" onClick="deleteUser('${'${'}userId}')">删除</button></td>
            <td><button type="button" class="user_btn" onClick="updateUser('${'${'}userId}','${'${'}userName}')">修改</button></td>
         </tr>
    </script>
    <form id="deleteForm" action="/user/delete" method="post">
        <input id="userId" name="userId" type="hidden"/>
    </form>
</body>
<script  src="../../../resources/jquery.tmpl.min.js"></script>
<script src="../../../resources/js/data.js"></script>
<script src="../../../resources/js/dataformat.js"></script>

<link href="../../../resources/css/select2.min.css" rel="stylesheet" />
<script src="../../../resources/js/select2.min.js"></script>
<script src="../../../resources/js/data.js"></script>
<script>
    $(document).ready(function () {
        search();
        var params={};
        evaluate(params);
        ajaxsearch(1,params);
        $("select").select2({
            data: politicalStatus,
            placeholder:'请选择',
            allowClear:true
        })
    });
    function evaluate(params) {
        params.userName=$("#queryUserName").val();
    }
    function search() {
        $("#rows").html('');
        var currentPage=document.getElementById("currentPage").innerText;
        document.getElementById("qwe").style.display="block";
        var params={};
        evaluate(params);
        $.ajax({
            async:false,
            type: "POST",
            url: "/user/pageSize",//注意路径
            data:params,
            dataType:"json",
            success:function(data) {
                document.getElementById("pageCount").innerText=data.pageCount;
                document.getElementById("totle").innerText=data.totle;
            },
            error:function(data){

                alert( "出错"+data[0]);
            }
        });
    }
    function previous() {
        params={};
        evaluate(params);
        var currentPage=parseInt(document.getElementById("currentPage").innerText);
        var s=currentPage-1;
        if(s>=1){
            $("#rows").html('');
            document.getElementById("currentPage").innerText=currentPage-1;
            ajaxsearch(s,params);
        }else{
            alert("已经是第一页");
        }
    }
    function next() {
        params={};
        evaluate(params);
        var currentPage=parseInt(document.getElementById("currentPage").innerText);
        count=document.getElementById("pageCount").innerText;
        var s=currentPage+1;
        if(s<=count){
            $("#rows").html('');
            document.getElementById("currentPage").innerText=currentPage+1;
            ajaxsearch(s,params);
        }else{
            alert("已经是最后一页");
        }
    }
    function ajaxsearch(currentPage,params) {
        $.ajax({
            async:false,
            type: "POST",
            url: "/user/userList/"+currentPage,//注意路径
            data:params,
            dataType:"json",
            success:function(data) {
                $("#rows").html('');
                $('#myTemplate').tmpl(data).appendTo('#rows');
            },
            error:function(data){
                alert( "出错"+data[0]);
            }
        });
    }
    function deleteUser(a) {
        var s=document.getElementById("userId");
        s.value=a;
        var form=document.getElementById("deleteForm");
        form.submit();
    }
    function queryUserName() {
        search();
        var params={};
        evaluate(params);
        ajaxsearch(1,params);
    }
    function updateUser(userId,userName) {
        document.getElementById("updateLight").style.display="block";
        document.getElementById("udapteUserId").value=userId;
        document.getElementById("userName").value=userName;
    }
    function clearSelect() {
        $("input").val("");
        ajaxsearch(1,'');
        $("#currentPage").html(1);
    }
</script>
</html>

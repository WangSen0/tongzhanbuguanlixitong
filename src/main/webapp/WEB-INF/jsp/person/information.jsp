<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/10
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人员导入</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="../../../resources/js/jquery.min.js"></script>
    <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="../../../resources/js/bootstrap.min.js"></script>
    <link href="../../../resources/css/mystylecss.css" rel="stylesheet"/>
</head>
<body>
<div class="content2">
    <div>
        <jsp:include page="../common/head1.jsp" flush="true"/>
        <ol class="breadcrumb" style="background-color:dodgerblue">
            <li><a href="/main" style="color: white">首页</a></li>
            <li style="color:white;">人员导入</li>
            <span><a style="color: white;margin-left: 1090px" href="/user/exit">退出登录</a></span>
        </ol>
    </div>
    <div style="margin-top: 20px;width: 100%">
        <h2 style="padding-left:15px;border-bottom: 1px solid #dddddd;width: 100%;height: 60px" onclick=""><span onclick="clearSelect()">人员导入</span></h2>
        <h3 style="padding-left: 15px">搜索</h3>
        <div style="margin:0px auto;height: 200px;border-bottom: solid 1px #dddddd">
            <table style="font-size: 14px" class="tablecss">
                <tr>
                    <td>
                        <label>工号：</label>
                        <input type="text" id="personId"/>
                    </td>
                    <td>
                        <label>姓名：</label>
                        <input type="text" id="name"/>
                    </td>
                    <td>
                        <label>政治面貌：</label>
                        <select id="politicalStatus">
                            <option></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>当前状态：</label>
                        <select id="currentStatus">
                            <option></option>
                        </select>
                    </td>
                    <td colspan="2">
                        <label>出生日期：</label>
                        <input type="date" id="birthdayStart"/>--<input type="date" id="birthdayEnd"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>民族</label>
                        <select id="nation">
                            <option></option>
                        </select>
                    </td>
                    <td>
                        <label>是否添加</label>
                        <select id="addStatus">
                            <option></option>
                            <option>已添加</option>
                            <option>未添加</option>
                        </select>
                    </td>
                </tr>
            </table>
            <div style="width: 200px;margin:0px auto;">
                <button class="btn btn-primary searchbtn" type="button"onclick="search()">搜索</button>
            </div>
        </div>
        <div style="width:98%;margin:0px auto;margin-top: 30px;margin-bottom: 50px">
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
                    <th>是否添加</th>
                    <th>添加</th>
                </thead>
                <tbody id="rows">
                </tbody>
            </table>
            <jsp:include page="../common/pagination.jsp" flush="true"></jsp:include>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp" flush="true"/>
</div>
    <script id="myTemplate" type="text/x-jquery-tmpl">
        <tr>
            <td><a href="javascript:void(0)" onclick="window.open('/information/detail/${'${'}personId}')">查看</a></td>
            <td>${'${'}personId}</td>
            <td>${'${'}name}</td>
            <td>${'${'}sex}</td>
            <td>${'${'}birthday}</td>
            <td>${'${'}country}</td>
            <td>${'${'}nation}</td>
            <td>${'${'}politicalStatus}</td>
            <td>${'${'}currentStatus}</td>
            <td>${'${'}addStatus}</td>
            <td><a href="jvascript:void(0)" onclick="addPerson(${'${'}personId},this)">添加</a></td>
         </tr>
     </script>
</body>
<link href="../../../resources/css/select2.min.css" rel="stylesheet" />
<script src="../../../resources/js/select2.min.js"></script>
<script  src="../../../resources/jquery.tmpl.min.js"></script>
<script src="../../../resources/js/data.js"></script>
<script src="../../../resources/js/dataformat.js"></script>
<script>
    $("#nation").select2({
        data: nation,
        placeholder:'请选择',
        allowClear:true
    })
    $("#politicalStatus").select2({
        data: politicalStatus,
        placeholder:'请选择',
        allowClear:true
    })
    $("#currentStatus").select2({
        data: currentStatus,
        placeholder:'请选择',
        allowClear:true
    })
    function addPerson(personId,nowId){
        $.ajax({
            async:false,
            type: "GET",
            url: "/information/addPerson/"+personId,//注意路径
            success:function(data) {
                if(data=="success"){
                    alert("添加成功");
                    nowId.parentNode.parentNode.cells[9].innerHTML="已添加";
                    params={};
                    evaluate(params);
                    var currentPage=parseInt(document.getElementById("currentPage").innerText);
                    $("#rows").html('');
                    ajaxsearch(currentPage,params);
                }else{
                    alert("添加失败");
                }
            },
            error:function(data){

                alert( "出错"+data[0]);
            }
        });
    }
    function evaluate(params) {
        params.personId=$("#personId").val();
        params.name=$("#name").val();
        params.politicalStatus=$("#politicalStatus").val();
        params.currentStatus=$("#currentStatus").val();
        params.birthdayStart=$("#birthdayStart").val();
        params.birthdayEnd=$("#birthdayEnd").val();
        params.addStatus=$("#addStatus").val();
        params.nation=$("#nation").val();
    }
    search();
     function search() {
         $("#rows").html('');
         document.getElementById("currentPage").innerText=1;
         var currentPage=document.getElementById("currentPage").innerText;
         var params={};
         evaluate(params);
         $.ajax({
             async:false,
             type: "POST",
             url: "/information/pageSize",//注意路径
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
         ajaxsearch(currentPage,params);
     }
    function ajaxsearch(currentPage,params) {
        $.ajax({
            async:false,
            type: "POST",
            url: "/information/select/"+currentPage,//注意路径
            data:params,
            dataType:"json",
            success:function(data) {
                var newDate=new Date;
                for(var i=0;i<data.length;i++){
                    if(data[i].birthday==null) continue;
                    newDate.setTime(data[i].birthday)
                    data[i].birthday=newDate.format("yyyy-MM-dd");
                }
                $('#myTemplate').tmpl(data).appendTo('#rows');
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
    function clearSelect() {
        $("input").val("");
        $("select").val("");
        ajaxsearch(1,'');
        $("#currentPage").html(1);
    }
</script>
</html>

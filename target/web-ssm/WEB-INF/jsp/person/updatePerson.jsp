
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人员更新</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="../../../resources/js/jquery.min.js"></script>
    <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="../../../resources/js/bootstrap.min.js"></script>
    <link href="../../../resources/css/mystylecss.css" rel="stylesheet"/>
</head>
<body>
<div>
<div class="content2">
    <div>
        <jsp:include page="../common/head1.jsp" flush="true"/>
        <ol class="breadcrumb" style="background-color:dodgerblue">
            <li><a href="/main" style="color: white">首页</a></li>
            <li style="color:white;">人员更新</li>
            <span><a style="color: white;margin-left: 1090px" href="/user/exit">退出登录</a></span>
        </ol>
    </div>
    <div style="margin-top: 20px;width: 100%">
        <h2 style="padding:10px;border-bottom: 1px solid #dddddd;width: 100%;height: 60px"><span onclick="clearSelect()">人员更新</span></h2>
        <h3 style="padding:10px;">搜索</h3>
        <div style="padding:0px;height: 100px;border-bottom: solid 1px #dddddd;width: 100%">
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
                </tr>
            </table>

            <div style="width: 200px;margin-left: 450px">
                <button class="btn btn-primary searchbtn" type="button"onclick="search()">搜索</button>
            </div>
        </div>
    </div>
    <div style="width:98%;margin: 10px auto">
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
            <th>更新</th>
            </thead>
            <tbody id="rows">
            </tbody>
        </table>
    </div>
    <jsp:include page="../common/pagination.jsp" flush="true"></jsp:include>

    <div style="padding-left:15px;height: 50px">
        <button type="button" class="btn btn-primary"  onclick="updateAllPerson()">全部更新</button>
    </div>
    <div id="loading" class="loading">
        <div>正在更新请稍后</div>
    </div>
<script id="myTemplate" type="text/x-jquery-tmpl">
        <tr>
            <td><a href="javascript:void(0)" onclick="window.open('/person/detail/${'${'}personId}')">查看</a></td>
            <td>${'${'}personId}</td>
            <td>${'${'}name}</td>
            <td>${'${'}sex}</td>
            <td>${'${'}birthday}</td>
            <td>${'${'}country}</td>
            <td>${'${'}nation}</td>
            <td>${'${'}politicalStatus}</td>
            <td>${'${'}currentStatus}</td>
            <td><a href="jvascript:void(0)" onclick="updatePerson(${'${'}personId},this)">更新</a></td>
         </tr>
</script>
    <jsp:include page="../common/footer.jsp"/>
</div>
</div>
</body>
<link href="../../../resources/css/select2.min.css" rel="stylesheet" />
<script src="../../../resources/js/select2.min.js"></script>
<script src="../../../resources/js/data.js"></script>
<script src="../../../resources/js/dataformat.js"></script>
<script  src="../../../resources/jquery.tmpl.min.js"></script>
<script>
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
    function updatePerson(personId,nowId){
        $.ajax({
            async:false,
            type: "POST",
            url: "/information/updatePerson/"+personId,//注意路径
            success:function(data) {
                if(data=="success"){
                    alert("更新成功");
                    params={};
                    evaluate(params);
                    var currentPage=parseInt(document.getElementById("currentPage").innerText);
                    $("#rows").html('');
                    ajaxsearch(currentPage,params);
                }else{
                    alert("更新失败");
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
            url: "/person/pageSize",//注意路径
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
            url: "/person/select/"+currentPage,//注意路径
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
    function updateAllPerson() {
        $("#qwe").css("display","block");
        $("#loading").css("display","block");
        params={};
        evaluate(params);
        $.ajax({
            async:true,
            type: "POST",
            url: "/information/updateAllPerson",//注意路径
            data:params,
            dataType:"json",
            success:function(data) {
                alert("更新"+data+"条记录");
                document.getElementById("loading").style.display="none";
            },
            error:function(data){
                alert( "出错"+data[0]);
            }
        });
    }
    function clearSelect() {
        $("input").val("");
        $("select").val("");
        ajaxsearch(1,'');
        $("#currentPage").html(1);
    }
</script>
</html>

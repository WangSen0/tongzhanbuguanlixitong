<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>人员列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="../../../resources/js/jquery.min.js"></script>
    <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="../../../resources/js/bootstrap.min.js"></script>
    <script src='../../../resources/js/ichart.latest.min.js'></script>
    <link href="../../../resources/css/mystylecss.css" rel="stylesheet"/>
</head>
<body>
<div class="content2">
    <div>
        <jsp:include page="../common/head1.jsp" flush="true"/>
        <ol class="breadcrumb" style="background-color: dodgerblue">
            <li><a style="color: white" href="/main">首页</a></li>
            <li style="color: white">查询</li>
            <span><a style="color: white;margin-left: 1120px" href="/user/exit">退出登录</a></span>
        </ol>
    </div>
    <div style="margin-top: 20px;width: 100%">
        <h2 style="padding:15px;border-bottom: 1px solid #dddddd;width: 100%;height: 60px"><span onclick="clearSelect()">人员管理-人员列表</span></h2>
        <h3 style="padding: 15px">搜索</h3>
        <div style="height: 350px;border-bottom: solid 1px #dddddd">
            <table class="tablecss">
                <tr>
                    <td><label>工号：</label><input id="personId" name="personId" type="text"></td>
                    <td><label>姓名：</label><input id="name" name="name" type="text"></td>
                    <td colspan="2"><label>出生日期：</label><input id="birthdayStart" name="birthdayStart" type="date"/>--<input id="birthdayEnd" name="birthdayEnd" type="date"></td>
                </tr>
                <tr>
                    <td>
                        <label>性别：</label>
                        <select id="sex" name="sex">
                            <option></option>
                        </select>
                    </td>
                    <td>
                        <label>民族：</label>
                        <select id="nation" name="nation">
                            <option></option>
                        </select>
                    </td>
                    <td>
                        <label>政治面貌：</label>
                        <select id="politicalStatus" name="politicalStatus">
                            <option></option>
                        </select>
                    </td>
                    <td>
                        <label>第二党派：</label>
                        <select id="secondPoliticalStatus" name="secondPoliticalStatus">
                            <option></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label >民主党派类别：</label>
                        <select id="politicalpartType" name="politicalpartType">
                            <option></option>
                            <option>全国</option>
                            <option>省</option>
                            <option>市</option>
                            <option>区</option>
                            <option>校</option>
                        </select>
                    </td>
                    <td>
                        <label>统战团体类别：</label>
                        <select id="unitedpartType" name="unitedpartType">
                            <option></option>
                            <option>全国</option>
                            <option>省</option>
                            <option>市</option>
                            <option>区</option>
                            <option>校</option>
                        </select>
                    </td>
                    <td>
                        <label>政协委员类别：</label>
                        <select id="politicalconsultType" name="politicalconsultType">
                            <option></option>
                            <option>全国</option>
                            <option>省</option>
                            <option>市</option>
                            <option>区</option>
                        </select>
                    </td>
                    <td>
                        <label>人大代表类别：</label>
                        <select id="deputypeopleType" name="deputypeopleTyp">
                            <option></option>
                            <option>全国</option>
                            <option>省</option>
                            <option>市</option>
                            <option>区</option>
                            <option>校</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>留学国家：</label>
                        <select id="studyabroadCountry" name="studyabroadCountry">
                            <option></option>
                            <c:forEach var="studyabroadCountry" items="${studyabroadCountryList}">
                                <option>${studyabroadCountry}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <label>教职工类别：</label>
                        <select id="staffStatus" name="staffStatus">
                            <option></option>
                        </select>
                    </td>
                    <td>
                        <label>所在院系部：</label>
                        <select id="academyLocation" name="academyLocation">
                            <option></option>
                            <c:forEach var="academyLocation" items="${academyLocationList}">
                                <option>${academyLocation}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <label>职务级别：</label>
                        <select id="positionLevel" name="positionLevel">
                            <option></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>聘任职务：</label>
                        <select id="employPosition" name="employPosition">
                            <option></option>
                            <c:forEach var="employPosition" items="${employPositionList}">
                                <option>${employPosition}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <label>岗位级别：</label>
                        <select id="stationLevel" name="stationLevel">
                            <option></option>
                        </select>
                    </td>
                    <td>
                        <label>分级岗位：</label>
                        <select id="stationLevelName" name="stationLevelName">
                            <option></option>
                            <c:forEach var="stationLevelName" items="${stationLevelNameList}">
                                <option>${stationLevelName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <label style="width: 100px">杰出人才：</label>
                        <select id="phenomTitle" name="phenomTitle">
                            <option></option>
                            <c:forEach var="phenomTitle" items="${phenomTitleList}">
                                <option>${phenomTitle}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>党外培养人士<br/>培养类别：</label>
                        <select id="outparttraining" name="outparttraining">
                            <option></option>
                        </select>
                    </td>
                </tr>
            </table>
            <div style="width: 200px;margin:0px auto;">
                <button class="btn btn-primary searchbtn" type="button"onclick="search2()">搜索</button>
            </div>
        </div>
    </div>
    <div id="qwe" style="width:98%;margin: 0px auto;display: none;margin-top: 30px;min-height: 300px">
        <table id="table" class="table table-hover table-bordered tbb">
            <thead>
            <th width="50px">查看</th>
            <th>工号</th>
            <th width="60px">姓名</th>
            <th>性别</th>
            <th width="90px">出生日期</th>
            <th width="60">民族</th>
            <th>政治面貌</th>
            <th style="width: 120px">教职工类别</th>
            <th style="width: 150px">所在院系部</th>
            <th>职务级别</th>
            <th>聘任职务</th>
            <th>岗位级别</th>
            <th>分级岗位</th>
            <%--<th>党外人士培养类别</th>--%>
            <th>删除</th>
            </thead>
            <tbody id="rows">
            </tbody>
        </table>


    </div>

    <jsp:include page="../common/pagination.jsp" flush="true"/>
    <div style="margin-bottom: 20px;">
        <button type="button" class="btn btn-primary btn-sm" onclick="document.getElementById('upload').style.display='block'">导出excel</button>
        <button type="button" class="btn btn-primary btn-sm" onclick="document.getElementById('upload2').submit()">全部导出</button>
        <select style="margin-left: 400px;height: 28px;border-radius: 4px" id="chartCondition">
            <option value="null"></option>
            <option value="birthday5">出生日期(5年)</option>
            <option value="birthday10">出生日期(10年)</option>
            <option value="nation">民族</option>
            <option value="politicalStatus">政治面貌</option>
            <option value="staffStatus">教职工类别</option>
            <option value="employPosition">聘任职务</option>
            <option value="outparttraining">党外人士培养类别</option>
        </select>
        <button style="border-left: 20px" class="btn btn-primary btn-sm w_100" data-toggle="modal" data-target="#chart" onclick="analyse()">分析</button>
    </div>

    <div style="z-index: 100000000" class="modal fade"  id="chart" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
            &times;
        </button>
        <div id='canvasDiv1' style="margin-top: 50px"></div>
        <div id='canvasDiv2' style="display: none;margin-top: 50px"></div>
        <button class="btn btn-info" type="button" onclick="document.getElementById('canvasDiv1').style.display='block';document.getElementById('canvasDiv2').style.display='none';">柱状图</button>
        <button class="btn btn-info" type="button" onclick="document.getElementById('canvasDiv1').style.display='none';document.getElementById('canvasDiv2').style.display='block';">饼状图</button>
    </div>
    <jsp:include page="../common/footer.jsp" flush="true"/>
</div>
<script id="myTemplate" type="text/x-jquery-tmpl">
    <tr>
        <td><a href="javascript:void(0)" onclick="window.open('/person/detail/${'${'}personId}')">查看</a></td>
        <td>${'${'}personId}</td>
        <td>${'${'}name}</td>
        <td>${'${'}sex}</td>
        <td>${'${'}birthday}</td>
        <td>${'${'}nation}</td>
        <td>${'${'}politicalStatus}</td>
        <td>${'${'}staffStatus}</td>
        <td>${'${'}academyLocation}</td>
        <td>${'${'}positionLevel}</td>
        <td>${'${'}employPosition}</td>
        <td>${'${'}stationLevel}</td>
        <td>${'${'}stationLevelName}</td>
        <%--<td>${'${'}outparttraining}</td>--%>
        <td><a href="jvascript:void(0)" onclick="deletePerson('${'${'}personId}')">删除</a></td>
     </tr>
</script>
<div>
    <form id="upload" class="white_content_file" style="margin-left: 150px;display: none" action="/person/excel" method="post" enctype="multipart/form-data">
        <div>
            <input type="hidden" value="123" name="wangsen"/>
            <input type="file" name="file" id="file"><br/><br/>
            <input type="submit" value="上传">
            <input style="margin-left: 80px" type="button" value="关闭" onclick="document.getElementById('upload').style.display='none';document.getElementById('file').value=''">
        </div>
    </form>
    <form id="upload2"style="margin-left: 150px;display: none" action="/person/excel" method="post" enctype="multipart/form-data">
        <input type="text" value="456" name="wangsen"/>
        <input type="file" name="file">
        <input type="submit" value="上传">
    </form>
</div>
</body>
<link href="../../../resources/css/select22.min.css" rel="stylesheet" />
<script src="../../../resources/js/select2.min.js"></script>
<script  src="../../../resources/jquery.tmpl.min.js"></script>
<script src="../../../resources/js/data.js"></script>
<script src="../../../resources/js/dataformat.js"></script>
<script>
    $(document).ready(function () {
        var params={};
        search(params);
        evaluate(params);
        ajaxsearch(1,params);
    });
    $("#sex").select2({
        data: sex,
        placeholder:'请选择',
        allowClear:true
    })
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
    $("#secondPoliticalStatus").select2({
        data: politicalStatus,
        placeholder:'请选择',
        allowClear:true
    })
    $("#staffStatus").select2({
        data:staffStatus,
        placeholder:'请选择',
        allowClear:true
    })
    $("#positionLevel").select2({
        data:positionLevel,
        placeholder:'请选择',
        allowClear:true
    })
    $("#stationLevel").select2({
        data:stationLevel,
        placeholder:'请选择',
        allowClear:true
    })
    $("#outparttraining").select2({
        data:outparttraining,
        placeholder:'请选择',
        allowClear:true
    })
    $("#studyabroadCountry").select2({
        placeholder:'请选择',
        allowClear:true
    })
    $("#academyLocation").select2({
        placeholder:'请选择',
        allowClear:true
    })
    $("#employPosition").select2({
        placeholder:'请选择',
        allowClear:true
    })
    $("#stationLevelName").select2({
        placeholder:'请选择',
        allowClear:true
    })
    $("#phenomTitle").select2({
        placeholder:'请选择',
        allowClear:true
    })
    $("#politicalpartType").select2({
        placeholder:'请选择',
        allowClear:true
    })
    $("#unitedpartType").select2({
        placeholder:'请选择',
        allowClear:true
    })
    $("#politicalconsultType").select2({
        placeholder:'请选择',
        allowClear:true
    })
    $("#deputypeopleType").select2({
        placeholder:'请选择',
        allowClear:true
    })
    function deletePerson(personId) {
        $.ajax({
            async:false,
            type: "GET",
            url: "/person/delete/"+personId,//注意路径
            success:function(data) {
                if(data=="success"){
                    alert("删除成功");
                    params={};
                    evaluate(params);
                    var currentPage=parseInt(document.getElementById("currentPage").innerText);
                    $("#rows").html('');
                    search();
                    ajaxsearch(currentPage,params);
                }else{
                    alert("删除失败");
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
        params.sex=$("#sex").val();
        params.birthdayStart=$("#birthdayStart").val();
        params.birthdayEnd=$("#birthdayEnd").val();
        params.nation=$("#nation").val();
        params.politicalStatus=$("#politicalStatus").val();
        params.secondPoliticalStatus=$("#secondPoliticalStatus").val();
        params.politicalpartType=$("#politicalpartType").val();
        params.unitedpartType=$("#unitedpartType").val();
        params.politicalconsultType=$("#politicalconsultType").val();
        params.deputypeopleType=$("#deputypeopleType").val();
        params.studyabroadCountry=$("#studyabroadCountry").val();
        params.staffStatus=$("#staffStatus").val();
        params.academyLocation=$("#academyLocation").val();
        params.positionLevel=$("#positionLevel").val();
        params.employPosition=$("#employPosition").val();
        params.stationLevel=$("#stationLevel").val();
        params.stationLevelName=$("#stationLevelName").val();
        params.phenomTitle=$("#phenomTitle").val();
        params.outparttraining=$("#outparttraining").val();
    }
    function ajaxsearch(currentPage,params) {
        $.ajax({
            async:false,
            type: "POST",
            url: "/person/select/"+currentPage,//注意路径
            data:params,
            dataType:"json",
            success:function(data) {
                $("#rows").html('');
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
    function search2(){
        params={};
        evaluate(params);
        search(params);
        document.getElementById("currentPage").innerText=1;
        ajaxsearch(1,params);
    }
    function search(params) {
        $("#rows").html('');
        var currentPage=document.getElementById("currentPage").innerText;
        document.getElementById("qwe").style.display="block";
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
    function analyse() {
        var s=$("#sex")
        document.getElementById("chart").style.display="block";
        var params={};
        evaluate(params);
        var chartCondition=$("#chartCondition").val();
        var title;
        var flag=1;
        var height="80%"
        if(chartCondition=="birthday5"){
            title="年龄分布图（5年）";flag=0;
        }else if(chartCondition=="birthday10"){
            title="年龄分布图（10年）";flag=0;
        }else if(chartCondition=="nation"){
            title="民族分布图"
        }else if(chartCondition=="politicalStatus"){
            title="政治面貌分布图"
        }else if(chartCondition=="staffStatus"){
            title="教职工类别分布图"
        }else if(chartCondition=="employPosition"){
            title="聘任职务分布图";
        }else if(chartCondition=="outparttraining") {
            title="党外人士培养类别分布图";
        }
        $.ajax({
            async:false,
            type: "POST",
            url: "/person/chart/"+chartCondition,//注意路径
            data:params,
            dataType:"json",
            success:function(data) {
                var widthchar=parseInt(data.length*70);
                if(widthchar>1200){
                    widthchar=1200;
                }else if(widthchar<500){
                    widthchar=500;
                }
                var color=["#a5c2d5","#cbab4f","#76a871","#9f7961","#a56f8f","#6f83a5","#a56f8f","#c12c44","#3A68D3","#9F2626","#a5c2d5","#cbab4f","#76a871","#9f7961","#a56f8f","#6f83a5","#a56f8f","#c12c44","#3A68D3","#9F2626"];
                var max=0;
                var data2=[];
                var maxN=0;
                for(var i=0;i<data.length;i++){
                    data[i].color=color[i];
                    if(data[i].value>max)
                        max=data[i].value;
                    var property=new Object();
                    property.name='';
                    property.value=data[i].value;
                    property.color=data[i].color;
                    data2.push(property);
                    var s='';
                    var j=0;
                    var temp=0;
                    while(j<data[i].name.length){
                        s+=data[i].name[j];
                        if((j+1)%4==0){
                            s+="\n";
                            temp++;
                        }
                        j++;
                    }
                    if(temp>maxN){
                        maxN=temp;
                    }
                    data2[i].name=s;
                }
                var aver;
                if(max%10==0){
                    aver=max/10;
                }else{
                    aver=parseInt(max/10)+1;
                }
                if(!flag){
                    data2=data;
                }
                if(maxN==1||maxN==2){
                    height='80%';
                }else if(maxN==3||maxN==4){
                    height='70%';
                }
                max=10*aver;
                new iChart.Column2D({
                    render : 'canvasDiv1',
                    data: data2,
                    title : title,
                    width :widthchar,
                    height : 550,
                    coordinate:{
                        height:height,
                        background_color:'#fefefe',
                        scale:[{
                            position:'left',
                            start_scale:0,
                            end_scale:max,
                            scale_space:aver,
                            listeners:{
                                parseText:function(t,x,y){
                                    return {text:t}
                                }
                            }
                        }]
                    }
                }).draw();
                new iChart.Pie2D({
                    render : 'canvasDiv2',
                    data: data,
                    title : title,
                    legend : {
                        enable : true,
                    },
                    width : 1050,
                    height : 550,
                    radius:160
                }).draw();
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

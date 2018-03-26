
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <title>详细信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="../../../resources/js/jquery.min.js"></script>
    <%--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../resources/css/mystylecss.css" rel="stylesheet"/>
</head>
</head>
<body>
<form id="upload" class="white_content_file" style="display: none" action="/person/excelDetail/${person.personId}" method="post" enctype="multipart/form-data">
    <div style="width:200px;margin: 50px auto">
        <input type="file" name="file" id="file"><br/><br/>
        <input style="margin-right: 30px" type="submit" value="上传">
        <input type="button" value="关闭" onclick="document.getElementById('upload').style.display='none';document.getElementById('file').value=''">
    </div>
</form>
<div class="content2">
    <div>
        <jsp:include page="../common/head1.jsp" flush="true"/>
        <ol class="breadcrumb" style="background-color: dodgerblue">
            <li><a style="color: white" href="/person/zggcddy/1">首页</a></li>
            <li style="color: white">详细</li>
            <span><a style="color: white;margin-left: 1120px" href="/user/exit">退出登录</a></span>
        </ol>
    </div>
    <div >
        <div style="padding-left:15px;height: 60px;width: 100%;border-bottom: 1px solid #dddddd">
            <h2>详细信息</h2>
        </div>
        <strong class="text-danger ">${param.message}</strong>
        <jsp:include page="../common/head.jsp" flush="true"></jsp:include>
        <form style="padding-left: 15px" class="form-horizontal J_searchForm" action="/person/updatePerson" method="post">
            <jsp:include page="../common2/main.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/politicalpart.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/unitedpart.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/politicalconsult.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/deputypeople.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/studyabroad.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/phenom.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/training.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/resume.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/family.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/paper.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/book.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/works.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/report.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/reward.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/project.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/patent.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/parttimejob.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/achievement.jsp" flush="true"></jsp:include>
            <jsp:include page="../common2/politicalperformence.jsp" flush="true"></jsp:include>
        </form>
    </div>
</div>
</body>
<link href="../../../resources/css/select2.min.css" rel="stylesheet" />
<script src="../../../resources/js/select2.min.js"></script>
<script src="../../../resources/js/area.js"></script>
<script src="../../../resources/js/data.js"></script>
<script src="../../../resources/js/dispalyhead.js"></script>
<script src="../../../resources/js/select.js"></script>
<script>
    function updatePerson() {
        $(".wangsen").css("display","inline");
        $("select").removeAttr("disabled","disabled");
        $("input").removeAttr("disabled",true);
        document.getElementById("update").style.display="none";
        $(".inputPerson").css("display","inline");
        $(".iPerson").css("display","none");
    }
    $(document).ready(function () {
        display("main");
        $("select").attr("disabled","disabled");
        $("input").attr("disabled","disabled");
        $(".inputPerson").css("display","none");
        $(".wangsen").css("display","none");
        select12();
        _init_area();
    });
    function display(k) {
        for (i in type) {
            if (k == type[i]) {
                document.getElementById(k).style.display = "block";
            }
            else {
                document.getElementById(type[i]).style.display = "none";
            }
        }
    }

</script>
</html>
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
<div class="content2">
    <div>
        <jsp:include page="../common/head1.jsp" flush="true"/>
        <ol class="breadcrumb" style="background-color: dodgerblue">
            <li><a style="color: white" href="/main">首页</a></li>
            <li><a style="color: white" href="/information/addPerson">人员导入</a></li>
            <li style="color: white">详细</li>
            <span><a style="color: white;margin-left: 1040px" href="/user/exit">退出登录</a></span>
        </ol>
    </div>
    <div style="margin-bottom: 40px">
        <div style="padding-left:15px;width:100%;border-bottom: 1px solid #dddddd;height: 60px;">
            <h2 style="display: inline">详细信息</h2>
        </div>
        <jsp:include page="../common/head.jsp" flush="true"></jsp:include>
        <form style="padding-left: 15px;" class="form-horizontal J_searchForm" action="/person/updatePerson" method="post">
            <jsp:include page="../common/main.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/politicalpart.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/unitedpart.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/politicalconsult.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/deputypeople.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/studyabroad.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/phenom.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/training.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/resume.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/family.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/paper.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/book.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/works.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/report.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/reward.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/project.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/patent.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/parttimejob.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/achievement.jsp" flush="true"></jsp:include>
            <jsp:include page="../common/politicalperformence.jsp" flush="true"></jsp:include>
        </form>
    </div>
    <jsp:include page="../common/footer.jsp" flush="true"/>
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
        document.getElementById("confirm").style.display="block";
        document.getElementById("update").style.display="none";
        $(".inputPerson").css("display","inline");
        $(".iPerson").css("display","none");
    }
    $(document).ready(function () {
        display("main");
//        document.getElementById("confirm").style.display="none";
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
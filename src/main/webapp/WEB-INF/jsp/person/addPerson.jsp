
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>添加人员</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>--%>
    <script src="../../../resources/js/jquery.min.js"></script>
    <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../resources/css/mystylecss.css" rel="stylesheet"/>
</head>
</head>
<body>
<div class="content2">
    <div>
        <jsp:include page="../common/head1.jsp" flush="true"/>
        <ol class="breadcrumb" style="background-color:dodgerblue">
            <li><a href="/main" style="color: white">首页</a></li>
            <li style="color:white;">增加</li>
            <span><a style="color: white;margin-left: 1120px" href="/user/exit">退出登录</a></span>
        </ol>
    </div>
    <div>
        <div style="padding-left:15px;width:100%;border-bottom: 1px solid #dddddd;height: 60px;">
            <h2 style="display: inline">添加人员</h2>
            <span style="color:red;font-size: 15px;margin-left: 1000px;">${param.message}</span>
        </div>
        <c:if test="${param.message!=null}">
            <script>alert("${param.message}")</script>
        </c:if>


        <%--<i style="color: red">${param.message}</i>--%>
        <jsp:include page="../common/head.jsp" flush="true"></jsp:include>
        <form id="addSubmit" style="padding-left: 15px;min-height:400px" class="form-horizontal J_searchForm" action="/person/addPerson" method="post">
            <%--简介--%>
            <jsp:include page="../common/main.jsp" flush="true"/>
            <%--民主党派职务--%>
            <jsp:include page="../common/politicalpart.jsp" flush="true"/>
            <%--统战团体职务--%>
            <jsp:include page="../common/unitedpart.jsp" flush="true"/>
            <%--政协委员--%>
                <jsp:include page="../common/politicalconsult.jsp" flush="true"/>
             <%--人大代表--%>
                <jsp:include page="../common/deputypeople.jsp" flush="true"/>
            <%--留学情况--%>
                <jsp:include page="../common/studyabroad.jsp" flush="true"/>
             <%--杰出人才--%>
                <jsp:include page="../common/phenom.jsp" flush="true"/>
            <%--参加政治理论培训或学习情况--%>
                <jsp:include page="../common/training.jsp" flush="true"/>
             <%--简历--%>
                <jsp:include page="../common/resume.jsp" flush="true"/>
             <%--家庭成员--%>
                <jsp:include page="../common/family.jsp" flush="true"/>
             <%--论文--%>
                <jsp:include page="../common/paper.jsp" flush="true"/>
             <%--著作--%>
                <jsp:include page="../common/book.jsp" flush="true"/>
             <%--作品--%>
                <jsp:include page="../common/works.jsp" flush="true"/>
             <%--报告--%>
                <jsp:include page="../common/report.jsp" flush="true"/>
             <%--获奖--%>
                <jsp:include page="../common/reward.jsp" flush="true"/>
             <%--项目--%>
                <jsp:include page="../common/project.jsp" flush="true"/>
             <%--专利--%>
                <jsp:include page="../common/patent.jsp" flush="true"/>
             <%--主要社会兼职--%>
                <jsp:include page="../common/parttimejob.jsp" flush="true"/>
             <%--主要成就和社会影响--%>
                <jsp:include page="../common/achievement.jsp" flush="true"/>
             <%--主要政治表现--%>
                <jsp:include page="../common/politicalperformence.jsp" flush="true"/>
            <div style="margin-left: 1150px;margin-bottom: 30px">
                <button class="btn-primary btn w_100" type="button" onclick="addSubmit()">提交</button>
            </div>
        </form>
    </div>
    <jsp:include page="../common/footer.jsp" flush="true"/>
</div>
</body>
<link href="../../../resources/css/select2.min.css" rel="stylesheet" />
<script src="../../../resources/js/select2.min.js"></script>
<script src="../../../resources/js/area.js"></script>
<script src="../../../resources/js/addoption.js"></script>
<script src="../../../resources/js/data.js"></script>
<script src="../../../resources/js/dispalyhead.js"></script>
<script src="../../../resources/js/select.js"></script>
<script>
    $(document).ready(function () {
        display("main");
        select12();
        _init_area();
    });

</script>
</html>
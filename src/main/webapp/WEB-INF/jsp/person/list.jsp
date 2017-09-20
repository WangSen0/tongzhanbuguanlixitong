<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/18
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../../resources/css/mystylecss.css"/>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
    </script>
    <script>
        $(document).ready(function () {
            $("#excel").click(function () {
                var params = {};
                //params.XX必须与Spring Mvc controller中的参数名称一致
                //否则在controller中使用@RequestParam绑定
                params.id =1 ;
                params.name = "2";
                params.password = "3";
                $.ajax({
                    async:false,
                    type: "POST",
                    url: "/person/excel",//注意路径
                    data:params,
                    dataType:"json",
                    success:function(data){

                            alert( data.code );
                    },
                    error:function(data){

                            alert( "出错"+data.code);
                    }
                });

            });
        });
    </script>
    <title>list</title>
</head>
<body>
<div>
    <jsp:include page="../main.jsp"></jsp:include>
</div>
<div>
    <table>
        <tr>
            <thead>ID</thead>
            <thead>姓名</thead>
            <thead>性别</thead>
            <thead>生日</thead>
            <thead>民族</thead>
            <thead>党派</thead>
            <thead>职称</thead>
        </tr>
        <c:forEach var="person" items="${persons}">
            <tr>
                <td>${person.id}</td>
                <td>${person.name}</td>
                <td>${person.sex}</td>
                <td>${person.birthday}</td>
                <td>${person.nation}</td>
                <td>${person.part}</td>
                <td>${person.title}</td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${persons!=null}">
        <a href="/person/list/${currentPage-1}">上一页</a><a href="/person/list/${currentPage+1}">下一页</a><br/>
        <a id="excel">导出Excel</a>
    </c:if>
    <button id="button">123</button>
</div>
</body>
</html>

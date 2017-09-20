<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/17
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../../resources/css/mystylecss.css"/>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
    </script>
    <script>
        $(document).ready(function () {
            $("#search").click(function () {
                var params = {};
                //params.XX必须与Spring Mvc controller中的参数名称一致
                //否则在controller中使用@RequestParam绑定
                params.name =$("#name").val();
                params.sex = $("#sex").val();
                params.time1 = $("#time1").val();
                params.time2=$("#time2").val();
                params.nation=$("#nation").val();
                params.part=$("#part").val();
                params.title=$("#title").val();
                $.ajax({
                    async:false,
                    type: "POST",
                    url: "/person/select/1",//注意路径
                    data:params,
                    dataType:"json",
                    success:function(data) {
                        var div = document.getElementById("table");
                        var a = document.createElement("table");
                        var table = "<table border = '1px'>";
                        for (var i = 0; i < 10; i++) {
                            table += "<tr>";
                            table += "<td>"+data[i].id+"</td>";
                            table += "<td>"+data[i].name+"</td>";
                            table += "<td>"+data[i].sex+"</td>";
                            table += "<td>"+data[i].birthday+"</td>";
                            table += "<td>"+data[i].nation+"</td>";
                            table += "<td>"+data[i].part+"</td>";
                            table += "<td>"+data[i].title+"</td>";
                            table += "</tr>";
                        }table += "</table>";
                        div.innerHTML=table;
                    },
                    error:function(data){

                        alert( "出错"+data.code);
                    }
                });

            });
        });
    </script>
    <title>select</title>
</head>
<body>
<div>
    <jsp:include page="../main.jsp"></jsp:include>
</div>
<div>

        姓名：<select id="name">
                <option value=""></option>
                <c:forEach var="name" items="${names}">
                    <option value="${name}">${name}</option>
                </c:forEach>
               </select><br/>
        性别：<select id="sex">
                <option value=""></option>
                <option value="男">男</option>
                 <option value="女">女</option>
              </select><br/>
        出生年月：<input type="date" id="time1"/>--<input type="date" id="time2"/><br/>
        民族：<input id="nation" type="text"/><br/>
        党派：<input id="part" type="text"/><br/>
        职称：<input id="title" type="text"/><br/>
        <input id="search" type="button" value="搜索"/><br/>
        <div id="table">
        </div>
</div>
</body>
</html>

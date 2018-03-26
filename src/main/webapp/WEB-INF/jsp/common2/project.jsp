<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="project">
    <h4 class="margin_50_0">项目</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="projectTable">
            <thead class="v-center">
            <tr>
                <th>项目名称</th><th>项目级别</th><th>项目经费</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.projectList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.projectTitle}</i><input class="inputPerson w_300" type="text" value="${item.projectTitle}" name="projectList[${status.index}].projectTitle"></td>
                    <td><i class="iPerson">${item.projectLevel}</i><input class="inputPerson w_300" type="text" value="${item.projectLevel}" name="projectList[${status.index}].projectLevel"></td>
                    <td><i class="iPerson">${item.projectOutlay}</i><input class="inputPerson w_300" type="text" value="${item.projectOutlay}" name="projectList[${status.index}].projectOutlay"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="projectList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('projectLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.projectList.size()>0}">
                <input type="hidden" id="projectCount" value="${person.projectList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="projectCount" value="0"/>
            </c:otherwise>
        </c:choose>
        <input type="hidden" value="0" id="projectCount"/>
    </div>
    <div id="projectLight" class="white_content">
        <div class="rows" style="margin-top: 50px">
            <label class="col-sm-4">项目名称：</label>
            <input class="col-sm-6" type="text" id="projectTitle"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">项目级别：</label>
            <input class="col-sm-6" type="text" id="projectLevel"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">项目经费：</label>
            <input class="col-sm-6" type="text" id="projectOutlay" placeholder="请输入小数"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('project')"/> <input type="button" value="关闭" onclick="closee('project')"/>
        </div>
    </div>
</div>

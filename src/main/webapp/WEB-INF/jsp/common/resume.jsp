<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="resume">
    <h4 class="margin_50_0">简历</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="resumeTable">
            <thead class="v-center">
            <tr>
                <th>开始时间</th><th>结束时间</th><th>内容</th><th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.resumeList}" varStatus="status">
                <tr>
                    <td><i class="iPerson"><fmt:formatDate value="${item.resumeStartTime}" pattern="yyyy-MM-dd"/></i><input class="inputPerson w_300" type="text" value="<fmt:formatDate value="${item.resumeStartTime}" pattern="yyyy-MM-dd"/>" name="resumeList[${status.index}].resumeStartTime"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.resumeEndTime}" pattern="yyyy-MM-dd"/></i><input class="inputPerson w_300" type="text" value="<fmt:formatDate value="${item.resumeEndTime}" pattern="yyyy-MM-dd"/>" name="resumeList[${status.index}].resumeEndTime"> </td>
                    <td><i class="iPerson">${item.resumeContent}</i><input class="inputPerson w_500" type="text" value="${item.resumeContent}" name="resumeList[${status.index}].resumeContent"></td>
                    <td><input class="inputPerson" type="button" value="删除" onclick="removeRow(this.parentNode.parentNode)"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="resumeList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('resumeLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.resumeList.size()>0}">
                <input type="hidden" id="resumeCount" value="${person.resumeList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="resumeCount" value="0"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="resumeLight" class="white_content" >
        <div class="rows" style="margin-top: 50px">
            <label class="col-sm-4">开始时间：</label>
            <input class="col-sm-6" type="date" id="resumeStartTime"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">结束时间：</label>
            <input class="col-sm-6" type="date" id="resumeEndTime"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">内容：</label>
            <input class="col-sm-6" type="text" id="resumeContent"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('resume')"/> <input type="button" value="关闭" onclick="closee('resume')"/>
        </div>
    </div>
</div>

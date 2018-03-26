<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="training">
    <h4 class="margin_50_0">参加政治理论培训或学习情况</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="trainingTable">
            <thead class="v-center">
            <tr>
                <th>培训地点</th><th>培训单位</th><th>培训内容</th><th>开始时间</th><th>结束日期</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.trainingList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.trainingPlace}</i><input class="inputPerson" type="text" value="${item.trainingPlace}" name="trainingList[${status.index}].trainingPlace"></td>
                    <td><i class="iPerson">${item.trainingCompany}</i><input class="inputPerson" type="text" value="${item.trainingCompany}" name="trainingList[${status.index}].trainingCompany"></td>
                    <td><i class="iPerson">${item.trainingContent}</i><input class="inputPerson" type="text" value="${item.trainingContent}" name="trainingList[${status.index}].trainingContent"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.trainingStartTime}" pattern="yyyy-MM-dd"/></i><input class="inputPerson" type="text" value="<fmt:formatDate value="${item.trainingStartTime}" pattern="yyyy-MM-dd"/>" name="trainingList[${status.index}].trainingStartTime"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.trainingEndTime}" pattern="yyyy-MM-dd"/></i><input class="inputPerson" type="text" value="<fmt:formatDate value="${item.trainingEndTime}" pattern="yyyy-MM-dd"/>" name="trainingList[${status.index}].trainingEndTime"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="trainingList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('trainingLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.trainingList.size()>0}">
                <input type="hidden" id="trainingCount" value="${person.trainingList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="trainingCount" value="0"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="trainingLight" class="white_content">
        <div class="rows" style="margin-top: 30px">
            <label class="col-sm-4">地点：</label>
            <input class="col-sm-6" type="text" id="trainingPlace"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">单位：</label>
            <input class="col-sm-6" type="text" id="trainingCompany"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">内容：</label>
            <input class="col-sm-6" type="text" id="trainingContent"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">开始日期：</label>
            <input class="col-sm-6" type="date" id="trainingStartTime"/>
        </div>
        <div class="rows">
            <label class="col-sm-4"> 结束日期：</label>
            <input class="col-sm-6" type="date" id="trainingEndTime"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('training')"/> <input type="button" value="关闭" onclick="closee('training')"/>
        </div>
    </div>
</div>

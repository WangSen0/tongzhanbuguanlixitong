<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="report">
    <h4 class="margin_50_0">报告</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="reportTable">
            <thead class="v-center">
            <tr>
                <th>报告题目</th><th>所属单位</th><th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.reportList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.reportTitle}</i><input class="inputPerson w_500" type="text" value="${item.reportTitle}" name="reportList[${status.index}].reportTitle"></td>
                    <td><i class="iPerson">${item.reportBelong}</i><input class="inputPerson w_500" type="text" value="${item.reportBelong}" name="reportList[${status.index}].reportBelong"></td>
                    <td><input class="inputPerson" type="button" value="删除" onclick="removeRow(this.parentNode.parentNode)"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="reportList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('reportLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.reportList.size()>0}">
                <input type="hidden" id="reportCount" value="${person.reportList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="reportCount" value="0"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="reportLight" class="white_content">
        <div class="rows" style="margin-top: 50px">
            <label class="col-sm-4">报告题目</label>
            <input class="col-sm-6" type="text" id="reportTitle"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">所属单位</label>
            <input class="col-sm-6" type="text" id="reportBelong"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('report')"/> <input type="button" value="关闭" onclick="closee('report')"/>
        </div>
    </div>
</div>

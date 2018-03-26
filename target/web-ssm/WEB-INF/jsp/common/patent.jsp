<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="patent">
    <h4 class="margin_50_0">专利</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="patentTable">
            <thead class="v-center">
            <tr>
                <th>专利名称</th><th>专利类型</th><th>专利权人</th><th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.patentList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.patentTitle}</i><input class="inputPerson w_300" type="text" value="${item.patentTitle}" name="patentList[${status.index}].patentTitle"/></td>
                    <td><i class="iPerson">${item.patentType}</i><input class="inputPerson w_300" type="text" value="${item.patentType}" name="patentList[${status.index}].patentType"/></td>
                    <td><i class="iPerson">${item.patentAuthor}</i><input class="inputPerson w_300" type="text" value="${item.patentAuthor}" name="patentList[${status.index}].patentAuthor"></td>
                    <td><input class="inputPerson" type="button" value="删除" onclick="removeRow(this.parentNode.parentNode)"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="patentList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('patentLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.patentList.size()>0}">
                <input type="hidden" id="patentCount" value="${person.patentList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="patentCount" value="0"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="patentLight" class="white_content">
        <div class="rows" style="margin-top: 50px">
            <label class="col-sm-4">专利名称：</label>
            <input class="col-sm-6" type="text" id="patentTitle"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">专利类型：</label>
            <input class="col-sm-6" type="text" id="patentType"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">专利权人：</label>
            <input class="col-sm-6" type="text" id="patentAuthor"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('patent')"/> <input type="button" value="关闭" onclick="closee('patent')"/>
        </div>
    </div>
</div>

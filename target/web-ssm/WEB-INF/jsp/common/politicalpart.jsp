<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="politicalpart">
    <h4 class="margin_50_0">民主党派职务</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="politicalpartTable">
            <thead class="v-center">
            <tr>
                <th>全国</th><th>省</th><th>市</th><th>区</th><th>校</th><th>届数</th><th>职务</th><th>开始时间</th><th>结束时间</th><th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.politicalpartList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.politicalpartCountry}</i><input class="inputPerson w_100" type="text" value="${item.politicalpartCountry}" name="politicalpartList[${status.index}].politicalpartCountry"></td>
                    <td><i class="iPerson">${item.politicalpartProvince}</i><input class="inputPerson w_100" type="text" value="${item.politicalpartProvince}" name="politicalpartList[${status.index}].politicalpartProvince"></td>
                    <td><i class="iPerson">${item.politicalpartCity}</i><input class="inputPerson w_100" type="text" value="${item.politicalpartCity}" name="politicalpartList[${status.index}].politicalpartCity"/></td>
                    <td><i class="iPerson">${item.politicalpartCounty}</i><input class="inputPerson w_100" type="text" value="${item.politicalpartCounty}" name="politicalpartList[${status.index}].politicalpartCounty"></td>
                    <td><i class="iPerson">${item.politicalpartSchool}</i><input class="inputPerson w_100" type="text" value="${item.politicalpartSchool}" name="politicalpartList[${status.index}].politicalpartSchool"></td>
                    <td><i class="iPerson">${item.politicalpartTimes}</i><input class="inputPerson w_100" type="text" value="${item.politicalpartTimes}" name="politicalpartList[${status.index}].politicalpartTimes"></td>
                    <td><i class="iPerson">${item.politicalpartPosition}</i><input class="inputPerson w_100" type="text" value="${item.politicalpartPosition}" name="politicalpartList[${status.index}].politicalpartPosition"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.politicalpartStartTime}" pattern="yyyy-MM-dd"/> </i><input class="inputPerson w_100" type="text" value="<fmt:formatDate value="${item.politicalpartStartTime}" pattern="yyyy-MM-dd"/>" name="politicalpartList[${status.index}].politicalpartStartTime"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.politicalpartEndTime}" pattern="yyyy-MM-dd"/> </i><input class="inputPerson w_100" type="text" value="<fmt:formatDate value="${item.politicalpartEndTime}" pattern="yyyy-MM-dd"/> " name="politicalpartList[${status.index}].politicalpartEndTime"></td>
                    <td><input class="inputPerson" type="button" value="删除" onclick="removeRow(this.parentNode.parentNode)"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="politicalpartList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('politicalpartLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.politicalpartList.size()>0}">
                <input type="hidden" id="politicalpartCount" value="${person.politicalpartList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="politicalpartCount" value="0"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="politicalpartLight" class="white_content">
        <div class="rows" style="margin-top: 15px">
            <label>国家：</label>
            <input type="text" id="politicalpartCountry"/>
        </div>
        <div class="rows">
            <label>省：</label>
            <select id="politicalpartProvince"></select> 
        </div>
        <div class="rows">
            <label>市：</label>
            <select id="politicalpartCity"></select>
        </div>
        <div class="rows">
            <label>区：</label>
            <select id="politicalpartCounty"></select>
        </div>
        <div class="rows">
            <label>校：</label>
            <input type="text" id="politicalpartSchool"/>
        </div>
        <div class="rows">
            <label>届数：</label>
            <input type="text" id="politicalpartTimes" placeholder="请输入数字"/>
        </div>
        <div class="rows">
            <label>职务：</label>
            <input type="text" id="politicalpartPosition"/>
        </div>
        <div class="rows">
            <label>开始时间：</label>
            <input type="date" id="politicalpartStartTime"/>
        </div>
        <div class="rows">
            <label>结束时间：</label>
            <input type="date" id="politicalpartEndTime"/>
        </div>
        <div class="lastrows">
             <input type="button" value="确定" onclick="addd('politicalpart')"/> <input type="button" value="关闭" onclick="closee('politicalpart')"/>
        </div>
    </div>
</div>
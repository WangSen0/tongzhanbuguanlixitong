<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/20
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="unitedpart">
    <h4 class="margin_50_0">统战团体职务</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="unitedpartTable">
            <thead class="v-center">
            <tr>
                <th>全国</th><th>省</th><th>市</th><th>区</th><th>校</th><th>届数</th><th>职务</th><th>开始时间</th><th>结束时间</th><th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.unitedpartList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.unitedpartCountry}</i><input class="inputPerson w_100" type="text" value="${item.unitedpartCountry}" name="unitedpartList[${status.index}].unitedpartCountry"></td>
                    <td><i class="iPerson">${item.unitedpartProvince}</i><input class="inputPerson w_100" type="text" value="${item.unitedpartProvince}" name="unitedpartList[${status.index}].unitedpartProvince"></td>
                    <td><i class="iPerson">${item.unitedpartCity}</i><input class="inputPerson w_100" type="text" value="${item.unitedpartCity}" name="unitedpartList[${status.index}].unitedpartCity"></td>
                    <td><i class="iPerson">${item.unitedpartCounty}</i><input class="inputPerson w_100" type="text" value="${item.unitedpartCounty}" name="unitedpartList[${status.index}].unitedpartCounty"></td>
                    <td><i class="iPerson">${item.unitedpartSchool}</i><input class="inputPerson w_100" type="text" value="${item.unitedpartSchool}" name="unitedpartList[${status.index}].unitedpartSchool"></td>
                    <td><i class="iPerson">${item.unitedpartTimes}</i><input class="inputPerson w_100" type="text" value="${item.unitedpartTimes}" name="unitedpartList[${status.index}].unitedpartTimes"></td>
                    <td><i class="iPerson">${item.unitedpartPosition}</i><input class="inputPerson w_100" type="text" value="${item.unitedpartPosition}" name="unitedpartList[${status.index}].unitedpartPosition"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.unitedpartStartTime}" pattern="yyyy-MM-dd"/></i><input class="inputPerson w_100" type="text" value="<fmt:formatDate value="${item.unitedpartStartTime}" pattern="yyyy-MM-dd"/>" name="unitedpartList[${status.index}].unitedpartStartTime"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.unitedpartEndTime}" pattern="yyyy-MM-dd" /></i><input class="inputPerson w_100" type="text" value="<fmt:formatDate value="${item.unitedpartEndTime}" pattern="yyyy-MM-dd" />" name="unitedpartList[${status.index}].unitedpartEndTime"></td>
                    <td><input class="inputPerson" type="button" value="删除" onclick="removeRow(this.parentNode.parentNode)"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="unitedpartList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('unitedpartLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.unitedpartList.size()>0}">
                <input type="hidden" id="unitedpartCount" value="${person.unitedpartList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="unitedpartCount" value="0"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="unitedpartLight" class="white_content">
        <div class="rows" style="margin-top: 20px">
            <label class="col-sm-4">国家：</label>
            <input class="col-sm-6" type="text" id="unitedpartCountry"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">省：</label>
            <select class="col-sm-6" id="unitedpartProvince"></select>
        </div>
        <div class="rows">
            <label class="col-sm-4">市：</label>
            <select class="col-sm-6" id="unitedpartCity"></select>
        </div>
        <div class="rows">
            <label class="col-sm-4">区：</label>
            <select class="col-sm-6" id="unitedpartCounty"></select>
        </div>
        <div class="rows">
            <label class="col-sm-4">校：</label>
            <input class="col-sm-6" type="text" id="unitedpartSchool"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">届数：</label>
            <input class="col-sm-6" type="text" id="unitedpartTimes" placeholder="请输入数字"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">职务：</label>
            <input class="col-sm-6" type="text" id="unitedpartPosition"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">开始时间：</label>
            <input class="col-sm-6" type="date" id="unitedpartStartTime"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">结束时间：</label>
            <input class="col-sm-6" type="date" id="unitedpartEndTime"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('unitedpart')"/> <input type="button" value="关闭" onclick="closee('unitedpart')"/>
        </div>
    </div>
</div>

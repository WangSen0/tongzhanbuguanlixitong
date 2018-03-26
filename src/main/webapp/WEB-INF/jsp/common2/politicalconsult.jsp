<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/20
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="politicalconsult">
    <h4 class="margin_50_0">政协委员</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="politicalconsultTable">
            <thead class="v-center">
            <tr>
                <th>全国</th><th>省</th><th>市</th><th>区</th><th>届数</th><th>开始时间</th><th>结束时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.politicalconsultList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.politicalconsultCountry}</i><input class="inputPerson w_100" type="text" value="${item.politicalconsultCountry}" name="politicalconsultList[${status.index}].politicalconsultCountry"></td>
                    <td><i class="iPerson">${item.politicalconsultProvince}</i><input class="inputPerson w_100" type="text" value="${item.politicalconsultProvince}"  name="politicalconsultList[${status.index}].politicalconsultProvince"></td>
                    <td><i class="iPerson">${item.politicalconsultCity}</i><input class="inputPerson w_100" type="text" value="${item.politicalconsultCity}"  name="politicalconsultList[${status.index}].politicalconsultCity"></td>
                    <td><i class="iPerson">${item.politicalconsultCounty}</i><input class="inputPerson w_100" type="text" value="${item.politicalconsultCounty}"  name="politicalconsultList[${status.index}].politicalconsultCounty"></td>
                    <td><i class="iPerson">${item.politicalconsultTimes}</i><input class="inputPerson w_100" type="text" value="${item.politicalconsultTimes}"  name="politicalconsultList[${status.index}].politicalconsultTimes"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.politicalconsultStartTime}" pattern="yyyy-MM-dd"/></i><input class="inputPerson w_100" type="date" value="<fmt:formatDate value="${item.politicalconsultStartTime}" pattern="yyyy-MM-dd"/>"  name="politicalconsultList[${status.index}].politicalconsultStartTime"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.politicalconsultEndTime}" pattern="yyyy-MM-dd"/></i><input class="inputPerson w_100" type="date" value="<fmt:formatDate value="${item.politicalconsultEndTime}" pattern="yyyy-MM-dd"/>"  name="politicalconsultList[${status.index}].politicalconsultEndTime"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="politicalconsultList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('politicalconsultLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.politicalconsultList.size()>0}">
                <input type="hidden" id="politicalconsultCount" value="${person.politicalconsultList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="politicalconsultCount" value="0"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="politicalconsultLight" class="white_content">
        <div class="rows" style="margin-top: 20px">
            <label class="col-sm-4">国家：</label>
            <input class="col-sm-6" type="text" id="politicalconsultCountry"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">省：</label>
            <select class="col-sm-6" id="politicalconsultProvince"></select>
        </div>
        <div class="rows">
            <label class="col-sm-4">市：</label>
            <select class="col-sm-6" id="politicalconsultCity"></select>
        </div>
        <div class="rows">
            <label class="col-sm-4">区：</label>
            <select class="col-sm-6" id="politicalconsultCounty"></select>
        </div>
        <div class="rows">
            <label class="col-sm-4">届数：</label>
            <input class="col-sm-6" type="text" id="politicalconsultTimes" placeholder="请输入数字"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">开始时间：</label>
            <input class="col-sm-6" type="date" id="politicalconsultStartTime"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">结束时间：</label>
            <input class="col-sm-6" type="date" id="politicalconsultEndTime"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('politicalconsult')"/> <input type="button" value="关闭" onclick="closee('politicalconsult')"/>
        </div>
    </div>
</div>

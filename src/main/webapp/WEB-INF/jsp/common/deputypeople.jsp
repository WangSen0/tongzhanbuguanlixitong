<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/20
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="deputypeople">
    <h4 class="margin_50_0">人大代表</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="deputypeopleTable">
            <thead class="v-center">
            <tr>
                <th>全国</th><th>省</th><th>市</th><th>区</th><th>届数</th><th>开始时间</th><th>结束时间</th><th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.deputypeopleList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.deputypeopleCountry}</i> <input class="inputPerson w_100" type="text" value="${item.deputypeopleCountry}" name="deputypeopleList[${status.index}].deputypeopleCountry"></td>
                    <td><i class="iPerson">${item.deputypeopleProvince}</i><input class="inputPerson w_100" type="text" value="${item.deputypeopleProvince}" name="deputypeopleList[${status.index}].deputypeopleProvinc"></td>
                    <td><i class="iPerson">${item.deputypeopleCity}</i><input class="inputPerson w_100" type="text" value="${item.deputypeopleCity}" name="deputypeopleList[${status.index}].deputypeopleCity"></td>
                    <td><i class="iPerson">${item.deputypeopleCounty}</i><input class="inputPerson w_100" type="text" value="${item.deputypeopleCounty}" name="deputypeopleList[${status.index}].deputypeopleCounty"></td>
                    <td><i class="iPerson">${item.deputypeopleTimes}</i><input class="inputPerson w_100" type="text" value="${item.deputypeopleTimes}" name="deputypeopleList[${status.index}].deputypeopleTimes"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.deputypeopleStartTime}" pattern="yyyy-MM-dd"/></i><input class="inputPerson w_100" type="text" value="<fmt:formatDate value="${item.deputypeopleStartTime}" pattern="yyyy-MM-dd"/>" name="deputypeopleList[${status.index}].deputypeopleStartTime"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.deputypeopleEndTime}" pattern="yyyy-MM-dd"/></i><input class="inputPerson w_100" type="text" value="<fmt:formatDate value="${item.deputypeopleEndTime}" pattern="yyyy-MM-dd"/>" name="deputypeopleList[${status.index}].deputypeopleEndTime"></td>
                    <td><input class="inputPerson" type="button" value="删除" onclick="removeRow(this.parentNode.parentNode)"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="deputypeopleList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('deputypeopleLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.deputypeopleList.size()>0}">
                <input type="hidden" id="deputypeopleCount" value="${person.deputypeopleList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="deputypeopleCount" value="0"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="deputypeopleLight" class="white_content">
        <div class="rows" style="margin-top: 20px">
            <label class="col-sm-4">国家：</label>
            <input class="col-sm-6" type="text" id="deputypeopleCountry"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">省：</label>
            <select class="col-sm-6" id="deputypeopleProvince"></select>
        </div>
        <div class="rows">
            <label class="col-sm-4">市：</label>
            <select class="col-sm-6" id="deputypeopleCity"></select>
        </div>
        <div class="rows">
            <label class="col-sm-4">区：</label>
            <select class="col-sm-6" id="deputypeopleCounty"></select>
        </div>
        <div class="rows">
            <label class="col-sm-4">届数：</label>
            <input class="col-sm-6" type="text" id="deputypeopleTimes" placeholder="请输入数字"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">开始时间：</label>
            <input class="col-sm-6" type="date" id="deputypeopleStartTime"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">结束时间：</label>
            <input class="col-sm-6" type="date" id="deputypeopleEndTime"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('deputypeople')"/> <input type="button" value="关闭" onclick="closee('deputypeople')"/>
        </div>
    </div>
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="phenom">
    <h4 class="margin_50_0">杰出人才</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="phenomTable">
            <thead class="v-center">
            <tr>
                <th>称号</th><th>开始时间</th><th>截至日期</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.phenomList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.phenomTitle}</i><input class="inputPerson w_300" type="text" value="${item.phenomTitle}" name="phenomList[${status.index}].phenomTitle"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.phenomStartTime}" pattern="yyyy-MM-dd"/></i><input class="inputPerson w_300" type="text" value="<fmt:formatDate value="${item.phenomStartTime}" pattern="yyyy-MM-dd"/>"  name="phenomList[${status.index}].phenomStartTime"/></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.phenomEndTime}" pattern="yyyy-MM-dd"/></i><input class="inputPerson w_300" type="text" value="<fmt:formatDate value="${item.phenomEndTime}" pattern="yyyy-MM-dd"/>"  name="phenomList[${status.index}].phenomEndTime"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="phenomList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('phenomLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.phenomList.size()>0}">
                <input type="hidden" id="phenomCount" value="${person.phenomList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="phenomCount" value="0"/>
            </c:otherwise>
        </c:choose>
        <input type="hidden" value="0" id="phenomCount"/>
    </div>
    <div id="phenomLight" class="white_content">
        <div class="rows" style="margin-top: 50px">
            <label class="col-sm-4">称号：</label>
            <input class="col-sm-6" type="text" id="phenomTitle"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">开始时间：</label>
            <input class="col-sm-6" type="date" id="phenomStartTime"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">截止日期：</label>
            <input class="col-sm-6" type="date" id="phenomEndTime"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('phenom')"/> <input type="button" value="关闭" onclick="closee('phenom')"/>
        </div>
    </div>
</div>

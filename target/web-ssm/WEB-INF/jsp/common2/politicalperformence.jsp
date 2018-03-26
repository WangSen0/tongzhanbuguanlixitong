<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="politicalperformence">
    <h4 class="margin_50_0">主要政治表现</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="politicalperformenceTable">
            <thead class="v-center">
            <tr>
                <th>内容</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.politicalperformenceList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.politicalperformenceContent}</i><input class="inputPerson w_500" type="text" value="${item.politicalperformenceContent}" name="politicalperformenceList[${status.index}].politicalperformenceContent"/></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="politicalperformenceList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('politicalperformenceLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.politicalperformenceList.size()>0}">
                <input type="hidden" id="politicalperformenceCount" value="${person.politicalperformenceList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="politicalperformenceCount" value="0"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="politicalperformenceLight" class="white_content">
        <div class="rows2" style="margin-top: 50px">
            <label class="col-sm-4">内容：</label>
            <textarea class="w_200" id="politicalperformenceContent"></textarea>
            <%--<input type="text" id="politicalperformenceContent"/>--%>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('politicalperformence')"/> <input type="button" value="关闭" onclick="closee('politicalperformence')"/>
        </div>
    </div>
</div>

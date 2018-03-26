<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="display: none" id="achievement">
    <h4 class="margin_50_0">主要成就和社会影响</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="achievementTable">
            <thead class="v-center">
            <tr>
                <th>内容</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.achievementList}" varStatus="status">
                <tr>
                    <td style="width: 70%"><i class="iPerson">${item.achievementContent}</i><input class="inputPerson w_600" type="text" value="${item.achievementContent}" name="achievementList[${status.index}].achievementContent"/></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="achievementList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('achievementLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.achievementList.size()>0}">
                <input type="hidden" id="achievementCount" value="${person.achievementList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="achievementCount" value="0"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="achievementLight" class="white_content">
        <div class="rows2" style="margin-top: 50px">
            <label class="col-sm-4">内容：</label>
            <textarea class="w_200" id="achievementContent"></textarea>
            <%--<input class="col-sm-6" type="text" id="achievementContent"/>--%>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('achievement')"/>
            <input type="button" value="关闭" onclick="closee('achievement')"/>
        </div>
    </div>
</div>

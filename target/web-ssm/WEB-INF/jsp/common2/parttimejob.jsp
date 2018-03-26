<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="parttimejob">
    <h4 class="margin_50_0">主要社会兼职</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="parttimejobTable">
            <thead class="v-center">
            <tr>
                <th>内容</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.parttimejobList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.parttimejobContent}</i><input class="inputPerson w_500" type="text" value="${item.parttimejobContent}" name="parttimejobList[${status.index}].parttimejobContent"/></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="parttimejobList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('parttimejobLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.parttimejobList.size()>0}">
                <input type="hidden" id="parttimejobCount" value="${person.parttimejobList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="parttimejobCount" value="0"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="parttimejobLight" class="white_content">
        <div class="rows2" style="margin-top: 50px">
                <label class="col-sm-4">内容：</label>
                <textarea class="w_200"  id="parttimejobContent"></textarea>

            <%--<input class="col-sm-6" type="text" id="parttimejobContent"/>--%>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('parttimejob')"/> <input type="button" value="关闭" onclick="closee('parttimejob')"/>
        </div>
    </div>
</div>

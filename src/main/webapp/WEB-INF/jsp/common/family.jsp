<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="family">
    <h4 class="margin_50_0">家庭成员</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="familyTable">
            <thead>
            <tr>
                <th>关系</th><th>姓名</th><th>出生日期</th><th>政治面貌</th><th>所在单位</th><th>职位</th><th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.familyList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.familyRelation}</i><input class="inputPerson" type="text" value="${item.familyRelation}" name="familyList[${status.index}].familyRelation"></td>
                    <td><i class="iPerson">${item.familyName}</i><input class="inputPerson" type="text" value="${item.familyName}" name="familyList[${status.index}].familyName"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.familyBirthday}" pattern="yyyy-MM-dd"/></i><input class="inputPerson" type="text" value="<fmt:formatDate value="${item.familyBirthday}" pattern="yyyy-MM-dd"/>" name="familyList[${status.index}].familyBirthday"></td>
                    <td><i class="iPerson">${item.familyPoliticalStatus}</i><input class="inputPerson" type="text" value="${item.familyPoliticalStatus}" name="familyList[${status.index}].familyPoliticalStatus"></td>
                    <td><i class="iPerson">${item.familyCompany}</i><input class="inputPerson" type="text" value="${item.familyCompany}" name="familyList[${status.index}].familyCompany"></td>
                    <td><i class="iPerson">${item.familyPosition}</i><input class="inputPerson" type="text" value="${item.familyPosition}" name="familyList[${status.index}].familyPosition"></td>
                    <td><input class="inputPerson" type="button" value="删除" onclick="removeRow(this.parentNode.parentNode)"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="familyList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('familyLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.familyList.size()>0}">
                <input type="hidden" id="familyCount" value="${person.familyList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="familyCount" value="0"/>
            </c:otherwise>
        </c:choose>
        </div>
    </div>
<div id="familyLight" class="white_content">
    <div class="rows" style="margin-top: 50px">
        <label>关系：</label>
        <input type="text" id="familyRelation"/>
    </div>
    <div class="rows">
        <label>姓名：</label>
        <input type="text" id="familyName"/>
    </div>
    <div class="rows">
        <label>出生年月：</label>
        <input type="date" id="familyBirthday"/>
    </div>
    <div class="rows">
        <label>政治面貌：</label>
        <select id="familyPoliticalStatus">
            <option></option>
        </select>
    </div>
    <div class="rows">
        <label>所在单位：</label>
        <input type="text" id="familyCompany"/>
    </div>
    <div class="rows">
        <label>职位：</label>
        <input type="text" id="familyPosition"/>
    </div>
    <div class="lastrows">
        <input type="button" value="确定" onclick="addd('family')"/> <input type="button" value="关闭" onclick="closee('family')"/>
    </div>

</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="paper">
    <h4 class="margin_50_0">论文</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="paperTable">
            <thead class="v-center">
            <tr>
                <th>论文题目</th><th>发表刊物</th><th>刊物级别</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.paperList}" varStatus="status">
                <tr>

                    <td><i class="iPerson">${item.paperTitle}</i><input class="inputPerson w_500" type="text" value="${item.paperTitle}" name="paperList[${status.index}].paperTitle"></td>
                    <td><i class="iPerson">${item.paperPublications}</i><input class="inputPerson w_300" type="text" value="${item.paperPublications}"name="paperList[${status.index}].paperPublications"></td>
                    <td><i class="iPerson">${item.paperLevel}</i><input class="inputPerson w_300" type="text" value="${item.paperLevel}" name="paperList[${status.index}].paperLevel"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="paperList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('paperLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.paperList.size()>0}">
                <input type="hidden" id="paperCount" value="${person.paperList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="paperCount" value="0"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="paperLight" class="white_content">
        <div class="rows" style="margin-top: 50px">
            <label class="col-sm-4">题目：</label>
            <input class="col-sm-6" type="text" id="paperTitle"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">发表刊物：</label>
            <input class="col-sm-6" type="text" id="paperPublications"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">刊物级别：</label>
            <input class="col-sm-6" type="text" id="paperLevel"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('paper')"/> <input type="button" value="关闭" onclick="closee('paper')"/>
        </div>
    </div>
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="works">
    <h4 class="margin_50_0">作品</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="worksTable">
            <thead class="v-center">
            <tr>
                <th>作品名称</th><th>所属单位</th><th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.worksList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.worksTitle}</i><input class="inputPerson w_500" type="text" value="${item.worksTitle}" name="worksList[${status.index}].worksTitle"></td>
                    <td><i class="iPerson">${item.worksBelong}</i><input class="inputPerson w_500" type="text" value="${item.worksBelong}" name="worksList[${status.index}].worksBelong"></td>
                    <td><input class="inputPerson" type="button" value="删除" onclick="removeRow(this.parentNode.parentNode)"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="worksList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('worksLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.worksList.size()>0}">
                <input type="hidden" id="worksCount" value="${person.worksList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="worksCount" value="0"/>
            </c:otherwise>
        </c:choose>
        <input type="hidden" value="0" id="worksCount"/>
    </div>
    <div id="worksLight" class="white_content">
        <div class="rows" style="margin-top: 50px">
            <label class="col-sm-4">作品名称：</label>
            <input class="col-sm-6" type="text" id="worksTitle"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">所属单位：</label>
            <input class="col-sm-6" type="text" id="worksBelong"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('works')"/> <input type="button" value="关闭" onclick="closee('works')"/>
        </div>
    </div>
</div>

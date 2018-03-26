<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="book">
    <h4 class="margin_50_0">著作</h4>
    <div class="table-responsive ">
        <table class="table table-hover table-bordered" id="bookTable">
            <thead class="v-center">
            <tr>
                <th>著作题目</th><th>出版单位</th><th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.bookList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.bookTitle}</i><input class="inputPerson w_500" type="text" value="${item.bookTitle}" name="bookList[${status.index}].bookTitle"></td>
                    <td><i class="iPerson">${item.bookPublish}</i><input class="inputPerson w_500" type="text" value="${item.bookPublish}" name="bookList[${status.index}].bookPublish"></td>
                    <td><input class="inputPerson" type="button" value="删除" onclick="removeRow(this.parentNode.parentNode)"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="bookList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('bookLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.bookList.size()>0}">
                <input type="hidden" id="bookCount" value="${person.bookList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="bookCount" value="0"/>
            </c:otherwise>
        </c:choose>
        <input type="hidden" value="0" id="bookCount"/>
    </div>
    <div id="bookLight" class="white_content">
        <div class="rows" style="margin-top: 50px">
            <label class="col-sm-4">著作名称：</label>
            <input class="col-sm-6" type="text" id="bookTitle"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">出版单位：</label>
            <input class="col-sm-6" type="text" id="bookPublish"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('book')"/> <input type="button" value="关闭" onclick="closee('book')"/>
        </div>
    </div>
</div>

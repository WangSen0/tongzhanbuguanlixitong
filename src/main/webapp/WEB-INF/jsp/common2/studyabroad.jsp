<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="studyabroad">
    <h4 class="margin_50_0">留学情况</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="studyabroadTable">
            <thead class="v-center">
            <tr>
                <th>情况</th><th>派出类别 </th><th>出境目的</th><th>派往国家</th><th>进修学校</th><th>出国身份</th><th>留学身份</th><th>出国期限</th><th>期限（个月）</th><th>出国日期</th><th>归国日期</th><th>备注</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.studyabroadList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.studyabroadStatus}</i><input class="inputPerson" type="text" value="${item.studyabroadStatus}" name="studyabroadList[${status.index}].studyabroadStatus"/></td>
                    <td><i class="iPerson">${item.studyabroadType}</i><input class="inputPerson" type="text" value="${item.studyabroadType}" name="studyabroadList[${status.index}].studyabroadType"></td>
                    <td><i class="iPerson">${item.studyabroadPurpose}</i><input class="inputPerson" type="text" value="${item.studyabroadPurpose}" name="studyabroadList[${status.index}].studyabroadPurpose"></td>
                    <td><i class="iPerson">${item.studyabroadCountry}</i><input class="inputPerson" type="text" value="${item.studyabroadCountry}" name="studyabroadList[${status.index}].studyabroadCountry"></td>
                    <td><i class="iPerson">${item.studyabroadSchool}</i><input class="inputPerson" type="text" value="${item.studyabroadSchool}" name="studyabroadList[${status.index}].studyabroadSchool"></td>
                    <td><i class="iPerson">${item.studyabroadGoabroadIdentity}</i><input class="inputPerson" type="text" value="${item.studyabroadGoabroadIdentity}" name="studyabroadList[${status.index}].studyabroadGoabroadIdentity"></td>
                    <td><i class="iPerson">${item.studyabroadStudyabroadIdentity}</i><input class="inputPerson" type="text" value="${item.studyabroadStudyabroadIdentity}" name="studyabroadList[${status.index}].studyabroadStudyabroadIdentity"/></td>
                    <td><i class="iPerson">${item.studyabroadLimit}</i><input class="inputPerson" type="text" value="${item.studyabroadLimit}" name="studyabroadList[${status.index}].studyabroadLimit"/></td>
                    <td><i class="iPerson">${item.studyabroadLimitMonth}</i><input class="inputPerson" type="text" value="${item.studyabroadLimitMonth}" name="studyabroadList[${status.index}].studyabroadLimitMonth"/></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.studyabroadStartTime}" pattern="yyyy-MM-dd"/></i><input class="inputPerson" type="text" value="<fmt:formatDate value="${item.studyabroadStartTime}" pattern="yyyy-MM-dd"/>" name="studyabroadList[${status.index}].studyabroadStartTime"></td>
                    <td><i class="iPerson"><fmt:formatDate value="${item.studyabroadEndTime}" pattern="yyyy-MM-dd"/></i><input class="inputPerson" type="text" value="<fmt:formatDate value="${item.studyabroadEndTime}" pattern="yyyy-MM-dd"/> " name="studyabroadList[${status.index}].studyabroadEndTime"></td>
                    <td><i class="iPerson">${item.studyabroadRemark}</i><input class="inputPerson" type="text" value="${item.studyabroadRemark}" name="studyabroadList[${status.index}].studyabroadRemark"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="studyabroadList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('studyabroadLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.studyabroadList.size()>0}">
                <input type="hidden" id="studyabroadCount" value="${person.studyabroadList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="studyabroadCount" value="0"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="studyabroadLight" class="white_content">
        <div class="rows" style="margin-top: 20px">
            <label class="col-sm-4">情况：</label>
            <select class="col-sm-6" id="studyabroadStatus">
                <option></option>
                <option>回国</option>
                <option>国外学缘</option>
            </select>
        </div>
        <div class="rows">
            <label class="col-sm-4">派出类别：</label>
            <select class="col-sm-6" id="studyabroadType">
                <option></option>
                <option>国家公派</option>
                <option>单位公派</option>
                <option>自费辞职</option>
                <option>自费公派</option>
                <option>归国引进</option>
                <option>自费留学</option>
                <option>陪读</option>
                <option>自费出国工作</option>
                <option>探亲</option>
            </select>
        </div>
        <div class="rows">
            <label class="col-sm-4">出境目的：</label>
            <select class="col-sm-6" id="studyabroadPurpose">
                <option></option>
                <option>留学</option>
                <option>工作</option>
                <option>探亲</option>
            </select>
        </div>
        <div class="rows">
            <label class="col-sm-4">派往国家：</label>
            <select class="col-sm-6" id="studyabroadCountry">
                <option></option>
                <c:forEach var="studyabroadCountry" items="${studyabroadCountryList}">
                    <option>${studyabroadCountry}</option>
                </c:forEach>
            </select>
        </div>
        <div class="rows">
            <label class="col-sm-4">进修学校：</label>
            <input class="col-sm-6" type="text" id="studyabroadSchool"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">出国身份：</label>
            <input class="col-sm-6" type="text" id="studyabroadGoabroadIdentity"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">留学身份：</label>
            <input class="col-sm-6" type="text" id="studyabroadStudyabroadIdentity"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">出国期限：</label>
            <input class="col-sm-6" type="text" id="studyabroadLimit"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">期限（个月）：</label>
            <input class="col-sm-6" type="text" id="studyabroadLimitMonth" placeholder="请输入数字"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">出国日期：</label>
            <input class="col-sm-6" type="date" id="studyabroadStartTime"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">归国日期：</label>
            <input class="col-sm-6" type="date" id="studyabroadEndTime"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">备注：</label>
            <input class="col-sm-6" type="text" id="studyabroadRemark"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('studyabroad')"/> <input type="button" value="关闭" onclick="closee('studyabroad')"/>
        </div>
    </div>
</div>

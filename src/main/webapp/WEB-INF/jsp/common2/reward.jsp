<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="reward">
    <h4 class="margin_50_0">获奖</h4>
    <div class="table-responsive w_1200">
        <table class="table table-hover table-bordered" id="rewardTable">
            <thead class="v-center">
            <tr>
                <th>奖励名称</th><th>成果名称</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${person.rewardList}" varStatus="status">
                <tr>
                    <td><i class="iPerson">${item.rewardName}</i><input class="inputPerson w_500" type="text" value="${item.rewardName}" name="rewardList[${status.index}].rewardName"></td>
                    <td><i class="iPerson">${item.rewardAchievement}</i><input class="inputPerson w_500" type="text" value="${item.rewardAchievement}"  name="rewardList[${status.index}].rewardAchievement"></td>
                    <input class="inputPerson" type="hidden" value="${person.personId}" name="rewardList[${status.index}].personId"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-info margin_top_50 wangsen" onclick="document.getElementById('rewardLight').style.display='block'">增加</button>
        <c:choose>
            <c:when test="${person.rewardList.size()>0}">
                <input type="hidden" id="rewardCount" value="${person.rewardList.size()}"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" id="rewardCount" value="0"/>
            </c:otherwise>
        </c:choose>
        <input type="hidden" value="0" id="rewardCount"/>
    </div>
    <div id="rewardLight" class="white_content">
        <div class="rows" style="margin-top: 50px">
            <label class="col-sm-4">奖励名称：</label>
            <input class="col-sm-6" type="text" id="rewardName"/>
        </div>
        <div class="rows">
            <label class="col-sm-4">成果名称：</label>
            <input class="col-sm-6" type="text" id="rewardAchievement"/>
        </div>
        <div class="lastrows">
            <input type="button" value="确定" onclick="addd('reward')"/> <input type="button" value="关闭" onclick="closee('reward')"/>
        </div>
    </div>
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="main">
    <h4 class="margin_50_0">简介</h4>
    <table class="tablecss">
        <tr>
            <td>
                <label>工号：</label>
                <input type="text" name="personId" id="personId" value="${person.personId}"/>
            </td>
            <td>
                <label>姓名：</label>
                <input type="text" name="name" id="name" value="${person.name}"/>
            </td>
            <td>
                <label>性别：</label>
                <select name="sex" id="sex">
                    <option value="${person.sex}">${person.sex}</option>
                    <option></option>
                </select>
            </td>
            <td>
                <label>出生日期：</label>
                <input type="date" name="birthday" id="birthday" value="<fmt:formatDate value="${person.birthday}" pattern="yyyy-MM-dd"/>"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>籍贯：</label>
                <input type="text" name="nationality" id="nationality" value="${person.nationality}"/>
            </td>
            <td>
                <label>出生地：</label>
                <input type="text" name="placeOfBirth" id="placeOfBirth" value="${person.placeOfBirth}"/>
            </td>
            <td>
                <label>民族：</label>
                <select name="nation" id="nation">
                    <option value="${person.nation}">${person.nation}</option>
                    <option></option>
                </select>
            </td>
            <td>
                <label>婚姻状况：</label>
                <select  name="maritalStatus" id="maritalStatus">
                    <option value="${person.maritalStatus}">${person.maritalStatus}</option>
                    <option></option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <label>国籍：</label>
                <select name="country" id="country">
                    <option value="${person.country}">${person.country}</option>
                    <option></option>
                    <c:forEach var="country" items="${countryList}">
                        <option>${country}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <label>入校日期：</label>
                <%--<input type="date" name="enterschoolTime" id="enterschoolTime" value="<fmt:formatDate value="${person.enterschoolTime}" pattern="yyyy-MM-dd"/>"/>--%>
                <input type="date" name="enterschoolTime" id="enterschoolTime" value="${person.enterschoolTime}"/>
            </td>
            <td>
                <label>毕业学校：</label>
                <select name="graduationSchool" id="graduationSchool">
                    <option value="${person.graduationSchool}">${person.graduationSchool}</option>
                    <option></option>
                    <c:forEach var="graduationSchool" items="${graduationSchoolList}">
                        <option>${graduationSchool}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <label>研究方向：</label>
                <input type="text" name="researchArea" id="researchArea" value="${person.researchArea}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>最高学历：</label>
                <select name="highestEducation" id="highestEducation">
                    <option value="${person.highestEducation}">${person.highestEducation}</option>
                    <option></option>
                </select>
            </td>
            <td>
                <label>最高学位：</label>
                <select name="highestDegree" id="highestDegree">
                    <option value="${person.highestDegree}">${person.highestDegree}</option>
                    <option></option>
                </select>
            </td>
            <td>
                <label>所学专业：</label>
                <input type="text" name="professional" id="professional" value="${person.professional}"/>
            </td>
            <td>
                <label>现从事学科：</label>
                <input type="text" name="workScience" id="workScience" value="${person.workScience}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>参加工作年月：</label>
                <%--<input type="date" name="startworkTime" id="startworkTime" value="<fmt:formatDate value="${person.startworkTime}" pattern="yyyy-MM-dd"/>"/>--%>
                <input type="date" name="startworkTime" id="startworkTime" value="${person.startworkTime}"/>
            </td>
            <td>
                <label>教职工类别：</label>
                <select name="staffStatus" id="staffStatus">
                    <option value="${person.staffStatus}">${person.staffStatus}</option>
                    <option></option>
                </select>
            </td>
            <td>
                <label>当前状态：</label>
                <select name="currentStatus" id="currentStatus">
                    <option value="${person.currentStatus}">${person.currentStatus}</option>
                    <option></option>
                </select>
            </td>
            <td>
                <label>状态变更时间：</label>
                <%--<input type="date" name="currentStatusTime" id="currentStatusTime" value="<fmt:formatDate value="${person.currentStatusTime}" pattern="yyyy-MM-dd"/>"/>--%>
                <input type="date" name="currentStatusTime" id="currentStatusTime" value="${person.currentStatusTime}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>所在院系部处：</label>
                <select name="academyLocation" id="academyLocation">
                    <option value="${person.academyLocation}">${person.academyLocation}</option>
                    <option></option>
                    <c:forEach var="academyLocation" items="${academyLocationList}">
                        <option value="${academyLocation}">${academyLocation}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <label>所在具体部门：</label>
                <input type="text" name="departmentLocation" id="departmentLocation" value="${person.departmentLocation}"/>
            </td>
            <td>
                <label>职务级别：</label>
                <select  name="positionLevel" id="positionLevel">
                    <option value="${person.positionLevel}">${person.positionLevel}</option>
                    <option></option>
                </select>
            </td>
            <td>
                <label>岗位级别：</label>
                <select name="stationLevel" id="stationLevel">
                    <option value="${person.stationLevel}">${person.stationLevel}</option>
                    <option></option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <label> 聘任职务：</label>
                <select  name="employPosition" id="employPosition">
                    <option value="${person.employPosition}">${person.employPosition}</option>
                    <option></option>
                    <c:forEach var="employPosition" items="${employPositionList}">
                        <option>${employPosition}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <label>职务聘任年月：</label>
                <%--<input type="date"  name="employPositionTime" id="employPositionTime" value="<fmt:formatDate value="${person.employPositionTime}" pattern="yyyy-MM-dd"/>"/>--%>
                <input type="date"  name="employPositionTime" id="employPositionTime" value="${person.employPositionTime}"/>
            </td>
            <td>
                <label>管理职员级别：</label>
                <select name="staffLevel" id="staffLevel">
                    <option value="${person.staffLevel}">${person.staffLevel}</option>
                    <option></option>
                </select>
            </td>
            <td>
                <label>管理员聘任年月：</label>
                <%--<input type="date" name="staffLevelTime" id="staffLevelTime" value="<fmt:formatDate value="${person.staffLevelTime}" pattern="yyyy-MM-dd"/>"/>--%>
                <input type="date" name="staffLevelTime" id="staffLevelTime" value="${person.staffLevelTime}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>分级岗位：</label>
                <select name="stationLevelName" id="stationLevelName">
                    <option value="${person.stationLevelName}">${person.stationLevelName}</option>
                    <option></option>
                    <c:forEach var="stationLevelName" items="${stationLevelNameList}">
                        <option>${stationLevelName}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <label>分级年月：</label>
                <%--<input type="date"  name="stationLevelTime" id="stationLevelTime" value="<fmt:formatDate value="${person.stationLevelTime}" pattern="yyyy-MM-dd"/>"/>--%>
                <input type="date"  name="stationLevelTime" id="stationLevelTime" value="${person.stationLevelTime}"/>
            </td>
            <td>
                <label>党政职务级别：</label>
                <input type="text" name="politicalPosition" id="politicalPosition" value="${person.politicalPosition}"/>
            </td>
            <td>
                <label>任职年月：</label>
                <%--<input type="date" name="politicalPositionTime" id="politicalPositionTime" value="<fmt:formatDate value="${person.politicalPositionTime}" pattern="yyyy-MM-dd"/>"/>--%>
                <input type="date" name="politicalPositionTime" id="politicalPositionTime" value="${person.politicalPositionTime}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>身份证号码：</label>
                <input type="text"  name="idcard" id="idcard" value="${person.idcard}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>政治面貌：</label>
                <select name="politicalStatus" id="politicalStatus">
                    <option value="${person.politicalStatus}">${person.politicalStatus}</option>
                    <option></option>
                </select>
            </td>
            <td>
                <label>参加党派时间：</label>
                <%--<input type="date" name="politicalTime" id="politicalTime" value="<fmt:formatDate value="${person.politicalTime}" pattern="yyyy-MM-dd"/>"/>--%>
                <input type="date" name="politicalTime" id="politicalTime" value="${person.politicalTime}"/>
            </td>
            <td>
                <label>第二党派：</label>
                <select name="secondPoliticalStatus" id="secondPoliticalStatus">
                    <option value="${person.secondPoliticalStatus}">${person.secondPoliticalStatus}</option>
                    <option></option>
                </select>
            </td>
            <td>
                <label>第二党派加入<br/>时间：</label>
                <%--<input type="date" name="secondTime" id="secondTime" value="<fmt:formatDate value="${person.secondTime}" pattern="yyyy-MM-dd"/>"/>--%>
                <input type="date" name="secondTime" id="secondTime" value="${person.secondTime}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>熟悉何种专业<br/>技术特长：</label>
                <input type="text" name="speciality" id="speciality" value="${person.speciality}"/>
            </td>
            <td>
                <label>工作电话：</label>
                <input type="text" name="workPhone" id="workPhone" value="${person.workPhone}"/>
            </td>
            <td>
                <label>家庭电话：</label>
                <input type="text" name="familyPhone" id="familyPhone" value="${person.familyPhone}"/>
            </td>
            <td>
                <label>手机：</label>
                <input type="text" name="phone" id="phone" value="${person.phone}"/>
            </td>
        </tr>
        <tr>

            <td>
                <label>电子邮箱：</label>
                <input type="text" name="email" id="email" value="${person.email}"/>
            </td>
            <td>
                <label>通讯地址：</label>
                <input type="text" name="contactAddress" id="contactAddress" value="${person.contactAddress}"/>
            </td>
            <td>
                <label>邮编：</label>
                <input type="text" name="zipcode" id="zipcode" value="${person.zipcode}"/>
            </td>
            <td>
                <label>传真：</label>
                <input type="text" name="fax" id="fax" value="${person.fax}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>党外培养人士<br/>培养类别：</label>
                <select name="outparttraining" id="outparttraining">
                    <option value="${person.outparttraining}">${person.outparttraining}</option>
                    <option></option>
                </select>
            </td>
            <td>
                <label>海外港澳台：</label>
                <select name="gatq" id="gatq">
                    <option value="${person.gatq}">${person.gatq}</option>
                    <option></option>
                </select>
            </td>
            <td>
                <label>健康状况：</label>
                <input type="text" name="healthStatus" id="healthStatus" value="${person.healthStatus}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>全日制教育：</label>
                <select name="fullTimeEducation" id="fullTimeEducation">
                    <option></option>
                </select>
            </td>
            <td>
                <label>全日制教育毕业<br/>学校：</label>
                <input type="text" name="fullTimeEducationSchool" id="fullTimeEducationSchool" value="${person.fullTimeEducationSchool}"/>
            </td>
            <td>
                <label>全日制教育毕业<br/>专业：</label>
                <input type="text" name="fullTimeEducationProfessional" id="fullTimeEducationProfessional" value="${person.fullTimeEducationProfessional}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>在职教育：</label>
                <select name="partTimeEducation" id="partTimeEducation">
                    <option></option>
                </select>
            </td>
            <td>
                <label>在职教育毕业<br/>学校：</label>
                <input type="text" name="partTimeEducationSchool" id="partTimeEducationSchool" value="${person.partTimeEducationSchool}"/>
            </td>
            <td>
                <label>在职教育毕业<br/>专业：</label>
                <input type="text" name="partTimeEducationProfessional" id="partTimeEducationProfessional" value="${person.partTimeEducationProfessional}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>有无国外居留证：</label>
                <select name="residencePermitAbroadStatus" id="residencePermitAbroadStatus">
                    <option value="${person.residencePermitAbroadStatus}">${person.residencePermitAbroadStatus}</option>
                    <option></option>
                </select>
            </td>
            <td>
                <label>获居留证时间：</label>
                <%--<input type="date"  name="residencePermitAbroadTime" id="residencePermitAbroadTime" value="<fmt:formatDate value="${person.residencePermitAbroadTime}" pattern="yyyy-MM-dd"/>"/>--%>
                <input type="date"  name="residencePermitAbroadTime" id="residencePermitAbroadTime" value="${person.residencePermitAbroadTime}"/>
            </td>
        </tr>
    </table>
</div>

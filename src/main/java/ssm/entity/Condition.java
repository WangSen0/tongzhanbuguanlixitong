package ssm.entity;

import java.util.Date;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/27
 */
public class Condition {
    private String personId;//工号
    private String name;//姓名
    private String sex;//性别
    private String birthdayStart;//出生年月开始
    private String birthdayEnd;//出生年月结束

    private String nation;//民族
    private String politicalStatus;//政治面貌
    private String secondPoliticalStatus;//第二党派

    private String politicalpartType;//民主党派类别
    private String unitedpartType;//统战团体类别
    private String politicalconsultType;//政协委员类别
    private String deputypeopleType;//人大代表类别

    private String studyabroadCountry;//留学国家
    private String staffStatus;//教职工类别
    private String academyLocation;//所在院系部
    private String positionLevel;//职务级别

    private String employPosition;//聘任职务
    private String stationLevel;//岗位级别
    private String stationLevelName;//分级岗位
    private String phenomTitle;//杰出人才;

    private String outparttraining;//党外培养人士培养类别
    public String getUnitedpartType() {
        return unitedpartType;
    }

    public void setUnitedpartType(String unitedpartType) {
        this.unitedpartType = unitedpartType;
    }

    public String getStudyabroadCountry() {
        return studyabroadCountry;
    }

    public void setStudyabroadCountry(String studyabroadCountry) {
        this.studyabroadCountry = studyabroadCountry;
    }

    public String getStationLevelName() {
        return stationLevelName;
    }

    public void setStationLevelName(String stationLevelName) {
        this.stationLevelName = stationLevelName;
    }

    public String getStationLevel() {
        return stationLevel;
    }

    public void setStationLevel(String stationLevel) {
        this.stationLevel = stationLevel;
    }

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSecondPoliticalStatus() {
        return secondPoliticalStatus;
    }

    public void setSecondPoliticalStatus(String secondPoliticalStatus) {
        this.secondPoliticalStatus = secondPoliticalStatus;
    }

    public String getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(String positionLevel) {
        this.positionLevel = positionLevel;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getPoliticalpartType() {
        return politicalpartType;
    }

    public void setPoliticalpartType(String politicalpartType) {
        this.politicalpartType = politicalpartType;
    }

    public String getPoliticalconsultType() {
        return politicalconsultType;
    }

    public void setPoliticalconsultType(String politicalconsultType) {
        this.politicalconsultType = politicalconsultType;
    }

    public String getPhenomTitle() {
        return phenomTitle;
    }

    public void setPhenomTitle(String phenomTitle) {
        this.phenomTitle = phenomTitle;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getOutparttraining() {
        return outparttraining;
    }

    public void setOutparttraining(String outparttraining) {
        this.outparttraining = outparttraining;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployPosition() {
        return employPosition;
    }

    public void setEmployPosition(String employPosition) {
        this.employPosition = employPosition;
    }

    public String getDeputypeopleType() {
        return deputypeopleType;
    }

    public void setDeputypeopleType(String deputypeopleType) {
        this.deputypeopleType = deputypeopleType;
    }

    public String getBirthdayStart() {
        return birthdayStart;
    }

    public void setBirthdayStart(String birthdayStart) {
        this.birthdayStart = birthdayStart;
    }

    public String getBirthdayEnd() {
        return birthdayEnd;
    }

    public void setBirthdayEnd(String birthdayEnd) {
        this.birthdayEnd = birthdayEnd;
    }

    public String getAcademyLocation() {
        return academyLocation;
    }

    public void setAcademyLocation(String academyLocation) {
        this.academyLocation = academyLocation;
    }
}

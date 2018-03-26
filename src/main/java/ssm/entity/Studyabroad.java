package ssm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Entity
public class Studyabroad {
    @Column(name = "studyabroad_id")
    private Integer studyabroadId;
    @Column(name = "person_id")
    private String personId;
    @Column(name = "studyabroad_status")
    private String studyabroadStatus;
    @Column(name = "studyabroad_type")
    private String studyabroadType;
    @Column(name = "studyabroad_purpose")
    private String studyabroadPurpose;
    @Column(name = "studyabroad_country")
    private String studyabroadCountry;
    @Column(name = "studyabroad_school")
    private String studyabroadSchool;
    @Column(name = "studyabroad_goabroad_identity")
    private String studyabroadGoabroadIdentity;
    @Column(name = "studyabroad_studyabroad_identity")
    private String studyabroadStudyabroadIdentity;
    @Column(name = "studyabroad_limit")
    private String studyabroadLimit;
    @Column(name = "studyabroad_limit_month")
    private String studyabroadLimitMonth;
    @Column(name = "studyabroad_start_time")
    private Date studyabroadStartTime;
    @Column(name = "studyabroad_end_time")
    private Date studyabroadEndTime;
    @Column(name = "studyabroad_remark")
    private String studyabroadRemark;

    public String getStudyabroadType() {
        return studyabroadType;
    }

    public void setStudyabroadType(String studyabroadType) {
        this.studyabroadType = studyabroadType;
    }

    public String getStudyabroadStudyabroadIdentity() {
        return studyabroadStudyabroadIdentity;
    }

    public void setStudyabroadStudyabroadIdentity(String studyabroadStudyabroadIdentity) {
        this.studyabroadStudyabroadIdentity = studyabroadStudyabroadIdentity;
    }

    public String getStudyabroadStatus() {
        return studyabroadStatus;
    }

    public void setStudyabroadStatus(String studyabroadStatus) {
        this.studyabroadStatus = studyabroadStatus;
    }

    public Date getStudyabroadStartTime() {
        return studyabroadStartTime;
    }

    public void setStudyabroadStartTime(Date studyabroadStartTime) {
        this.studyabroadStartTime = studyabroadStartTime;
    }

    public String getStudyabroadSchool() {
        return studyabroadSchool;
    }

    public void setStudyabroadSchool(String studyabroadSchool) {
        this.studyabroadSchool = studyabroadSchool;
    }

    public String getStudyabroadRemark() {
        return studyabroadRemark;
    }

    public void setStudyabroadRemark(String studyabroadRemark) {
        this.studyabroadRemark = studyabroadRemark;
    }

    public String getStudyabroadPurpose() {
        return studyabroadPurpose;
    }

    public void setStudyabroadPurpose(String studyabroadPurpose) {
        this.studyabroadPurpose = studyabroadPurpose;
    }

    public String getStudyabroadLimitMonth() {
        return studyabroadLimitMonth;
    }

    public void setStudyabroadLimitMonth(String studyabroadLimitMonth) {
        this.studyabroadLimitMonth = studyabroadLimitMonth;
    }

    public String getStudyabroadLimit() {
        return studyabroadLimit;
    }

    public void setStudyabroadLimit(String studyabroadLimit) {
        this.studyabroadLimit = studyabroadLimit;
    }

    public Integer getStudyabroadId() {
        return studyabroadId;
    }

    public void setStudyabroadId(Integer studyabroadId) {
        this.studyabroadId = studyabroadId;
    }

    public String getStudyabroadGoabroadIdentity() {
        return studyabroadGoabroadIdentity;
    }

    public void setStudyabroadGoabroadIdentity(String studyabroadGoabroadIdentity) {
        this.studyabroadGoabroadIdentity = studyabroadGoabroadIdentity;
    }

    public Date getStudyabroadEndTime() {
        return studyabroadEndTime;
    }

    public void setStudyabroadEndTime(Date studyabroadEndTime) {
        this.studyabroadEndTime = studyabroadEndTime;
    }

    public String getStudyabroadCountry() {
        return studyabroadCountry;
    }

    public void setStudyabroadCountry(String studyabroadCountry) {
        this.studyabroadCountry = studyabroadCountry;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}

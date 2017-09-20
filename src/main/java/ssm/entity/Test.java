package ssm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/16
 */
@Entity
public class Test {
    @Column(name = "id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="sex")
    private String sex;
    @Column(name="birthday")
    private String birthday;
    @Column(name="nation")
    private String nation;
    @Column(name="nativeplace")
    private String nativeplace;
    @Column(name="part")
    private String part;
    @Column(name="parttime")
    private String parttime;
    @Column(name="location")
    private String location;
    @Column(name="worktime")
    private String worktime;
    @Column(name="health")
    private String health;
    @Column(name="title")
    private String title;
    @Column(name="eduction1")
    private String eduction1;
    @Column(name="school1")
    private String school1;
    @Column(name="eduction2")
    private String eduction2;
    @Column(name="school2")
    private String school2;
    @Column(name="job")
    private String job;
    @Column(name="parttimejob")
    private String parttimejob;
    @Column(name="resume")
    private String resume;
    @Column(name="reason")
    private String reason;

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool2() {

        return school2;
    }

    public void setSchool2(String school2) {
        this.school2 = school2;
    }

    public String getSchool1() {

        return school1;
    }

    public void setSchool1(String school1) {
        this.school1 = school1;
    }

    public String getResume() {

        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getParttimejob() {

        return parttimejob;
    }

    public void setParttimejob(String parttimejob) {
        this.parttimejob = parttimejob;
    }

    public String getParttime() {
        return parttime;
    }

    public void setParttime(String parttime) {
        this.parttime = parttime;
    }

    public String getPart() {

        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getEduction2() {
        return eduction2;
    }

    public void setEduction2(String eduction2) {
        this.eduction2 = eduction2;
    }

    public String getEduction1() {
        return eduction1;
    }

    public void setEduction1(String eduction1) {
        this.eduction1 = eduction1;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

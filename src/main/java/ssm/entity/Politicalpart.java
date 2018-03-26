package ssm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * 职责
 *民主党派职务
 * @author wangsen
 * @time 2017/9/21
 */
@Entity
public class Politicalpart {
    @Column(name = "politicalpart_id")
    private  Integer politicalpartId;
    @Column(name = "person_id")
    private String personId;
    @Column(name = "politicalpart_country")
    private String politicalpartCountry;
    @Column(name = "politicalpart_province")
    private String politicalpartProvince;
    @Column(name = "politicalpart_city")
    private String politicalpartCity;
    @Column(name = "politicalpart_county")
    private String politicalpartCounty;
    @Column(name = "politicalpart_school")
    private String politicalpartSchool;
    @Column(name = "politicalpart_times")
    private Integer politicalpartTimes;
    @Column(name = "politicalpart_position")
    private String politicalpartPosition;
    @Column(name = "politicalpart_start_time")
    private Date politicalpartStartTime;
    @Column(name = "politicalpart_end_time")
    private Date politicalpartEndTime;

    public Integer getPoliticalpartTimes() {
        return politicalpartTimes;
    }

    public void setPoliticalpartTimes(Integer politicalpartTimes) {
        this.politicalpartTimes = politicalpartTimes;
    }

    public Date getPoliticalpartStartTime() {
        return politicalpartStartTime;
    }

    public void setPoliticalpartStartTime(Date politicalpartStartTime) {
        this.politicalpartStartTime = politicalpartStartTime;
    }

    public String getPoliticalpartSchool() {
        return politicalpartSchool;
    }

    public void setPoliticalpartSchool(String politicalpartSchool) {
        this.politicalpartSchool = politicalpartSchool;
    }

    public String getPoliticalpartProvince() {
        return politicalpartProvince;
    }

    public void setPoliticalpartProvince(String politicalpartProvince) {
        this.politicalpartProvince = politicalpartProvince;
    }

    public String getPoliticalpartPosition() {
        return politicalpartPosition;
    }

    public void setPoliticalpartPosition(String politicalpartPosition) {
        this.politicalpartPosition = politicalpartPosition;
    }

    public Integer getPoliticalpartId() {
        return politicalpartId;
    }

    public void setPoliticalpartId(Integer politicalpartId) {
        this.politicalpartId = politicalpartId;
    }

    public Date getPoliticalpartEndTime() {
        return politicalpartEndTime;
    }

    public void setPoliticalpartEndTime(Date politicalpartEndTime) {
        this.politicalpartEndTime = politicalpartEndTime;
    }

    public String getPoliticalpartCounty() {
        return politicalpartCounty;
    }

    public void setPoliticalpartCounty(String politicalpartCounty) {
        this.politicalpartCounty = politicalpartCounty;
    }

    public String getPoliticalpartCountry() {
        return politicalpartCountry;
    }

    public void setPoliticalpartCountry(String politicalpartCountry) {
        this.politicalpartCountry = politicalpartCountry;
    }

    public String getPoliticalpartCity() {
        return politicalpartCity;
    }

    public void setPoliticalpartCity(String politicalpartCity) {
        this.politicalpartCity = politicalpartCity;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}

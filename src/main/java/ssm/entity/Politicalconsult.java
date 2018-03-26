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
public class Politicalconsult {
    @Column(name="politicalconsult_id")
    private Integer politicalconsultId;
    @Column(name="person_id")
    private String personId;
    @Column(name="politicalconsult_country")
    private String politicalconsultCountry;
    @Column(name="politicalconsult_province")
    private String politicalconsultProvince;
    @Column(name="politicalconsult_city")
    private String politicalconsultCity;
    @Column(name="politicalconsult_county")
    private String politicalconsultCounty;
    @Column(name="politicalconsult_times")
    private Integer politicalconsultTimes;
    @Column(name="politicalconsult_start_time")
    private Date politicalconsultStartTime;
    @Column(name="politicalconsult_end_time")
    private Date politicalconsultEndTime;

    public Integer getPoliticalconsultTimes() {
        return politicalconsultTimes;
    }

    public void setPoliticalconsultTimes(Integer politicalconsultTimes) {
        this.politicalconsultTimes = politicalconsultTimes;
    }

    public Date getPoliticalconsultStartTime() {
        return politicalconsultStartTime;
    }

    public void setPoliticalconsultStartTime(Date politicalconsultStartTime) {
        this.politicalconsultStartTime = politicalconsultStartTime;
    }

    public String getPoliticalconsultProvince() {
        return politicalconsultProvince;
    }

    public void setPoliticalconsultProvince(String politicalconsultProvince) {
        this.politicalconsultProvince = politicalconsultProvince;
    }

    public Integer getPoliticalconsultId() {
        return politicalconsultId;
    }

    public void setPoliticalconsultId(Integer politicalconsultId) {
        this.politicalconsultId = politicalconsultId;
    }

    public Date getPoliticalconsultEndTime() {
        return politicalconsultEndTime;
    }

    public void setPoliticalconsultEndTime(Date politicalconsultEndTime) {
        this.politicalconsultEndTime = politicalconsultEndTime;
    }

    public String getPoliticalconsultCounty() {
        return politicalconsultCounty;
    }

    public void setPoliticalconsultCounty(String politicalconsultCounty) {
        this.politicalconsultCounty = politicalconsultCounty;
    }

    public String getPoliticalconsultCountry() {
        return politicalconsultCountry;
    }

    public void setPoliticalconsultCountry(String politicalconsultCountry) {
        this.politicalconsultCountry = politicalconsultCountry;
    }

    public String getPoliticalconsultCity() {
        return politicalconsultCity;
    }

    public void setPoliticalconsultCity(String politicalconsultCity) {
        this.politicalconsultCity = politicalconsultCity;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}

package ssm.entity;

import javafx.scene.chart.PieChart;

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
public class Deputypeople {
    @Column(name="deputypeople_id")
    private Integer deputypeopleId;
    @Column(name = "person_id")
    private String personId;
    @Column(name="deputypeople_country")
    private String deputypeopleCountry;
    @Column(name = "deputypeople_province")
    private String deputypeopleProvince;
    @Column(name = "deputypeople_city")
    private String deputypeopleCity;
    @Column(name = "deputypeople_county")
    private String deputypeopleCounty;
    @Column(name = "deputypeople_times")
    private Integer deputypeopleTimes;
    @Column(name = "deputypeople_start_time")
    private Date deputypeopleStartTime;
    @Column(name = "deputypeople_end_time")
    private Date deputypeopleEndTime;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getDeputypeopleTimes() {
        return deputypeopleTimes;
    }

    public void setDeputypeopleTimes(Integer deputypeopleTimes) {
        this.deputypeopleTimes = deputypeopleTimes;
    }

    public Date getDeputypeopleStartTime() {
        return deputypeopleStartTime;
    }

    public void setDeputypeopleStartTime(Date deputypeopleStartTime) {
        this.deputypeopleStartTime = deputypeopleStartTime;
    }

    public String getDeputypeopleProvince() {
        return deputypeopleProvince;
    }

    public void setDeputypeopleProvince(String deputypeopleProvince) {
        this.deputypeopleProvince = deputypeopleProvince;
    }

    public Integer getDeputypeopleId() {
        return deputypeopleId;
    }

    public void setDeputypeopleId(Integer deputypeopleId) {
        this.deputypeopleId = deputypeopleId;
    }

    public Date getDeputypeopleEndTime() {
        return deputypeopleEndTime;
    }

    public void setDeputypeopleEndTime(Date deputypeopleEndTime) {
        this.deputypeopleEndTime = deputypeopleEndTime;
    }

    public String getDeputypeopleCounty() {
        return deputypeopleCounty;
    }

    public void setDeputypeopleCounty(String deputypeopleCounty) {
        this.deputypeopleCounty = deputypeopleCounty;
    }

    public String getDeputypeopleCountry() {
        return deputypeopleCountry;
    }

    public void setDeputypeopleCountry(String deputypeopleCountry) {
        this.deputypeopleCountry = deputypeopleCountry;
    }

    public String getDeputypeopleCity() {
        return deputypeopleCity;
    }

    public void setDeputypeopleCity(String deputypeopleCity) {
        this.deputypeopleCity = deputypeopleCity;
    }
}

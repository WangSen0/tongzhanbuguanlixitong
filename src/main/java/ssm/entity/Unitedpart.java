package ssm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Entity
public class Unitedpart {
    @Column(name = "unitedpart_id")
    private Integer unitedpartId;
    @Column(name = "person_id")
    private String personId;
    @Column(name = "unitedpart_country")
    private String unitedpartCountry;
    @Column(name = "unitedpart_province")
    private String unitedpartProvince;
    @Column(name = "unitedpart_city")
    private String unitedpartCity;
    @Column(name = "unitedpart_county")
    private String unitedpartCounty;
    @Column(name = "unitedpart_school")
    private String unitedpartSchool;
    @Column(name = "unitedpart_times")
    private Integer unitedpartTimes;
    @Column(name = "unitedpart_position")
    private String unitedpartPosition;
    @Column(name = "unitedpart_start_time")
    private Date unitedpartStartTime;
    @Column(name = "unitedpart_end_time")
    private Date unitedpartEndTime;

    public Integer getUnitedpartTimes() {
        return unitedpartTimes;
    }

    public void setUnitedpartTimes(Integer unitedpartTimes) {
        this.unitedpartTimes = unitedpartTimes;
    }

    public Date getUnitedpartStartTime() {
        return unitedpartStartTime;
    }

    public void setUnitedpartStartTime(Date unitedpartStartTime) {
        this.unitedpartStartTime = unitedpartStartTime;
    }

    public String getUnitedpartSchool() {
        return unitedpartSchool;
    }

    public void setUnitedpartSchool(String unitedpartSchool) {
        this.unitedpartSchool = unitedpartSchool;
    }

    public String getUnitedpartProvince() {
        return unitedpartProvince;
    }

    public void setUnitedpartProvince(String unitedpartProvince) {
        this.unitedpartProvince = unitedpartProvince;
    }

    public String getUnitedpartPosition() {
        return unitedpartPosition;
    }

    public void setUnitedpartPosition(String unitedpartPosition) {
        this.unitedpartPosition = unitedpartPosition;
    }

    public Integer getUnitedpartId() {
        return unitedpartId;
    }

    public void setUnitedpartId(Integer unitedpartId) {
        this.unitedpartId = unitedpartId;
    }

    public Date getUnitedpartEndTime() {
        //SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        //return simpleDateFormat.parse(unitedpartEndTime.toString()).toString();
        return unitedpartEndTime;
    }

    public void setUnitedpartEndTime(Date unitedpartEndTime) {
        this.unitedpartEndTime = unitedpartEndTime;
    }

    public String getUnitedpartCounty() {
        return unitedpartCounty;
    }

    public void setUnitedpartCounty(String unitedpartCounty) {
        this.unitedpartCounty = unitedpartCounty;
    }

    public String getUnitedpartCountry() {
        return unitedpartCountry;
    }

    public void setUnitedpartCountry(String unitedpartCountry) {
        this.unitedpartCountry = unitedpartCountry;
    }

    public String getUnitedpartCity() {
        return unitedpartCity;
    }

    public void setUnitedpartCity(String unitedpartCity) {
        this.unitedpartCity = unitedpartCity;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}

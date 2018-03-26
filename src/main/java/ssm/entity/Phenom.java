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
public class Phenom {
    @Column(name="phenom_id")
    private Integer phenomId;
    @Column(name="person_id")
    private String personId;
    @Column(name="phenom_title")
    private String phenomTitle;
    @Column(name="phenom_start_time")
    private Date phenomStartTime;
    @Column(name="phenom_end_time")
    private Date phenomEndTime;

    public String getPhenomTitle() {
        return phenomTitle;
    }

    public void setPhenomTitle(String phenomTitle) {
        this.phenomTitle = phenomTitle;
    }

    public Date getPhenomStartTime() {
        return phenomStartTime;
    }

    public void setPhenomStartTime(Date phenomStartTime) {
        this.phenomStartTime = phenomStartTime;
    }

    public Integer getPhenomId() {
        return phenomId;
    }

    public void setPhenomId(Integer phenomId) {
        this.phenomId = phenomId;
    }

    public Date getPhenomEndTime() {
        return phenomEndTime;
    }

    public void setPhenomEndTime(Date phenomEndTime) {
        this.phenomEndTime = phenomEndTime;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}

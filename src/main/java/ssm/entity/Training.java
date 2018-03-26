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
public class Training {
    @Column(name = "training_id")
    private Integer trainingId;
    @Column(name = "person_id")
    private String personId;
    @Column(name = "training_place")
    private String trainingPlace;
    @Column(name = "training_company")
    private String trainingCompany;
    @Column(name = "training_content")
    private String trainingContent;
    @Column(name = "training_start_time")
    private Date trainingStartTime;
    @Column(name = "training_end_time")
    private Date trainingEndTime;

    public Date getTrainingStartTime() {
        return trainingStartTime;
    }

    public void setTrainingStartTime(Date trainingStartTime) {
        this.trainingStartTime = trainingStartTime;
    }

    public String getTrainingPlace() {
        return trainingPlace;
    }

    public void setTrainingPlace(String trainingPlace) {
        this.trainingPlace = trainingPlace;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public Date getTrainingEndTime() {
        return trainingEndTime;
    }

    public void setTrainingEndTime(Date trainingEndTime) {
        this.trainingEndTime = trainingEndTime;
    }

    public String getTrainingContent() {
        return trainingContent;
    }

    public void setTrainingContent(String trainingContent) {
        this.trainingContent = trainingContent;
    }

    public String getTrainingCompany() {
        return trainingCompany;
    }

    public void setTrainingCompany(String trainingCompany) {
        this.trainingCompany = trainingCompany;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}

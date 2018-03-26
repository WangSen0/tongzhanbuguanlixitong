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
public class Resume {
    @Column(name = "resume_id")
    private Integer resumeId;
    @Column(name = "person_id")
    private String personId;
    @Column(name = "resume_start_time")
    private Date resumeStartTime;
    @Column(name = "resume_end_time")
    private Date resumeEndTime;
    @Column(name = "resume_content")
    private String resumeContent;

    public Date getResumeStartTime() {
        return resumeStartTime;
    }

    public void setResumeStartTime(Date resumeStartTime) {
        this.resumeStartTime = resumeStartTime;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Date getResumeEndTime() {
        return resumeEndTime;
    }

    public void setResumeEndTime(Date resumeEndTime) {
        this.resumeEndTime = resumeEndTime;
    }

    public String getResumeContent() {
        return resumeContent;
    }

    public void setResumeContent(String resumeContent) {
        this.resumeContent = resumeContent;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}

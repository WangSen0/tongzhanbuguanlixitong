package ssm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 职责
 *主要政治表现
 * @author wangsen
 * @time 2017/9/21
 */
@Entity
public class Politicalperformence {
    @Column(name="politicalperformence_id")
    private Integer politicalperformenceId;
    @Column(name="person_id")
    private String personId;
    @Column(name="politicalperformence_content")
    private String politicalperformenceContent;

    public Integer getPoliticalperformenceId() {
        return politicalperformenceId;
    }

    public void setPoliticalperformenceId(Integer politicalperformenceId) {
        this.politicalperformenceId = politicalperformenceId;
    }

    public String getPoliticalperformenceContent() {
        return politicalperformenceContent;
    }

    public void setPoliticalperformenceContent(String politicalperformenceContent) {
        this.politicalperformenceContent = politicalperformenceContent;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}

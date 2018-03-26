package ssm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Entity
public class Parttimejob {
    @Column(name="parttimejob_id")
    private Integer parttimejobId;
    @Column(name="person_id")
    private String personId;
    @Column(name="parttimejob_content")
    private String parttimejobContent;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getParttimejobId() {
        return parttimejobId;
    }

    public void setParttimejobId(Integer parttimejobId) {
        this.parttimejobId = parttimejobId;
    }

    public String getParttimejobContent() {
        return parttimejobContent;
    }

    public void setParttimejobContent(String parttimejobContent) {
        this.parttimejobContent = parttimejobContent;
    }
}

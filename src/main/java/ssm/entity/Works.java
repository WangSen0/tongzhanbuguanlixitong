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
public class Works {
    @Column(name = "id")
    private Integer id;
    @Column(name = "works_id")
    private String worksId;
    @Column(name = "person_id")
    private String personId;
    @Column(name = "works_title")
    private String worksTitle;
    @Column(name = "works_belong")
    private String worksBelong;

    public String getWorksId() {
        return worksId;
    }

    public void setWorksId(String worksId) {
        this.worksId = worksId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorksTitle() {
        return worksTitle;
    }

    public void setWorksTitle(String worksTitle) {
        this.worksTitle = worksTitle;
    }

    public String getWorksBelong() {
        return worksBelong;
    }

    public void setWorksBelong(String worksBelong) {
        this.worksBelong = worksBelong;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}

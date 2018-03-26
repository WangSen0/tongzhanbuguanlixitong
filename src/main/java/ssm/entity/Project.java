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
public class Project {
    @Column(name = "id")
    private Integer id;
    @Column(name = "project_id")
    private String projectId;
    @Column(name = "person_id")
    private String personId;
    @Column(name = "project_title")
    private String projectTitle;
    @Column(name = "project_level")
    private String projectLevel;
    @Column(name = "project_outlay")
    private Double projectOutlay;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public Double getProjectOutlay() {
        return projectOutlay;
    }

    public void setProjectOutlay(Double projectOutlay) {
        this.projectOutlay = projectOutlay;
    }

    public String getProjectLevel() {
        return projectLevel;
    }

    public void setProjectLevel(String projectLevel) {
        this.projectLevel = projectLevel;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}

package ssm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Entity
public class Patent {
    @Column(name = "id")
    private Integer id;
    @Column(name = "patent_id")
    private String patentId;
    @Column(name = "person_id")
    private String personId;
    @Column(name = "patent_title")
    private String patentTitle;
    @Column(name = "patent_type")
    private String patentType;
    @Column(name = "patent_author")
    private String patentAuthor;

    public String getPatentId() {
        return patentId;
    }

    public void setPatentId(String patentId) {
        this.patentId = patentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public String getPatentTitle() {
        return patentTitle;
    }

    public void setPatentTitle(String patentTitle) {
        this.patentTitle = patentTitle;
    }

    public String getPatentAuthor() {
        return patentAuthor;
    }

    public void setPatentAuthor(String patentAuthor) {
        this.patentAuthor = patentAuthor;
    }
}

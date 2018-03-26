package ssm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 职责
 *论文
 * @author wangsen
 * @time 2017/9/21
 */
@Entity
public class Paper {
    @Column(name = "id")
    private Integer id;
    @Column(name="paper_id")
    private String paperId;
    @Column(name = "person_id")
    private String personId;
    @Column(name="paper_title")
    private String paperTitle;
    @Column(name = "paper_publications")
    private String paperPublications;
    @Column(name="paper_level")
    private String paperLevel;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
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

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getPaperPublications() {
        return paperPublications;
    }

    public void setPaperPublications(String paperPublications) {
        this.paperPublications = paperPublications;
    }

    public String getPaperLevel() {
        return paperLevel;
    }

    public void setPaperLevel(String paperLevel) {
        this.paperLevel = paperLevel;
    }
}

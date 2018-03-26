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
public class Family {
    @Column(name = "family_id")
    private Integer familyId;
    @Column(name="person_id")
    private String personId;
    @Column(name="family_relation")
    private String familyRelation;
    @Column(name="family_name")
    private String familyName;
    @Column(name="family_birthday")
    private Date familyBirthday;
    @Column(name="family_political_status")
    private String familyPoliticalStatus;
    @Column(name="family_company")
    private String familyCompany;
    @Column(name="family_position")
    private String familyPosition;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFamilyRelation() {
        return familyRelation;
    }

    public void setFamilyRelation(String familyRelation) {
        this.familyRelation = familyRelation;
    }

    public String getFamilyPosition() {
        return familyPosition;
    }

    public void setFamilyPosition(String familyPosition) {
        this.familyPosition = familyPosition;
    }

    public String getFamilyPoliticalStatus() {
        return familyPoliticalStatus;
    }

    public void setFamilyPoliticalStatus(String familyPoliticalStatus) {
        this.familyPoliticalStatus = familyPoliticalStatus;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public String getFamilyCompany() {
        return familyCompany;
    }

    public void setFamilyCompany(String familyCompany) {
        this.familyCompany = familyCompany;
    }

    public Date getFamilyBirthday() {
        return familyBirthday;
    }

    public void setFamilyBirthday(Date familyBirthday) {
        this.familyBirthday = familyBirthday;
    }
}

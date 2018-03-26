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
public class Report {
    @Column(name = "id")
    private Integer id;
    @Column(name = "report_id")
    private String reportId;
    @Column(name = "person_id")
    private String personId;
    @Column(name = "report_title")
    private String reportTitle;
    @Column(name = "report_belong")
    private String reportBelong;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportBelong() {
        return reportBelong;
    }

    public void setReportBelong(String reportBelong) {
        this.reportBelong = reportBelong;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}

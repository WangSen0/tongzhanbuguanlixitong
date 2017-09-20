package ssm.entity;

import javax.persistence.Entity;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/17
 */
@Entity
public class Condition {
    private String name;
    private String sex;
    private String time1;
    private String time2;
    private String nation;
    private String part;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime2() {

        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime1() {

        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPart() {

        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getNation() {

        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package ssm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 职责
 *主要社会成就和社会影响
 * @author wangsen
 * @time 2017/9/21
 */
@Entity
public class Achievement {
    @Column(name = "achievement_id")
    private Integer achievementId;
    @Column(name="person_id")
    private String personId;
    @Column(name="achievement_content")
    private String achievementContent;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementContent() {
        return achievementContent;
    }

    public void setAchievementContent(String achievementContent) {
        this.achievementContent = achievementContent;
    }
}

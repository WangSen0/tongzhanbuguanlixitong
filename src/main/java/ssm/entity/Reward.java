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
public class Reward {
    @Column(name = "id")
    private Integer id;
    @Column(name = "reward_id")
    private String rewardId;
    @Column(name = "person_id")
    private String personId;
    @Column(name = "reward_name")
    private String rewardName;
    @Column(name = "reward_achievement")
    private String rewardAchievement;

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardAchievement() {
        return rewardAchievement;
    }

    public void setRewardAchievement(String rewardAchievement) {
        this.rewardAchievement = rewardAchievement;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}

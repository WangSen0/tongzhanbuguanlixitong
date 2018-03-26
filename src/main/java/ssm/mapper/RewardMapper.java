package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Reward;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface RewardMapper {
    public List<Reward> listAllReward()throws Exception;
    public Reward queryByRewardId(@Param("id")Integer id)throws Exception;
    public List<Reward> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertReward(@Param("reward")Reward reward)throws Exception;
    public int deleteByRewardId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updateReward(@Param("reward") Reward reward) throws Exception;
}

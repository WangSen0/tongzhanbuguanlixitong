package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Achievement;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface AchievementMapper {
        public List<Achievement> listAllAchievement()throws Exception;
        public Achievement queryByAchievementId(@Param("id")Integer id)throws Exception;
        public List<Achievement> queryByPersonId(@Param("id")String id)throws Exception;
        public int insertAchievement(@Param("achievement")Achievement achievement)throws Exception;
        public int deleteByAchievementId(@Param("id")Integer id)throws Exception;
        public int deleteByPersonId(@Param("personId")String personId)throws Exception;
        public int updateAchievement(@Param("achievement") Achievement achievement) throws Exception;


}

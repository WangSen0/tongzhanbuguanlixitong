package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Training;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface TrainingMapper {
    public List<Training> listAllTraining()throws Exception;
    public Training queryByTrainingId(@Param("id")Integer id)throws Exception;
    public List<Training> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertTraining(@Param("training")Training training)throws Exception;
    public int deleteByTrainingId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updateTraining(@Param("training") Training training) throws Exception;
}

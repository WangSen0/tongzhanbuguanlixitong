package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Politicalperformence;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface PoliticalperformenceMapper {
    public List<Politicalperformence> listAllPoliticalperformence()throws Exception;
    public Politicalperformence queryByPoliticalperformenceId(@Param("id")Integer id)throws Exception;
    public List<Politicalperformence> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertPoliticalperformence(@Param("politicalperformence")Politicalperformence politicalperformence)throws Exception;
    public int deleteByPoliticalperformenceId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updatePoliticalperformence(@Param("politicalperformence") Politicalperformence politicalperformence) throws Exception;
}

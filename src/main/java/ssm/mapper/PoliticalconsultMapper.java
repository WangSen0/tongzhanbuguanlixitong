package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Politicalconsult;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface PoliticalconsultMapper {
    public List<Politicalconsult> listAllPoliticalconsult()throws Exception;
    public Politicalconsult queryByPoliticalconsultId(@Param("id")Integer id)throws Exception;
    public List<Politicalconsult> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertPoliticalconsult(@Param("politicalconsult")Politicalconsult politicalconsult)throws Exception;
    public int deleteByPoliticalconsultId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updatePoliticalconsult(@Param("politicalconsult") Politicalconsult politicalconsult) throws Exception;
}

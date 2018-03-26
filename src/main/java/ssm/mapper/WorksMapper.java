package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Works;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface WorksMapper {
    public List<Works> listAllWorks()throws Exception;
    public Works queryByWorksId(@Param("id")Integer id)throws Exception;
    public List<Works> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertWorks(@Param("works")Works works)throws Exception;
    public int deleteByWorksId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updateWorks(@Param("works") Works works) throws Exception;
}

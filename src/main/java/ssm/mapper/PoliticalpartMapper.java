package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Politicalpart;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface PoliticalpartMapper {
    public List<Politicalpart> listAllPoliticalpart()throws Exception;
    public Politicalpart queryByPoliticalpartId(@Param("id")Integer id)throws Exception;
    public List<Politicalpart> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertPoliticalpart(@Param("politicalpart")Politicalpart politicalpart)throws Exception;
    public int deleteByPoliticalpartId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updatePoliticalpart(@Param("politicalpart") Politicalpart politicalpart) throws Exception;
}

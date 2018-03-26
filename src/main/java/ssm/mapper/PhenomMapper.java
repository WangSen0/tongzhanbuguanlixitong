package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ssm.entity.Phenom;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface PhenomMapper {
    public List<Phenom> listAllPhenom()throws Exception;
    public Phenom queryByPhenomId(@Param("id")Integer id)throws Exception;
    public List<Phenom> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertPhenom(@Param("phenom")Phenom phenom)throws Exception;
    public int deleteByPhenomId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updatePhenom(@Param("phenom") Phenom phenom) throws Exception;
    public List<String> queryPhenomTitle()throws Exception;
}

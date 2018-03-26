package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Patent;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface PatentMapper {
    public List<Patent> listAllPatent()throws Exception;
    public Patent queryByPatentId(@Param("id")Integer id)throws Exception;
    public List<Patent> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertPatent(@Param("patent")Patent patent)throws Exception;
    public int deleteByPatentId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updatePatent(@Param("patent") Patent patent) throws Exception;
}

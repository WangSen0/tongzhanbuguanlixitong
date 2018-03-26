package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Family;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface FamilyMapper {
    public List<Family> listAllFamily()throws Exception;
    public Family queryByFamilyId(@Param("id")Integer id)throws Exception;
    public List<Family> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertFamily(@Param("family")Family family)throws Exception;
    public int deleteByFamilyId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updateFamily(@Param("family") Family family) throws Exception;
}

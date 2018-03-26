package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Unitedpart;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface UnitedpartMapper {
    public List<Unitedpart> listAllUnitedpart()throws Exception;
    public Unitedpart queryByUnitedpartId(@Param("id")Integer id)throws Exception;
    public List<Unitedpart> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertUnitedpart(@Param("unitedpart")Unitedpart unitedpart)throws Exception;
    public int deleteByUnitedpartId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updateUnitedpart(@Param("unitedpart") Unitedpart unitedpart) throws Exception;
}

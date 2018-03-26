package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Deputypeople;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface DeputypeopleMapper {
    public List<Deputypeople> listAllDeputypeople()throws Exception;
    public Deputypeople queryByDeputypeopleId(@Param("id")Integer id)throws Exception;
    public List<Deputypeople> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertDeputypeople(@Param("deputypeople")Deputypeople deputypeople)throws Exception;
    public int deleteByDeputypeopleId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updateDeputypeople(@Param("deputypeople") Deputypeople deputypeople) throws Exception;
}

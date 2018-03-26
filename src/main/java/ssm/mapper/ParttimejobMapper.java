package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Parttimejob;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface ParttimejobMapper {
    public List<Parttimejob> listAllParttimejob()throws Exception;
    public Parttimejob queryByParttimejobId(@Param("id")Integer id)throws Exception;
    public List<Parttimejob> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertParttimejob(@Param("parttimejob")Parttimejob parttimejob)throws Exception;
    public int deleteByParttimejobId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updateParttimejob(@Param("parttimejob") Parttimejob Parttimejob) throws Exception;
}

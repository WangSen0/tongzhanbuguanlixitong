package ssm.mapper.information;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Condition;
import ssm.entity.InformationCondition;
import ssm.entity.Person;
import ssm.utils.ObjectCount;
import ssm.utils.Property;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface PersonInformationMapper {
    public Person queryByPersonId(@Param("personId") String personId)throws Exception;
    public List<Person> queryByPersonName(@Param("name")String name)throws Exception;
    public List<Person> queryByCondition(@Param("condition")InformationCondition condition,@Param("offerset")Integer offerset,@Param("rows")Integer rows)throws Exception;
    public Integer queryCountByCondition(@Param("condition")InformationCondition condition,@Param("offerset")Integer offerset,@Param("rows")Integer rows)throws Exception;
}

package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Condition;
import ssm.entity.Person;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/16
 */
@Repository
public interface PersonMapper {
    public int newPerson(@Param("person") Person person)throws Exception;
    public int delPersonById(@Param("id")int id)throws Exception;
    public int updatePerson(@Param("person")Person person)throws Exception;
    public Person queryById(@Param("id") int id)throws Exception;
    public List<Person> listPerson()throws Exception;
    public List<String> queryName()throws Exception;
    public List<Person> queryByCondition(@Param("condition")Condition condition,@Param("offerset")Integer offerset,@Param("rows")Integer rows) throws Exception;
    public List<Person> queryByPage(@Param("offerset")Integer offerset,@Param("rows")Integer rows)throws Exception;
}

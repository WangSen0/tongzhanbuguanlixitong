package ssm.service;

import org.apache.ibatis.annotations.Param;
import ssm.entity.Condition;
import ssm.entity.Person;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/16
 */

public interface PersonService {
    public int newPerson(Person person)throws Exception;
    public int delPersonById(int id)throws Exception;
    public int updatePerson(Person person)throws Exception;
    public Person queryById(int id)throws Exception;
    public List<Person> listPerson()throws Exception;
    public List<String> queryName()throws Exception;
    public List<Person> queryByCondition(Condition condition,Integer offerset,Integer rows)throws Exception;
    public List<Person> queryByPage(Integer offerset,Integer rows)throws Exception;
}

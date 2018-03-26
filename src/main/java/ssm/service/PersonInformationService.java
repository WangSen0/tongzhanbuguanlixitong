package ssm.service;

import org.apache.ibatis.annotations.Param;
import ssm.entity.InformationCondition;
import ssm.entity.Person;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/11/10
 */
public interface PersonInformationService {
    public Person queryByPersonId(String personId)throws Exception;
    public List<Person> queryByPersonName(String name)throws Exception;
    public List<Person> queryByCondition(InformationCondition condition,Integer offerset, Integer rows)throws Exception;
    public Integer queryCountByCondition(InformationCondition condition,Integer offerset, Integer rows)throws Exception;
    public Integer updatePersonByInformation(Person person,Person personInformation)throws Exception;
}

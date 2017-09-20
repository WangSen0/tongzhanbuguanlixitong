package ssm.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.entity.Condition;
import ssm.entity.Person;
import ssm.mapper.PersonMapper;
import ssm.service.PersonService;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/16
 */
@Service("personService")
public class PersonServiceimpl implements PersonService{
    @Autowired
    PersonMapper personMapper;
    @Override
    public int newPerson(Person person)throws Exception{
        return personMapper.newPerson(person);
    }
    @Override
    public int delPersonById(int id)throws Exception{
        return personMapper.delPersonById(id);
    }
    @Override
    public int updatePerson(Person person)throws Exception{
        return personMapper.updatePerson(person);
    }
    @Override
    public Person queryById(int id)throws Exception{
        return personMapper.queryById(id);
    }
    @Override
    public List<Person> listPerson()throws Exception{
        return personMapper.listPerson();
    }
    @Override
    public List<String> queryName()throws Exception{
        return personMapper.queryName();
    }
    @Override
    public List<Person> queryByCondition(Condition condition,Integer offerst,Integer rows)throws Exception{
        return personMapper.queryByCondition(condition,offerst,rows);
    }
    @Override
    public List<Person> queryByPage(Integer offerset,Integer rows)throws Exception{
        return personMapper.queryByPage(offerset,rows);
    }
}

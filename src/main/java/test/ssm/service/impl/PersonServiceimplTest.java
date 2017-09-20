package test.ssm.service.impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.entity.Condition;
import ssm.entity.Person;
import ssm.service.PersonService;
import ssm.service.TestService;
import ssm.utils.Excel;

import java.util.List;

/** 
* PersonServiceimpl Tester. 
* 
* @author <Authors name> 
* @since <pre>九月 16, 2017</pre> 
* @version 1.0 
*/

public class PersonServiceimplTest extends AbstractTestCase {
@Autowired
    PersonService personService;
@Autowired
    TestService testService;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: newPerson(Person person) 
* 
*/ 
@Test
public void testNewPerson() throws Exception { 
//TODO: Test goes here...
    Person person=new Person();
    for(int i=0;i<30;i++)
    {
        person.setName(String.valueOf(i));
        person.setSex("2");
        person.setBirthday("1992-09-14");
        person.setEduction1("4");
        person.setEduction2("5");
        person.setHealth("6");
        person.setJob("7");
        person.setLocation("8");
        person.setNation("9");
        person.setNativeplace("10");
        person.setPart("11");
        person.setParttime("1992-09-14");
        person.setParttimejob("13");
        person.setReason("14");
        person.setResume("15");
        person.setSchool1("16");
        person.setSchool2("17");
        person.setTitle("18");
        person.setWorktime("1992-09-14");
        personService.newPerson(person);
    }

} 

@Test
public void testDelPersonById() throws Exception { 
personService.delPersonById(2);
} 

/** 
* 
* Method: updatePerson(Person person) 
* 
*/ 
@Test
public void testUpdatePerson() throws Exception {
    Person person=new Person();
    person.setId(1);
    person.setName("1");
    person.setSex("2");
    person.setBirthday("1992-09-14");
    person.setEduction1("4");
    person.setEduction2("5");
    person.setHealth("6");
    person.setJob("7");
    person.setLocation("8");
    person.setNation("9");
    person.setNativeplace("10");
    person.setPart("11");
    person.setParttime("1992-09-14");
    person.setParttimejob("13");
    person.setReason("14");
    person.setResume("15");
    person.setSchool1("16");
    person.setSchool2("17");
    person.setTitle("18");
    person.setWorktime("1992-09-14");
    personService.updatePerson(person);
} 

/** 
* 
* Method: queryById(int id) 
* 
*/ 
@Test
public void testQueryById() throws Exception { 
Person person=personService.queryById(34);
Excel excel=new Excel();
excel.writeModel(person);
} 

/** 
* 
* Method: listPerson() 
* 
*/ 
@Test
public void testListPerson() throws Exception {
    List<Person>list=personService.listPerson();
    //List<Person> list=personService.listPerson();
} 

@Test
    public void testQueryName()throws Exception{
    List<String> names=personService.queryName();
}
@Test
    public void testQueryByCondition()throws Exception{
    Condition condition=new Condition();
    //condition.setName("1");
    //condition.setTitle("");
    List<Person> list=personService.queryByCondition(condition,0,100);
    Excel excel=new Excel();
    excel.write(list);
}
@Test
    public void testQueryByPage()throws Exception{
    List<Person> list=personService.queryByPage(1,2);
}
} 

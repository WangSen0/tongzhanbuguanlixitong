package test.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import ssm.entity.*;
import ssm.mapper.PersonMapper;
import ssm.mapper.UserMapper;
import ssm.mapper.information.*;
import ssm.service.PersonService;
import ssm.utils.ObjectCount;
import ssm.utils.Property;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/11/8
 */
public class Test1 extends AbstractTestCase {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PersonMapper personMapper;
    @Autowired
    BookInformationMapper bookInformationMapper;
    @Autowired
    PaperInformationMapper paperInformationMapper;
    @Autowired
    PatentInformationMapper patentInformationMapper;
    @Autowired
    ProjectInformationMapper projectInformationMapper;
    @Autowired
    ReportInformationMapper reportInformationMapper;
    @Autowired
    RewardInformationMapper rewardInformationMapper;
    @Autowired
    WorksInformationMapper worksInformationMapper;
    @Autowired
    PersonInformationMapper personInformationMapper;
    @Autowired
    PersonService personService;
    @Test
    public void testUser() throws Exception{
//        List<Book> bookList=bookInformationMapper.queryByPersonId("2001900226");
//        paperInformationMapper.queryByPersonId("1000906751");
//        patentInformationMapper.queryByPersonId("2001900080");
//        projectInformationMapper.queryByPersonId("1000905109");
//        reportInformationMapper.queryByPersonId("1000900009");
//        rewardInformationMapper.queryByPersonId("1000906712");
//        List<Works> worksList=worksInformationMapper.queryByPersonId("1000901701");
//        Person person=personInformationMapper.queryByPersonId("1000901701");
//        List<Person> personList=personInformationMapper.queryByPersonName("孔俊");
//        InformationCondition informationCondition=new InformationCondition();
//        informationCondition.setPersonId("2008");
//        informationCondition.setName("赵雪");
//        informationCondition.setBirthdayStart("2000-10-14");
//        informationCondition.setBirthdayEnd("1999-01-01");
//        informationCondition.setNation("01");
//        informationCondition.setCurrentStatus("在职");
//        informationCondition.setPoliticalStatus("中国共产党党员");
//        List<Person> personList=personInformationMapper.queryByCondition(informationCondition,0,10000);
//        Integer i=personInformationMapper.queryCountByCondition(informationCondition,0,100000);
//        Person person=personInformationMapper.queryByPersonId("1000900002");
//        Person person1=personService.queryByPersonId("1000900002");
//        List<ObjectCount> objectCountList=personMapper.querySexAndCount();
//        List<ObjectCount> propertyList=personMapper.queryNationAndCount();
//        List<ObjectCount> propertyList1=personMapper.queryPoliticalStatusAndCount();
//        Condition condition=new Condition();
//        Integer count=personMapper.queryCountByCondition(condition,0,1000000);
        //int i=userMapper.updatePassword("6","6");
//        List<Person> personList=personService.zggcddy(1,2);
        List<Person> personList=personMapper.qunzong(1,10);
        List<Person> personList1=personService.qunzong(1,10);
    }
}

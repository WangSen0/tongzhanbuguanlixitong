package test.ssm.service.impl; 

import com.sun.org.apache.regexp.internal.REProgram;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import ssm.entity.*;
import ssm.mapper.*;
import ssm.service.PersonService;
import ssm.service.UserService;
import ssm.utils.Property;

import javax.jws.soap.SOAPBinding;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/** 
* TestServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>九月 17, 2017</pre> 
* @version 1.0 
*/ 
public class TestServiceImplTest extends  AbstractTestCase {
    @Autowired
    UserService userService;
@Autowired
    AchievementMapper achievementMapper;
@Autowired
    BookMapper bookMapper;
    @Autowired
    DeputypeopleMapper deputypeopleMapper;
    @Autowired
    FamilyMapper familyMapper;
    @Autowired
    PaperMapper paperMapper;
    @Autowired
    ParttimejobMapper parttimejobMapper;
    @Autowired
    PatentMapper patentMapper;
    @Autowired
    PersonMapper personMapper;
    @Autowired
    PhenomMapper phenomMapper;
    @Autowired
    PoliticalconsultMapper politicalconsultMapper;
    @Autowired
    PoliticalpartMapper politicalpartMapper;
    @Autowired
    PoliticalperformenceMapper politicalperformenceMapper;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    ReportMapper reportMapper;
    @Autowired
    ResumeMapper resumeMapper;
    @Autowired
    RewardMapper rewardMapper;
    @Autowired
    StudyabroadMapper studyabroadMapper;
    @Autowired
    TrainingMapper trainingMapper;
    @Autowired
    UnitedpartMapper unitedpartMapper;
    @Autowired
    WorksMapper worksMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    PersonService personService;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: list() 
* 
*/
@Test
public void testAchievement() throws Exception{
    Achievement achievement=new Achievement();
    achievement.setPersonId("1");
    achievement.setAchievementContent("789");

    int i=achievementMapper.insertAchievement(achievement);
    List<Achievement> achievementList=achievementMapper.listAllAchievement();
    Achievement achievement1=achievementMapper.queryByAchievementId(4);
    List<Achievement> achievementList1=achievementMapper.queryByPersonId("1");
    achievement1.setAchievementContent("111");

    int j=achievementMapper.updateAchievement(achievement1);
    achievementMapper.deleteByAchievementId(4);

}
@Test
public void testBook() throws Exception{
//    Book book =new Book();
//    book.setId(1);
//    book.setBookId("1");
//    book.setPersonId("2");
//    book.setBookTitle("wangsen");
//    book.setBookPublish("qinghua");
//    int i=bookMapper.insertBook(book);
//    List<Book> bookList=bookMapper.listAllBook();
    List<Book> bookList1=bookMapper.queryByPersonId("2");
//    Book book1=bookMapper.queryByBookId(20);
//    book1.setBookPublish("beida");
//    int j=bookMapper.updateBook(book1);
//    int k=bookMapper.deleteByBookId(20);
}
@Test
public void testDeputypeople() throws Exception {
    Deputypeople deputypeople=new Deputypeople();
    deputypeople.setPersonId("1");
    deputypeople.setDeputypeopleCountry("zhongguo");
    deputypeople.setDeputypeopleProvince("changchun");
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    deputypeople.setDeputypeopleStartTime(simpleDateFormat.parse("2000-09-14"));
    deputypeople.setDeputypeopleEndTime(simpleDateFormat.parse("2010-09-14"));
    int i=deputypeopleMapper.insertDeputypeople(deputypeople);
    deputypeopleMapper.listAllDeputypeople();
    Deputypeople deputypeople1=deputypeopleMapper.queryByDeputypeopleId(2);
    List<Deputypeople> deputypeopleList=deputypeopleMapper.queryByPersonId("1");
    deputypeople.setPersonId("1");
    deputypeople.setDeputypeopleTimes(2);
    deputypeople.setDeputypeopleEndTime(simpleDateFormat.parse("2017-09-14"));
    int j=deputypeopleMapper.updateDeputypeople(deputypeople);
    int k=deputypeopleMapper.deleteByDeputypeopleId(2);
}
@Test
public void testFamily()throws Exception{
    Family family=new Family();
    List<Family> familyList;
    family.setPersonId("1");
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    family.setFamilyBirthday(simpleDateFormat.parse("1999-09-14"));
    family.setFamilyRelation("son");
    int i=familyMapper.insertFamily(family);
    familyList=familyMapper.listAllFamily();
    family=familyMapper.queryByFamilyId(1);
    familyList=familyMapper.queryByPersonId("1");
    family.setPersonId("1");
    family.setFamilyRelation("father");
    int j=familyMapper.updateFamily(family);
    familyMapper.deleteByFamilyId(1);
}
@Test
public void testPaper()throws Exception{
    Paper paper=new Paper();
    paper.setPaperId("1");
    paper.setPersonId("2");
    paper.setPaperTitle("3");
    paper.setPaperPublications("4");
    paper.setPaperLevel("5");
    int i=paperMapper.insertPaper(paper);
    List<Paper> paperList=paperMapper.listAllPaper();
    List<Paper> paperList1=paperMapper.queryByPersonId("1");
    Paper paper1=paperMapper.queryByPaperId(10);
    paper1.setPaperLevel("666");
    int j=paperMapper.updatePaper(paper1);
    int k=paperMapper.deleteByPaperId(10);
}
@Test
    public void testParttimejob()throws Exception{
    Parttimejob parttimejob=new Parttimejob();
    parttimejob.setPersonId("1");
    parttimejob.setParttimejobContent("wangaen");
    int i=parttimejobMapper.insertParttimejob(parttimejob);

    List<Parttimejob> parttimejobList=parttimejobMapper.listAllParttimejob();
    Parttimejob parttimejob1=parttimejobMapper.queryByParttimejobId(1);
    List<Parttimejob> parttimejobList1=parttimejobMapper.queryByPersonId("1");

    parttimejob.setParttimejobId(1);
    parttimejob.setParttimejobContent("wangting");
    int j=parttimejobMapper.updateParttimejob(parttimejob);
    int k=parttimejobMapper.deleteByParttimejobId(1);
}
@Test
    public void testPatent()throws Exception{
    Patent patent=new Patent();
    patent.setPatentId("1");
    patent.setPersonId("2");
    patent.setPatentTitle("3");
    patent.setPatentAuthor("4");
    patent.setPatentType("5");
    int i=patentMapper.insertPatent(patent);
    List<Patent> patentList=patentMapper.listAllPatent();
    List<Patent> patentList1=patentMapper.queryByPersonId("2");
    Patent patent1=patentMapper.queryByPatentId(15);
    patent1.setPatentAuthor("666");
    int j=patentMapper.updatePatent(patent1);
    int k=patentMapper.deleteByPatentId(15);
}
@Test
    public void testPhenom()throws Exception{
    Phenom phenom=new Phenom();
    phenom.setPersonId("1");
    phenom.setPhenomTitle("title");
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    phenom.setPhenomStartTime(simpleDateFormat.parse("2000-01-01"));
    phenom.setPhenomEndTime(simpleDateFormat.parse("2010-01-01"));
    phenomMapper.insertPhenom(phenom);

    List<Phenom> phenomList=phenomMapper.listAllPhenom();
    Phenom phenom1=phenomMapper.queryByPhenomId(1);
    List<Phenom> phenomList1=phenomMapper.queryByPersonId("1");

    phenom1.setPhenomTitle("wangsen");
    phenomMapper.updatePhenom(phenom1);
    phenomMapper.deleteByPhenomId(1);
}
@Test
    public void testpoliticalconsult()throws  Exception{
    Politicalconsult politicalconsult=new Politicalconsult();
    politicalconsult.setPersonId("1");
    politicalconsult.setPoliticalconsultCountry("zhongguo");
    politicalconsult.setPoliticalconsultProvince("changchun");
    politicalconsult.setPoliticalconsultTimes(10);
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    politicalconsult.setPoliticalconsultStartTime(simpleDateFormat.parse("2000-09-14"));
    politicalconsult.setPoliticalconsultEndTime(simpleDateFormat.parse("2010-09-14"));
    int i=politicalconsultMapper.insertPoliticalconsult(politicalconsult);

    List<Politicalconsult> politicalconsultList=politicalconsultMapper.listAllPoliticalconsult();
    Politicalconsult politicalconsult1=politicalconsultMapper.queryByPoliticalconsultId(1);
    List<Politicalconsult> politicalconsultList1=politicalconsultMapper.queryByPersonId("1");

    politicalconsult1.setPoliticalconsultEndTime(simpleDateFormat.parse("1999-09-14"));
    int j=politicalconsultMapper.updatePoliticalconsult(politicalconsult1);
    int k=politicalconsultMapper.deleteByPoliticalconsultId(1);
}
@Test
    public void testPoliticalpart() throws Exception{
    Politicalpart politicalpart=new Politicalpart();
    politicalpart.setPersonId("1");
    politicalpart.setPoliticalpartCountry("zhongguo");
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    politicalpart.setPoliticalpartStartTime(simpleDateFormat.parse("2000-09-14"));
    politicalpart.setPoliticalpartEndTime(simpleDateFormat.parse("2010-09-14"));
    int i=politicalpartMapper.insertPoliticalpart(politicalpart);

    List<Politicalpart> politicalpartList=politicalpartMapper.listAllPoliticalpart();
    Politicalpart politicalpart1=politicalpartMapper.queryByPoliticalpartId(1);
    List<Politicalpart> politicalpartList1=politicalpartMapper.queryByPersonId("1");

    politicalpart1.setPoliticalpartEndTime(simpleDateFormat.parse("2017-09-14"));
    int j=politicalpartMapper.updatePoliticalpart(politicalpart1);
    int k=politicalpartMapper.deleteByPoliticalpartId(1);
}
@Test
    public void testPoliticalperformence()throws Exception{
    Politicalperformence politicalperformence=new Politicalperformence();
    politicalperformence.setPersonId("1");
    politicalperformence.setPoliticalperformenceContent("content");
    int i=politicalperformenceMapper.insertPoliticalperformence(politicalperformence);

    List<Politicalperformence> politicalperformenceList=politicalperformenceMapper.listAllPoliticalperformence();
    Politicalperformence politicalperformence1=politicalperformenceMapper.queryByPoliticalperformenceId(2);
    List<Politicalperformence> politicalperformenceList1=politicalperformenceMapper.queryByPersonId("2");

    politicalperformence1.setPoliticalperformenceContent("wangsaen");
    int j=politicalperformenceMapper.updatePoliticalperformence(politicalperformence1);
    int k=politicalperformenceMapper.deleteByPoliticalperformenceId(2);
}
@Test
public void testProject()throws Exception{
    Project project=new Project();
    project.setProjectId("1");
    project.setPersonId("2");
    project.setProjectTitle("3");
    project.setProjectLevel("4");
    project.setProjectOutlay(23.6);
    int i=projectMapper.insertProject(project);
    List<Project> projectList=projectMapper.listAllProject();
    List<Project> projectList1=projectMapper.queryByPersonId("2");
    Project project1=projectMapper.queryByProjectId(12);
    project1.setProjectOutlay(88.8);
    int j=projectMapper.updateProject(project1);
    int k=projectMapper.deleteByProjectId(12);
}
@Test
public void testReport()throws Exception{
    Report report=new Report();
    report.setPersonId("1");
    report.setPersonId("2");
    report.setReportTitle("3");
    report.setReportBelong("4");
    int i=reportMapper.insertReport(report);
    List<Report> reportList=reportMapper.listAllReport();
    List<Report> reportList1=reportMapper.queryByPersonId("2");
    Report report1=reportMapper.queryByReportId(20);
    report1.setReportTitle("666");
    int j=reportMapper.updateReport(report1);
    int k=reportMapper.deleteByReportId(20);
}
@Test
    public void testResume() throws  Exception{
    Resume resume=new Resume();
    resume.setPersonId("1");
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    resume.setResumeStartTime(simpleDateFormat.parse("2000-01-01"));
    resume.setResumeEndTime(simpleDateFormat.parse("2010-01-01"));
    resume.setResumeContent("content");
    int i=resumeMapper.insertResume(resume);

    List<Resume> resumeList=resumeMapper.listAllResume();
    Resume resume1=resumeMapper.queryByResumeId(1);
    List<Resume> resumeList1=resumeMapper.queryByPersonId("1");

    resume1.setResumeContent("wangsen");
    int j=resumeMapper.updateResume(resume1);
    int k=resumeMapper.deleteByResumeId(1);
}
@Test
public void testReward() throws Exception{
    Reward reward=new Reward();
    reward.setRewardId("1");
    reward.setPersonId("2");
    reward.setRewardName("3");
    reward.setRewardAchievement("4");
    int i=rewardMapper.insertReward(reward);
    List<Reward> rewardList=rewardMapper.listAllReward();
    List<Reward> rewardList1=rewardMapper.queryByPersonId("2");
    Reward reward1=rewardMapper.queryByRewardId(11);
    reward1.setRewardAchievement("666");
    int j=rewardMapper.updateReward(reward1);
    int k=rewardMapper.deleteByRewardId(11);
}
@Test
    public void testStudyabroad()throws Exception{
    Studyabroad studyabroad=new Studyabroad();
    studyabroad.setPersonId("vvv");
    studyabroad.setStudyabroadStatus("vvv");
//    studyabroad.setPersonId("1");
//    studyabroad.setStudyabroadCountry("zhongguo");
//    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//    studyabroad.setStudyabroadEndTime(simpleDateFormat.parse("2000-01-01"));
//    studyabroad.setStudyabroadId(1);
    int i=studyabroadMapper.insertStudyabroad(studyabroad);

//    List<Studyabroad> studyabroadList=studyabroadMapper.listAllStudyabroad();
//    Studyabroad studyabroad1=studyabroadMapper.queryByStudyabroadId(1);
//    List<Studyabroad> studyabroadList1=studyabroadMapper.queryByPersonId("1");
//
//    studyabroad1.setStudyabroadCountry("country");
//    studyabroad1.setStudyabroadPurpose("purpose");
//    int j=studyabroadMapper.updateStudyabroad(studyabroad1);
//    int k=studyabroadMapper.deleteByStudyabroadId(1);

}
@Test
    public void testTraining()throws Exception{
    Training training=new Training();
    training.setPersonId("1");
    training.setTrainingCompany("company");
    training.setTrainingContent("content");
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    training.setTrainingStartTime(simpleDateFormat.parse("2000-01-01"));
    int i=trainingMapper.insertTraining(training);

    List<Training> trainingList=trainingMapper.listAllTraining();
    Training training1=trainingMapper.queryByTrainingId(1);
    List<Training> trainingList1=trainingMapper.queryByPersonId("1");

    training1.setTrainingContent("wangsen");
    int j=trainingMapper.updateTraining(training1);
    int k=trainingMapper.deleteByTrainingId(1);
}
@Test
    public void testUnitedpart()throws Exception{
    Unitedpart unitedpart=new Unitedpart();
    unitedpart.setPersonId("1");
    unitedpart.setUnitedpartCity("changchun");
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    //unitedpart.setUnitedpartEndTime(simpleDateFormat.parse("2000-09-14"));
    unitedpart.setUnitedpartId(1);
    int i=unitedpartMapper.insertUnitedpart(unitedpart);

    List<Unitedpart> unitedpartList=unitedpartMapper.listAllUnitedpart();
    Unitedpart unitedpart1=unitedpartMapper.queryByUnitedpartId(1);
    List<Unitedpart> unitedpartList1=unitedpartMapper.queryByPersonId("1");

    unitedpart1.setUnitedpartCity("taiyuan");
    //unitedpart1.setUnitedpartEndTime(simpleDateFormat.parse("2010-01-01"));
    int j=unitedpartMapper.updateUnitedpart(unitedpart1);
    int k=unitedpartMapper.deleteByUnitedpartId(1);
}
@Test
public void testWorks()throws Exception{
    Works works=new Works();
    works.setWorksId("1");
    works.setPersonId("2");
    works.setWorksTitle("3");
    works.setWorksBelong("4");
    int i=worksMapper.insertWorks(works);
//    List<Works> worksList=worksMapper.listAllWorks();
//    List<Works> worksList1=worksMapper.queryByPersonId("2");
//    Works works1=worksMapper.queryByWorksId(10);
//    works1.setWorksTitle("555");
//    int j=worksMapper.updateWorks(works1);
//    int k=worksMapper.deleteByWorksId(1);
}
@Test
public void testPerson()throws Exception{
//    Person person=new Person();
//    person.setPersonId("2016102530");
//    person.setName("wangsen");
//    person.setSex("男");
//    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//    person.setBirthday(simpleDateFormat.parse("2000-01-01"));
//    person.setIdcard("idcard");
//    person.setOutparttraining("参政议政");
//    int i=personMapper.insertPerson(person);
//
    //List<Person> personList=personMapper.listAllPerson();
//    Person person1=personMapper.queryByPersonId("123");
//    person1.setName("wangting");
//    int j=personMapper.updatePerson(person1);
//    int k=personMapper.deleteByPersonId("123");
    Condition condition=new Condition();
    condition.setStationLevelName("分级");
    List<Person> personList=personMapper.queryByCondition(condition,0,1000);
//    List<Person> personList1=personMapper.queryByCondition(condition,0,10);
//    List<String> list=personMapper.queryPoliticalStatus();
//    List<String> list1=personMapper.querySecondPoliticalStatus();
//    List<String> list2=personMapper.queryGraduationSchool();
//    List<String> list3=personMapper.queryHighestEducation();
//    List<String> list4=personMapper.queryHighestDegree();
//    List<String> list5=personMapper.queryAcademyLocation();
//    List<String> list6=personMapper.queryEmployPosition();
//    List<String> list7=personMapper.queryPoliticalPosition();
//    List<String> list8=personMapper.queryNation();
}
@Test
public void testUser() throws Exception{
    List<User> userList=userMapper.queryByLimit("",0,2);
//    User user=new User();
//    user.setUserName("wangsen");
//    user.setUserPassword("password");
//    user.setUserAuthority("authority");
//    //int i=userMapper.insertUser(user);
//    User user2=userMapper.queryByNameAndPassword(user);
//
//    List<User> userList=userMapper.listAllUser();
//    User user1=userMapper.queryByUserId(1);
//
//    user1.setUserName("wangting");
//    int j=userMapper.updateUser(user1);
//    //int k=userMapper.deleteByUserId(1);
    userMapper.queryByUserName("123");
}
@Test
    public void testQuerySex()throws Exception{
    Condition condition=new Condition();
    List<Person> personList=personMapper.queryByCondition(condition,0,1000000);
//    Condition condition=new Condition();
//    List<Property> list1=personMapper.querySexByCondition(condition);
//    List<Property> list3=personMapper.queryNationByCondition(condition);
//    List<Property> list4=personMapper.queryPoliticalStatusByCondition(condition);
//    List<Property> list5=personMapper.queryStaffStatusByCondition(condition);
//    List<Property> list6=personMapper.queryEmployPositionByCondition(condition);
//    List<Property> list7=personMapper.queryOutparttrainingByCondition(condition);
}
@Test
    public void testDeleteByPersonId()throws Exception{
    int i;
    List<String> q=phenomMapper.queryPhenomTitle();
    //i=achievementMapper.deleteByPersonId("2");
//    i=bookMapper.deleteByPersonId("2");
//    i=deputypeopleMapper.deleteByPersonId("2");
//    i=familyMapper.deleteByPersonId("2");
//    i=paperMapper.deleteByPersonId("2");
//    i=parttimejobMapper.deleteByPersonId("2");
//    i=patentMapper.deleteByPersonId("2");
//    i=phenomMapper.deleteByPersonId("2");
//    i=politicalconsultMapper.deleteByPersonId("2");
//    i=politicalpartMapper.deleteByPersonId("2");
//    i=politicalperformenceMapper.deleteByPersonId("2");
//    i=projectMapper.deleteByPersonId("2");
//    i=reportMapper.deleteByPersonId("2");
//    i=resumeMapper.deleteByPersonId("2");
//    i=rewardMapper.deleteByPersonId("2");
//    i=studyabroadMapper.deleteByPersonId("2");
//    i=trainingMapper.deleteByPersonId("2");
//    i=unitedpartMapper.deleteByPersonId("2");
//    i=worksMapper.deleteByPersonId("2");
}
@Test
    public void test()throws Exception{
    List<User> userList=userService.listAllUser();
}
}

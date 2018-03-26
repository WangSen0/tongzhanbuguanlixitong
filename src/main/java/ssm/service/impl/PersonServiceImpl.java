package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.entity.*;
import ssm.mapper.*;
import ssm.service.PersonService;
import ssm.utils.ObjectCount;
import ssm.utils.Property;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/26
 */
@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    PersonMapper personMapper;
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
    List<Achievement> achievementList;
    List<Book> bookList;
    List<Deputypeople> deputypeopleList;
    List<Family> familyList;
    List<Paper> paperList;
    List<Parttimejob> parttimejobList;
    List<Patent> patentList;
    List<Phenom> phenomList;
    List<Politicalconsult> politicalconsultList;
    List<Politicalpart> politicalpartList;
    List<Politicalperformence>politicalperformenceList;
    List<Project> projectList;
    List<Report> reportList;
    List<Resume> resumeList;
    List<Reward> rewardList;
    List<Studyabroad> studyabroadList;
    List<Training> trainingList;
    List<Unitedpart> unitedpartList;
    List<Works> worksList;
    @Override
    public List<Person> listAllPerson()throws Exception{
        return personMapper.listAllPerson();
    }
    @Override
    public Person queryByPersonId(String id)throws Exception{
        return personMapper.queryByPersonId(id);
    }
    @Override
    public List<Person> queryByCondition(Condition condition, Integer offerset, Integer rows)throws Exception{
        return personMapper.queryByCondition(condition,offerset,rows);
    }
    @Override
    public Integer queryCountByCondition(Condition condition, Integer offerset, Integer rows)throws Exception{
        return personMapper.queryCountByCondition(condition,offerset,rows);
    }
    private void qwe(Person person){
        achievementList= person.getAchievementList();
        bookList=person.getBookList();
        deputypeopleList=person.getDeputypeopleList();
        familyList=person.getFamilyList();
        paperList=person.getPaperList();
        parttimejobList=person.getParttimejobList();
        patentList=person.getPatentList();
        phenomList=person.getPhenomList();
        politicalconsultList=person.getPoliticalconsultList();
        politicalpartList= person.getPoliticalpartList();
        politicalperformenceList= person.getPoliticalperformenceList();
        projectList=person.getProjectList();
        reportList=person.getReportList();
        resumeList=person.getResumeList();
        rewardList=person.getRewardList();
        studyabroadList=person.getStudyabroadList();
        trainingList=person.getTrainingList();
        unitedpartList=person.getUnitedpartList();
        worksList=person.getWorksList();
    }
    public void insert()throws Exception{
        if(achievementList!=null){
            for(Achievement achievement:achievementList){
                if(achievement.getPersonId()==null||achievement.getPersonId()=="")
                    continue;
                achievementMapper.insertAchievement(achievement);
            }
        }
        if(bookList!=null){
            for(Book book:bookList){
                if(book.getPersonId()==null||book.getPersonId()=="")
                    continue;
                bookMapper.insertBook(book);
            }
        }
        if(deputypeopleList!=null){
            for(Deputypeople deputypeople:deputypeopleList){
                if(deputypeople.getPersonId()==null||deputypeople.getPersonId()=="")
                    continue;
                deputypeopleMapper.insertDeputypeople(deputypeople);
            }
        }
        if(familyList!=null){
            for(Family family:familyList){
                if(family.getPersonId()==null||family.getPersonId()=="")
                    continue;
                familyMapper.insertFamily(family);
            }
        }
        if(paperList!=null){
            for(Paper paper:paperList){
                if(paper.getPersonId()==null||paper.getPersonId()=="")
                    continue;
                paperMapper.insertPaper(paper);
            }
        }
        if(parttimejobList!=null){
            for(Parttimejob parttimejob:parttimejobList){
                if(parttimejob.getPersonId()==null||parttimejob.getPersonId()=="")
                    continue;
                parttimejobMapper.insertParttimejob(parttimejob);
            }
        }
        if(patentList!=null){
            for(Patent patent:patentList){
                if(patent.getPersonId()==null||patent.getPersonId()=="")
                    continue;
                patentMapper.insertPatent(patent);
            }
        }
        if(phenomList!=null){
            for(Phenom phenom:phenomList){
                if(phenom.getPersonId()==null||phenom.getPersonId()=="")
                    continue;
                phenomMapper.insertPhenom(phenom);
            }
        }
        if(politicalconsultList!=null){
            for(Politicalconsult politicalconsult:politicalconsultList){
                if(politicalconsult.getPersonId()==null||politicalconsult.getPersonId()=="")
                    continue;
                politicalconsultMapper.insertPoliticalconsult(politicalconsult);
            }
        }
        if(politicalpartList!=null){
            for(Politicalpart politicalpart:politicalpartList){
                if(politicalpart.getPersonId()==null||politicalpart.getPersonId()=="")
                    continue;
                politicalpartMapper.insertPoliticalpart(politicalpart);
            }
        }
        if(politicalperformenceList!=null){
            for(Politicalperformence politicalperformence:politicalperformenceList){
                if(politicalperformence.getPersonId()==null||politicalperformence.getPersonId()=="")
                    continue;
                politicalperformenceMapper.insertPoliticalperformence(politicalperformence);
            }
        }
        if(projectList!=null){
            for(Project project:projectList){
                if(project.getPersonId()==null||project.getPersonId()=="")
                    continue;
                projectMapper.insertProject(project);
            }
        }
        if(reportList!=null){
            for(Report report:reportList){
                if(report.getPersonId()==null||report.getPersonId()=="")
                    continue;
                reportMapper.insertReport(report);
            }
        }
        if(resumeList!=null){
            for(Resume resume:resumeList){
                if(resume.getPersonId()==null||resume.getPersonId()=="")
                    continue;
                resumeMapper.insertResume(resume);
            }
        }
        if(rewardList!=null){
            for(Reward reward:rewardList){
                if(reward.getPersonId()==null||reward.getPersonId()=="")
                    continue;
                rewardMapper.insertReward(reward);
            }
        }
        if(studyabroadList!=null){
            for(Studyabroad studyabroad:studyabroadList){
                if(studyabroad.getPersonId()==null||studyabroad.getPersonId()=="")
                    continue;
                studyabroadMapper.insertStudyabroad(studyabroad);
            }
        }
        if(trainingList!=null){
            for(Training training:trainingList){
                if(training.getPersonId()==null||training.getPersonId()=="")
                    continue;
                trainingMapper.insertTraining(training);
            }
        }
        if(unitedpartList!=null){
            for(Unitedpart unitedpart:unitedpartList){
                if(unitedpart.getPersonId()==null||unitedpart.getPersonId()=="")
                    continue;
                unitedpartMapper.insertUnitedpart(unitedpart);
            }
        }
        if(worksList!=null){
            for(Works works:worksList){
                if(works.getPersonId()==null||works.getPersonId()=="")
                    continue;
                worksMapper.insertWorks(works);
            }
        }
    }
    @Override
    public int insertPerson(Person person)throws Exception{
        qwe(person);
        int k=0;
        if(person.getPersonId()!=null&&person.getPersonId()!="")
            k=personMapper.insertPerson(person);
        insert();
        return k;
    }
    @Override
    public int deleteByPersonId(String id)throws Exception{
        deleteAllBesidePerson(id);
        return personMapper.deleteByPersonId(id);
    }
    @Override
    public int updatePerson(Person person) throws Exception{
        qwe(person);
        deleteAllBesidePerson(person.getPersonId());
        insert();
        return personMapper.updatePerson(person);
    }

    @Override
    public List<String> queryNation()throws Exception{
        return personMapper.queryNation();
    }
    @Override
    public List<String> queryPoliticalStatus()throws Exception{
        return personMapper.queryPoliticalStatus();
    }
    @Override
    public List<String> querySecondPoliticalStatus()throws Exception{
        return personMapper.querySecondPoliticalStatus();
    }
    @Override
    public List<String> queryGraduationSchool()throws Exception{
        return personMapper.queryGraduationSchool();
    }
    @Override
    public List<String> queryHighestEducation()throws Exception{
        return personMapper.queryHighestEducation();
    }
    @Override
    public List<String> queryHighestDegree()throws Exception{
        return personMapper.queryHighestDegree();
    }
    @Override
    public List<String> queryAcademyLocation()throws Exception{
        return personMapper.queryAcademyLocation();
    }
    @Override
    public List<String> queryEmployPosition()throws Exception{
        return personMapper.queryEmployPosition();
    }
    @Override
    public List<String> queryPoliticalPosition()throws Exception{
        return personMapper.queryPoliticalPosition();
    }
    @Override
    public List<String> queryCountry()throws Exception{
        return personMapper.queryCountry();
    }
    @Override
    public List<String> queryStationLevelName()throws Exception{
        return personMapper.queryStationLevelName();
    }
    @Override
    public List<Property> querySexByCondition(Condition condition)throws Exception{
        return personMapper.querySexByCondition(condition);
    }
    @Override
    public List<Property> queryBirthdayByCondition10(Condition condition)throws Exception{
        List<Property> propertyList2=new ArrayList<>();
        List<Property> propertyList1=personMapper.queryBirthdayByCondition(condition);
        int[] a=new int[10];
        for(Property property:propertyList1){
            int year=Integer.parseInt(property.getName().substring(0,4));
            int month=Integer.parseInt(property.getName().substring(5,7));
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            int nowYear=Integer.parseInt(simpleDateFormat.format(new Date()).substring(0,4));
            int nowMonth=Integer.parseInt(simpleDateFormat.format(new Date()).substring(5,7));
            int k=(nowYear-year-(nowMonth>month?1:0))/10;
            switch (k){
                case 2:a[k]++;break;
                case 3:a[k]++;break;
                case 4:a[k]++;break;
                case 5:a[k]++;break;
                case 6:a[k]++;break;
                case 7:a[k]++;break;
                case 8:a[k]++;break;
                case 9:a[k]++;break;
            }
        }
        Property property;
        for(int i=2;i<10;i++){
            property=new Property();
            property.setName(String.valueOf(i*10)+"-"+String.valueOf(i*10+9));
            property.setValue(a[i]);
            propertyList2.add(property);
        }
        return propertyList2;
    }
    @Override
    public List<Property> queryBirthdayByCondition5(Condition condition)throws Exception{
        List<Property> propertyList2=new ArrayList<>();
        List<Property> propertyList1=personMapper.queryBirthdayByCondition(condition);
        int[] a=new int[20];
        for(Property property:propertyList1){
            int year=Integer.parseInt(property.getName().substring(0,4));
            int month=Integer.parseInt(property.getName().substring(5,7));
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            int nowYear=Integer.parseInt(simpleDateFormat.format(new Date()).substring(0,4));
            int nowMonth=Integer.parseInt(simpleDateFormat.format(new Date()).substring(5,7));
            int k=(nowYear-year-(nowMonth>month?1:0))/5;
            switch (k){
                case 4:a[k]++;break;
                case 5:a[k]++;break;
                case 6:a[k]++;break;
                case 7:a[k]++;break;
                case 8:a[k]++;break;
                case 9:a[k]++;break;
                case 10:a[k]++;break;
                case 11:a[k]++;break;
                case 12:a[k]++;break;
                case 13:a[k]++;break;
                case 14:a[k]++;break;
                case 15:a[k]++;break;
                case 16:a[k]++;break;
                case 17:a[k]++;break;
                case 18:a[k]++;break;
                case 19:a[k]++;break;
                default:break;
            }
        }
        Property property;
        for(int i=4;i<20;i++){
            property=new Property();
            property.setName(String.valueOf(i*5)+"-"+String.valueOf(i*5+4));
            property.setValue(a[i]);
            propertyList2.add(property);
        }
        return propertyList2;
    }
    @Override
    public String queryPoliticalStatusByPersonId(String id)throws Exception{
        return personMapper.queryPoliticalStatusByPersonId(id);
    }
    @Override
    public List<Property> queryNationByCondition(Condition condition)throws Exception{
        return personMapper.queryNationByCondition(condition);
    }
    @Override
    public List<Property> queryPoliticalStatusByCondition(Condition condition)throws Exception{
        List<Property> propertyList=personMapper.queryPoliticalStatusByCondition(condition);
        for(Property property:propertyList){
            switch (property.getName()){
                case "中国共产党党员":property.setName("中共党员");break;
                case "中国民主同盟盟员":property.setName("民盟");break;
                case "九三学社社员":property.setName("九三");break;
                case "中国民主促进会会员":property.setName("民进");break;
                case "中国国民党革命委员会会员":property.setName("民革");break;
                case "中国共产党预备党员":property.setName("预备党员");break;
                case "中国民主建国会会员":property.setName("民建");break;
                case "无党派民主人士":property.setName("无党派");break;
                case "农工党党员":property.setName("农工");break;
                case "致公党党员":property.setName("致公党");break;
            }
        }
        return propertyList;
    }
    @Override
    public List<Property> queryStaffStatusByCondition(Condition condition)throws Exception{
        return personMapper.queryStaffStatusByCondition(condition);
    }
    @Override
    public List<Property> queryEmployPositionByCondition(Condition condition)throws Exception{
        return personMapper.queryEmployPositionByCondition(condition);
    }
    @Override
    public List<Property> queryOutparttrainingByCondition(Condition condition)throws Exception{
        return personMapper.queryOutparttrainingByCondition(condition);
    }
    @Override
    public List<String> queryPersonId()throws Exception{
        return personMapper.queryPersonId();
    }
    @Override
    public List<ObjectCount> querySexAndCount()throws Exception{
        return personMapper.querySexAndCount();
    }
    @Override
    public List<ObjectCount> queryNationAndCount()throws Exception{
        return personMapper.queryNationAndCount();
    }
    @Override
    public List<ObjectCount> queryPoliticalStatusAndCount()throws Exception{
        return personMapper.queryPoliticalStatusAndCount();
    }
    @Override
    public List<Person> zggcddy(Integer offerset,Integer rows)throws Exception{
        return personMapper.zggcddy(offerset,rows);
    }
    @Override
    public List<Person> zggcdybdy(Integer offerset,Integer rows) throws Exception{
        return personMapper.zggcdybdy(offerset,rows);
    }
    @Override
    public List<Person> gqty(Integer offerset,Integer rows) throws Exception{
        return personMapper.gqty(offerset,rows);
    }
    @Override
    public List<Person> zggmdgmwyhhy(Integer offerset,Integer rows) throws Exception{
        return personMapper.zggmdgmwyhhy(offerset,rows);
    }
    @Override
    public List<Person> zgmztmmy(Integer offerset,Integer rows) throws Exception{
        return personMapper.zgmztmmy(offerset,rows);
    }

    @Override
    public List<Person> zgmzjghhy(Integer offerset,Integer rows) throws Exception{
        return personMapper.zgmzcjhhy(offerset,rows);
    }
    @Override
    public List<Person> zgmzcjhhy(Integer offerset,Integer rows) throws Exception{
        return personMapper.zgmzcjhhy(offerset,rows);
    }
    @Override
    public List<Person> ngddy(Integer offerset,Integer rows) throws Exception{
        return personMapper.ngddy(offerset,rows);
    }
    @Override
    public List<Person> zgggy(Integer offerset,Integer rows) throws Exception{
        return personMapper.zgggy(offerset,rows);
    }
    @Override
    public List<Person> jsxssy(Integer offerset,Integer rows) throws Exception{
        return personMapper.jsxssy(offerset,rows);
    }
    @Override
    public List<Person> tmmy(Integer offerset,Integer rows) throws Exception{
        return personMapper.tmmy(offerset,rows);
    }
    @Override
    public List<Person> wdprs(Integer offerset,Integer rows) throws Exception{
        return personMapper.wdprs(offerset,rows);
    }
    @Override
    public List<Person> qunzong(Integer offerset,Integer rows) throws Exception{
        return personMapper.qunzong(offerset,rows);
    }

    //中国国民党革命委员会会员 当前状态
    @Override
    public List<ObjectCount> queryZggmdgmwyhhy()throws Exception{
        List<ObjectCount> zggmdgmwyhhyList=personMapper.queryZggmdgmwyhhy();
        zggmdgmwyhhyList=changeCurrentStatus(zggmdgmwyhhyList);
        return zggmdgmwyhhyList;
    }

    //中国民主同盟盟员 当前状态
    @Override
    public List<ObjectCount> queryZgmztmmy()throws Exception{
        List<ObjectCount> zgmztmmyList=personMapper.queryZgmztmmy();
        zgmztmmyList=changeCurrentStatus(zgmztmmyList);
        return zgmztmmyList;
    }

    //中国民主建国会会员 当前状态
    @Override
    public List<ObjectCount> queryZgmzjghhy()throws Exception{
        List<ObjectCount> zgmzjghhyList=personMapper.queryZgmzjghhy();
        zgmzjghhyList=changeCurrentStatus(zgmzjghhyList);
        return zgmzjghhyList;
    }

    //中国民主促进会会员 当前状态
    @Override
    public List<ObjectCount> queryZgmzcjhhy()throws Exception{
        List<ObjectCount> zgmzcjhhyList=personMapper.queryZgmzcjhhy();
        zgmzcjhhyList=changeCurrentStatus(zgmzcjhhyList);
        return zgmzcjhhyList;
    }

    //农工党党员 当前状态
    @Override
    public List<ObjectCount> queryNgddy()throws Exception{
        List<ObjectCount> ngddyList=personMapper.queryNgddy();
        ngddyList=changeCurrentStatus(ngddyList);
        return ngddyList;
    }

    //九三学社社员 当前状态
    @Override
    public List<ObjectCount> queryJsxssy()throws Exception{
        List<ObjectCount> jsxssyList=personMapper.queryJsxssy();
        jsxssyList=changeCurrentStatus(jsxssyList);
        return jsxssyList;
    }

    //台联 当前状态
    @Override
    public List<ObjectCount> queryTailian()throws Exception{
        List<ObjectCount> tailianList=personMapper.queryTailian();
        tailianList=changeCurrentStatus(tailianList);
        return tailianList;
    }

    //侨联 当前状态
    @Override
    public List<ObjectCount> queryQiaolian()throws Exception{
        List<ObjectCount> qiaolianList=personMapper.queryQiaolian();
        qiaolianList=changeCurrentStatus(qiaolianList);
        return qiaolianList;
    }

    //无党派民主人士 聘任职务
    @Override
    public List<ObjectCount> queryWdprs()throws Exception{
        List<ObjectCount> wdprsList=personMapper.queryWdprs();
        wdprsList=changeEmployPosition(wdprsList);
        return wdprsList;
    }

    // 归国 聘任职务
    @Override
    public List<ObjectCount> queryStudyabroad()throws Exception{
        List<ObjectCount> studyabroadList=personMapper.queryStudyabroad();
        studyabroadList=changeEmployPosition(studyabroadList);
        return studyabroadList;
    }

    //少数民族总人数
    @Override
    public Integer queryMinorityCount()throws Exception{
        return personMapper.queryMinorityCount();
    }

    private List<ObjectCount> changeCurrentStatus(List<ObjectCount> objectList){
        boolean flag1,flag2;
        flag1=flag2=false;
        for(ObjectCount objectCount:objectList){
            if(objectCount.getName().equals("在职"))
                flag1=true;
            if(objectCount.getName().equals("退休"))
                flag2=true;
        }
        if(!flag1){
            ObjectCount objectCount=new ObjectCount();
            objectCount.setName("在职");
            objectCount.setValue(0);
            objectList.add(objectCount);
        }
        if(!flag2){
            ObjectCount objectCount=new ObjectCount();
            objectCount.setName("退休");
            objectCount.setValue(0);
            objectList.add(objectCount);
        }
        return objectList;
    }
    private List<ObjectCount> changeEmployPosition(List<ObjectCount> objectList){
        boolean flag1,flag2;
        flag1=flag2=false;
        for(ObjectCount objectCount:objectList){
            if(objectCount.getName().equals("教授"))
                flag1=true;
            if(objectCount.getName().equals("副教授"))
                flag2=true;
        }
        if(!flag1){
            ObjectCount objectCount=new ObjectCount();
            objectCount.setName("教授");
            objectCount.setValue(0);
            objectList.add(objectCount);
        }
        if(!flag2){
            ObjectCount objectCount=new ObjectCount();
            objectCount.setName("副教授");
            objectCount.setValue(0);
            objectList.add(objectCount);
        }
        return objectList;
    }
    private void deleteAllBesidePerson(String id){
        try{
            achievementMapper.deleteByPersonId(id);
            bookMapper.deleteByPersonId(id);
            deputypeopleMapper.deleteByPersonId(id);
            familyMapper.deleteByPersonId(id);
            paperMapper.deleteByPersonId(id);

            parttimejobMapper.deleteByPersonId(id);
            patentMapper.deleteByPersonId(id);
            phenomMapper.deleteByPersonId(id);
            politicalconsultMapper.deleteByPersonId(id);
            politicalpartMapper.deleteByPersonId(id);

            politicalperformenceMapper.deleteByPersonId(id);
            projectMapper.deleteByPersonId(id);
            reportMapper.deleteByPersonId(id);
            resumeMapper.deleteByPersonId(id);
            rewardMapper.deleteByPersonId(id);

            studyabroadMapper.deleteByPersonId(id);
            trainingMapper.deleteByPersonId(id);
            unitedpartMapper.deleteByPersonId(id);
            worksMapper.deleteByPersonId(id);
        }catch (Exception e){

        }
    }
}

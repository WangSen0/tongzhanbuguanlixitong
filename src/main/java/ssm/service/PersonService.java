package ssm.service;

import org.apache.ibatis.annotations.Param;
import ssm.entity.Condition;
import ssm.entity.Person;
import ssm.utils.ObjectCount;
import ssm.utils.Property;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/26
 */
public interface PersonService {
    public List<Person> listAllPerson()throws Exception;
    public Person queryByPersonId(String id)throws Exception;
    public List<Person> queryByCondition(Condition condition, Integer offerset, Integer rows)throws Exception;
    public Integer queryCountByCondition(Condition condition, Integer offerset, Integer rows)throws Exception;
    public int insertPerson(Person person)throws Exception;
    public int deleteByPersonId(String id)throws Exception;
    public int updatePerson(Person person) throws Exception;

    public List<String> queryCountry()throws Exception;
    public List<String> queryNation()throws Exception;//民族
    public List<String> queryPoliticalStatus()throws Exception;//查找政治面貌
    public String queryPoliticalStatusByPersonId(String id)throws Exception;
    public List<String> querySecondPoliticalStatus()throws Exception;//查找第二党派
    public List<String> queryGraduationSchool()throws Exception;//查找毕业学校
    public List<String> queryHighestEducation()throws Exception;//最高学历
    public List<String> queryHighestDegree()throws Exception;//最高学位
    public List<String> queryAcademyLocation()throws Exception;//所在院系部
    public List<String> queryEmployPosition()throws Exception;//聘任职务
    public List<String> queryPoliticalPosition()throws Exception;//党政职务级别
    public List<String> queryStationLevelName()throws Exception;//分级岗位名称

    public List<Property> querySexByCondition(Condition condition)throws Exception;
    public List<Property> queryBirthdayByCondition5(Condition condition)throws Exception;
    public List<Property> queryBirthdayByCondition10(Condition condition)throws Exception;
    public List<Property> queryNationByCondition(Condition condition)throws Exception;
    public List<Property> queryPoliticalStatusByCondition(Condition condition)throws Exception;
    public List<Property> queryStaffStatusByCondition(Condition condition)throws Exception;
    public List<Property> queryEmployPositionByCondition(Condition condition)throws Exception;
    public List<Property> queryOutparttrainingByCondition(Condition condition)throws Exception;
    public List<String> queryPersonId()throws Exception;
    public List<ObjectCount> querySexAndCount()throws Exception;//查性别
    public List<ObjectCount> queryNationAndCount()throws Exception;//查民族
    public List<ObjectCount> queryPoliticalStatusAndCount()throws Exception;//查政治面貌

    public List<Person> zggcddy(Integer offerset,Integer rows)throws Exception;//中国共产党党员
    public List<Person> zggcdybdy(Integer offerset,Integer rows) throws Exception;//中国共产党预备党员
    public List<Person> gqty(Integer offerset,Integer rows) throws Exception;//共青团员
    public List<Person> zggmdgmwyhhy(Integer offerset,Integer rows) throws Exception;//中国国民党革命委员会会员
    public List<Person> zgmztmmy(Integer offerset,Integer rows) throws Exception;//中国民主同盟盟员

    public List<Person> zgmzjghhy(Integer offerset,Integer rows) throws Exception;//中国民主建国会会员
    public List<Person> zgmzcjhhy(Integer offerset,Integer rows) throws Exception;//中国民主促进会会员
    public List<Person> ngddy(Integer offerset,Integer rows) throws Exception;//农工党党员
    public List<Person> zgggy(Integer offerset,Integer rows) throws Exception;//致公党党员
    public List<Person> jsxssy(Integer offerset,Integer rows) throws Exception;//九三学社社员

    public List<Person> tmmy(Integer offerset,Integer rows) throws Exception;//台盟盟员
    public List<Person> wdprs(Integer offerset,Integer rows) throws Exception;//无党派民主人士
    public List<Person> qunzong(Integer offerset,Integer rows) throws Exception;//群众

    public List<ObjectCount> queryZggmdgmwyhhy()throws Exception;//中国国民党革命委员会会员 当前状态
    public List<ObjectCount> queryZgmztmmy()throws Exception;//中国民主同盟盟员 当前状态
    public List<ObjectCount> queryZgmzjghhy()throws Exception;//中国民主建国会会员 当前状态
    public List<ObjectCount> queryZgmzcjhhy()throws Exception;//中国民主促进会会员 当前状态
    public List<ObjectCount> queryNgddy()throws Exception;//农工党党员 当前状态

    public List<ObjectCount> queryJsxssy()throws Exception;//九三学社社员 当前状态
    public List<ObjectCount> queryTailian()throws Exception;//台联 当前状态
    public List<ObjectCount> queryQiaolian()throws Exception;//侨联 当前状态
    public List<ObjectCount> queryWdprs()throws Exception;//无党派民主人士 聘任职务
    public List<ObjectCount> queryStudyabroad()throws Exception;// 归国 聘任职务

    public Integer queryMinorityCount()throws Exception;//少数民族总人数
}

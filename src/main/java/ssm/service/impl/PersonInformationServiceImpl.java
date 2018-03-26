package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.entity.InformationCondition;
import ssm.entity.Person;
import ssm.mapper.PersonMapper;
import ssm.mapper.information.PersonInformationMapper;
import ssm.service.PersonInformationService;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/11/10
 */
@Service
public class PersonInformationServiceImpl implements PersonInformationService {
    @Autowired
    PersonInformationMapper personInformationMapper;
    @Autowired
    PersonMapper personMapper;
    @Override
    public Person queryByPersonId(String personId)throws Exception{
        return personInformationMapper.queryByPersonId(personId);
    }
    @Override
    public List<Person> queryByPersonName(String name)throws Exception{
        return personInformationMapper.queryByPersonName(name);
    }
    @Override
    public List<Person> queryByCondition(InformationCondition condition,Integer offerset, Integer rows)throws Exception{
        return personInformationMapper.queryByCondition(condition,offerset,rows);
    }
    @Override
    public Integer queryCountByCondition(InformationCondition condition,Integer offerset, Integer rows)throws Exception{
        return personInformationMapper.queryCountByCondition(condition,offerset,rows);
    }
    public Integer updatePersonByInformation(Person person,Person personInformation)throws Exception{
        if(person.getBookList().size()<personInformation.getBookList().size())
            person.setBookList(personInformation.getBookList());
        if(person.getPaperList().size()<personInformation.getPaperList().size())
            person.setPaperList(personInformation.getPaperList());
        if(person.getPatentList().size()<personInformation.getPatentList().size())
            person.setPatentList(personInformation.getPatentList());
        if(person.getProjectList().size()<personInformation.getProjectList().size())
            person.setProjectList(personInformation.getProjectList());
        if(person.getReportList().size()<personInformation.getReportList().size())
            person.setReportList(personInformation.getReportList());
        if(person.getRewardList().size()<personInformation.getRewardList().size())
            person.setRewardList(personInformation.getRewardList());
        if(person.getWorksList().size()<personInformation.getWorksList().size())
            person.setWorksList(personInformation.getWorksList());

        if(personInformation.getName()!=null&&personInformation.getName()!="")
            person.setName(personInformation.getName());
        if(personInformation.getSex()!=null&&personInformation.getSex()!="")
            person.setSex(personInformation.getSex());
        if(personInformation.getBirthday()!=null&&personInformation.getBirthday().toString()!="")
            person.setBirthday(personInformation.getBirthday());
        if(personInformation.getNationality()!=null&&personInformation.getNationality()!="")
            person.setNationality(personInformation.getNationality());
        if(personInformation.getPlaceOfBirth()!=null&&personInformation.getPlaceOfBirth()!="")
            person.setPlaceOfBirth(personInformation.getPlaceOfBirth());
        if(personInformation.getMaritalStatus()!=null&&personInformation.getMaritalStatus()!="")
            person.setMaritalStatus(personInformation.getMaritalStatus());
        if(personInformation.getCountry()!=null&&personInformation.getCountry()!="")
            person.setCountry(personInformation.getCountry());
        if(personInformation.getEnterschoolTime()!=null&&personInformation.getEnterschoolTime()!="")
            person.setEnterschoolTime(personInformation.getEnterschoolTime());
        if(personInformation.getGraduationSchool()!=null&&personInformation.getGraduationSchool()!="")
            person.setGraduationSchool(personInformation.getGraduationSchool());
        if(personInformation.getHighestEducation()!=null&&personInformation.getHighestEducation()!="")
            person.setHighestEducation(personInformation.getHighestEducation());
        if(personInformation.getHighestDegree()!=null&&personInformation.getHighestDegree()!="")
            person.setHighestDegree(personInformation.getHighestDegree());
        if(personInformation.getProfessional()!=null&&personInformation.getProfessional()!="")
            person.setProfessional(personInformation.getProfessional());
        if(personInformation.getWorkScience()!=null&&personInformation.getWorkScience()!="")
            person.setWorkScience(personInformation.getWorkScience());
        if(personInformation.getResearchArea()!=null&&personInformation.getResearchArea()!="")
            person.setResearchArea(personInformation.getResearchArea());
        if(personInformation.getStartworkTime()!=null&&personInformation.getStartworkTime()!="")
            person.setStartworkTime(personInformation.getStartworkTime());
        if(personInformation.getStaffStatus()!=null&&personInformation.getStaffStatus()!="")
            person.setStaffStatus(personInformation.getStaffStatus());
        if(personInformation.getCurrentStatus()!=null&&personInformation.getCurrentStatus()!="")
            person.setCurrentStatus(personInformation.getCurrentStatus());
        if(personInformation.getCurrentStatusTime()!=null && personInformation.getCurrentStatusTime()!="")
            person.setCurrentStatusTime(personInformation.getCurrentStatusTime());
        if(personInformation.getAcademyLocation()!=null && personInformation.getAcademyLocation()!="")
            person.setAcademyLocation(personInformation.getAcademyLocation());
        if(personInformation.getDepartmentLocation()!=null && personInformation.getDepartmentLocation()!="")
            person.setDepartmentLocation(personInformation.getDepartmentLocation());
        if(personInformation.getPositionLevel()!=null && personInformation.getPositionLevel()!="")
            person.setPositionLevel(personInformation.getPositionLevel());
        if(personInformation.getEmployPosition()!=null && personInformation.getEmployPosition()!="")
            person.setEmployPosition(personInformation.getEmployPosition());
        if(personInformation.getEmployPositionTime()!=null && personInformation.getEmployPositionTime()!="")
            person.setEmployPositionTime(personInformation.getEmployPositionTime());
        if(personInformation.getStationLevel()!=null && personInformation.getStationLevel()!="")
            person.setStationLevel(personInformation.getStationLevel());
        if(personInformation.getStationLevelName()!=null && personInformation.getStationLevelName()!="")
            person.setStationLevelName(personInformation.getStationLevelName());
        if(personInformation.getStationLevelTime()!=null && personInformation.getStationLevelTime()!="")
            person.setStationLevelTime(personInformation.getStationLevelTime());
        if(personInformation.getPoliticalPosition()!=null && personInformation.getPoliticalPosition()!="")
            person.setPoliticalPosition(personInformation.getPoliticalPosition());
        if(personInformation.getPoliticalPositionTime()!=null && personInformation.getPoliticalPositionTime()!="")
            person.setPoliticalPositionTime(personInformation.getPoliticalPositionTime());
        if(personInformation.getStaffLevel()!=null && personInformation.getStaffLevel()!="")
            person.setStaffLevel(personInformation.getStaffLevel());
        if(personInformation.getStaffLevelTime()!=null && personInformation.getStaffLevelTime()!="")
            person.setStaffLevelTime(personInformation.getStaffLevelTime());
        if(personInformation.getIdcard()!=null && personInformation.getIdcard()!="")
            person.setIdcard(personInformation.getIdcard());
        return personMapper.updatePerson(person);
    }
}

package ssm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Entity
public class Person {
    @Column(name = " person_id")//职工号
    private String personId;
    @Column(name = "name")//姓名
    private String name;
    @Column(name = "sex")//性别_显示值
    private String sex;
    @Column(name = "birthday")//出生日期
    private Date birthday;
    @Column(name = "nationality")//籍贯_显示值
    private String nationality;

    @Column(name = "place_of_birth")//出生地_显示值
    private String placeOfBirth;
    @Column(name = "nation")//民族_显示值
    private String nation;
    @Column(name = "marital_status")//婚姻状况_显示值
    private String maritalStatus;
    @Column(name = "country")//国籍_显示值
    private String country;
    @Column(name = "gatq")//港澳台侨_显示值
    private String gatq;

    @Column(name = "political_status")//政治面貌_显示值
    private String politicalStatus;
    @Column(name = "political_time")//参加党派时间
    private String politicalTime;
    @Column(name = "second_political_status")//第二党派
    private String secondPoliticalStatus;
    @Column(name = "scond_time")//第二党派参加党派时间
    private String secondTime;
    @Column(name = "enterschool_time")//入校日期
    private String enterschoolTime;

    @Column(name = "graduation_school")//毕业学校/单位
    private String graduationSchool;
    @Column(name = "highest_education")//最高学历_显示值
    private String highestEducation;
    @Column(name = "highest_degree")//最高学位_显示值
    private String highestDegree;
    @Column(name = "professional")//所学专业
    private String professional;
    @Column(name = "full_time_education")//全日制教育
    private String fullTimeEducation;

    @Column(name = "full_time_education_school")//全日制毕业学校
    private String fullTimeEducationSchool;
    @Column(name = "full_time_education_professional")//全日制毕业专业
    private String fullTimeEducationProfessional;
    @Column(name = "part_time_education")//在职教育
    private String partTimeEducation;
    @Column(name = "part_time_education_school")//在职毕业学校
    private String partTimeEducationSchool;
    @Column(name = "part_time_education_professional")//在职毕业专业
    private String partTimeEducationProfessional;

    @Column(name = "work_science")//现从事学科_显示值
    private String workScience;
    @Column(name = "research_area")//研究方向
    private String researchArea;
    @Column(name = "residence_permit_abroad_status")//有无国外居留证长期永久
    private String residencePermitAbroadStatus;
    @Column(name = "residence_permit_abroad_time")//获居留证时间
    private String residencePermitAbroadTime;
    @Column(name = "startwork_time")//参加工作年月
    private String startworkTime;

    @Column(name = "staff_status")//教职工类别_显示值
    private String staffStatus;
    @Column(name = "current_status")//当前状态_显示值
    private String currentStatus;
    @Column(name = "current_status_time")//状态变更时间
    private String currentStatusTime;
    @Column(name = "health_status")//健康状况
    private String healthStatus;
    @Column(name = "academy_location")//所在院系部处_显示值
    private String academyLocation;

    @Column(name = "department_location")//所在具体部门_显示值
    private String departmentLocation;
    @Column(name = "position_level")//职务级别_显示值
    private String positionLevel;
    @Column(name = "employ_position_time")//职务聘任年月
    private String employPositionTime;
    @Column(name = "employ_position")//聘任职务_显示值
    private String employPosition;
    @Column(name = "station_level")//岗位级别_显示值
    private String stationLevel;

    @Column(name = "station_level_name")//分级岗位名称
    private String stationLevelName;
    @Column(name = "station_level_time")//分级年月
    private String stationLevelTime;
    @Column(name = "political_position")//党政职务级别_显示值
    private String politicalPosition;
    @Column(name = "political_position_time")//任职年月
    private String politicalPositionTime;
    @Column(name = "staff_level")//管理职员职级_显示值
    private  String staffLevel;

    @Column(name = "staff_level_time")//管理职员职级聘任年月
    private String staffLevelTime;
    @Column(name = "speciality")//熟悉何种专业技术及有何种特长
    private String speciality;
    @Column(name = "work_phone")//工作电话
    private String workPhone;
    @Column(name = "family_phone")//家庭电话
    private String familyPhone;
    @Column(name = "phone")//手机
    private String phone;

    @Column(name = "email")//电子邮箱
    private String email;
    @Column(name = "contact_address")//通讯地址
    private String contactAddress;
    @Column(name = "zipcode")//邮编
    private String zipcode;
    @Column(name = "fax")//传真
    private String fax;
    @Column(name = "idcard")//身份证号码
    private String idcard;
    @Column(name = "outparttraining")//党外培养人士培养类别
    private String outparttraining;
    @Column(name = "addStatus")
    String addStatus;

    public String getAddStatus() {
        return addStatus;
    }

    public void setAddStatus(String addStatus) {
        this.addStatus = addStatus;
    }

    public String getOutparttraining() {
        return outparttraining;
    }

    public void setOutparttraining(String outparttraining) {
        this.outparttraining = outparttraining;
    }

    List<Achievement> achievementList;//主要成就和社会影响
    List<Book> bookList;//著作
    List<Deputypeople> deputypeopleList; //人大代表
    List<Family> familyList;//家庭成员
    List<Paper> paperList;//论文

    List<Parttimejob> parttimejobList;//社会兼职
    List<Patent> patentList;//专利
    List<Phenom> phenomList;//杰出人才
    List<Politicalconsult> politicalconsultList;//政协委员
    List<Politicalpart> politicalpartList;//民主党派职务

    List<Politicalperformence> politicalperformenceList;//主要政治表现
    List<Project> projectList;//项目
    List<Report> reportList;//报告
    List<Resume> resumeList;//简历
    List<Reward> rewardList;//奖励

    List<Studyabroad> studyabroadList;//留学
    List<Training> trainingList;//参加政治理论培训与学习情况
    List<Unitedpart> unitedpartList;//统战团体职务
    List<Works> worksList;//作品

    public List<Works> getWorksList() {
        return worksList;
    }

    public void setWorksList(List<Works> worksList) {
        this.worksList = worksList;
    }

    public List<Unitedpart> getUnitedpartList() {
        return unitedpartList;
    }

    public void setUnitedpartList(List<Unitedpart> unitedpartList) {
        this.unitedpartList = unitedpartList;
    }

    public List<Training> getTrainingList() {
        return trainingList;
    }

    public void setTrainingList(List<Training> trainingList) {
        this.trainingList = trainingList;
    }

    public List<Studyabroad> getStudyabroadList() {
        return studyabroadList;
    }

    public void setStudyabroadList(List<Studyabroad> studyabroadList) {
        this.studyabroadList = studyabroadList;
    }

    public List<Reward> getRewardList() {
        return rewardList;
    }

    public void setRewardList(List<Reward> rewardList) {
        this.rewardList = rewardList;
    }

    public List<Resume> getResumeList() {
        return resumeList;
    }

    public void setResumeList(List<Resume> resumeList) {
        this.resumeList = resumeList;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Politicalperformence> getPoliticalperformenceList() {
        return politicalperformenceList;
    }

    public void setPoliticalperformenceList(List<Politicalperformence> politicalperformenceList) {
        this.politicalperformenceList = politicalperformenceList;
    }

    public List<Politicalpart> getPoliticalpartList() {
        return politicalpartList;
    }

    public void setPoliticalpartList(List<Politicalpart> politicalpartList) {
        this.politicalpartList = politicalpartList;
    }

    public List<Politicalconsult> getPoliticalconsultList() {
        return politicalconsultList;
    }

    public void setPoliticalconsultList(List<Politicalconsult> politicalconsultList) {
        this.politicalconsultList = politicalconsultList;
    }

    public List<Phenom> getPhenomList() {
        return phenomList;
    }

    public void setPhenomList(List<Phenom> phenomList) {
        this.phenomList = phenomList;
    }

    public List<Patent> getPatentList() {
        return patentList;
    }

    public void setPatentList(List<Patent> patentList) {
        this.patentList = patentList;
    }

    public List<Parttimejob> getParttimejobList() {
        return parttimejobList;
    }

    public void setParttimejobList(List<Parttimejob> parttimejobList) {
        this.parttimejobList = parttimejobList;
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<Paper> paperList) {
        this.paperList = paperList;
    }

    public List<Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<Family> familyList) {
        this.familyList = familyList;
    }

    public List<Deputypeople> getDeputypeopleList() {
        return deputypeopleList;
    }

    public void setDeputypeopleList(List<Deputypeople> deputypeopleList) {
        this.deputypeopleList = deputypeopleList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Achievement> getAchievementList() {
        return achievementList;
    }

    public void setAchievementList(List<Achievement> achievementList) {
        this.achievementList = achievementList;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getWorkScience() {
        return workScience;
    }

    public void setWorkScience(String workScience) {
        this.workScience = workScience;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public void setCurrentStatusTime(String currentStatusTime) {
        this.currentStatusTime = currentStatusTime;
    }

    public String getStationLevelName() {
        return stationLevelName;
    }

    public void setStationLevelName(String stationLevelName) {
        this.stationLevelName = stationLevelName;
    }

    public String getStationLevel() {
        return stationLevel;
    }

    public void setStationLevel(String stationLevel) {
        this.stationLevel = stationLevel;
    }


    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getStaffLevel() {
        return staffLevel;
    }

    public void setStaffLevel(String staffLevel) {
        this.staffLevel = staffLevel;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSecondPoliticalStatus() {
        return secondPoliticalStatus;
    }

    public void setSecondPoliticalStatus(String secondPoliticalStatus) {
        this.secondPoliticalStatus = secondPoliticalStatus;
    }

    public String getResidencePermitAbroadStatus() {
        return residencePermitAbroadStatus;
    }

    public void setResidencePermitAbroadStatus(String residencePermitAbroadStatus) {
        this.residencePermitAbroadStatus = residencePermitAbroadStatus;
    }

    public String getResearchArea() {
        return researchArea;
    }

    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(String positionLevel) {
        this.positionLevel = positionLevel;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getPoliticalPosition() {
        return politicalPosition;
    }

    public void setPoliticalPosition(String politicalPosition) {
        this.politicalPosition = politicalPosition;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPartTimeEducationSchool() {
        return partTimeEducationSchool;
    }

    public void setPartTimeEducationSchool(String partTimeEducationSchool) {
        this.partTimeEducationSchool = partTimeEducationSchool;
    }

    public String getPartTimeEducationProfessional() {
        return partTimeEducationProfessional;
    }

    public void setPartTimeEducationProfessional(String partTimeEducationProfessional) {
        this.partTimeEducationProfessional = partTimeEducationProfessional;
    }

    public String getPartTimeEducation() {
        return partTimeEducation;
    }

    public void setPartTimeEducation(String partTimeEducation) {
        this.partTimeEducation = partTimeEducation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getGraduationSchool() {
        return graduationSchool;
    }

    public void setGraduationSchool(String graduationSchool) {
        this.graduationSchool = graduationSchool;
    }

    public String getGatq() {
        return gatq;
    }

    public void setGatq(String gatq) {
        this.gatq = gatq;
    }

    public String getFullTimeEducationSchool() {
        return fullTimeEducationSchool;
    }

    public void setFullTimeEducationSchool(String fullTimeEducationSchool) {
        this.fullTimeEducationSchool = fullTimeEducationSchool;
    }

    public String getFullTimeEducationProfessional() {
        return fullTimeEducationProfessional;
    }

    public void setFullTimeEducationProfessional(String fullTimeEducationProfessional) {
        this.fullTimeEducationProfessional = fullTimeEducationProfessional;
    }

    public String getFullTimeEducation() {
        return fullTimeEducation;
    }

    public void setFullTimeEducation(String fullTimeEducation) {
        this.fullTimeEducation = fullTimeEducation;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    public String getEnterschoolTime() {
        return enterschoolTime;
    }

    public void setEnterschoolTime(String enterschoolTime) {
        this.enterschoolTime = enterschoolTime;
    }

    public String getEmployPosition() {
        return employPosition;
    }

    public void setEmployPosition(String employPosition) {
        this.employPosition = employPosition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAcademyLocation() {
        return academyLocation;
    }

    public void setAcademyLocation(String academyLocation) {
        this.academyLocation = academyLocation;
    }

    public String getCurrentStatusTime() {
        return currentStatusTime;
    }
    public String getStationLevelTime() {
        return stationLevelTime;
    }

    public void setStationLevelTime(String stationLevelTime) {
        this.stationLevelTime = stationLevelTime;
    }

    public String getStartworkTime() {
        return startworkTime;
    }

    public void setStartworkTime(String startworkTime) {
        this.startworkTime = startworkTime;
    }

    public String getStaffLevelTime() {
        return staffLevelTime;
    }

    public void setStaffLevelTime(String staffLevelTime) {
        this.staffLevelTime = staffLevelTime;
    }

    public String getSecondTime() {
        return secondTime;
    }

    public void setSecondTime(String secondTime) {
        this.secondTime = secondTime;
    }

    public String getResidencePermitAbroadTime() {
        return residencePermitAbroadTime;
    }

    public void setResidencePermitAbroadTime(String residencePermitAbroadTime) {
        this.residencePermitAbroadTime = residencePermitAbroadTime;
    }

    public String getPoliticalTime() {
        return politicalTime;
    }

    public void setPoliticalTime(String politicalTime) {
        this.politicalTime = politicalTime;
    }

    public String getPoliticalPositionTime() {
        return politicalPositionTime;
    }

    public void setPoliticalPositionTime(String politicalPositionTime) {
        this.politicalPositionTime = politicalPositionTime;
    }

    public String getEmployPositionTime() {
        return employPositionTime;
    }

    public void setEmployPositionTime(String employPositionTime) {
        this.employPositionTime = employPositionTime;
    }
}

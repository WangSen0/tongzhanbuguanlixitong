package ssm.utils;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Repository;
import ssm.entity.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/17
 */
public class Excel extends AbstractCommon{
    SimpleDateFormat simpleDateFormat;
    public Excel(){
        simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    }
    public void writeDetail(Person person,String filePath){
        try{
            XSSFRow row;
            FileInputStream fis = new FileInputStream(new File(filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            for(int k=0;k<workbook.getNumberOfSheets();k++){
                XSSFSheet spreadsheet = workbook.getSheetAt(k);
                Iterator<Row> rowIterator = spreadsheet.iterator();
                while (rowIterator.hasNext()) {
                    row = (XSSFRow) rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String str = cell.getStringCellValue();
                        boolean flag=false;
                        StringBuffer p=new StringBuffer();
                        List<String> list=new ArrayList<>();
                        for(int i=0;i<str.length();i++){
                            if(str.charAt(i)=='#'){
                                if(flag){
                                    list.add(p.toString());
                                    flag=false;
                                }else{
                                    p=new StringBuffer();
                                    flag=true;
                                }
                            }else{
                                p.append(str.charAt(i));
                            }
                        }
                        if(list.size()>0){
                            for(String q:list){
                                if(q.charAt(0)>='0'&&q.charAt(0)<='9'){
                                    str=str.replace("#"+q+"#",find(Integer.parseInt(q.substring(0,1))-1,q.substring(1),person));
                                }else{
                                    str=str.replace("#"+q+"#",find(q,person));
                                }
                            }
                            cell.setCellValue(str);
                        }else{
                            continue;
                        }
                    }
                }
            }

            FileOutputStream out = new FileOutputStream(
                    new File(filePath));
            workbook.write(out);
            out.close();
            fis.close();
        }
        catch(IOException e){}
    }
    public String writeSelect(List<Person> personList, String file, HttpServletRequest request){
        String s="";
        String sss="";
        String ssss="";
        try{
            String filePath;
            if(file.equals("")){
                filePath=request.getServletContext().getRealPath("/excel")+"/"+"547240561565666900.xlsx";
            }else{
                filePath=file;
            }
            List<String> list=new ArrayList<>();
            XSSFRow row;
            FileInputStream fis = new FileInputStream(new File(filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFFont hssfFont = workbook.createFont();
            hssfFont.setFontHeightInPoints((short)10);
            hssfFont.setFontName("宋体");
            XSSFCellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setFont(hssfFont);
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = spreadsheet.iterator();
            if(rowIterator.hasNext()){
                row=(XSSFRow) rowIterator.next();
                for(int i=0;i<personList.size();i++){
                    spreadsheet.createRow(i+1);
                }
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    String str = cell.getStringCellValue();
                    boolean flag=false;
                    StringBuffer p=new StringBuffer();
                    for(int i=0;i<str.length();i++){
                        if(str.charAt(i)=='#'){
                            if(flag){
                                list.add(p.toString());
                                flag=false;
                            }else{
                                p=new StringBuffer();
                                flag=true;
                            }
                        }else{
                            p.append(str.charAt(i));
                        }
                    }
                    String str2=str;
                    if(list.size()>0){
                        for(String q:list){
                            str2=str2.replace("#"+q+"#",q);
                        }
                        cell.setCellValue(str2);
                    }else{
                        continue;
                    }
                    ssss=str;
                    if(list.size()>0){
                        for(int i=0;i<personList.size();i++){
                            String ss=str;
                            Person person=personList.get(i);
                            sss=person.getPersonId();
                            for(String q:list){
                                if(q.charAt(0)>='0'&&q.charAt(0)<='9'){
                                    ss=ss.replace("#"+q+"#",find(Integer.parseInt(q.substring(0,1))-1,q.substring(1),person));
                                }else{
                                    ss=ss.replace("#"+q+"#",find(q,person));
                                }
                            }
                            int qq=i+1;
                            int pp=cell.getColumnIndex();
                            Row nowRow=spreadsheet.getRow(i+1);
                            Cell nowCell=nowRow.createCell(cell.getColumnIndex());
                            nowCell.setCellStyle(cellStyle);
                            nowCell.setCellValue(ss);
                        }

                    }else{
                        continue;
                    }
                }
            }
            FileOutputStream out;
            SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-ddhh-mm-ss");
            if(file.equals("")){
                filePath=request.getServletContext().getRealPath("/excel")+"/"+simpleDateFormat2.format(new Date())+".xlsx";
                out = new FileOutputStream(
                        new File(filePath));
            }else{
                out = new FileOutputStream(
                        new File(filePath));
            }
            workbook.write(out);
            out.close();
            fis.close();
            return filePath;
        }
        catch(IOException e){
            System.out.println(sss+" 123 "+ssss);
            e.printStackTrace();
            return "";
        }
    }
    public String find(int id,String str,Person person){
        StringBuffer s=new StringBuffer();
        s=new StringBuffer();
        try{
            if(str.equals("论文题目")){
                s.append(person.getPaperList().get(id).getPaperTitle());
            }else if(str.equals("发表刊物")){
                s.append(person.getPaperList().get(id).getPaperPublications());
            }else if (str.equals("刊物级别")){
                s.append(person.getPaperList().get(id).getPaperLevel());
            }else if (str.equals("报告名称")){
                s.append(person.getReportList().get(id).getReportTitle());
            }else if (str.equals("报告所属单位")){
                s.append(person.getReportList().get(id).getReportBelong());
            }else if (str.equals("培训地点")){
                s.append(person.getTrainingList().get(id).getTrainingPlace());
            }else if (str.equals("培训单位")){
                s.append(person.getTrainingList().get(id).getTrainingCompany());
            }else if (str.equals("培训内容")){
                s.append(person.getTrainingList().get(id).getTrainingContent());
            }else if (str.equals("培训开始时间")){
                s.append(simpleDateFormat.format(person.getTrainingList().get(id).getTrainingStartTime()));
            }else if (str.equals("培训结束时间")){
                s.append(simpleDateFormat.format(person.getTrainingList().get(id).getTrainingEndTime()));
            }else if (str.equals("奖励名称")){
                s.append(person.getRewardList().get(id).getRewardName());
            }else if (str.equals("成果名称")){
                s.append(person.getRewardList().get(id).getRewardAchievement());
            }else if (str.equals("家属关系")){
                s.append(person.getFamilyList().get(id).getFamilyRelation());
            }else if (str.equals("家属姓名")){
                s.append(person.getFamilyList().get(id).getFamilyName());
            }else if (str.equals("家属出生年月")){
                s.append(simpleDateFormat.format(person.getFamilyList().get(id).getFamilyBirthday()));
            }else if (str.equals("家属政治面貌")){
                s.append(person.getFamilyList().get(id).getFamilyPoliticalStatus());
            }else if (str.equals("家属工作单位")){
                s.append(person.getFamilyList().get(id).getFamilyCompany());
            }else if (str.equals("家属职务")){
                s.append(person.getFamilyList().get(id).getFamilyPosition());
            }else if (str.equals("简历开始时间")){
                s.append(simpleDateFormat.format(person.getResumeList().get(id).getResumeStartTime()));
            }else if (str.equals("简历结束时间")){
                s.append(simpleDateFormat.format(person.getResumeList().get(id).getResumeEndTime()));
            }else if (str.equals("简历内容")){
                s.append(person.getResumeList().get(id).getResumeContent());
            }else if (str.equals("杰出人才称号")){
                s.append(person.getPhenomList().get(id).getPhenomTitle());
            }else if (str.equals("杰出人才开始时间")){
                s.append(simpleDateFormat.format(person.getPhenomList().get(id).getPhenomStartTime()));
            }else if (str.equals("杰出人才结束时间")){
                s.append(simpleDateFormat.format(person.getPhenomList().get(id).getPhenomEndTime()));
            }else if (str.equals("留学情况")){
                s.append(person.getStudyabroadList().get(id).getStudyabroadStatus());
            }else if (str.equals("留学派出类别")){
                s.append(person.getStudyabroadList().get(id).getStudyabroadType());
            }else if (str.equals("留学出境目的")){
                s.append(person.getStudyabroadList().get(id).getStudyabroadPurpose());
            }else if (str.equals("留学派往国家")){
                s.append(person.getStudyabroadList().get(id).getStudyabroadCountry());
            }else if (str.equals("留学进修学校")){
                s.append(person.getStudyabroadList().get(id).getStudyabroadSchool());
            }else if (str.equals("留学出国身份")){
                s.append(person.getStudyabroadList().get(id).getStudyabroadGoabroadIdentity());
            }else if (str.equals("留学身份")){
                s.append(person.getStudyabroadList().get(id).getStudyabroadStudyabroadIdentity());
            }else if (str.equals("留学出国期限")){
                s.append(person.getStudyabroadList().get(id).getStudyabroadLimit());
            }else if (str.equals("留学期限(个月)")){
                s.append(person.getStudyabroadList().get(id).getStudyabroadLimitMonth());
            }else if (str.equals("留学出国日期")){
                s.append(simpleDateFormat.format(person.getStudyabroadList().get(id).getStudyabroadStartTime()));
            }else if (str.equals("留学归国日期")){
                s.append(simpleDateFormat.format(person.getStudyabroadList().get(id).getStudyabroadEndTime()));
            }else if (str.equals("留学备注")) {
                s.append(person.getStudyabroadList().get(id).getStudyabroadRemark());
            }else if (str.equals("民主党派全国")) {
                s.append(person.getPoliticalpartList().get(id).getPoliticalpartCountry());
            }else if (str.equals("民主党派省")) {
                s.append(person.getPoliticalpartList().get(id).getPoliticalpartProvince());
            }else if (str.equals("民主党派市")) {
                s.append(person.getPoliticalpartList().get(id).getPoliticalpartCity());
            }else if (str.equals("民主党派区")) {
                s.append(person.getPoliticalpartList().get(id).getPoliticalpartCounty());
            }else if (str.equals("民主党派校")) {
                s.append(person.getPoliticalpartList().get(id).getPoliticalpartSchool());
            }else if (str.equals("民主党派第几届")) {
                s.append(person.getPoliticalpartList().get(id).getPoliticalpartTimes());
            }else if (str.equals("民主党派职务")) {
                s.append(person.getPoliticalpartList().get(id).getPoliticalpartPosition());
            }else if (str.equals("民主党派开始时间")) {
                s.append(simpleDateFormat.format(person.getPoliticalpartList().get(id).getPoliticalpartStartTime()));
            }else if (str.equals("民主党派结束时间")) {
                s.append(simpleDateFormat.format(person.getPoliticalpartList().get(id).getPoliticalpartEndTime()));
            }else if (str.equals("人大代表全国")) {
                s.append(person.getDeputypeopleList().get(id).getDeputypeopleCountry());
            }else if (str.equals("人大代表省")) {
                s.append(person.getDeputypeopleList().get(id).getDeputypeopleProvince());
            }else if (str.equals("人大代表市")) {
                s.append(person.getDeputypeopleList().get(id).getDeputypeopleCity());
            }else if (str.equals("人大代表区")) {
                s.append(person.getDeputypeopleList().get(id).getDeputypeopleCounty());
            }else if (str.equals("人大代表第几届")) {
                s.append(person.getDeputypeopleList().get(id).getDeputypeopleTimes());
            }else if (str.equals("人大代表开始时间")) {
                s.append(simpleDateFormat.format(person.getDeputypeopleList().get(id).getDeputypeopleStartTime()));
            }else if (str.equals("人大代表结束时间")) {
                s.append(simpleDateFormat.format(person.getDeputypeopleList().get(id).getDeputypeopleEndTime()));
            }else if (str.equals("统战团体全国")) {
                s.append(person.getUnitedpartList().get(id).getUnitedpartCountry());
            }else if (str.equals("统战团体省")) {
                s.append(person.getUnitedpartList().get(id).getUnitedpartProvince());
            }else if (str.equals("统战团体市")) {
                s.append(person.getUnitedpartList().get(id).getUnitedpartCity());
            }else if (str.equals("统战团体区")) {
                s.append(person.getUnitedpartList().get(id).getUnitedpartCounty());
            }else if (str.equals("统战团体校")) {
                s.append(person.getUnitedpartList().get(id).getUnitedpartSchool());
            }else if (str.equals("统战团体第几届")) {
                s.append(person.getUnitedpartList().get(id).getUnitedpartTimes());
            }else if (str.equals("统战团体职务")) {
                s.append(person.getUnitedpartList().get(id).getUnitedpartPosition());
            }else if (str.equals("统战团体开始时间")) {
                s.append(simpleDateFormat.format(person.getUnitedpartList().get(id).getUnitedpartPosition()));
            }else if (str.equals("统战团体结束时间")) {
                s.append(simpleDateFormat.format(person.getUnitedpartList().get(id).getUnitedpartEndTime()));
            }else if (str.equals("项目名称")) {
                s.append(person.getProjectList().get(id).getProjectTitle());
            }else if (str.equals("项目级别")) {
                s.append(person.getProjectList().get(id).getProjectLevel());
            }else if (str.equals("项目经费")) {
                s.append(person.getProjectList().get(id).getProjectOutlay());
            }else if (str.equals("政协委员全国")) {
                s.append(person.getPoliticalconsultList().get(id).getPoliticalconsultCountry());
            }else if (str.equals("政协委员省")) {
                s.append(person.getPoliticalconsultList().get(id).getPoliticalconsultProvince());
            }else if (str.equals("政协委员市")) {
                s.append(person.getPoliticalconsultList().get(id).getPoliticalconsultCity());
            }else if (str.equals("政协委员区")) {
                s.append(person.getPoliticalconsultList().get(id).getPoliticalconsultCounty());
            }else if (str.equals("政协委员第几届")) {
                s.append(person.getPoliticalconsultList().get(id).getPoliticalconsultTimes());
            }else if (str.equals("政协委员开始时间")) {
                s.append(simpleDateFormat.format(person.getPoliticalconsultList().get(id).getPoliticalconsultStartTime()));
            }else if (str.equals("政协委员结束时间")) {
                s.append(simpleDateFormat.format(person.getPoliticalconsultList().get(id).getPoliticalconsultEndTime()));
            }else if (str.equals("主要社会成就及影响")) {
                s.append(person.getAchievementList().get(id).getAchievementContent());
            }else if (str.equals("主要社会兼职")) {
                s.append(person.getParttimejobList().get(id).getParttimejobContent());
            }else if (str.equals("主要政治表现")) {
                s.append(person.getPoliticalperformenceList().get(id).getPoliticalperformenceContent());
            }else if (str.equals("著作名称")) {
                s.append(person.getBookList().get(id).getBookTitle());
            }else if (str.equals("著作出版单位")) {
                s.append(person.getBookList().get(id).getBookPublish());
            }else if (str.equals("专利名称")) {
                s.append(person.getPatentList().get(id).getPatentTitle());
            }else if (str.equals("专利类型")) {
                s.append(person.getPatentList().get(id).getPatentType());
            }else if (str.equals("专利权人")) {
                s.append(person.getPatentList().get(id).getPatentAuthor());
            }else if (str.equals("作品名称")) {
                s.append(person.getWorksList().get(id).getWorksTitle());
            }else if (str.equals("作品所属单位")) {
                s.append(person.getWorksList().get(id).getWorksBelong());
            }
            return s.toString();
        }catch (Exception e){
            return s.toString();
        }

    }
    public String find(String str,Person person) {
        StringBuffer s=new StringBuffer();
        s=new StringBuffer();
        if (str.equals("职工号")) {
            if (person.getPersonId()!=null && person.getPersonId()!="")
                s.append(person.getPersonId().trim());
        } else if (str.equals("姓名")) {
            if(person.getName()!=null && person.getName()!="")
                s.append(person.getName().trim());
        } else if (str.equals("性别")) {
            if(person.getSex()!=null && person.getSex()!="")
                s.append(person.getSex().trim());
        } else if (str.equals("出生日期")) {
            if(person.getBirthday()!=null)
                s.append(simpleDateFormat.format(person.getBirthday()));
        } else if (str.equals("籍贯")) {
            if(person.getNationality()!=null && person.getNationality()!="")
                s.append(person.getNationality().trim());
        } else if (str.equals("出生地")) {
            if(person.getPlaceOfBirth()!=null && person.getPlaceOfBirth()!="")
                s.append(person.getPlaceOfBirth().trim());
        } else if (str.equals("民族")) {
            if(person.getNation()!=null && person.getNation()!="")
                s.append(person.getNation().trim());
        } else if (str.equals("婚姻状况")) {
            if(person.getMaritalStatus()!=null && person.getMaritalStatus()!="")
                s.append(person.getMaritalStatus().trim());
        } else if (str.equals("国籍")) {
            if(person.getCountry()!=null && person.getCountry()!="")
                s.append(person.getCountry().trim());
        } else if (str.equals("港澳台侨")) {
            if(person.getGatq()!=null && person.getGatq()!="")
                s.append(person.getGatq().trim());
        } else if (str.equals("政治面貌")) {
            if(person.getPoliticalStatus()!=null && person.getPoliticalStatus()!="")
                s.append(person.getPoliticalStatus().trim());
        } else if (str.equals("参加党派时间")) {
            if(person.getPoliticalTime()!=null && person.getPoliticalTime()!="")
                s.append(person.getPoliticalTime().trim());
        } else if (str.equals("第二党派")) {
            if(person.getSecondPoliticalStatus()!=null && person.getSecondPoliticalStatus()!="")
                s.append(person.getSecondPoliticalStatus().trim());
        } else if (str.equals("第二党派参加党派时间")) {
            if(person.getSecondTime()!=null && person.getSecondTime()!="")
                s.append(person.getSecondTime().trim());
        } else if (str.equals("入校日期")) {
            if(person.getEnterschoolTime()!=null && person.getEnterschoolTime()!="")
                s.append(person.getEnterschoolTime().trim());
        } else if (str.equals("毕业学校/单位")) {
            if(person.getGraduationSchool()!=null && person.getGraduationSchool()!="")
                s.append(person.getGraduationSchool().trim());
        } else if (str.equals("最高学历")) {
            if(person.getHighestEducation()!=null && person.getHighestEducation()!="")
                s.append(person.getHighestEducation().trim());
        } else if (str.equals("最高学位")) {
            if(person.getHighestDegree()!=null && person.getHighestDegree()!="")
                s.append(person.getHighestDegree().trim());
        } else if (str.equals("所学专业")) {
            if(person.getProfessional()!=null && person.getProfessional()!="")
                s.append(person.getProfessional().trim());
        } else if (str.equals("全日制教育")) {
            if(person.getFullTimeEducation()!=null && person.getFullTimeEducation()!="")
                s.append(person.getFullTimeEducation().trim());
        } else if (str.equals("全日制毕业学校")) {
            if(person.getFullTimeEducationSchool()!=null && person.getFullTimeEducationSchool()!="")
                s.append(person.getFullTimeEducationSchool().trim());
        } else if (str.equals("全日制毕业专业")) {
            if(person.getFullTimeEducationProfessional()!=null && person.getFullTimeEducationProfessional()!="")
                s.append(person.getFullTimeEducationProfessional().trim());
        } else if (str.equals("在职教育")) {
            if(person.getPartTimeEducation()!=null && person.getPartTimeEducation()!="")
                s.append(person.getPartTimeEducation().trim());
        } else if (str.equals("在职毕业学校")) {
            if(person.getPartTimeEducationSchool()!=null && person.getPartTimeEducationSchool()!="")
                s.append(person.getPartTimeEducationSchool().trim());
        } else if (str.equals("在职毕业专业")) {
            if(person.getPartTimeEducationProfessional()!=null && person.getPartTimeEducationProfessional()!="")
                s.append(person.getPartTimeEducationProfessional().trim());
        } else if (str.equals("现从事学科")) {
            if(person.getWorkScience()!=null && person.getWorkScience()!="")
                s.append(person.getWorkScience().trim());
        } else if (str.equals("研究方向")) {
            if(person.getResearchArea()!=null && person.getResearchArea()!="")
                s.append(person.getResearchArea().trim());
        } else if (str.equals("有无国外居留证长期永久")) {
            if(person.getResidencePermitAbroadStatus()!=null && person.getResidencePermitAbroadStatus()!="")
                s.append(person.getResidencePermitAbroadStatus().trim());
        } else if (str.equals("获居留证时间")) {
            if(person.getResidencePermitAbroadTime()!=null && person.getResidencePermitAbroadTime()!="")
                s.append(person.getResidencePermitAbroadTime().trim());
        } else if (str.equals("参加工作年月")) {
            if(person.getStartworkTime()!=null && person.getStartworkTime()!="")
                s.append(person.getStartworkTime().trim());
        } else if (str.equals("教职工类别")) {
            if(person.getStaffStatus()!=null && person.getStaffStatus()!="")
                s.append(person.getStaffStatus().trim());
        } else if (str.equals("当前状态")) {
            if(person.getCurrentStatus()!=null && person.getCurrentStatus()!="")
                s.append(person.getCurrentStatus().trim());
        } else if (str.equals("状态变更时间")) {
            if(person.getCurrentStatusTime()!=null && person.getCurrentStatusTime()!="")
                s.append(person.getCurrentStatusTime().trim());
        } else if (str.equals("健康状况")) {
            if(person.getHealthStatus()!=null && person.getHealthStatus()!="")
                s.append(person.getHealthStatus().trim());
        } else if (str.equals("所在院系部处")) {
            if(person.getAcademyLocation()!=null && person.getAcademyLocation()!="")
                s.append(person.getAcademyLocation().trim());
        } else if (str.equals("所在具体部门")) {
            if(person.getDepartmentLocation()!=null && person.getDepartmentLocation()!="")
                s.append(person.getDepartmentLocation().trim());
        } else if (str.equals("职务级别")) {
            if(person.getPositionLevel()!=null && person.getPositionLevel()!="")
                s.append(person.getPositionLevel().trim());
        } else if (str.equals("职务聘任年月")) {
            if(person.getEmployPositionTime()!=null && person.getEmployPositionTime()!="")
                s.append(person.getEmployPositionTime().trim());
        } else if (str.equals("聘任职务")) {
            if(person.getEmployPosition()!=null && person.getEmployPosition()!="")
                s.append(person.getEmployPosition().trim());
        } else if (str.equals("岗位级别")) {
            if(person.getStationLevel()!=null && person.getStationLevel()!="")
                s.append(person.getStationLevel().trim());
        } else if (str.equals("分级岗位名称")) {
            if(person.getStationLevelName()!=null && person.getStationLevelName()!="")
                s.append(person.getStationLevelName().trim());
        } else if (str.equals("分级年月")) {
            if(person.getStationLevelTime()!=null && person.getStationLevelTime()!="")
                s.append(person.getStationLevelTime().trim());
        } else if (str.equals("党政职务级别")) {
            if(person.getPoliticalPosition()!=null && person.getPoliticalPosition()!="")
                s.append(person.getPoliticalPosition().trim());
        } else if (str.equals("任职年月")) {
            if(person.getPoliticalPositionTime()!=null && person.getPoliticalPositionTime()!="")
                s.append(person.getPoliticalPositionTime().trim());
        } else if (str.equals("管理职员职级")) {
            if(person.getStaffLevel()!=null && person.getStaffLevel()!="")
                s.append(person.getStaffLevel().trim());
        } else if (str.equals("管理职员职级聘任年月")) {
            if(person.getStaffLevelTime()!=null && person.getStaffLevelTime()!="")
                s.append(person.getStaffLevelTime().trim());
        } else if (str.equals("熟悉何种专业技术及有何种特长")) {
            if(person.getSpeciality()!=null && person.getSpeciality()!="")
                s.append(person.getSpeciality().trim());
        } else if (str.equals("工作电话")) {
            if(person.getWorkPhone()!=null && person.getWorkPhone()!="")
                s.append(person.getWorkPhone().trim());
        } else if (str.equals("家庭电话")) {
            if(person.getFamilyPhone()!=null && person.getFamilyPhone()!="")
                s.append(person.getFamilyPhone().trim());
        } else if (str.equals("手机")) {
            if(person.getPhone()!=null && person.getPhone()!="")
                s.append(person.getPhone().trim());
        } else if (str.equals("电子邮箱")) {
            if(person.getEmail()!=null && person.getEmail()!="")
                s.append(person.getEmail().trim());
        } else if (str.equals("通讯地址")) {
            if(person.getContactAddress()!=null && person.getContactAddress()!="")
                s.append(person.getContactAddress().trim());
        } else if (str.equals("邮编")) {
            if(person.getZipcode()!=null && person.getZipcode()!="")
                s.append(person.getZipcode().trim());
        } else if (str.equals("传真")) {
            if(person.getFax()!=null && person.getFax()!="")
                s.append(person.getFax().trim());
        } else if (str.equals("身份证号码")) {
            if(person.getIdcard()!=null && person.getIdcard()!="")
                s.append(person.getIdcard().trim());
        } else if (str.equals("主要成就和社会影响")) {
            for (Achievement achievement : person.getAchievementList()) {
                if(achievement.getAchievementContent()!=null && achievement.getAchievementContent()!="")
                    s.append(achievement.getAchievementContent().trim() + "\n");
            }
        } else if (str.equals("著作")) {
            for (Book book : person.getBookList()) {
                if(book.getBookTitle()!=null && book.getBookTitle()!="")
                    s.append(book.getBookTitle().trim());
                s.append("");
                if(book.getBookPublish()!=null && book.getBookPublish()!="")
                    s.append(book.getBookPublish().trim());
                s.append("\n");
            }
        } else if (str.equals("人大代表")) {
            for (Deputypeople deputypeople : person.getDeputypeopleList()) {
                if(deputypeople.getDeputypeopleCountry()!=null && deputypeople.getDeputypeopleCountry()!="")
                    s.append(deputypeople.getDeputypeopleCountry().trim());
                if(deputypeople.getDeputypeopleProvince()!=null && deputypeople.getDeputypeopleProvince()!="")
                    s.append(deputypeople.getDeputypeopleProvince().trim());
                if(deputypeople.getDeputypeopleCity()!=null && deputypeople.getDeputypeopleCity()!="")
                    s.append(deputypeople.getDeputypeopleCity().trim());
                if(deputypeople.getDeputypeopleCounty()!=null && deputypeople.getDeputypeopleCounty()!="")
                    s.append(deputypeople.getDeputypeopleCounty().trim());
                s.append(" ");
                if(deputypeople.getDeputypeopleTimes()!=null)
                    s.append(deputypeople.getDeputypeopleTimes());
                s.append("");
                if(deputypeople.getDeputypeopleStartTime()!=null)
                    s.append(simpleDateFormat.format(deputypeople.getDeputypeopleStartTime())+"至");
                if(deputypeople.getDeputypeopleEndTime()!=null)
                    s.append(simpleDateFormat.format(deputypeople.getDeputypeopleEndTime()));
                s.append("\n");
            }
        } else if (str.equals("家庭成员")) {
            for (Family family : person.getFamilyList()) {
                if(family.getFamilyRelation()!=null && family.getFamilyRelation()!="")
                    s.append(family.getFamilyRelation().trim());
                s.append(" ");
                if(family.getFamilyName()!=null && family.getFamilyName()!="")
                    s.append(family.getFamilyName().trim());
                s.append(" ");
                if(family.getFamilyBirthday()!=null)
                    s.append(simpleDateFormat.format(family.getFamilyBirthday()));
                s.append(" ");
                if(family.getFamilyPoliticalStatus()!=null && family.getFamilyPoliticalStatus()!="")
                    s.append(family.getFamilyPoliticalStatus().trim());
                s.append(" ");
                if(family.getFamilyCompany()!=null && family.getFamilyCompany()!="")
                    s.append(family.getFamilyCompany().trim());
                s.append(" ");
                if(family.getFamilyPosition()!=null && family.getFamilyPosition()!="")
                    s.append(family.getFamilyPosition().trim());
                s.append("\n");
            }
        } else if (str.equals("论文")) {
            for (Paper paper : person.getPaperList()) {
                if(paper.getPaperTitle()!=null && paper.getPaperTitle()!="")
                    s.append(paper.getPaperTitle().trim());
                s.append(" ");
                if(paper.getPaperPublications()!=null && paper.getPaperPublications()!="")
                    s.append(paper.getPaperPublications().trim());
                s.append(" ");
                if(paper.getPaperLevel()!=null && paper.getPaperLevel()!="")
                s.append(paper.getPaperLevel().trim());
                s.append("\n");
            }
        } else if (str.equals("社会兼职")) {
            for (Parttimejob parttimejob : person.getParttimejobList()) {
                if(parttimejob.getParttimejobContent()!=null && parttimejob.getParttimejobContent()!="")
                    s.append(parttimejob.getParttimejobContent().trim());
                s.append("\n");
            }
        } else if (str.equals("专利")) {
            for (Patent patent : person.getPatentList()) {
                if(patent.getPatentTitle()!=null && patent.getPatentTitle()!="")
                    s.append(patent.getPatentTitle().trim());
                s.append(" ");
                if(patent.getPatentType()!=null && patent.getPatentType()!="")
                    s.append(patent.getPatentType().trim());
                s.append(" ");
                if(patent.getPatentAuthor()!=null && patent.getPatentAuthor()!="")
                    s.append(patent.getPatentAuthor().trim());
                s.append("\n");
            }
        } else if (str.equals("杰出人才")) {
            for (Phenom phenom : person.getPhenomList()) {
                if(phenom.getPhenomTitle()!=null && phenom.getPhenomTitle()!="")
                    s.append(phenom.getPhenomTitle().trim());
                s.append(" ");
                if(phenom.getPhenomStartTime()!=null)
                    s.append(simpleDateFormat.format(phenom.getPhenomStartTime())+"至");
                if(phenom.getPhenomEndTime()!=null)
                    s.append(simpleDateFormat.format(phenom.getPhenomEndTime()));
                s.append("\n");
            }
        } else if (str.equals("政协委员")) {
            for (Politicalconsult politicalconsult : person.getPoliticalconsultList()) {
                if(politicalconsult.getPoliticalconsultCountry()!=null && politicalconsult.getPoliticalconsultCountry()!="")
                    s.append(politicalconsult.getPoliticalconsultCountry().trim());
                if(politicalconsult.getPoliticalconsultProvince()!=null && politicalconsult.getPoliticalconsultProvince()!="")
                    s.append(politicalconsult.getPoliticalconsultProvince().trim());
                if(politicalconsult.getPoliticalconsultCity()!=null && politicalconsult.getPoliticalconsultCity()!="")
                    s.append(politicalconsult.getPoliticalconsultCity().trim());
                if(politicalconsult.getPoliticalconsultCounty()!=null && politicalconsult.getPoliticalconsultCounty()!="")
                    s.append(politicalconsult.getPoliticalconsultCounty().trim());
                s.append(" ");
                if(politicalconsult.getPoliticalconsultTimes()!=null)
                    s.append(politicalconsult.getPoliticalconsultTimes());
                s.append(" ");
                if(politicalconsult.getPoliticalconsultStartTime()!=null)
                    s.append(simpleDateFormat.format(politicalconsult.getPoliticalconsultStartTime())+"至");
                if(politicalconsult.getPoliticalconsultEndTime()!=null)
                    s.append(simpleDateFormat.format(politicalconsult.getPoliticalconsultEndTime()));
                s.append("\n");
            }
        } else if (str.equals("民主党派职务")) {
            for (Politicalpart politicalpart : person.getPoliticalpartList()) {
                if(politicalpart.getPoliticalpartCountry()!=null && politicalpart.getPoliticalpartCountry()!="")
                    s.append(politicalpart.getPoliticalpartCountry().trim());
                if(politicalpart.getPoliticalpartProvince()!=null && politicalpart.getPoliticalpartProvince()!="")
                    s.append(politicalpart.getPoliticalpartProvince().trim());
                if(politicalpart.getPoliticalpartCity()!=null && politicalpart.getPoliticalpartCity()!="")
                    s.append(politicalpart.getPoliticalpartCity().trim());
                if(politicalpart.getPoliticalpartCounty()!=null && politicalpart.getPoliticalpartCounty()!="")
                    s.append(politicalpart.getPoliticalpartCounty().trim());
                if(politicalpart.getPoliticalpartSchool()!=null && politicalpart.getPoliticalpartSchool()!="")
                    s.append(politicalpart.getPoliticalpartSchool().trim());
                s.append(" ");
                if(politicalpart.getPoliticalpartPosition()!=null && politicalpart.getPoliticalpartPosition()!="")
                    s.append(politicalpart.getPoliticalpartPosition().trim());
                s.append(" ");
                if(politicalpart.getPoliticalpartTimes()!=null)
                    s.append(politicalpart.getPoliticalpartTimes());
                s.append(" ");
                if(politicalpart.getPoliticalpartStartTime()!=null)
                    s.append(simpleDateFormat.format(politicalpart.getPoliticalpartStartTime())+"至");
                if(politicalpart.getPoliticalpartEndTime()!=null)
                    s.append(simpleDateFormat.format(politicalpart.getPoliticalpartEndTime()));
                s.append("\n");
            }
        } else if (str.equals("主要政治表现")) {
            for (Politicalperformence politicalperformence : person.getPoliticalperformenceList()) {
                if(politicalperformence.getPoliticalperformenceContent()!=null && politicalperformence.getPoliticalperformenceContent()!="")
                    s.append(politicalperformence.getPoliticalperformenceContent().trim());
                s.append("\n");
            }
        } else if (str.equals("项目")) {
            for (Project project : person.getProjectList()) {
                if(project.getProjectTitle()!=null && project.getProjectTitle()!="")
                    s.append(project.getProjectTitle().trim());
                s.append(" ");
                if(project.getProjectLevel()!=null && project.getProjectLevel()!="")
                    s.append(project.getProjectLevel().trim());
                s.append(" ");
                if(project.getProjectOutlay()!=null)
                    s.append(project.getProjectOutlay());
                s.append("\n");
            }
        } else if (str.equals("报告")) {
            for (Report report : person.getReportList()) {
                if(report.getReportTitle()!=null && report.getReportTitle()!="")
                    s.append(report.getReportTitle().trim());
                s.append(" ");
                if(report.getReportBelong()!=null && report.getReportBelong()!="")
                    s.append(report.getReportBelong().trim());
                s.append("\n");
            }
        } else if (str.equals("简历")) {
            for (Resume resume : person.getResumeList()) {
                if(resume.getResumeStartTime()!=null)
                    s.append(simpleDateFormat.format(resume.getResumeStartTime())+"至");
                if(resume.getResumeEndTime()!=null)
                    s.append(simpleDateFormat.format(resume.getResumeEndTime()));
                s.append(" ");
                if(resume.getResumeContent()!=null && resume.getResumeContent()!="")
                    s.append(resume.getResumeContent().trim());
                s.append("\n");
            }
        } else if (str.equals("奖励")) {
            for (Reward reward : person.getRewardList()) {
                if(reward.getRewardName()!=null && reward.getRewardName()!="")
                    s.append(reward.getRewardName().trim());
                s.append(" ");
                if(reward.getRewardAchievement()!=null && reward.getRewardAchievement()!="")
                    s.append(reward.getRewardAchievement().trim());
                s.append("\n");
            }
        } else if (str.equals("留学")) {
            for (Studyabroad studyabroad : person.getStudyabroadList()) {
                if(studyabroad.getStudyabroadCountry()!=null && studyabroad.getStudyabroadCountry()!="")
                    s.append(studyabroad.getStudyabroadCountry().trim());
                s.append(" ");
                if(studyabroad.getStudyabroadSchool()!=null && studyabroad.getStudyabroadSchool()!="")
                    s.append(studyabroad.getStudyabroadSchool().trim());
                s.append(" ");
                if(studyabroad.getStudyabroadStartTime()!=null)
                    s.append(simpleDateFormat.format(studyabroad.getStudyabroadStartTime())+"至");
                if(studyabroad.getStudyabroadEndTime()!=null)
                    s.append(simpleDateFormat.format(studyabroad.getStudyabroadEndTime()));
                s.append("\n");
            }
        } else if (str.equals("参加政治理论培训与学习情况")) {
            for (Training training : person.getTrainingList()) {
                if(training.getTrainingPlace()!=null && training.getTrainingPlace()!="")
                    s.append(training.getTrainingPlace().trim());
                s.append(" ");
                if(training.getTrainingCompany()!=null && training.getTrainingCompany()!="")
                    s.append(training.getTrainingCompany().trim());
                s.append(" ");
                if(training.getTrainingContent()!=null && training.getTrainingContent()!="")
                    s.append(training.getTrainingContent().trim());
                s.append(" ");
                if(training.getTrainingStartTime()!=null)
                    s.append(simpleDateFormat.format(training.getTrainingStartTime())+"至");
                if(training.getTrainingEndTime()!=null)
                    s.append(simpleDateFormat.format(training.getTrainingEndTime()));
                s.append("\n");
            }
        } else if (str.equals("统战团体职务")) {
            for (Unitedpart unitedpart : person.getUnitedpartList()) {
                if(unitedpart.getUnitedpartCountry()!=null && unitedpart.getUnitedpartCountry()!="")
                    s.append(unitedpart.getUnitedpartCountry().trim());
                if(unitedpart.getUnitedpartProvince()!=null && unitedpart.getUnitedpartProvince()!="")
                    s.append(unitedpart.getUnitedpartProvince().trim());
                if(unitedpart.getUnitedpartCity()!=null && unitedpart.getUnitedpartCity()!="")
                    s.append(unitedpart.getUnitedpartCity().trim());
                if(unitedpart.getUnitedpartCounty()!=null && unitedpart.getUnitedpartCounty()!="")
                    s.append(unitedpart.getUnitedpartCounty().trim());
                if(unitedpart.getUnitedpartSchool()!=null && unitedpart.getUnitedpartSchool()!="")
                    s.append(unitedpart.getUnitedpartSchool().trim());
                s.append(" ");
                if(unitedpart.getUnitedpartPosition()!=null && unitedpart.getUnitedpartPosition()!="")
                    s.append(unitedpart.getUnitedpartPosition().trim());
                s.append(" ");
                if(unitedpart.getUnitedpartTimes()!=null)
                    s.append(unitedpart.getUnitedpartTimes());
                s.append(" ");
                if(unitedpart.getUnitedpartStartTime()!=null)
                    s.append(simpleDateFormat.format(unitedpart.getUnitedpartStartTime())+"至");
                if(unitedpart.getUnitedpartEndTime()!=null)
                    s.append(simpleDateFormat.format(unitedpart.getUnitedpartEndTime()));
                s.append("\n");
            }
        } else if (str.equals("作品")) {
            for (Works works : person.getWorksList()) {
                if(works.getWorksTitle()!=null && works.getWorksTitle()!="")
                    s.append(works.getWorksTitle().trim());
                s.append(" ");
                if(works.getWorksBelong()!=null && works.getWorksBelong()!="")
                    s.append(works.getWorksBelong().trim());
                s.append(" ");
                s.append("\n");
            }
        }
        if(s==null||s.toString()=="")s.append("");
            return s.toString();
    }
}

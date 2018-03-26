package ssm.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ssm.entity.*;
import ssm.mapper.PhenomMapper;
import ssm.mapper.StudyabroadMapper;
import ssm.service.PersonService;
import ssm.utils.Excel;
import ssm.utils.Page;
import ssm.utils.Property;
import ssm.utils.SaveFile;

import javax.json.JsonObject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/26
 */
@RequestMapping(value = "/person")
@Controller
public class PersonController extends AbstractController{
    @Autowired
    PersonService personService;
    @Autowired
    StudyabroadMapper studyabroadMapper;
    @Autowired
    PhenomMapper phenomMapper;
    @ResponseBody
    @RequestMapping(value = "/delete/{personId}",method = RequestMethod.GET)
    public String deletePerson(@PathVariable(value = "personId")String personId){
        try{
            int j=personService.deleteByPersonId(personId);
            return j>0?"success":"failure";
        }catch (Exception e){
            return "";
        }
    }
    @RequestMapping(value = "/queryPerson",method = RequestMethod.GET)
    public String queryPerson(ModelMap modelMap,HttpSession httpSession){
        User user=(User)httpSession.getAttribute("user");
        if(user==null || !user.getUserAuthority().equals("管理员")){
            return "redirect:/login";
        }
        try{
            List<String> academyLocationList=personService.queryAcademyLocation();//所在院系部
            List<String> employPositionList=personService.queryEmployPosition();//聘任职务
            List<String> stationLevelNameList=personService.queryStationLevelName();//分级岗位名称
            List<String> studyabroadCountryList=studyabroadMapper.queryStudyabroadCountry();//留学国家
            List<String> phenomTitleList=phenomMapper.queryPhenomTitle();//杰出人才
            modelMap.addAttribute("academyLocationList",academyLocationList);
            modelMap.addAttribute("employPositionList",employPositionList);
            modelMap.addAttribute("stationLevelNameList",stationLevelNameList);
            modelMap.addAttribute("studyabroadCountryList",studyabroadCountryList);
            modelMap.addAttribute("phenomTitleList",phenomTitleList);
            return "person/queryPerson";
        }catch (Exception e){
            return "wrong";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/select/{currentPage}",method = RequestMethod.POST)
    public List<Person> queryPerson(@Param("condition") Condition condition, @PathVariable("currentPage")Integer currentPage, HttpSession httpSession){
        try{
            httpSession.setAttribute("condition",condition);
            List<Person> personList=personService.queryByCondition(condition,(currentPage-1)*DEFAULT_PAGE_SIZE,DEFAULT_PAGE_SIZE);
            return personList;
        }catch (Exception e){
            List<Person> personList=new ArrayList();
            return personList;
        }
    }
    @ResponseBody
    @RequestMapping(value = "/pageSize",method = RequestMethod.POST)
    public Page pageSize(@Param("condition") Condition condition){
        try{
            Page page=new Page();
            Integer count=personService.queryCountByCondition(condition,0,10000000);
            Integer pageCount;
            if(count%DEFAULT_PAGE_SIZE==0){
                pageCount=count/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=count/DEFAULT_PAGE_SIZE+1;
            }
            page.setPageCount(pageCount);
            page.setTotle(count);
            return page;
        }catch (Exception e){
            return new Page();
        }
    }
    @RequestMapping(value = "/detail/{personId}",method = RequestMethod.GET)
    public String detail(@PathVariable("personId")String personId,ModelMap modelMap,HttpSession httpSession){
        User user=(User)httpSession.getAttribute("user");
        if(user==null || !user.getUserAuthority().equals("管理员")){
            return "redirect:/login";
        }
        try{
            Person person=personService.queryByPersonId(personId);
            modelMap.addAttribute("person",person);
            List<String> countryList=personService.queryCountry();
            modelMap.addAttribute("countryList",countryList);
            List<String> graduationSchoolList=personService.queryGraduationSchool();
            modelMap.addAttribute("graduationSchoolList",graduationSchoolList);
            List<String> academyLocationList=personService.queryAcademyLocation();
            modelMap.addAttribute("academyLocationList",academyLocationList);
            List<String> employPositionList=personService.queryEmployPosition();
            modelMap.addAttribute("employPositionList",employPositionList);
            List<String> stationLevelNameList=personService.queryStationLevelName();
            modelMap.addAttribute("stationLevelNameList",stationLevelNameList);
            List<String> studyabroadCountryList = studyabroadMapper.queryStudyabroadCountry();
            modelMap.addAttribute("studyabroadCountryList",studyabroadCountryList);
            return "person/detail";
        }catch (Exception e){
            return "wrong";
        }
    }
    @RequestMapping(value = "/detail2/{politicalStatus}/{personId}",method = RequestMethod.GET)
    public String detail2(@PathVariable("personId")String personId,@PathVariable("politicalStatus")String politicalStatus,ModelMap modelMap,HttpSession httpSession){
        try{
            switch (politicalStatus.trim()){
                case "zggcddy":politicalStatus="中国共产党党员";break;
                case "zggcdybdy":politicalStatus="中国共产党预备党员";break;
                case "gqty":politicalStatus="共青团员";break;
                case "zggmdgmwyhhy":politicalStatus="中国国民党革命委员会会员";break;
                case "zgmztmmy":politicalStatus="中国民主同盟盟员";break;
                case "zgmzjghhy":politicalStatus="中国民主建国会会员";break;
                case "zgmzcjhhy":politicalStatus="中国民主促进会会员";break;
                case "ngddy":politicalStatus="农工党党员";break;
                case "zgggy":politicalStatus="致公党党员";break;
                case "jsxssy":politicalStatus="九三学社社员";break;
                case "tmmy":politicalStatus="台盟盟员";break;
                case "wdprs":politicalStatus="无党派民主人士";break;
                case "qunzong":politicalStatus="群众";break;
            }
            User user=(User)httpSession.getAttribute("user");
            String s=personService.queryPoliticalStatusByPersonId(personId).trim();
            if(user==null || !user.getUserAuthority().equals(politicalStatus)){
                return "redirect:/login";
            }
            Person person=personService.queryByPersonId(personId);
            modelMap.addAttribute("person",person);
            List<String> countryList=personService.queryCountry();
            modelMap.addAttribute("countryList",countryList);
            List<String> graduationSchoolList=personService.queryGraduationSchool();
            modelMap.addAttribute("graduationSchoolList",graduationSchoolList);
            List<String> academyLocationList=personService.queryAcademyLocation();
            modelMap.addAttribute("academyLocationList",academyLocationList);
            List<String> employPositionList=personService.queryEmployPosition();
            modelMap.addAttribute("employPositionList",employPositionList);
            List<String> stationLevelNameList=personService.queryStationLevelName();
            modelMap.addAttribute("stationLevelNameList",stationLevelNameList);
            List<String> studyabroadCountryList = studyabroadMapper.queryStudyabroadCountry();
            modelMap.addAttribute("studyabroadCountryList",studyabroadCountryList);
            return "person/detail2";
        }catch (Exception e){
            return "wrong";
        }
    }
    @RequestMapping(value = "/addPerson",method = RequestMethod.GET)
    public String addPerson(HttpSession httpSession,ModelMap modelMap){
        User user=(User)httpSession.getAttribute("user");
        if(user==null || !user.getUserAuthority().equals("管理员")){
            return "redirect:/login";
        }
        try{
            List<String> countryList=personService.queryCountry();
            modelMap.addAttribute("countryList",countryList);
            List<String> graduationSchoolList=personService.queryGraduationSchool();
            modelMap.addAttribute("graduationSchoolList",graduationSchoolList);
            List<String> academyLocationList=personService.queryAcademyLocation();
            modelMap.addAttribute("academyLocationList",academyLocationList);
            List<String> employPositionList=personService.queryEmployPosition();
            modelMap.addAttribute("employPositionList",employPositionList);
            List<String> stationLevelNameList=personService.queryStationLevelName();
            modelMap.addAttribute("stationLevelNameList",stationLevelNameList);
            List<String> studyabroadCountryList = studyabroadMapper.queryStudyabroadCountry();
            modelMap.addAttribute("studyabroadCountryList",studyabroadCountryList);
            return "person/addPerson";
        }catch (Exception e) {
            return "wrong";
        }
    }
    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
    public String addPerson(@Param("person") Person person, RedirectAttributes redirectAttributes){
        try{
            Person person1=personService.queryByPersonId(person.getPersonId());
            if(person1!=null){
                redirectAttributes.addAttribute("message","用户已存在");
                return "redirect:/person/addPerson";
            }
            int i=personService.insertPerson(person);
            if(i>0) {
                redirectAttributes.addAttribute("message", "添加成功");
                return "redirect:/person/addPerson";
                //return "redirect:/person/detail/"+person.getPersonId();
            }else{
                return "wrong";
            }
        }catch (Exception e){
            return "wrong";
        }

    }
    @RequestMapping(value = "/updatePerson/{personId}",method = RequestMethod.GET)
    public String update(@PathVariable(value = "personId")String personId,HttpSession httpSession){
        User user=(User)httpSession.getAttribute("user");
        if(user==null || !user.getUserAuthority().equals("管理员")){
            return "redirect:/login";
        }
        return "person/updatePerson";
    }
    @RequestMapping(value = "/updatePerson",method = RequestMethod.POST)
    public String update(@Param("person") Person person,RedirectAttributes redirectAttributes){
        try{
            int j=personService.updatePerson(person);
            if(j>0)
                redirectAttributes.addAttribute("message","修改成功");
            return "redirect:/person/detail/"+person.getPersonId();
        }catch (Exception e){
            return "wrong";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/chart/{chartCondition}",method = RequestMethod.POST)
    public List<Property> chart(@Param("condition") Condition condition, @PathVariable("chartCondition")String chartCondition, HttpSession httpSession){
        List<Property> propertyList=new ArrayList<>();
        try{
             if(chartCondition.equals("birthday5")){
                propertyList=personService.queryBirthdayByCondition5(condition);
            }else if(chartCondition.equals("birthday10")){
                 propertyList=personService.queryBirthdayByCondition10(condition);
             }else if(chartCondition.equals("nation")){
                 propertyList=personService.queryNationByCondition(condition);
             }else if(chartCondition.equals("politicalStatus")){
                 propertyList=personService.queryPoliticalStatusByCondition(condition);
             }else if(chartCondition.equals("staffStatus")){
                 propertyList=personService.queryStaffStatusByCondition(condition);
             }else if(chartCondition.equals("employPosition")){
                 propertyList=personService.queryEmployPositionByCondition(condition);
             }else if(chartCondition.equals("outparttraining")){
                 propertyList=personService.queryOutparttrainingByCondition(condition);
             }
            return propertyList;
        }catch (Exception e){
            return propertyList;
        }
    }
    @RequestMapping(value = "/zggcddy/{currentPage}",method = RequestMethod.GET)
    public String zggcddy(ModelMap modelMap,@PathVariable("currentPage")Integer currentPage,HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("中国共产党党员")){
                return "redirect:/login";
            }
            Integer totle=personService.zggcddy(0,1000000).size();
            Integer pageCount;
            if(totle%DEFAULT_PAGE_SIZE==0){
                pageCount=totle/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=totle/DEFAULT_PAGE_SIZE+1;
            }
            List<Person> personList=personService.zggcddy(DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("totle",totle);
            modelMap.addAttribute("pageCount",pageCount);
            modelMap.addAttribute("personList",personList);
            modelMap.addAttribute("currentPage",currentPage);
            return "part/zggcddy";
        }catch (Exception e){
            return "";
        }

    }
    @RequestMapping(value = "/zggcdybdy/{currentPage}",method = RequestMethod.GET)
    public String zggcdybdy(ModelMap modelMap,@PathVariable("currentPage")Integer currentPage,HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("中国共产党预备党员")){
                return "redirect:/login";
            }
            Integer totle=personService.zggcdybdy(0,1000000).size();
            Integer pageCount;
            if(totle%DEFAULT_PAGE_SIZE==0){
                pageCount=totle/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=totle/DEFAULT_PAGE_SIZE+1;
            }
            List<Person> personList=personService.zggcdybdy(DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("totle",totle);
            modelMap.addAttribute("pageCount",pageCount);
            modelMap.addAttribute("personList",personList);
            modelMap.addAttribute("currentPage",currentPage);
            return "part/zggcdybdy";
        }catch (Exception e){
            return "";
        }

    }
    @RequestMapping(value = "/gqty/{currentPage}",method = RequestMethod.GET)
    public String gqty(ModelMap modelMap,@PathVariable("currentPage")Integer currentPage,HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("共青团员")){
                return "redirect:/login";
            }
            Integer totle=personService.gqty(0,1000000).size();
            Integer pageCount;
            if(totle%DEFAULT_PAGE_SIZE==0){
                pageCount=totle/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=totle/DEFAULT_PAGE_SIZE+1;
            }
            List<Person> personList=personService.gqty(DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("totle",totle);
            modelMap.addAttribute("pageCount",pageCount);
            modelMap.addAttribute("personList",personList);
            modelMap.addAttribute("currentPage",currentPage);
            return "part/gqty";
        }catch (Exception e){
            return "";
        }

    }
    @RequestMapping(value = "/zggmdgmwyhhy/{currentPage}",method = RequestMethod.GET)
    public String zggmdgmwyhhy(ModelMap modelMap,@PathVariable("currentPage")Integer currentPage,HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("中国国民党革命委员会会员")){
                return "redirect:/login";
            }
            Integer totle=personService.zggmdgmwyhhy(0,1000000).size();
            Integer pageCount;
            if(totle%DEFAULT_PAGE_SIZE==0){
                pageCount=totle/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=totle/DEFAULT_PAGE_SIZE+1;
            }
            List<Person> personList=personService.zggmdgmwyhhy(DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("totle",totle);
            modelMap.addAttribute("pageCount",pageCount);
            modelMap.addAttribute("personList",personList);
            modelMap.addAttribute("currentPage",currentPage);
            return "part/zggmdgmwyhhy";
        }catch (Exception e){
            return "";
        }

    }
    @RequestMapping(value = "/zgmztmmy/{currentPage}",method = RequestMethod.GET)
    public String zgmztmmy(ModelMap modelMap,@PathVariable("currentPage")Integer currentPage,HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("中国民主同盟盟员")){
                return "redirect:/login";
            }
            Integer totle=personService.zgmztmmy(0,1000000).size();
            Integer pageCount;
            if(totle%DEFAULT_PAGE_SIZE==0){
                pageCount=totle/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=totle/DEFAULT_PAGE_SIZE+1;
            }
            List<Person> personList=personService.zgmztmmy(DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("totle",totle);
            modelMap.addAttribute("pageCount",pageCount);
            modelMap.addAttribute("personList",personList);
            modelMap.addAttribute("currentPage",currentPage);
            return "part/zgmztmmy";
        }catch (Exception e){
            return "";
        }

    }
    @RequestMapping(value = "/zgmzjghhy/{currentPage}",method = RequestMethod.GET)
    public String zgmzjghhy(ModelMap modelMap,@PathVariable("currentPage")Integer currentPage,HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("中国民主建国会会员")){
                return "redirect:/login";
            }
            Integer totle=personService.zgmzjghhy(0,1000000).size();
            Integer pageCount;
            if(totle%DEFAULT_PAGE_SIZE==0){
                pageCount=totle/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=totle/DEFAULT_PAGE_SIZE+1;
            }
            List<Person> personList=personService.zgmzjghhy(DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("totle",totle);
            modelMap.addAttribute("pageCount",pageCount);
            modelMap.addAttribute("personList",personList);
            modelMap.addAttribute("currentPage",currentPage);
            return "part/zgmzjghhy";
        }catch (Exception e){
            return "";
        }

    }
    @RequestMapping(value = "/zgmzcjhhy/{currentPage}",method = RequestMethod.GET)
    public String zgmzcjhhy(ModelMap modelMap,@PathVariable("currentPage")Integer currentPage,HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("中国民主促进会会员")){
                return "redirect:/login";
            }
            Integer totle=personService.zgmzcjhhy(0,1000000).size();
            Integer pageCount;
            if(totle%DEFAULT_PAGE_SIZE==0){
                pageCount=totle/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=totle/DEFAULT_PAGE_SIZE+1;
            }
            List<Person> personList=personService.zgmzcjhhy(DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("totle",totle);
            modelMap.addAttribute("pageCount",pageCount);
            modelMap.addAttribute("personList",personList);
            modelMap.addAttribute("currentPage",currentPage);
            return "part/zgmzcjhhy";
        }catch (Exception e){
            return "";
        }

    }
    @RequestMapping(value = "/ngddy/{currentPage}",method = RequestMethod.GET)
    public String ngddy(ModelMap modelMap,@PathVariable("currentPage")Integer currentPage,HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("农工党党员")){
                return "redirect:/login";
            }
            Integer totle=personService.ngddy(0,1000000).size();
            Integer pageCount;
            if(totle%DEFAULT_PAGE_SIZE==0){
                pageCount=totle/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=totle/DEFAULT_PAGE_SIZE+1;
            }
            List<Person> personList=personService.ngddy(DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("totle",totle);
            modelMap.addAttribute("pageCount",pageCount);
            modelMap.addAttribute("personList",personList);
            modelMap.addAttribute("currentPage",currentPage);
            return "part/ngddy";
        }catch (Exception e){
            return "";
        }

    }
    @RequestMapping(value = "/zgggy/{currentPage}",method = RequestMethod.GET)
    public String zgggy(ModelMap modelMap,@PathVariable("currentPage")Integer currentPage,HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("致公党党员")){
                return "redirect:/login";
            }
            Integer totle=personService.zgggy(0,1000000).size();
            Integer pageCount;
            if(totle%DEFAULT_PAGE_SIZE==0){
                pageCount=totle/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=totle/DEFAULT_PAGE_SIZE+1;
            }
            List<Person> personList=personService.zgggy(DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("totle",totle);
            modelMap.addAttribute("pageCount",pageCount);
            modelMap.addAttribute("personList",personList);
            modelMap.addAttribute("currentPage",currentPage);
            return "part/zgggy";
        }catch (Exception e){
            return "";
        }

    }
    @RequestMapping(value = "/jsxssy/{currentPage}",method = RequestMethod.GET)
    public String jsxssy(ModelMap modelMap,@PathVariable("currentPage")Integer currentPage,HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("九三学社社员")){
                return "redirect:/login";
            }
            Integer totle=personService.jsxssy(0,1000000).size();
            Integer pageCount;
            if(totle%DEFAULT_PAGE_SIZE==0){
                pageCount=totle/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=totle/DEFAULT_PAGE_SIZE+1;
            }
            List<Person> personList=personService.jsxssy(DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("totle",totle);
            modelMap.addAttribute("pageCount",pageCount);
            modelMap.addAttribute("personList",personList);
            modelMap.addAttribute("currentPage",currentPage);
            return "part/jsxssy";
        }catch (Exception e){
            return "";
        }

    }
    @RequestMapping(value = "/tmmy/{currentPage}",method = RequestMethod.GET)
    public String tmmy(ModelMap modelMap,@PathVariable("currentPage")Integer currentPage,HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("台盟盟员")){
                return "redirect:/login";
            }
            Integer totle=personService.tmmy(0,1000000).size();
            Integer pageCount;
            if(totle%DEFAULT_PAGE_SIZE==0){
                pageCount=totle/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=totle/DEFAULT_PAGE_SIZE+1;
            }
            List<Person> personList=personService.tmmy(DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("totle",totle);
            modelMap.addAttribute("pageCount",pageCount);
            modelMap.addAttribute("personList",personList);
            modelMap.addAttribute("currentPage",currentPage);
            return "part/tmmy";
        }catch (Exception e){
            return "";
        }

    }
    @RequestMapping(value = "/wdprs/{currentPage}",method = RequestMethod.GET)
    public String wdprs(ModelMap modelMap,@PathVariable("currentPage")Integer currentPage,HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("无党派民主人士")){
                return "redirect:/login";
            }
            Integer totle=personService.wdprs(0,1000000).size();
            Integer pageCount;
            if(totle%DEFAULT_PAGE_SIZE==0){
                pageCount=totle/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=totle/DEFAULT_PAGE_SIZE+1;
            }
            List<Person> personList=personService.wdprs(DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("totle",totle);
            modelMap.addAttribute("pageCount",pageCount);
            modelMap.addAttribute("personList",personList);
            modelMap.addAttribute("currentPage",currentPage);
            return "part/wdprs";
        }catch (Exception e){
            return "";
        }

    }
    @RequestMapping(value = "/qunzong/{currentPage}",method = RequestMethod.GET)
    public String qunzong(ModelMap modelMap,@PathVariable("currentPage")Integer currentPage,HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("群众")){
                return "redirect:/login";
            }
            Integer totle=personService.qunzong(0,1000000).size();
            Integer pageCount;
            if(totle%DEFAULT_PAGE_SIZE==0){
                pageCount=totle/DEFAULT_PAGE_SIZE;
            }else{
                pageCount=totle/DEFAULT_PAGE_SIZE+1;
            }
            List<Person> personList=personService.qunzong(DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("totle",totle);
            modelMap.addAttribute("pageCount",pageCount);
            modelMap.addAttribute("personList",personList);
            modelMap.addAttribute("currentPage",currentPage);
            return "part/qunzong";
        }catch (Exception e){
            return "";
        }

    }

    //excel全部
    @ResponseBody
    @RequestMapping(value = "/excel",method = RequestMethod.POST)
    public  ResponseEntity<byte[]> excel(@RequestParam("file")MultipartFile file,@RequestParam("wangsen") String wangsen, HttpServletRequest request, HttpSession httpSession)throws Exception{
        String p=request.getServletContext().getRealPath("/excel");
        String fileName="";

        if(!wangsen.equals("456")){
            fileName=file.getOriginalFilename();
            File filePath=new File(p,fileName);
            if(!filePath.getParentFile().exists())
                filePath.mkdirs();
            try{
                file.transferTo(filePath);
            }catch (Exception e){
            }
        }
//        Logger logger=LoggerFactory.getLogger(PersonController.class);
//        logger.info(request.getServletContext().getRealPath("/excel"));
//        String filePath="";
//        Condition condition=(Condition) httpSession.getAttribute("condition");
//        List<Person> personList=personService.queryByCondition(condition,0,100000);
//        if(wangsen.equals("123")){
//            SaveFile saveFile=new SaveFile();
//            filePath=saveFile.save(request,filePath);
//        }
        Condition condition=(Condition) httpSession.getAttribute("condition");
        List<Person> personList=personService.queryByCondition(condition,0,100000);
        Excel excel=new Excel();
        if(fileName.equals(""))
            p=excel.writeSelect(personList,"",request);
        else
            p=excel.writeSelect(personList,p+"/"+fileName,request);
        FileInputStream fis = new FileInputStream(new File(p));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            workbook.write(out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        String fileName2 = new String("文件.xlsx".getBytes("UTF-8"), "iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName2);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        ResponseEntity<byte[]> filebyte = new ResponseEntity<byte[]>(out.toByteArray(),headers, HttpStatus.CREATED);
        try {
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return filebyte;
        //return "upload";
    }

    @RequestMapping(value = "/excelDetail/{personId}",method = RequestMethod.POST)
    public  ResponseEntity<byte[]> excelDetail(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request, @PathVariable("personId")String personId)throws Exception{
        String p=request.getServletContext().getRealPath("/excel");
        String fileName=file.getOriginalFilename();
        File filePath=new File(p,fileName);
        if(!filePath.getParentFile().exists())
            filePath.mkdirs();
        try{
            file.transferTo(filePath);
        }catch (Exception e){

        }
        Person person=personService.queryByPersonId(personId);
        Excel excel=new Excel();
        excel.writeDetail(person,p+"/"+file.getOriginalFilename());

        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            workbook.write(out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        String fileName2 = new String("文件.xlsx".getBytes("UTF-8"), "iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName2);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        ResponseEntity<byte[]> filebyte = new ResponseEntity<byte[]>(out.toByteArray(),headers, HttpStatus.CREATED);
        try {
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return filebyte;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    public Boolean judge(String s){
        int lastIndex=s.lastIndexOf(".");
        String p=s.substring(lastIndex+1);
        if(p.equals("xlsx"))
            return true;
        else
            return false;
    }
}

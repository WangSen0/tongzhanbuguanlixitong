package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ssm.entity.Condition;
import ssm.entity.InformationCondition;
import ssm.entity.Person;
import ssm.entity.User;
import ssm.service.PersonInformationService;
import ssm.service.PersonService;
import ssm.utils.Page;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/11/10
 */
@Controller
@RequestMapping(value = "/information")
public class Information extends AbstractController {
    @Autowired
    PersonInformationService personInformationService;
    @Autowired
    PersonService personService;
    @RequestMapping(value = "/addPerson")
    public String addPerson(HttpSession httpSession){
        try{
            User user=(User)httpSession.getAttribute("user");
            if(user==null || !user.getUserAuthority().equals("管理员")){
                return "redirect:/login";
            }
            return "person/information";
        }catch (Exception e){
            return "";
        }
    }
    @RequestMapping(value = "/pageSize")
    @ResponseBody
    public Page pageSize(InformationCondition informationCondition){
        try{
            Page page=new Page();
            Integer count=personInformationService.queryCountByCondition(informationCondition,0,1000000);
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
    @ResponseBody
    @RequestMapping(value = "/select/{currentPage}")
    public List<Person> queryPerson(InformationCondition condition, @PathVariable(value = "currentPage")Integer currentPage){
        try{
            List<Person> personList=personInformationService.queryByCondition(condition,(currentPage-1)*DEFAULT_PAGE_SIZE,DEFAULT_PAGE_SIZE);
            return personList;
        }catch (Exception e){
            List<Person> personList=new ArrayList<>();
            return personList;
        }
    }
    @ResponseBody
    @RequestMapping(value = "/addPerson/{personId}")
    public String addPerson(@PathVariable(value = "personId")String personId){
        try{
            Person person=personInformationService.queryByPersonId(personId);
            Person person1=personService.queryByPersonId(personId);
            if(person1!=null){
                return "fail";
            }
            int i=personService.insertPerson(person);
            if(i>0){
                return "success";
            }else{
                return "fail";
            }

        }catch (Exception e){
            return "fail";
        }
    }
    @RequestMapping(value = "/detail/{personId}")
    public String detailPerson(@PathVariable(value = "personId")String personId, HttpSession httpSession, ModelMap modelMap){
        User user=(User)httpSession.getAttribute("user");
        if(user==null || !user.getUserAuthority().equals("管理员")){
            return "redirect:/login";
        }
        try{
            Person person=personInformationService.queryByPersonId(personId);
            modelMap.addAttribute("person",person);
            return "person/detailInformation";
        }catch (Exception e){
            return "";
        }
    }
    @RequestMapping(value = "/updatePerson",method = RequestMethod.GET)
    public String updatePerson(HttpSession httpSession){
        if(httpSession.getAttribute("user")==null){
            return "redirect:/login";
        }
        return "person/updatePerson";
    }
    @ResponseBody
    @RequestMapping(value = "/updatePerson/{personId}",method = RequestMethod.POST)
    public String updatePerson(@PathVariable(value = "personId") String personId){
        try{
            Person person=personService.queryByPersonId(personId);
            Person personInformation=personInformationService.queryByPersonId(personId);
            if(personInformation==null){
                return "fail";
            }
            Integer k=personInformationService.updatePersonByInformation(person,personInformation);
            if(k>0)
                return "success";
            else
                return "fail";
        }catch (Exception e){
            return "";
        }
    }
    @ResponseBody
    @RequestMapping(value = "/updateAllPerson",method = RequestMethod.POST)
    public Integer updateAllPerson(InformationCondition informationCondition){
        int k=0;
        try{
            List<String> personIdList=personService.queryPersonId();
            for(String personId:personIdList){
                Person person=personService.queryByPersonId(personId);
                Person personInformation=personInformationService.queryByPersonId(personId);
                if(personInformation==null){
                    continue;
                }
                k+=personInformationService.updatePersonByInformation(person,personInformation);
            }
            return k;
        }catch (Exception e){
            return 0;
        }
    }
}

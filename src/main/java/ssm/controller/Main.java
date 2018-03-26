package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ssm.entity.Condition;
import ssm.entity.User;
import ssm.service.PersonService;
import ssm.utils.ObjectCount;
import ssm.utils.Property;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/26
 */
@Controller
public class Main {
    @Autowired
    PersonService personService;
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String main(HttpSession httpSession, ModelMap modelMap){
        User user=(User)httpSession.getAttribute("user");
        if(user==null || !user.getUserAuthority().equals("管理员")){
            return "redirect:/login";
        }
        try{
//            List<ObjectCount> sexList=personService.querySexAndCount();
//            List<ObjectCount> nationList=personService.queryNationAndCount();
//            List<ObjectCount> politicalStatusList=personService.queryPoliticalStatusAndCount();
//            Condition condition=new Condition();
//            Integer PersonCount=personService.queryCountByCondition(condition,0,1000000);
//            modelMap.addAttribute("sexList",sexList);
//            modelMap.addAttribute("nationList",nationList);
//            modelMap.addAttribute("politicalStatusList",politicalStatusList);
//            modelMap.addAttribute("personCount",PersonCount);
            List<ObjectCount> zggmdgmwyhhyList=personService.queryZggmdgmwyhhy();
            List<ObjectCount> zgmztmmyList=personService.queryZgmztmmy();
            List<ObjectCount> zgmzjghhyList=personService.queryZgmzjghhy();
            List<ObjectCount> zgmzcjhhyList=personService.queryZgmzcjhhy();
            List<ObjectCount> ngddyList=personService.queryNgddy();
            List<ObjectCount> jsxssyList=personService.queryJsxssy();
            List<ObjectCount> tailianList=personService.queryTailian();
            List<ObjectCount> qiaolianList=personService.queryQiaolian();
            List<ObjectCount> wdprsList=personService.queryWdprs();
            List<ObjectCount> studyabroadList=personService.queryStudyabroad();
            Integer minorityCount=personService.queryMinorityCount();

            Integer minzhuCount=0;
            Integer tongzhanCount=0;
            for(ObjectCount objectCount:zggmdgmwyhhyList){
                minzhuCount=objectCount.getValue()+minzhuCount;
            }
            for(ObjectCount objectCount:zgmztmmyList){
                minzhuCount=objectCount.getValue()+minzhuCount;
            }
            for(ObjectCount objectCount:zgmzjghhyList){
                minzhuCount=objectCount.getValue()+minzhuCount;
            }
            for(ObjectCount objectCount:zgmzcjhhyList){
                minzhuCount=objectCount.getValue()+minzhuCount;
            }
            for(ObjectCount objectCount:ngddyList){
                minzhuCount=objectCount.getValue()+minzhuCount;
            }
            for(ObjectCount objectCount:jsxssyList){
                minzhuCount=objectCount.getValue()+minzhuCount;
            }

            for(ObjectCount objectCount:tailianList){
                tongzhanCount=objectCount.getValue()+tongzhanCount;
            }
            for(ObjectCount objectCount:qiaolianList){
                tongzhanCount=objectCount.getValue()+tongzhanCount;
            }
            for(ObjectCount objectCount:wdprsList){
                tongzhanCount=objectCount.getValue()+tongzhanCount;
            }
            for(ObjectCount objectCount:studyabroadList){
                tongzhanCount=objectCount.getValue()+tongzhanCount;
            }
            //Integer minzhuCount=zggmdgmwyhhyList.size()+zgmztmmyList.size()+zgmzjghhyList.size()+zgmzcjhhyList.size()+ngddyList.size()+jsxssyList.size();
//            Integer tongzhanCount=tailianList.size()+qiaolianList.size()+wdprsList.size()+studyabroadList.size();

            modelMap.addAttribute("minzhuCount",minzhuCount);
            modelMap.addAttribute("zggmdgmwyhhyList",zggmdgmwyhhyList);
            modelMap.addAttribute("zgmztmmyList",zgmztmmyList);
            modelMap.addAttribute("zgmzjghhyList",zgmzjghhyList);
            modelMap.addAttribute("zgmzcjhhyList",zgmzcjhhyList);

            modelMap.addAttribute("ngddyList",ngddyList);
            modelMap.addAttribute("jsxssyList",jsxssyList);

            modelMap.addAttribute("tongzhanCount",tongzhanCount);
            modelMap.addAttribute("tailianList",tailianList);
            modelMap.addAttribute("qiaolianList",qiaolianList);
            modelMap.addAttribute("wdprsList",wdprsList);
            modelMap.addAttribute("studyabroadList",studyabroadList);
            modelMap.addAttribute("minorityCount",minorityCount);

            return "main";
        }catch (Exception e){
            return "";
        }
    }
}

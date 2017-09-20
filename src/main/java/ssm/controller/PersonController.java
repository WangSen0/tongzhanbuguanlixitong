package ssm.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ssm.entity.Condition;
import ssm.entity.Person;
import ssm.entity.User;
import ssm.service.PersonService;
import ssm.utils.Excel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/17
 */
@RequestMapping(value = "/person")
@Controller
public class PersonController extends AbstractController {
    @Autowired
    PersonService personService;
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public String insert(){
        return "person/insert";
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insert(@Param("person")Person person, ModelMap modelMap) throws Exception {
        try{
            int i=personService.newPerson(person);
            if(i==1){
                modelMap.addAttribute("message","successful");
                return "redirect:/person/insert";
            }else { return "wrongPage";}
        }catch (Exception e){
            return "wrongPage";
        }
    }
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public String select(ModelMap modelMap){
        try{modelMap.addAttribute("123");
            List<String>names=personService.queryName();
            modelMap.addAttribute("names",names);
            return "person/select";
        }catch (Exception e){
            return "wrongPage";
        }
    }
    @ResponseBody
    @RequestMapping(value = "/select/{currentPage}",method = RequestMethod.POST)
    public List<Person> select(@PathVariable("currentPage")Integer currentPage,@Param("condition")Condition condition, ModelMap modelMap, RedirectAttributes redirectAttributes, HttpSession httpSession){
        try{
            httpSession.setAttribute("condition",condition);
            List<Person> persons=personService.queryByCondition(condition,(currentPage-1)*DEFAULT_PAGE_SIZE,DEFAULT_PAGE_SIZE);
            //redirectAttributes.addFlashAttribute("condition",condition);
            modelMap.addAttribute("persons",persons);
            return persons;
        }catch (Exception e){
            List<Person> persons=new ArrayList<Person>();
            return persons;
        }
    }
    @RequestMapping(value = "/list/{currentPage}",method = RequestMethod.GET)
    public String list(@PathVariable("currentPage")Integer currentPage, RedirectAttributes redirectAttributes, ModelMap modelMap,HttpSession httpSession){
        try{
            if(currentPage<1){
                currentPage=1;
            }
            Condition condition=(Condition) httpSession.getAttribute("condition");
            List<Person> persons=personService.queryByCondition(condition,(currentPage-1)*DEFAULT_PAGE_SIZE,DEFAULT_PAGE_SIZE);
            modelMap.addAttribute("currentPage",currentPage);
            modelMap.addAttribute("persons",persons);
            return "person/list";
        }catch (Exception e){
            return "wrongPage";
        }
    }
//    @RequestMapping(value = "/select/{currentPage}",method = RequestMethod.POST)
//    public String select(@PathVariable("currentPage")Integer currentPage,@Param("condition")Condition condition,ModelMap modelMap){
//        try{
//            List<String>names=personService.queryName();
//            modelMap.addAttribute("names",names);
//            modelMap.addAttribute("currentPage",currentPage);
//            List<Person> persons=personService.queryByCondition(condition,(currentPage-1)*DEFAULT_PAGE_SIZE,DEFAULT_PAGE_SIZE);
//            modelMap.addAttribute("persons",persons);
//            return "person/select";
//        }catch (Exception e){
//            return "wrongPage";
//        }
//    }
    @RequestMapping(value = "/excel",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> excel(HttpSession httpSession, User user){
        try{
            Condition condition=(Condition) httpSession.getAttribute("condition");
            List<Person>list=personService.queryByCondition(condition,0,1000000000);
            Excel excel=new Excel();
            excel.write(list);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", "1");
            return map;
        }catch (Exception e){
            Map<String,Object> resultMap = new HashMap<String, Object>();
            resultMap.put("msg", "SUCCESS");
            return resultMap;
        }
    }

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String upload()throws Exception{
        return "upload";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(HttpServletRequest request)throws Exception{
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null) {
                    //String s4=Class.class.getClass().getResource("/").getPath();
                    String path="C:\\Users\\Administrator\\Desktop\\webssm\\src\\main\\webapp\\resources\\excel\\"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
            }
        }
        return "upload";
    }
}

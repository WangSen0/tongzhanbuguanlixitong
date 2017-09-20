package ssm.controller;

import com.sun.deploy.net.HttpResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ssm.entity.User;
import ssm.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping(value = "/user")
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, String name, HttpSession httpSession, RedirectAttributes redirectAttributes, ModelMap modelMap){
        try{
            User user1=new User();
            user1=userService.queryByNameAndPassword(user.getName(),user.getPassword());
            if(user1!=null){
                httpSession.setAttribute("user",user1);
                return "redirect:/main";
            }else{
                modelMap.addAttribute("message","login fail");
                return "login";
            }
        }catch (Exception e){
            return "";
        }
    }
    @RequestMapping(value = "/insertUser",method = RequestMethod.GET)
    public String insertUser(){return "insertUser";}
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public String insertUser(User user,ModelMap modelMap){
        try{
            User user1=userService.queryByName(user.getName());
            if(user1!=null){
                modelMap.addAttribute("message","already exit user");
                return "insertUser";
            }else{
                userService.newUser(user);
                modelMap.addAttribute("message","successful");
                return "redirect:/user/listUser";
            }
        }catch (Exception e){return "";}
    }
    @RequestMapping(value = "listUser",method = RequestMethod.GET)
    public String userList(ModelMap modelMap){
        try{
            List<User>userList=userService.listAllPerson();
            modelMap.addAttribute("userList",userList);
            return "listUser";
        }catch (Exception e){return "";}
    }
    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id")int id,ModelMap modelMap){
        try{
            int i=userService.delById(id);
            if(i==1){
                modelMap.put("message","successful");

            }else{
                modelMap.addAttribute("message","fail");
            }
            return "redirect:/user/listUser";

        }catch (Exception e){return "";}
    }
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") int id,ModelMap modelMap){
        try{
            User user=userService.queryById(id);
            modelMap.addAttribute("user1",user);
        }catch (Exception e){return "";}

       return "updateUser";
    }
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String update2(@PathVariable("id")int id,@Param("user")User user,ModelMap modelMap,@Param("password1")String password1){
        try{
            User userQuery=userService.queryByNameAndPassword(user.getName(),password1);
            if(userQuery!=null){
                int i=userService.update(user);
                if(i==1){
                    modelMap.addAttribute("message","successful");
                }else{
                    modelMap.addAttribute("message","fail");
                }
            }else{
                modelMap.addAttribute("message","fail");
            }
            return "redirect:/user/update/"+user.getId();
        }catch (Exception e){return "";}
    }
}

package ssm.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ssm.entity.Condition;
import ssm.entity.Person;
import ssm.entity.User;
import ssm.service.UserService;
import ssm.utils.Page;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/26
 */
@Controller
public class UserController  extends AbstractController {
    @Autowired
    UserService userService;
    @RequestMapping(value = {"","/login"},method = RequestMethod.GET)
    public String login(HttpSession httpSession){
        User user=(User)httpSession.getAttribute("user");
        if(user!=null){
            if(user.getUserAuthority().equals("管理员")){
                return "redirect:/main";
            }else if(user.getUserAuthority().equals("中国共产党党员")){
                return "redirect:/person/zggcddy/1";
            }else if(user.getUserAuthority().equals("中国共产党预备党员")){
                return "redirect:/person/zggcdybdy/1";
            }else if(user.getUserAuthority().equals("共青团员")){
                return "redirect:/person/gqty/1";
            }else if(user.getUserAuthority().equals("中国国民党革命委员会会员")){
                return "redirect:/person/zggmdgmwyhhy/1";
            }else if(user.getUserAuthority().equals("中国民主同盟盟员")){
                return "redirect:/person/zgmztmmy/1";
            }else if(user.getUserAuthority().equals("中国民主建国会会员")){
                return "redirect:/person/zgmzjghhy/1";
            }else if(user.getUserAuthority().equals("中国民主促进会会员")){
                return "redirect:/person/zgmzcjhhy/1";
            }else if(user.getUserAuthority().equals("农工党党员")){
                return "redirect:/person/ngddy/1";
            }else if(user.getUserAuthority().equals("致公党党员")){
                return "redirect:/person/zgggy/1";
            }else if(user.getUserAuthority().equals("九三学社社员")){
                return "redirect:/person/jsxssy/1";
            }else if(user.getUserAuthority().equals("台盟盟员")){
                return "redirect:/person/tmmy/1";
            }else if(user.getUserAuthority().equals("无党派民主人士")){
                return "redirect:/person/wdprs/1";
            }else if(user.getUserAuthority().equals("群众")){
                return "redirect:/person/qunzong/1";
            }
        }
        return "login/login";
    }
    // region 登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, RedirectAttributes redirectAttributes, HttpSession httpSession){
        try{
            User user1=userService.queryByNameAndPassword(user);
            if(user1==null){
                redirectAttributes.addFlashAttribute("message","帐号密码错误！");
                return "redirect:/login";
            }else{
                httpSession.setAttribute("user",user1);
                if(user1.getUserAuthority().equals("管理员")){
                    return "redirect:/main";
                }else if(user1.getUserAuthority().equals("中国共产党党员")){
                    return "redirect:/person/zggcddy/1";
                }else if(user1.getUserAuthority().equals("中国共产党预备党员")){
                    return "redirect:/person/zggcdybdy/1";
                }else if(user1.getUserAuthority().equals("共青团员")){
                    return "redirect:/person/gqty/1";
                }else if(user1.getUserAuthority().equals("中国国民党革命委员会会员")){
                    return "redirect:/person/zggmdgmwyhhy/1";
                }else if(user1.getUserAuthority().equals("中国民主同盟盟员")){
                    return "redirect:/person/zgmztmmy/1";
                }else if(user1.getUserAuthority().equals("中国民主建国会会员")){
                    return "redirect:/person/zgmzjghhy/1";
                }else if(user1.getUserAuthority().equals("中国民主促进会会员")){
                    return "redirect:/person/zgmzcjhhy/1";
                }else if(user1.getUserAuthority().equals("农工党党员")){
                    return "redirect:/person/ngddy/1";
                }else if(user1.getUserAuthority().equals("致公党党员")){
                    return "redirect:/person/zgggy/1";
                }else if(user1.getUserAuthority().equals("九三学社社员")){
                    return "redirect:/person/jsxssy/1";
                }else if(user1.getUserAuthority().equals("台盟盟员")){
                    return "redirect:/person/tmmy/1";
                }else if(user1.getUserAuthority().equals("无党派民主人士")){
                    return "redirect:/person/wdprs/1";
                }else if(user1.getUserAuthority().equals("群众")){
                    return "redirect:/person/qunzong/1";
                }else{
                    throw new Exception();
                }
            }

        }catch (Exception e){
            return "wrong";
        }
    }
    @RequestMapping(value = "/user/exit",method = RequestMethod.GET)
    public String exitUser(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "redirect:/login";
    }
    // endregion
    //region 用户列表
    @RequestMapping(value = "/user/userList/{currentPage}",method = RequestMethod.GET)
    public String userList(HttpSession httpSession, @PathVariable("currentPage")Integer currentPage){
        User user=(User)httpSession.getAttribute("user");
        if(user==null || !user.getUserAuthority().equals("管理员")){
            return "redirect:/login";
        }
        try{
            List<User> userList=userService.queryByLimit("",0,DEFAULT_PAGE_SIZE);
            return "user/userList";
        }catch (Exception e){
            return "wrong";
        }
    }
    //endregion
    //region 删除用户
    @RequestMapping(value = "/user/delete",method = RequestMethod.POST)
    public String deleteUser(@Param("userId")Integer userId,HttpSession httpSession,RedirectAttributes redirectAttributes){
        User user=(User)httpSession.getAttribute("user");
        if(user==null || !user.getUserAuthority().equals("管理员")){
            return "redirect:/login";
        }
        try{
            int i=userService.deleteByUserId(userId);
            if(i>0)
                redirectAttributes.addFlashAttribute("message","删除成功");
            else
                redirectAttributes.addFlashAttribute("message","删除失败");
            return "redirect:/user/userList/1";
        }catch (Exception e){
            return "wrong";
        }
    }
    //endregion
    //region 添加用户
    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public String addUser(@Param("user") User user,HttpSession httpSession,RedirectAttributes redirectAttributes){
        if(httpSession.getAttribute("user")==null)
            return "redirect:/login";
        try{
            User user1=userService.queryByUserName(user.getUserName());
            if(user1!=null){
                redirectAttributes.addFlashAttribute("message","用户已存在");
                return "redirect:/user/userList/1";
            }
            if(user.getUserName().equals("")||user.getUserPassword().equals("")){
                redirectAttributes.addFlashAttribute("message","用户名不能为空！");
                return "redirect:/user/userList/1";
            }
            int i=userService.insertUser(user);
            if(i>0)
                redirectAttributes.addFlashAttribute("message","添加成功");
            else
                redirectAttributes.addFlashAttribute("message","添加失败");
            return "redirect:/user/userList/1";
        }catch (Exception e){
            return "wrong";
        }
    }
    //endregion

    @RequestMapping(value = "/user/updateUser",method = RequestMethod.POST)
    public String updateUser(User user,RedirectAttributes redirectAttributes){
        try{
            int i=userService.updateUser(user);
            if(i>0){
                redirectAttributes.addFlashAttribute("message","更新成功");
            }else{
                redirectAttributes.addFlashAttribute("message","更新失败");
            }
            return "redirect:/user/userList/1";
        }catch (Exception e){
            return "wrong";
        }
    }
    //修改密码
    @RequestMapping(value = "/user/updatePassword",method = RequestMethod.POST)
    public String updatePassword(User user,String newPassword,RedirectAttributes redirectAttributes){
        try{
            User user1=userService.queryByNameAndPassword(user);
            if(user1!=null){
                int j=userService.updatePassword(user.getUserName(),newPassword);
                if(j>0){
                    redirectAttributes.addFlashAttribute("message","修改成功");
                }else{
                    redirectAttributes.addFlashAttribute("message","修改失败");
                }
            }else{//帐号密码不正确
                redirectAttributes.addFlashAttribute("message","密码不正确");
            }

            if(user.getUserAuthority().equals("管理员")){
                return "redirect:/main";
            }else if(user.getUserAuthority().equals("中国共产党党员")){
                return "redirect:/person/zggcddy/1";
            }else if(user.getUserAuthority().equals("中国共产党预备党员")){
                return "redirect:/person/zggcdybdy/1";
            }else if(user.getUserAuthority().equals("共青团员")){
                return "redirect:/person/gqty/1";
            }else if(user.getUserAuthority().equals("中国国民党革命委员会会员")){
                return "redirect:/person/zggmdgmwyhhy/1";
            }else if(user.getUserAuthority().equals("中国民主同盟盟员")){
                return "redirect:/person/zgmztmmy/1";
            }else if(user.getUserAuthority().equals("中国民主建国会会员")){
                return "redirect:/person/zgmzjghhy/1";
            }else if(user.getUserAuthority().equals("中国民主促进会会员")){
                return "redirect:/person/zgmzcjhhy/1";
            }else if(user.getUserAuthority().equals("农工党党员")){
                return "redirect:/person/ngddy/1";
            }else if(user.getUserAuthority().equals("致公党党员")){
                return "redirect:/person/zgggy/1";
            }else if(user.getUserAuthority().equals("九三学社社员")){
                return "redirect:/person/jsxssy/1";
            }else if(user.getUserAuthority().equals("台盟盟员")){
                return "redirect:/person/tmmy/1";
            }else if(user.getUserAuthority().equals("无党派民主人士")){
                return "redirect:/person/wdprs/1";
            }else if(user.getUserAuthority().equals("群众")){
                return "redirect:/person/qunzong/1";
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            return "";
        }
    }
    //region 分页返回用户列表
    @ResponseBody
    @RequestMapping(value = "/user/userList/{currentPage}",method = RequestMethod.POST)
    public List<User> ajaxUserList(@Param("userName")String userName, HttpSession httpSession, @PathVariable("currentPage")Integer currentPage){
        try{
            List<User> userList=userService.queryByLimit(userName,DEFAULT_PAGE_SIZE*(currentPage-1),DEFAULT_PAGE_SIZE);
            return userList;
        }catch (Exception e){
            List<User> userList=new ArrayList<>();
            return userList;
        }
    }
    //endregion

    @ResponseBody
    @RequestMapping(value = "/user/pageSize",method = RequestMethod.POST)
    public Page pageSize(String userName){
        try{
            Page page=new Page();
            page.setCurrentPage(1);
            List<User> userList=userService.queryByLimit(userName,0,1000000);
            int count=userList.size();
            if(count%DEFAULT_PAGE_SIZE==0){
                page.setPageCount(count/DEFAULT_PAGE_SIZE);
            }else{
                page.setPageCount(count/DEFAULT_PAGE_SIZE+1);
            }
            page.setTotle(userList.size());
            return page;
        }catch (Exception e){
            return new Page();
        }
    }
}

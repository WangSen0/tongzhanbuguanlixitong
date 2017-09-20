package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.entity.Person;
import ssm.entity.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/15
 */
@Controller
public class Main {
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String main(ModelMap modelMap, HttpSession httpSession){
        User s=(User)httpSession.getAttribute("user");
        if(s!=null){
            return "main";
        }else {
            return "redirect:/user/login";
        }
    }
}

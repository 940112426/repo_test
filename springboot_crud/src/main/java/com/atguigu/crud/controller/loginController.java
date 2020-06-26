package com.atguigu.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;
import sun.net.httpserver.HttpServerImpl;
import sun.security.util.Password;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author XuMingyue
 * @create 2020-04-13 14:18
 */
@Controller
public class loginController {
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session){
        //@RequestParam("username") String username 所传过来的参数名必须为username,如果没有传值，则报错
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
//            return "dashboard";
            session.setAttribute("loginUser",username);
            //为了防止刷新页面后重新提交，通过重定向
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名或者密码错误");
            return "index";
        }
    }

}

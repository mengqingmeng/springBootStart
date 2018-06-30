package com.example.demo.controller;

import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("shiro")
public class TestShiroController {

    @RequestMapping("login")
    public String login(){
        return "/thymeleaf/shiro/login";
    }

    @RequestMapping("/index")
    public String index(){
        return "/thymeleaf/shiro/index";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "/thymeleaf/shiro/unauthorized";
    }

    @RequestMapping("/admin")
    @ResponseBody
    public String admin(){
        return "admin success";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(){
        return "edit success";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject!=null){
            subject.logout();
        }
        return "/thymeleaf/shiro/login";
    }

    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam("userName") String userName,
                            @RequestParam("password")String password, HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        Subject subject = SecurityUtils.getSubject();

        try{
            subject.login(token);
            User user = (User) subject.getPrincipal();

            session.setAttribute("user",user);

            return "/thymeleaf/shiro/index";
        }catch (Exception e){
            log.error("登陆失败："+userName+";"+e.getMessage());
            return "/thymeleaf/shiro/login";
        }
    }
}

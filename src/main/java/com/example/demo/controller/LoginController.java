package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login(){
       return "thymeleaf/login/login";
    }

    @RequestMapping("loginSuccess")
    public String loginSuccess(){
        return "thymeleaf/login/loginSuccess";
    }

    @RequestMapping(value = "login",method=RequestMethod.POST)
    public String loginPost(String username,String password){
        return "login post";
    }
}

package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("name","mqm");
        return "thymeleaf/index";
    }

    @RequestMapping("/center")
    public String center(ModelMap map){
        return "thymeleaf/center/center";
    }

    @RequestMapping("/test")
    public String test(ModelMap map){
        List<User> users = new ArrayList<User>();
        User u = new User();
        u.setAge(18);
        u.setBirthDay(new Date());
        u.setDesc("<div>哈哈!!</div>");
        u.setName("MQM");
        u.setPassword("123123");
        users.add(u);

        User u1 = new User();
        u1.setPassword("321321");
        u1.setName("HA");
        u1.setDesc("SDesc");
        u1.setAge(2);
        u1.setBirthDay(new Date());
        users.add(u1);
        map.put("users",users);
        map.put("user",u);
        return "thymeleaf/test";
    }

    @RequestMapping("/postform")
    public String postform(User u){
        System.out.println(u.getName());
        System.out.println(u.getAge());
        return "redirect:/th/test";
    }

}

package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

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
        User u = new User();
        u.setAge(13);
        u.setBirthDay(new Date());
        u.setDesc("<div>哈哈</div>");
        u.setName("MQM");
        u.setPassword("123123");
        map.put("user",u);
        return "thymeleaf/test";
    }
}

package com.example.demo.controller;

import com.example.demo.pojo.Resource;
import com.example.demo.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    Resource resource;

    @ResponseBody
    @RequestMapping("/getUser")
    public User getUser() {
        User u = new User();
        u.setAge(3);
        u.setBirthDay(new Date());
        u.setDesc("第三个用户2");
        u.setName("meng");
        u.setPassword("meng");
        return u;
    }

    @ResponseBody
    @RequestMapping("/getProperties")
    public Resource getProperties(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        return bean;
    }
}

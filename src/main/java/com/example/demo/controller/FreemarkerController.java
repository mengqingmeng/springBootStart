package com.example.demo.controller;

import com.example.demo.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ftl")
public class FreemarkerController {
    @Autowired
    Resource resource;

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("resource",resource);
        return "freemarker/index";
    }

    @RequestMapping("/center")
    public String center(ModelMap map){
        return "freemarker/center/center";
    }
}

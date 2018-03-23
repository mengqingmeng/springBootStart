package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/err")
public class ErrorController {

    @RequestMapping("/test")
    public String error(){
        int a = 1/0;
        return "/thymeleaf/test";
    }
}

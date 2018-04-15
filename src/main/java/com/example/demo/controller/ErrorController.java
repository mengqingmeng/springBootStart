package com.example.demo.controller;

import com.example.demo.utils.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/err")
public class ErrorController {

    @RequestMapping("/test")
    public String error(){
        int a = 1/0;
        return "/thymeleaf/test";
    }

            @RequestMapping("/ajaxError")
        public String ajaxError(){
            return "ajaxError";
        }

        @ResponseBody
        @RequestMapping("/getAjaxError")
        public JSONResult getAjaxError(){
            int a = 1/0;
            return JSONResult.ok();
        }
}

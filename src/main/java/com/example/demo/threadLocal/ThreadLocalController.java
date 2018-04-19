package com.example.demo.threadLocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("threadLocal")
public class ThreadLocalController {

    @ResponseBody
    @RequestMapping("test")
    public Long test(){
        return RequestHolder.get();
    }
}

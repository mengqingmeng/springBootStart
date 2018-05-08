package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@EnableGlobalMethodSecurity(prePostEnabled = true) //需要加此注解，否则：@PreAuthorize("hasRole('ROLE_ADMIN')")无效
public class HelloController {

    @RequestMapping("/")
    public Object index(){
        log.info("spring boot start");
        return "spring boot start";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/hello")
    public Object hello(){
        log.info("hello controller");
        return "hello!";
    }

}

package com.example.demo.controller;

import com.example.demo.pojo.Happiness;
import com.example.demo.service.HappinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/happiness")
public class HappinessController {
    @Autowired
    private HappinessService happinessService;

    @RequestMapping("/query")
    public List<Happiness> testQuery(){
        return happinessService.selectService("北京");
    }

    @RequestMapping("/insert")
    public List<Happiness> testInsert(){
        happinessService.insertService("西安",2);
        log.info("insert success");
        return happinessService.selectService("西安");
    }
}

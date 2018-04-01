package com.example.demo.controller;

import com.example.demo.task.AsyncTasks;
import com.example.demo.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("tasks")
public class DoTask {
    @Autowired
    private AsyncTasks asyncTasks;

    @RequestMapping("test1")
    public JSONResult test1() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future<Boolean> a = asyncTasks.doTask1();
        Future<Boolean> b = asyncTasks.doTask2();
        Future<Boolean> c = asyncTasks.doTask3();
        while(!a.isDone() || !b.isDone() || !c.isDone()){
            if(a.isDone() && b.isDone() && c.isDone()){
                break;
            }
        }
        long end = System.currentTimeMillis();
        String times ="总共耗时："+(end-start)+"毫秒";
        System.out.println(times);
        return JSONResult.ok(times);
    }
}

package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 */
@Component
public class TestTask {
    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    //定时任务注解，每3秒执行一次，也可以用corn设置，网址：http://cron.qqe2.com/
    //@Scheduled(fixedRate = 3000)
    public void reportCurrentTime(){
        System.out.println("current time:"+dataFormat.format(new Date()));
    }
}

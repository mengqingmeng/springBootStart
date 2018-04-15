package com.example.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Component
@Slf4j
public class CallableDemo implements Callable<Integer> {
    private int sum;

    @Override
    public Integer call() throws Exception {
        log.info("");
        return null;
    }
}

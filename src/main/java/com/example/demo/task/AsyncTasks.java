package com.example.demo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTasks {

    //Future<V>接口是用来获取异步计算结果的,白了就是对具体的Runnable或者Callable对象任务执行的结果进行获取(get()),取消(cancel()),判断是否完成等操作
    @Async
    public Future<Boolean> doTask1() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时："+(end-start));
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask2() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(600);
        long end = System.currentTimeMillis();
        System.out.println("任务2耗时："+(end-start));
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask3() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(400);
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时："+(end-start));
        return new AsyncResult<>(true);
    }
}

package com.example.demo.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample2 {

    /**
     * synchronized修饰类，作用对象为这个类的所有对象
     */
    public static void test1(int j){
        //因为这里的锁的对象的类，所有该类所有的实例共用一把锁
        synchronized (SynchronizedExample2.class){
            for (int i=0;i<100;i++){
                log.info("test1-{}-{}",j,i);
            }
        }
    }

    /**
     * synchronized修饰静态方法，作用对象为这个类的所有对象
     */
    public static synchronized void test2(int j){
        for (int i=0;i<100;i++){
            log.info("test2-{}-{}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            example2.test2(1);
        });
        executorService.execute(()->{
            example1.test2(2);
        });
    }
}

package com.example.demo.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {

    /**
     * synchronized修饰静态代码块，锁为调用的对象
     */
    public void test1(int j){

        //修饰的静态代码块内的代码不执行完成，别的线程不能执行
        synchronized (this){
            for (int i=0;i<100;i++){
                log.info("test1-{}-{}",j,i);
            }
        }
    }

    /**
     * synchronized修饰方法，锁为调用的对象
     */
    public synchronized void test2(int j){
        for (int i=0;i<100;i++){
            log.info("test2-{}-{}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            example1.test2(1);
        });
        executorService.execute(()->{
            example1.test2(2);
        });
    }
}

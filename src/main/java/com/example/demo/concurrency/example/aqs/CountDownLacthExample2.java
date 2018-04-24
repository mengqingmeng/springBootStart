package com.example.demo.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch 的使用，超时设定
 */
@Slf4j
public class CountDownLacthExample2 {

    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for(int i=0;i<threadCount;i++){
            final int threadNumber = i;
            executorService.execute(()->{
                try {
                    test(threadNumber);
                } catch (Exception e) {
                    log.error("exception:" + e);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await(10,TimeUnit.MILLISECONDS);//超时设定,超时不再等待
        executorService.shutdown();
        log.info("thread finished");
    }

    private static void test(int threadNumber) throws Exception{
        Thread.sleep(10);
        log.info("threadNumber:{}",threadNumber);
    }
}

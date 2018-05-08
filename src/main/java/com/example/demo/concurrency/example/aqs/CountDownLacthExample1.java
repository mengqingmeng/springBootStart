package com.example.demo.concurrency.example.aqs;

import com.example.demo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch的使用
 */
@Slf4j
@ThreadSafe
public class CountDownLacthExample1 {

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

        countDownLatch.await();
        executorService.shutdown();
        log.info("thread finished");
    }

    private static void test(int threadNumber) throws Exception{
        Thread.sleep(100);
        log.info("threadNumber:{}",threadNumber);
        Thread.sleep(100);
    }
}

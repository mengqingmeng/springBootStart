package com.example.demo.concurrency.example.atomic;

import com.example.demo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 是线程安全的示例
 */
@Slf4j
@ThreadSafe
public class AtomicExample3 {

    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程总数
    public static int threadTotal = 200;

    public static LongAdder count = new LongAdder();

    private static void add(){
        count.increment();
    }

    public static void main(String[] args) throws InterruptedException {
        //线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        //计数器
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.info("exception:"+e.getMessage());
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();//保证coutDown必须减为0
        executorService.shutdown();
        log.info("count:"+count);//每次运行的结果，有可能不同，所以线程不安全
    }
}

package com.example.demo.concurrency.example.atomic;

import com.example.demo.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 是线程安全的示例
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {
    //AtomicIntegerFieldUpdater用来更新类的字段，用的不多
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");


    //字段必须用volatile修饰，且不是static
    @Getter
    public int count = 100;

    public static void main(String[] args) {
        AtomicExample5 atomicExample5 = new AtomicExample5();
        if (updater.compareAndSet(atomicExample5,100,110)){
            log.info("change success1,{}",atomicExample5.getCount());
        }

        if (updater.compareAndSet(atomicExample5,120,130)){
            log.info("change success2,{}",atomicExample5.getCount());
        }else{
            log.info("change failed2,{}",atomicExample5.getCount());
        }
    }
}

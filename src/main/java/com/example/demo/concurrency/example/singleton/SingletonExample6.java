package com.example.demo.concurrency.example.singleton;

import com.example.demo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 通过静态代码块实现单列模式
 */
@Slf4j
@ThreadSafe
public class SingletonExample6 {
    private SingletonExample6(){

    }

    //通过volatile+双重检测机制 限制指令重排
    private static SingletonExample6 singletonExample1 = null;

    static {
        singletonExample1 = new SingletonExample6();
    }

    public static void main(String[] args) {
        log.info(String.valueOf(SingletonExample6.singletonExample1.hashCode()));
        log.info(String.valueOf(SingletonExample6.singletonExample1.hashCode()));
    }
}

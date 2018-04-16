package com.example.demo.concurrency.example.singleton;

import com.example.demo.concurrency.annoations.NotThreadSafe;
import com.example.demo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 单列模式，懒汉模式：比较懒，不先初始化对象
 */
@Slf4j
@ThreadSafe
public class SingletonExample4 {
    private SingletonExample4(){

    }

    //通过volatile+双重检测机制 限制指令重排
    private volatile static SingletonExample4 singletonExample1 = null;

    public SingletonExample4 getInstance(){

        //双重检测机制
        if(singletonExample1 == null){
            synchronized (SingletonExample4.class){
                if(singletonExample1 == null){
                    singletonExample1 = new SingletonExample4();
                }
            }
        }

        return singletonExample1;

    }
}

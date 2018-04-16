package com.example.demo.concurrency.example.singleton;

import com.example.demo.concurrency.annoations.NotThreadSafe;
import com.example.demo.concurrency.annoations.ThreadSafe;

/**
 * 单列模式，懒汉模式：比较懒，不先初始化对象
 */
@NotThreadSafe
public class SingletonExample3 {
    private SingletonExample3(){

    }

    private  static SingletonExample3 singletonExample1 = null;

    public SingletonExample3 getInstance(){

        //双重检测机制
        //因为有指令重排的存在，所以也不是线程安全的
        if(singletonExample1 == null){
            synchronized (SingletonExample3.class){
                if(singletonExample1 == null){
                    singletonExample1 = new SingletonExample3();
                }
            }
        }

        return singletonExample1;

    }
}

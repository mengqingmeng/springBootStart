package com.example.demo.concurrency.example.singleton;

import com.example.demo.concurrency.annoations.NotThreadSafe;

/**
 * 单列模式，懒汉模式：比较懒，不先初始化对象
 */
@NotThreadSafe
public class SingletonExample1 {
    private SingletonExample1(){

    }

    private  static  SingletonExample1 singletonExample1 = null;

    public SingletonExample1 getInstance(){
        //线程不安全，如果多个线程执行到这个if块内，将创建多个对象
        if(singletonExample1 == null){
            singletonExample1 = new SingletonExample1();
        }
        return singletonExample1;

    }
}

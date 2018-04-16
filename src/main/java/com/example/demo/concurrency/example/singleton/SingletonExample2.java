package com.example.demo.concurrency.example.singleton;

import com.example.demo.concurrency.annoations.NotThreadSafe;
import com.example.demo.concurrency.annoations.ThreadSafe;

/**
 * 单列模式，饿汉模式：比较饿，一上来就初始化对象
 * 线程安全，但是有两个问题：
 * 1.如果在构造方法有耗时操作，则会加载很慢
 * 2.如果不使用，则浪费资源
 */
@ThreadSafe
public class SingletonExample2 {
    private SingletonExample2(){

    }

    private  static SingletonExample2 singletonExample1 = new SingletonExample2();

    public SingletonExample2 getInstance(){
        //线程安全
        return singletonExample1;

    }
}

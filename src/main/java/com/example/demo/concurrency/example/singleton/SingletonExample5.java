package com.example.demo.concurrency.example.singleton;

import com.example.demo.concurrency.annoations.Recommend;
import com.example.demo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 通过枚举获取单列
 */
@Slf4j
@ThreadSafe
@Recommend
public class SingletonExample5 {
    private SingletonExample5(){

    }

    public static SingletonExample5 getInstace(){
        return Singleton.INSTACNCE.getInstance();
    }

    private enum Singleton{
        INSTACNCE;

        private SingletonExample5 instance;

        Singleton(){
            instance = new SingletonExample5();
        }

        public SingletonExample5 getInstance(){
            return instance;
        }
    }

    public static void main(String[] args) {
        SingletonExample5 singletonExample5 = getInstace();
    }
}

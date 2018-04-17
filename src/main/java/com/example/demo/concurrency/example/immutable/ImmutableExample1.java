package com.example.demo.concurrency.example.immutable;

import com.example.demo.concurrency.annoations.NotThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * final 修饰类，方法，变量
 *      类：该类不可以被继承
 *      方法：方法不可以被继承类修改
 *      变量：如下注释
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {
    /**
     * final修饰变量
     *      基础类型：值不可修改
     *      引用类型：引用的对象不可修改，但是对象里面的值可以修改
     */
    private static final Integer a = 1;
    private static final String b = "b";
    private static final Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(2,3);
        log.info("map 放内容了");
    }

    public static void main(String[] args) {
        log.info("main 方法");
        map.put(2,4);
        log.info("map get 2:{}",map.get(2));
    }
}

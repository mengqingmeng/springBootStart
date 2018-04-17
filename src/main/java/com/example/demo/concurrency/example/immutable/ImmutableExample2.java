package com.example.demo.concurrency.example.immutable;

import com.example.demo.concurrency.annoations.ThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * 把对象变成不可变对象，可有效避免线程安全问题
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {
    private static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(2,3);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        log.info("main 方法");
        map.put(2,4);
        log.info("map get 2:{}",map.get(2));
    }
}

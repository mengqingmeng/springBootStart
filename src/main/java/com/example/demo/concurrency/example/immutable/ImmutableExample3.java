package com.example.demo.concurrency.example.immutable;

import com.example.demo.concurrency.annoations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * 不可变对象
 */
@Slf4j
@ThreadSafe
public class ImmutableExample3 {
    private final static ImmutableList<Integer> list = ImmutableList.of(1,2,3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer,Integer> map = ImmutableMap.<Integer,Integer>builder().put(2,3).put(4,5).build();
    public static void main(String[] args) {
        log.info("list size:"+list.size());
//        list.add(4);
//        set.add(5);
        log.info("map get:"+map.get(4));

    }
}

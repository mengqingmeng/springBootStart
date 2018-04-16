package com.example.demo.concurrency.example.publish;

import com.example.demo.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 发布对象，将对象内部信息，分享给外部
 * 非私有方法，返回对象的引用
 *
 */
@Slf4j
@NotThreadSafe
public class UnSafePublish {
    private String[] strs = {"a","b","c"};

    public String[] getStrs(){
        return strs;
    }

    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        String[] strs = unSafePublish.getStrs();
        log.info("{}", Arrays.toString(strs));
        strs[0] = "d";
        log.info("{}",Arrays.toString(strs));
    }
}

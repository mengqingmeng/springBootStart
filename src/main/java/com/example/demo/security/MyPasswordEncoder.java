package com.example.demo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//密码加密
@Slf4j
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encode = passwordEncoder.encode(charSequence);
        log.info("加密后的密码："+encode);
        return encode;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encode = passwordEncoder.encode(charSequence);
        boolean match = passwordEncoder.matches(charSequence, encode);
        log.info("bcrypt密码对比:" + match);
        return match;
    }
}

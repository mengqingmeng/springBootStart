package com.example.demo.controller;

import com.example.demo.pojo.SysUser;
import com.example.demo.service.UserService;
import com.example.demo.utils.JSONResult;
import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("mybatis")
public class CURDController {

    final static Logger log = LoggerFactory.getLogger(CURDController.class);

    @Autowired
    UserService userService;
    @Autowired
    Sid sid;

    @RequestMapping("saveUser")
    public JSONResult saveUser(){
        SysUser sysUser = new SysUser();
        sysUser.setId(sid.nextShort());
        sysUser.setNickname("mqm");
        userService.saveUser(sysUser);
        return JSONResult.ok(sysUser);
    }

}

package com.example.demo.service;

import com.example.demo.pojo.SysUser;

import java.util.List;

public interface UserService {

    public void saveUser(SysUser user);
    public void updateUser(SysUser user);
    public void deleteUser(int userId);
    public SysUser queryUserById(int id);
    public List<SysUser> queryUserList(SysUser user);
}

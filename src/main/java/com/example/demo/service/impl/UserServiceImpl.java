package com.example.demo.service.impl;

import com.example.demo.mapper.SysUserMapper;
import com.example.demo.mapper.SysUserMapperCustom;
import com.example.demo.pojo.SysUser;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    SysUserMapper userMapper;

    @Autowired
    SysUserMapperCustom sysUserMapperCustom; //注入，自定义mapper

    @Override
    public void saveUser(SysUser user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(SysUser user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(int userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public SysUser queryUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysUser> queryUserList(SysUser user) {
        return userMapper.select(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED) //事物
    public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmptyOrWhitespace(user.getNickname())){
            criteria.andLike("nickname","%"+user.getNickname()+"%");
        }
        List<SysUser> userList = userMapper.selectByExample(example);
        return userList;
    }

    @Override
    public SysUser getUserCustomMapper(String id) {
        List<SysUser> userList = sysUserMapperCustom.queryUserSimpleInfoById(id);
        if (userList!=null && !userList.isEmpty()){
            return userList.get(0);
        }

        return null;
    }
}

package com.example.demo.mapper;

import com.example.demo.pojo.SysUser;
import com.example.demo.utils.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义Mapper，相当于hibernate中的dao
 */
@Repository
public interface SysUserMapperCustom extends MyMapper<SysUser> {
    List<SysUser> queryUserSimpleInfoById(String id);
}
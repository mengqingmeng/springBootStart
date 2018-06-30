package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 测试shiro用的mapper
 */
@Mapper
public interface UserMapper {
    User findByUserName(@Param("userName") String userName);
}

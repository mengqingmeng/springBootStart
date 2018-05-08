package com.example.demo.mapper;

import com.example.demo.pojo.Happiness;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 其实mybatis中的mapper 就是dao，是这么理解吗
 */
@Mapper
public interface HappinessDao {

    /**
     *  * ****全注解版****
     *  * mybatis,不能像hibernate那样自动生成表结构，需要手动建立表结构
     *  * 注解版本，别人说不好维护
     *  *
     */

    //@Select("SELECT * FROM happiness WHERE city = #{city}")
    List<Happiness> findHappinessByCity(@Param("city") String city);

    //@Insert("INSERT INTO happiness(city, num) VALUES(#{city}, #{num})")
    int insertHappiness(@Param("city") String city, @Param("num") Integer num);
}

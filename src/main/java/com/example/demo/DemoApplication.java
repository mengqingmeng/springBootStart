package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mybatis mapper包路径，注意这里引包，不要引错了
@MapperScan(basePackages = "com.example.demo.mapper")
@ComponentScan(basePackages = {"com.example.demo","org.n3r.idworker"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


//	//配置mybatis的分页插件pageHelper
//	@Bean
//	public PageHelper pageHelper(){
//		PageHelper pageHelper = new PageHelper();
//		Properties properties = new Properties();
//		properties.setProperty("offsetAsPageNum","true");
//		properties.setProperty("rowBoundsWithCount","true");
//		properties.setProperty("reasonable","true");
//		properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
//		pageHelper.setProperties(properties);
//		return pageHelper;
//	}
}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mybatis mapper包路径，注意这里引包，不要引错了
@MapperScan(basePackages = "com.example.demo.mapper")
@ComponentScan(basePackages = {"com.example.demo","org.n3r.idworker"})
@EnableScheduling //启动定时任务
@EnableAsync //启动异步任务
@EnableEurekaServer //注册中心
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

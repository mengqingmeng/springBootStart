package com.example.demo.config;

import com.example.demo.filter.HttpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean httpFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter( new HttpFilter());
        registrationBean.addUrlPatterns("/login/*");
        return registrationBean;
    }
}

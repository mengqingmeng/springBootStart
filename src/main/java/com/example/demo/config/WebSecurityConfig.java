package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * web security配置类
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         *1 .permitAll():该请求任何人都可以访问
         *2 .anyRequest().authenticated():其他的请求都必须要有权限认证
         *3 这里我们可以通过匹配器来匹配路径，比如antMatchers方法，假设我要管理员才可以访问admin文件夹下的内容，我可以这样来写：
         * .antMatchers("/admin/**").hasRole("ROLE_ADMIN")，
         * 也可以设置admin文件夹下的文件可以有多个角色来访问，写法如下：.antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN","ROLE_USER")
         */
        http.authorizeRequests().antMatchers("/**").permitAll()  //根目录和/login不拦截
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login")    //登陆页面路径为/login
        .defaultSuccessUrl("/chat") //登陆成功后的跳转页面
        .permitAll()
        .and()
        .logout()
        .permitAll();
        super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER");
        super.configure(auth);
    }

    //忽略静态文件的请求
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resource/static/**");
        super.configure(web);
    }
}

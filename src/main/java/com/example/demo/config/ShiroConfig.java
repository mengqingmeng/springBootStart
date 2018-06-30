package com.example.demo.config;

import com.example.demo.shiroSecurity.AuthRealm;
import com.example.demo.shiroSecurity.CredentialMatcher;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    //配置shiro开始
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);

        bean.setLoginUrl("/shiro/login");
        bean.setSuccessUrl("/shiro/index");
        bean.setUnauthorizedUrl("/shiro/unauthorized");

        LinkedHashMap<String,String> fiterChainDefinitionMap = new LinkedHashMap<String,String>();
        fiterChainDefinitionMap.put("/shiro/login","anon");
        fiterChainDefinitionMap.put("/shiro/loginUser","anon");
        fiterChainDefinitionMap.put("/shiro/admin","roles[admin]"); //拥有某些角色拦截
        fiterChainDefinitionMap.put("/shiro/edit","perms[edit]");   //拥有某些权限拦截
        fiterChainDefinitionMap.put("/druid/**","roles[admin]"); //不拦截druid
        fiterChainDefinitionMap.put("/**","user");

        bean.setFilterChainDefinitionMap(fiterChainDefinitionMap);

        return bean;
    }


    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        return manager;
    }

    @Bean("authRealm")
    public AuthRealm authRealm(@Qualifier("credentialMatcher") CredentialMatcher matcher){
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCredentialsMatcher(matcher);
        authRealm.setCacheManager(new MemoryConstrainedCacheManager());//将授权的内容缓存在内存中
        return  authRealm;
    }

    @Bean("credentialMatcher")
    public CredentialMatcher credentialMatcher(){
        return new CredentialMatcher();
    }
    //配置shiro结束

    //配置shiro与spring boot 开始
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
    //配置shiro与spring boot结束
}

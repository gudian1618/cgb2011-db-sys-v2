package com.github.gudian1618.cgb2011dbsysv2.common.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/7/12 9:59 上午
 */

@Configuration
public class SpringShiroConfig {

    /**
     * 配置shiro中的核心对象:安全管理器
     *
     * @Bean 此注解描述的方法会交个ispring框架管理, 默认的名字为方法名
     */
    @Bean
    public SecurityManager securityManager(Realm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    /**
     * 配置shiroFilterFactoryBean对象,基于对象创建过滤器工厂,通过过滤器工厂创建过滤器进行请求过滤
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Autowired SecurityManager securityManager) {
        ShiroFilterFactoryBean sBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        sBean.setSecurityManager(securityManager);
        // 设置登录页面url
        sBean.setLoginUrl("/doLoginUI");
        // 设置过滤规则
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        // 静态资源允许匿名访问:"anon"
        map.put("/bower_components/**", "anon");
        map.put("/build/**", "anon");
        map.put("/dist/**", "anon");
        map.put("/plugins/**", "anon");
        map.put("/user/doLogin", "anon");
        // logout由shiro提供
        map.put("/doLogout", "logout");
        // 除了匿名资源,其他都需要认证("authc")后访问
        map.put("/**", "authc");
        sBean.setFilterChainDefinitionMap(map);
        return sBean;
    }

    /**
     * shiro框架授权配置
     * shiro框架中的授权是基于spring中AOP规范做了一个具体实现
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor (SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor= new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }


}

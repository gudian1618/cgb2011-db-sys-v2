package com.github.gudian1618.cgb2011dbsysv2.common.config;

import com.github.gudian1618.cgb2011dbsysv2.common.web.TimeAccessInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/8/20 7:39 下午
 */

@Configuration
public class SpringWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TimeAccessInterceptor()).addPathPatterns("/user/doLogin");
    }
}

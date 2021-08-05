package com.sangeng.config;

import com.sangeng.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    // 之前在LoginInterceptor上加上了@Component注解，把它注入到了spring容器里面
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)   // 添加对应的拦截器对象
                .addPathPatterns("/**")             // 配置拦截路径
                .excludePathPatterns("/sys_user/login");   // 配置排除路径
    }
}

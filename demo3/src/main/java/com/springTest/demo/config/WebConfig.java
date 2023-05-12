package com.springTest.demo.config;

import com.springTest.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//有了Configuration这个注解之后，springboot就会自动读取这个类，这样的话以下的配置才会生效
@Configuration
public class WebConfig implements WebMvcConfigurer {
//public class WebConfig extends WebMvcConfigurationSupport {
//需要重写增加拦截器的方法
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        这里表示添加LoginInterceptor拦截器，当命中/user/**路由时就会命中该拦截器。
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**");
    }
}

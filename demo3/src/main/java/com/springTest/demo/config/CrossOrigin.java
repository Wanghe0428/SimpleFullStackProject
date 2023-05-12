package com.springTest.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//此配置类是在配置后端允许跨域的方式
@Configuration
public class CrossOrigin implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //允许跨域访问的路径
                .allowedOrigins("*") //允许所有网站跨域
                .allowedMethods("POST", "GET", "OPTIONS", "DELETE") //允许的方法
                .maxAge(168000) //预检间隔时间
                .allowedHeaders("*")  //允许头部设置
                .allowCredentials(false); //是否支持发送cookie
    }
}

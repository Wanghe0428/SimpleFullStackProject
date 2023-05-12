package com.springTest.demo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//分页查询配置
@Configuration
public class MyBatisPlusConfig {
//    配置MyBatisPlus数据库拦截器
    @Bean
    public MybatisPlusInterceptor paginationInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);  //数据库类型是mysql
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor); //paginationInnerInterceptor表示分页查询
        return mybatisPlusInterceptor;
    }
}
package com.springTest.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HandlerInterceptor类为拦截器类
public class LoginInterceptor implements HandlerInterceptor {
    //这里需要重写原始类的的请求前preHandle、请求中postHandle、请求后afterHandle
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        request为前端的请求，可以通过request拿到前端的cookie，response可以向前端返回信息
        System.out.println("登录前拦截");
        return true;
    }
}

package com.springTest.demo.controller;

import com.springTest.demo.entity.User;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    @GetMapping("/hello") 等同于上面，为使用get方式
//    http://localhost:8080/hello?name=wanghe&phone=123
    public String hello(String name, String phone) {
        System.out.println("hello" + name + phone);
        return "hello1";
    }

    @RequestMapping(value = "test1", method = RequestMethod.GET)
//    @RequestParam注解
    public String test1(@RequestParam(value = "nikename", required = false) String name) {
        System.out.println(name);
        return "get请求";
    }
    @RequestMapping(value = "test2", method = RequestMethod.POST)
    public String test2(String name) {
        System.out.println("我叫" + name);
        return  "post请求";
    }
    @RequestMapping(value = "test3", method = RequestMethod.POST)
    public String test3(User user) {
        System.out.println(user);
        return "post请求";
    }
    @RequestMapping(value = "test4", method = RequestMethod.POST)
//    @RequestBody是表明接收前端数据为JSON对象的注解
    public String test4(@RequestBody User user) {
        System.out.println(user);
        return "post请求";
    }

    //**表示通配符匹配，任意接收test/dd或test/ff
    @RequestMapping(value = "test/**", method = RequestMethod.POST)
//    @RequestBody是表明接收前端数据为JSON对象的注解
    public String test(@RequestBody User user) {
        System.out.println(user);
        return "通配符匹配";
    }
}

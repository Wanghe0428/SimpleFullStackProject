package com.springTest.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    //restful格式的url


    //增
    @PostMapping("/user")
    public String save() {return "添加用户";}



    //删
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable int id) {
        System.out.println(id);
        return "根据id删除用户";
    }

    //改
    @PutMapping("/user/{id}")
    public String update(@PathVariable int id) {
        System.out.println(id);
        return "修改用户";
    }

    // 查id
    @GetMapping("user/{id}")
    public String getUserById(@PathVariable int id) {
        System.out.println(id);
        return "根据ID获取用户信息";
    }
}
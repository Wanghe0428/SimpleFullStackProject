package com.springTest.demo.controller;

import com.springTest.demo.entity.Order;
import com.springTest.demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
//Autowired 是一个注释，它可以对类成员变量、方法及构造函数进行标注，让 spring 完成 bean 自动装配的工作
    @Autowired
    private OrderMapper orderMapper;

//    查询所有订单，以及订单所对应的用户
    @GetMapping("/order/findAll")
    public List<Order> findAll() {
        return orderMapper.selectAllOrdersAndUser();
    }
}

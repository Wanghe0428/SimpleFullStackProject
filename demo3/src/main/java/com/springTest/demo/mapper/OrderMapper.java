package com.springTest.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springTest.demo.entity.Order;
import com.springTest.demo.entity.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {
    @Select("select * from t_order where uid = #{uid}")
    public List<Order> selectByUid(int uid);

//    查询所有订单，同时查询订单所对应的用户，注意一个订单仅对应一个用户，所以用@One
    @Select("select * from t_order")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "total", property = "total"),
            @Result(column = "uid", property = "user", javaType = User.class,
                one = @One(select = "com.springTest.demo.mapper.UserByMyBatisPlusMapper.selectById")
            ),
    })
    public List<Order> selectAllOrdersAndUser();
}

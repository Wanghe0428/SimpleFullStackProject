package com.springTest.demo.mapper;

//使用myBatiesPlus来写数据库操作
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springTest.demo.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//继承于MyBatisPlus的BaseMapper接口，这样传入User表，这样你就不用写基础的增删改查了，MyBatisPlus会自动帮你完成这些
public interface UserByMyBatisPlusMapper extends BaseMapper<User> {

    @Select("select * from user where id = #{id}")
    public User selectById(int id);

//    查询用户及其所有的订单
    @Select("select * from user") //Results是查询的结果映射，注意这里将用户对应的所有订单全都映射为orders属性
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "password", property = "password"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "id", property = "orders", javaType = List.class,
                    many = @Many(select = "com.springTest.demo.mapper.OrderMapper.selectByUid")
            ),//many表示映射的一对多的关系，select=后面的语句表示要调用哪一个mapper的什么方法
    })
    public List<User> selectAllUserAndOrders();
}

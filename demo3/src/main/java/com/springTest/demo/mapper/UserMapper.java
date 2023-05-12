package com.springTest.demo.mapper;

import com.springTest.demo.entity.User;
// 注意这是Mybatis来做的，用mybatis需要手动写注解，而如果使用MyBatisPlus则就不用写注解了，可以理解是对Mybatis的简化
//使用MyBatis来写数据库的操作
import org.apache.ibatis.annotations.*;

import java.util.List;

//Mapper注解表明这个接口是一个mapper映射器，用于数据库查询与映射
@Mapper
//不需要写一个类，只需要写方法声明（接口），所有的实现都可以让MyBatis来完成，
// 注意这是Mybatis来做的，用mybatis需要手动写注解，
// 而如果使用MyBatisPlus则就不用写注解了，可以理解是对Mybatis的简化
public interface UserMapper {
//   在MyBatis写数据库操代码时，是在注解中写sql语句，查询的方法名无所谓
//   查询所有用户
    @Select("select * from user")
    public List<User> find();

//    增加用户，按照springBoot格式来写，注意#的使用
    @Insert("insert into user values (#{id}, #{userName}, #{password}, #{birthday})")
    public int insert(User user);  //返回值时插入几条记录，如果失败了返回值为0

//   删除用户，根据id进行删除
    @Delete("delete from user where id=#{id}")
    public int delete(int id);

//    更新用户
    @Update("update user set userName=#{userName},password=#{password},birthday=#{birthday} where id=#{id}")
    public int update(User user);
}

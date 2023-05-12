package com.springTest.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;


//tableName表示关联数据库的表名
@TableName("user")
public class User {
//    表明user中的id是主键，且是自增的
    @TableId(type = IdType.AUTO)
    private String userName;
//   TableField其是一个对应映射的注解，表示user类中的password对应数据库的表中的password
    @TableField("password")
    private String password;
    private int id;
    private String birthday;
//描述用户的所有订单,告诉MyBatisPlus，user类的order属性在user表中是不存在的
    @TableField(exist = false)
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUserName() {
        return  userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return  password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}

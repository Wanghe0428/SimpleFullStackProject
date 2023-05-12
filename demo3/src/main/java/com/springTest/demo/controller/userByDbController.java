package com.springTest.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springTest.demo.entity.User;
import com.springTest.demo.mapper.UserByMyBatisPlusMapper;
import com.springTest.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin  //springBoot设置允许跨域
public class userByDbController {
//    Autowired 是一个注释，它可以对类成员变量、方法及构造函数进行标注，让 spring 完成 bean 自动装配的工作
    @Autowired
    private UserMapper userMapper; //使用MyBatis来完成相关数据库操作
    @Autowired
    private UserByMyBatisPlusMapper userPlusMapper; //使用myBatisPlus来完成数据库相关操作
    //    查询用户
    @GetMapping("/userDb")
    public List<User> query() {
//        List是一个数据结构集合，其可以放置各种复杂数据类型，相比数组更加好用。有linkedList和ArrayList两种，类似于js中的数组Array
        List<User> list = userMapper.find(); //通过useMapper接口的find方法来查询数据库并将查询结果赋给list对象
        //通过myBatisPlus自身提供的selectList来查找，这里需要传入null，表示查找表的所有项
         List<User> list1 = userPlusMapper.selectList(null);
        System.out.println(list);
        System.out.println(list1);
        return list;
    }

//    增加用户
    @PostMapping("/userDb")
    public String insert(User user) {
        int insertNums = userMapper.insert(user);
        int insertNums1 = userPlusMapper.insert(user);
        System.out.println(insertNums);
        System.out.println(insertNums1);
//        if(insertNums > 0) {
//            return "插入数据";
//        } else {
//            return "插入失败";
//        }
        return "增加用户";
    }

//    删除用户
    @DeleteMapping("/userDb")
    public String delete(int id) {
        System.out.println("删除"+id);
        int isDeleteSuccess = userMapper.delete(id);
        if (isDeleteSuccess == 0) {
            System.out.println("删除失败");
        } else {
            System.out.println("删除成功");
        }
        return "删除数据";
    }

//    修改用户
    @PatchMapping("/userDb")
    public String update(User user) {
        System.out.println("修改");
        System.out.println(user);
        int isUpdateSuccess = userMapper.update(user);
        if (isUpdateSuccess == 0) {
            System.out.println("更新失败");
        } else {
            System.out.println("更新成功");
        }
        return "更新数据";
    }


//    查询所有用户，以及用户所对应的订单
    @GetMapping("/userDb/find")
    public List<User> find(){
        return userPlusMapper.selectAllUserAndOrders();
    }

//    条件查询
    @GetMapping("/userDb/findByTerm")
    public List<User> findByTerm() {
    // 使用条件构造器QueryWrapper
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", "wh");  //插入相等条件eq,还有其他条件比如lt小于
        List list = userPlusMapper.selectList(queryWrapper);
        System.out.println(list);
        return list;
    }

//    分页查询
    @GetMapping("/userDb/findByPage")
    public IPage<User> findByPage() {
        //设置起始值及每页条数。表示返回几条数据
        Page<User> page = new Page<>(0, 4); //第一个参数为从第几条开始取，第二个参数为取几条
        //返回结果集
        IPage<User> ipage = userPlusMapper.selectPage(page, null);
        return ipage;
    }
}

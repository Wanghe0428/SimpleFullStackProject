CREATE TABLE user (
    id INT(11),
    useName VARCHAR(25),
    password VARCHAR(25),
    birthday VARCHAR(25)
);
insert into user(id,useName,password,birthday) value ( 1,"wh","wh13403896149WH","199828");
insert into user(id,useName,password,birthday) value ( 2,"xxx","wh111","199807");
# 修改id为主键自增
ALTER TABLE user MODIFY id INT AUTO_INCREMENT PRIMARY KEY; 

# 修改useName属性为userName
ALTER TABLE user change useName userName VARCHAR(25); 
insert into user(id,userName,password,birthday) value ( 2,"xxx","wh111","199807");

ALTER TABLE user MODIFY id INT(11) AUTO_INCREMENT; 
ALTER TABLE user MODIFY id INT AUTO_INCREMENT;

update user set userName="adad",password="dadwa",birthday="033" where id=2;


# 创建订单数据库表t_order。每一个用户都可对应一个订单
create table t_order (
	id INT(11),  #订单编号
    orderTime VARCHAR(25),  # 下单时间
    total INT(11),  # 下单金额
    uid INT(11)  # 此订单对应的用户id,此时uid就相当于外键，即与其他表相关联的键
);

insert into t_order(id, orderTime, total, uid) value (1, "2023-05-02", 3000, 1);


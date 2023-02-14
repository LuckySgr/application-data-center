create table user
(
    id            varchar(30) not null comment '用户ID'
        primary key,
    username      varchar(50) not null comment '用户昵称',
    password      varchar(50) not null comment ' 用户密码',
    sex           varchar(3)  not null comment ' 用户性别',
    status        varchar(3)  not null comment '用户状态',
    register_time date        not null comment '用户注册时间'
);

INSERT INTO application_data_center.user (id, username, password, sex, status, register_time) VALUES ('1', 'LuckySgr', '123456', '1', '1', '2021-12-19');

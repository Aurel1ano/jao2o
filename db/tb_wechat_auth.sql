create table `tb_wechat_auth`(
    `wechat_auth_id` int(10) not null auto_increment,
    `user_id` int(10) not null comment '作为外键与personinfo表中的userid关联',
    `open_id` varchar(1024) not null,
    `create_time` datetime default null,
    primary key(`wechat_auth_id`),
    constraint `fk_wechatauth_profile` foreign key(`user_id`) references `tb_person_info`(`user_id`)
)ENGINE=InnoDb auto_increment=1 default charset=utf8;
alter table tb_wechat_auth add unique index(open_id);
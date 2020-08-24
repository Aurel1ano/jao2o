create table `tb_local_auth`(
    `local_auth_id` int(10) not null auto_increment,
    `user_id` int(10) not null comment '作为外键与personinfo表中的userid关联',
    `username` varchar(128) not null,
    `password` varchar(128) not null,
    `create_time` datetime default null,
    `last_edit_time` datetime default null,
    primary key(`local_auth_id`),
    unique key `uk_local_profile`(`username`),
    constraint `fk_localauth_profile` foreign key (`user_id`) references `tb_person_info`(`user_id`)
)ENGINE=InnoDb auto_increment=1 default charset=utf8;
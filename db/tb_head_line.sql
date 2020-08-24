create table `tb_head_line`(
    `line_id` int(100) not null auto_increment,
    `line_name` varchar(1000) default null,
    `line_link` varchar(2000) not null,
    `line_img` varchar(2000) not null,
    `priority` int(2) default null,
    `enable_status` int(2) not null default '0',
    `create_time` datetime default null,
    `last_edit_time` datetime default null,
    primary key(`line_id`)
)ENGINE=InnoDB auto_increment=1 default charset=utf8
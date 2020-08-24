create table `tb_shop_category`(
    `shop_category_id` int(11) not null auto_increment,
    `shop_category_name` varchar(100) not null default '',
    `shop_category_desc` varchar(1000) default '',
    `shop_category_img` varchar(2000) default null,
    `priority` int(2) not null default '0',
    `create_time` datetime default null,
    `last_edit_time` datetime default null,
    `parent_id` int(11) default null,
    primary key (`shop_category_id`),
    constraint `fk_shop_category_self` foreign key (`parent_id`) references `tb_shop_category`(`shop_category_id`)
)ENGINE=InnoDB auto_increment=1 default charset=utf8;
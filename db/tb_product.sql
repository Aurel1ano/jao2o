create table `tb_product`(
    `product_id` int(100) not null auto_increment,
    `product_name` varchar(100) not null,
    `product_desc` varchar(2000) default null,
    `img_addr` varchar(2000) default '',
    `normal_price` varchar(100) default null,
    `promotion_price` varchar(100) default null,
    `priority` int(2) not null default '0',
    `create_time` datetime default null,
    `last_edit_time` datetime default null,
    `enable_status` int(2) not null default '0',
    `product_category_id` int(11) default null,
    `shop_id` int(20) not null default '0',
    primary key (`product_id`),
    constraint `fk_product_procategory` foreign key (`product_category_id`) references `tb_product_category`(`product_category_id`),
    constraint `fk_product_shop` foreign key (`shop_id`) references `tb_shop`(`shop_id`)
)ENGINE=InnoDB auto_increment=1 default charset=utf8;
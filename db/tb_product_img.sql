create table `tb_product_img`(
    `product_img_id` int(20) not null auto_increment,
    `img_addr` varchar(2000) not null,
    `img_desc` varchar(2000) default null,
    `priority` int(2) default '0',
    `create_time` datetime default null,
    `product_id` int(20) default null,
    primary key (`product_img_id`),
    constraint `fk_img_product` foreign key (`product_id`) references `tb_product`(`product_id`)
)ENGINE=InnoDB auto_increment=1 default charset=utf8;
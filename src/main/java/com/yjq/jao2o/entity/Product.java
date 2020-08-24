package com.yjq.jao2o.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 产品
 */
@Data
public class Product {
    private Long productId;
    private String productName;
    private String productDesc;
    private String imgAddr;
    private String normalPrice;
    private String promotionPrice;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    // -1不可用 0下架 1可用
    private Integer enableStatus;

    private List<ProductImg> productImgList;
    private Shop shop;
}

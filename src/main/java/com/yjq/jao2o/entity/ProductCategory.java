package com.yjq.jao2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品类别
 */
@Data
public class ProductCategory {
    private Long productCategoryId;
    private Long shopId;
    private String productCategoryName;
    private Integer priority;
    private Date createTime;
}

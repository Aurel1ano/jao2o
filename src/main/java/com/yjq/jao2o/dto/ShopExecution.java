package com.yjq.jao2o.dto;

import com.yjq.jao2o.entity.Shop;

import java.util.List;

public class ShopExecution {

    // 结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    // 店铺数量
    private int count;

    // 操作的shop(增删改)
    private Shop shop;

    // shop列表(查询)
    private List<Shop> shopList;

}

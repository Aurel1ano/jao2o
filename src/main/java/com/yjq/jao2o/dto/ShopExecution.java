package com.yjq.jao2o.dto;

import com.yjq.jao2o.entity.Shop;
import com.yjq.jao2o.enums.ShopStateEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ShopExecution {

    // 结果状态
    @Setter
    @Getter
    private int state;

    // 状态标识
    @Setter
    @Getter
    private String stateInfo;

    // 店铺数量
    @Setter
    @Getter
    private int count;

    // 操作的shop(增删改)
    @Setter
    @Getter
    private Shop shop;

    // shop列表(查询)
    @Setter
    @Getter
    private List<Shop> shopList;

    public ShopExecution() {

    }

    // 失败的构造器
    public ShopExecution(ShopStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    // 成功的构造器
    public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }

}

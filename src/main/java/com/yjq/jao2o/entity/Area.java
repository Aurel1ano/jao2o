package com.yjq.jao2o.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

public class Area {

    // 区域Id
    @Getter @Setter
    private Integer areaId;

    // 区域名称
    @Getter @Setter
    private String areaName;

    // 权重
    @Getter @Setter
    private Integer priority;

    // 创建时间
    @Getter @Setter
    private Date createTime;

    //最后编辑时间
    @Getter @Setter
    private Date lastEditTime;

}

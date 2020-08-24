package com.yjq.jao2o.entity;

import lombok.Data;
import java.util.Date;

/**
 * 区域信息
 */
@Data
public class Area {

    // 区域Id
    private Integer areaId;

    // 区域名称
    private String areaName;

    // 权重
    private Integer priority;

    // 创建时间
    private Date createTime;

    //最后编辑时间
    private Date lastEditTime;

}

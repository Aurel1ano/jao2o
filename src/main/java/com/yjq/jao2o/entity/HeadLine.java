package com.yjq.jao2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * 头条
 */
@Data
public class HeadLine {
    private Long lineId;
    private String lineName;
    private String lineLink;
    private String lineImg;
    private Integer priority;
    // 0不可用1可用
    private Integer enableStatus;
    private Date createTime;
    private Date lastEditTime;
}

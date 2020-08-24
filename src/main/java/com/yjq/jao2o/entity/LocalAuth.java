package com.yjq.jao2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * 本地账号
 */
@Data
public class LocalAuth {
    private Long localAuthId;
    private String userName;
    private String password;
    private Date createTime;
    private Date lastEditTime;
    private PersonInfo personInfo;
}

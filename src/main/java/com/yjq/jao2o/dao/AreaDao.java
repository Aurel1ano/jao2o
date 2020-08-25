package com.yjq.jao2o.dao;

import com.yjq.jao2o.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 列出区域列表
     * @return List
     */
    List<Area> queryArea();
}

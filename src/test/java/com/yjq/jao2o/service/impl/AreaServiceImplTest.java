package com.yjq.jao2o.service.impl;

import com.yjq.jao2o.BaseTest;
import com.yjq.jao2o.entity.Area;
import com.yjq.jao2o.service.AreaService;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceImplTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList() {
        List<Area> areaList = areaService.getAreaList();
        assertEquals("右街2楼", areaList.get(0).getAreaName());
    }
}
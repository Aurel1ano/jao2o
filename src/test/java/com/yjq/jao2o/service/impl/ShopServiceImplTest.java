package com.yjq.jao2o.service.impl;

import com.yjq.jao2o.BaseTest;
import com.yjq.jao2o.dto.ShopExecution;
import com.yjq.jao2o.entity.Area;
import com.yjq.jao2o.entity.PersonInfo;
import com.yjq.jao2o.entity.Shop;
import com.yjq.jao2o.entity.ShopCategory;
import com.yjq.jao2o.enums.ShopStateEnum;
import com.yjq.jao2o.service.ShopService;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceImplTest extends BaseTest {

    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() throws FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺4");
        shop.setShopDesc("test4");
        shop.setShopAddr("test4");
        shop.setPhone("test4");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("D:/projectdev/test.jpg");
        InputStream is = new FileInputStream(shopImg);
//        ImageHolder imageHolder = new ImageHolder(shopImg.getName(), is);
        ShopExecution se = shopService.addShop(shop, is, shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }
}
package com.yjq.jao2o.service.impl;

import com.yjq.jao2o.dao.ShopDao;
import com.yjq.jao2o.dto.ShopExecution;
import com.yjq.jao2o.entity.Shop;
import com.yjq.jao2o.enums.ShopStateEnum;
import com.yjq.jao2o.exceptions.ShopOperationException;
import com.yjq.jao2o.service.ShopService;
import com.yjq.jao2o.util.ImageUtil;
import com.yjq.jao2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException{
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                throw new ShopOperationException("店铺创建失败");
            } else {
                if (shopImgInputStream != null) {
                    try {
                        addShopImg(shop, shopImgInputStream, fileName);
                    } catch (Exception e) {
                        throw new ShopOperationException("addShopImg error:" + e.getMessage());
                    }
                }
                effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0) {
                    throw new ShopOperationException("更新图片地址失败");
                }
            }

        }catch (Exception e) {
            throw new ShopOperationException("addShop error:" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream, fileName, dest);
        shop.setShopImg(shopImgAddr);
    }
}

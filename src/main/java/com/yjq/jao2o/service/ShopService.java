package com.yjq.jao2o.service;

import com.yjq.jao2o.dto.ShopExecution;
import com.yjq.jao2o.entity.Shop;

import java.io.File;

public interface ShopService {

    ShopExecution addShop(Shop shop, File shopImgFile);
}

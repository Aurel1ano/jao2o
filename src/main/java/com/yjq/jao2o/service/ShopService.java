package com.yjq.jao2o.service;

import com.yjq.jao2o.dto.ShopExecution;
import com.yjq.jao2o.entity.Shop;
import com.yjq.jao2o.exceptions.ShopOperationException;

import java.io.File;
import java.io.InputStream;

public interface ShopService {

    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}

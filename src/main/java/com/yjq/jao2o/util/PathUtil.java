package com.yjq.jao2o.util;

public class PathUtil {

    private static String seperator = System.getProperty("file.separator");

    /**
     * 获取图像存储路径
     *
     * @return
     */
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/projectdev/image/";
        } else {
            basePath = "/home/jqo2o/image/";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    /**
     * 获取店铺图片存储路径
     *
     * @param shopId
     * @return
     */
    public static String getShopImagePath(long shopId) {
        String imagePath = "upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", seperator);
    }
}

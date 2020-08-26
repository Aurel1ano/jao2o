package com.yjq.jao2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {

    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    private static final Random random = new Random();

    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * CommonsMultipartFile转换为File
     * @param commonsMultipartFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile commonsMultipartFile) {
        File newFile = new File(commonsMultipartFile.getOriginalFilename());
        try {
            commonsMultipartFile.transferTo(newFile);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 处理缩略图，并返回新生成图片的相对值路径
     * @param thumbnailFile
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(File thumbnailFile, String targetAddr) {
        String realFileName = getRandomFileName();
        String extension = getFileExtension(thumbnailFile);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is:" + relativeAddr);
        File destFile = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current complete is:" + PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnailFile).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "\\water.jpg")), 0.25f)
                    .outputQuality(0.8f)
                    .toFile(destFile);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及到的目录,逐级创建
     * @param pathStr
     */
    private static void makeDirPath(String pathStr) {
        // 全路径
        String realFileParentPath = PathUtil.getImgBasePath() + pathStr;

        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 生成随机文件名
     * @return
     */
    private static String getRandomFileName() {
        int ranNum = random.nextInt(89999) + 10000;
        String nowTimeStr = simpleDateFormat.format(new Date());
        return nowTimeStr + ranNum;
    }

    /**
     * 获得文件扩展名
     * @param file
     * @return
     */
    private static String getFileExtension(File file) {
        String originalFileName = file.getName();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

}

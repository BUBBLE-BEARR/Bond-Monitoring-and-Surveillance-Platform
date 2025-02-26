package com.project.common.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Base64;
import java.io.*;

public class ImageUtils {

    private static final Logger log = LoggerFactory.getLogger(ImageUtils.class);

    /**
     * 本地图片转换Base64的方法
     * @param imgPath
     */
    public  String imageToBase64(String imgPath,String suffix) {
        String base64 = null;
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
            // 对字节数组Base64编码
            Base64.Encoder encoder = Base64.getEncoder();
            // 返回Base64编码过的字节数组字符串
            base64 = getPictureHead(suffix)+encoder.encodeToString(data);
        } catch (IOException e) {
            log.error("图片转换失败：",e);
        }finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (Exception e2) {
                log.error("InputStream关闭失败：",e2);
            }
        }
        return base64;
    }

    public  String getPictureHead(String type){
        type=type.toLowerCase();
        if("png".equals(type)){
            return "data:image/png;base64,";
        }else if("jpg".equals(type)){
            return "data:image/jpeg;base64,";
        }else if("gif".equals(type)){
            return "data:image/gif;base64,";
        }else {
            return "data:image/png;base64,";
        }
    }

}



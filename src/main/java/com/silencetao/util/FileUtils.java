package com.silencetao.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.silencetao.common.SilenceInfo;
import com.silencetao.common.SilenceStatus;
import com.silencetao.exception.SilenceException;

/**
 * 文件操作工具类
 * @author Silence
 * create time 2017年7月25日 下午5:20:05
 * @version 1.0.1
 */
public class FileUtils {
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 上传文件工具方法
     * @version 1.0.1 
     * @param file 要上传的文件
     * @param realPath 上传文件的路径
     * @return 上传成功返回文件名，否则返回null
     */
    public static String upload(MultipartFile file, String realPath) {
        String result = null;
        
        if (file == null || file.isEmpty()) {
            logger.error(SilenceInfo.UPLOAD_FILE_EMPTY);
            throw new SilenceException(SilenceStatus.ILLEGAL_ARGUMENT, SilenceInfo.UPLOAD_FILE_EMPTY);
        }
        
        String fileName = file.getOriginalFilename();
        String fileUploadName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."), fileName.length());
        
        File path = new File(realPath);
        if (!path.exists()) {
            path.mkdirs();
        }
        
        File fileGoal = new File(realPath + fileUploadName);
        try {
            file.transferTo(fileGoal);
            result = fileUploadName;
            logger.info("上传文件{}成功", fileUploadName);
        } catch (IOException e) {
            logger.error(SilenceInfo.UPLOAD_FILE_FAILED, e);
            throw new SilenceException(SilenceStatus.ILLEGAL_ARGUMENT, SilenceInfo.UPLOAD_FILE_FAILED);
        } catch (Exception e) {
            logger.error(SilenceInfo.SYSTEM_ERROR, e);
            throw new SilenceException(SilenceStatus.SYSTEM_ERROR, SilenceInfo.SYSTEM_ERROR);
        }
        
        return result;
    }
    
    /**
     * 删除指定目录下的文件
     * @version 1.0.1 
     * @param path 文件路径
     * @param fileName 文件名
     * @return 删除成功返回true，否则返回false
     */
    public static boolean delete(String path, String fileName) {
        File file = new File(path + fileName);
        
        if (file.exists()) {
            file.delete();
            logger.info("删除{}文件成功", fileName);
            return true;
        }
        
        logger.info("文件不存在");
        return false;
    }
}

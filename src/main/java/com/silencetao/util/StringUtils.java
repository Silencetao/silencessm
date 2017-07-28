package com.silencetao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import net.sf.json.JSONObject;

/**
 * 字符串操作工具类
 * @author Silence
 * create time 2017年7月28日 下午3:23:56
 * @version 1.0.1
 */
public class StringUtils {
    private static Logger logger = LoggerFactory.getLogger(StringUtils.class);
    
    /**
     * 判断字符串是空白字符串
     * @version 1.0.1 
     * @param target
     * @return
     */
    public static boolean isBlank(String target) {
        int strLen;
        
        if (target == null || (strLen = target.length()) == 0) {
            return true;
        }
        
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(target.charAt(i)) == false) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * 判断字符串不是空白字符串
     * @version 1.0.1 
     * @param target
     * @return
     */
    public static boolean isNotBlank(String target) {
        return !StringUtils.isBlank(target);
    }
    
    /**
     * 判断两个字符串是否相等
     * @version 1.0.1 
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    /**
     * 对字符串进行MD5加密
     * @version 1.0.1 
     * @param str 要加密的字符串
     * @param slat 盐值
     * @return
     */
    public static String getMd5(String str, String salt) {
        String base = str + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
    
    /**
     * 生成指定位数的随机数
     * @version 1.0.1 
     * @param len 要生成随机数的长度
     * @return
     */
    public static String getRandom(long len) {
        int ans = 0;
        while(Math.log10(ans) + 1 < len) {
            ans = (int) (Math.random() * Math.pow(10, len));
        }
        
        return Integer.toString(ans);
    }
    
    /**
     * 根据生日计算年龄
     * @version 1.0.1 
     * @param birthday
     * @return
     * @throws Exception
     */
    public static int getAge(Date birthday) throws Exception {  
        Calendar cal = Calendar.getInstance();  
        if (cal.before(birthday)) {  
            logger.error("根据生日计算生日失败");
            return 0;
        }
        
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthday);  
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
        int age = yearNow - yearBirth;  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) age--;  
            } else {  
                age--;  
            }  
        }
        
        return age;  
    }
    
    /**
     * 将对象转换为JSON
     * @version 1.0.1 
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        JSONObject json = JSONObject.fromObject(object);
        return json.toString();
    }
    
    /**
     * 将字符串装换为Date对象
     * @version 1.0.1 
     * @param str
     * @return
     */
    public static Date stringToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            logger.error("将字符串装换为Date对象失败", e);
        }
        
        return date;
    }
    
    private StringUtils() {}
}

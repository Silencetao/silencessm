package com.silencetao.util;

import java.util.regex.Pattern;

/**
 * 邮件工具类
 * @author Silence
 * create time 2017年7月28日 下午3:02:53
 * @version 1.0.1
 */
public class EmailUtils {
    
    /**
     * 用于匹配邮箱的正则表达式
     */
    private static final Pattern emailPattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
    
    /**
     * 判断string是否为正确的邮箱
     * @version 1.0.1 
     * @param string
     * @return
     */
    public static boolean isEmail(String string) {
        return emailPattern.matcher(string).matches();
    }
    
    private EmailUtils() {}
}

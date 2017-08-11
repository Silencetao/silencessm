package com.silencetao.util;

import javax.servlet.http.HttpServletRequest;

import com.silencetao.common.UserConst;
import com.silencetao.entity.User;

/**
 * 判断用户是否登录的工具类
 * @author Silence
 * create time 2017年8月11日 下午3:06:20
 * @version 1.0.1
 */
public class SessionUtils {

    /**
     * 通过判断session是否为空判断用户是否登录
     * @version 1.0.1 
     * @param request
     * @return
     */
    public static boolean isLogin(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(UserConst.CURRENT_USER);
        
        if (user != null) {
            return true;
        }
        
        return false;
    }
}

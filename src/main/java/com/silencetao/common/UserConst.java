package com.silencetao.common;

/**
 * 为User实体需要用的常量定义的常量类
 * @author Silence
 * create time 2017年7月28日 下午3:14:16
 * @version 1.0.1
 */
public class UserConst {

    /**
     * 用来表示当前用户
     */
    public static final String CURRENT_USER = "currentUser";
    
    public static final String PASSWORD_SALT = "silencetao!@#$%^&*()0987654321jfdljfdljsadlf93249";
    
    /**
     * 用来表示用户角色的常量接口
     * @author Silence
     * create time 2017年7月28日 下午3:17:47
     * @version 1.0.1
     */
    public interface Role {
        
        /**
         * 普通用户
         */
        int ROLE_CUSTOMER = 1;

        /**
         * 管理员
         */
        int ROLE_ADMIN = 2;
    }
}

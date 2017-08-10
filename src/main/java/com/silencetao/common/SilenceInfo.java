package com.silencetao.common;

/**
 * 系统信息提示类
 * @author Silence
 * create time 2017年8月10日 下午2:44:00
 * @version 1.0.1
 */
public class SilenceInfo {
    
    /**
     * 状态代码：0
     * 状态描述：success
     * 请求成功提示信息
     */
    public static final String EMAIL_SEND_SUCCESS = "邮件发送成功";
    
    public static final String USER_REGISTER_SUCCESS = "用户注册成功";
    public static final String USER_LOGIN_SUCCESS = "用户登录成功";

    public static final String UPLOAD_FILE_SUCCESS = "上传文件成功";
    
    /**
     * 状态代码：1
     * 状态描述：failed
     * 请求失败错误提示信息
     */
    public static final String FAILED = "请求失败，请稍后重试";
    
    /**
     * 状态代码：2
     * 状态描述：illegal argument
     * 请求参数错误提示信息
     */
    public static final String EMAIL_EMPTY = "邮箱不能为空";
    public static final String EMAIL_FORMAT_ERROR = "邮箱格式不正确";
    public static final String EMAIL_EXIST = "邮箱已注册";
    public static final String EMAIL_TOPIC_EMPTY = "邮件主题不能为空";
    public static final String EMAIL_CONTENT_EMPTY = "邮件内容不能为空";
    public static final String EMAIL_CONTENT_ILLEGAL = "邮件内容不符合规定";
    public static final String EMAIL_SEND_FAILED = "邮件发送失败";
    
    public static final String USERNAME_EMPTY = "用户名不能为空";
    public static final String USERNAME_EXIST = "用户名已存在";
    public static final String PASSWORD_EMPTY = "密码不能为空";
    public static final String PASSWORD_ILLEGAL = "密码长度为6~16";
    public static final String USER_REGISTER_FAILED = "用户注册失败";
    public static final String USER_LOGIN_FAILED = "用户登录失败";
    public static final String USER_LOGIN_ERROR = "用户名不存在或密码错误";
    public static final String USERNAME_NOT_EXIST = "用户名不存在";
    public static final String PASSWORD_ERROR = "密码错误";
    
    public static final String UPLOAD_FILE_EMPTY = "上传文件不能为空";
    public static final String UPLOAD_FILE_FAILED = "上传文件失败";
    
    /**
     * 状态代码：7
     * 状态描述：system error
     * 系统错误提示信息
     */
    public static final String SYSTEM_ERROR = "系统错误，请稍后重试";
    
    /**
     * 状态代码：8
     * 状态描述：permission denied
     * 没有操作权限提示信息
     */
    public static final String PERMISSION_DENIED = "对不起，您没有操作权限";
    
    /**
     * 状态代码：10
     * 状态描述：need login
     * 需要用户登录提示信息
     */
    public static final String NEED_LOGIN = "需要登录，请先登录";
}

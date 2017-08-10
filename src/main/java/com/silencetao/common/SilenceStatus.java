package com.silencetao.common;

/**
 * 前端响应状态信息枚举类
 * @author Silence
 * create time 2017年7月28日 下午2:10:38
 * @version 1.0.1
 */
public enum SilenceStatus {

    /**
     * 请求成功时返回的状态
     */
    SUCCESS(0, "success"),
    
    /**
     * 请求失败时返回的状态
     */
    FAILED(1, "failed"),
    
    /**
     * 请求参数错误时返回的状态
     */
    ILLEGAL_ARGUMENT(2, "illegal argument"),
    
    /**
     * 系统错误
     */
    SYSTEM_ERROR(7, "system error"),
    
    /**
     * 没有操作权限
     */
    PERMISSION_DENIED(8, "permission denied"),
    
    /**
     * 需要用户登录时返回的状态
     */
    NEED_LOGIN(10, "need login");
    
    /**
     * 状态码
     */
    private final int code;
    
    /**
     * 状态信息
     */
    private final String desc;

    private SilenceStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

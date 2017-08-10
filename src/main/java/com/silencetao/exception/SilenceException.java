package com.silencetao.exception;

import com.silencetao.common.SilenceStatus;

/**
 * 自定义异常类
 * @author Silence
 * create time 2017年8月9日 下午4:59:36
 * @version 1.0.1
 */
public class SilenceException extends RuntimeException {
    private static final long serialVersionUID = 6897172975463583600L;
    
    /**
     * 错误状态码
     */
    private int status;

    public SilenceException(String message) {
        super(message);
    }
    
    public SilenceException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public SilenceException(SilenceStatus code) {
        super(code.getDesc());
        this.status = code.getCode();
    }
    
    public SilenceException(SilenceStatus code, String message) {
        super(message);
        this.status = code.getCode();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

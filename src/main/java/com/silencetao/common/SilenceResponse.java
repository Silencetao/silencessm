package com.silencetao.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.silencetao.exception.SilenceException;

/**
 * 前端响应数据封装类
 * @author Silence
 * create time 2017年7月28日 下午2:04:31
 * @version 1.0.1
 */
@JsonSerialize(include = Inclusion.NON_NULL)
public class SilenceResponse<T> implements Serializable {
    private static final long serialVersionUID = 36066501129349253L;

    /**
     * 状态码
     */
    private int status;
    
    /**
     * 状态信息
     */
    private String message;
    
    /**
     * 响应数据
     */
    private T data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
    
    @JsonIgnore
    public boolean isSuccess() {
        return status == SilenceStatus.SUCCESS.getCode();
    }

    private SilenceResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private SilenceResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private SilenceResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    
    /**
     * 当需要表示请求成功时，调用此方法
     * @version 1.0.1 
     * @return 返回携带SUCCESS状态码和状态信息的ResponseMessage对象
     */
    public static <T> SilenceResponse<T> getSuccess() {
        return new SilenceResponse<>(SilenceStatus.SUCCESS.getCode(), SilenceStatus.SUCCESS.getDesc());
    }
    
    /**
     * 当需要表示请求成功时，调用此方法
     * @version 1.0.1 
     * @param message
     * @return 返回携带SUCCESS状态码和message的ResponseMessage对象
     */
    public static <T> SilenceResponse<T> getSuccessMessage(String message) {
        return new SilenceResponse<>(SilenceStatus.SUCCESS.getCode(), message);
    }
    
    /**
     * 当需要表示请求成功时，调用此方法
     * @version 1.0.1 
     * @param data
     * @return 返回携带SUCCESS状态码和data的ResponseMessage对象
     */
    public static <T> SilenceResponse<T> getSuccessData(T data) {
        return new SilenceResponse<T>(SilenceStatus.SUCCESS.getCode(), data);
    }
    
    /**
     * 当需要表示请求成功时，调用此方法
     * @version 1.0.1 
     * @param message
     * @param data
     * @return 返回携带SUCCESS状态码和message、data的ResponseMessage对象
     */
    public static <T> SilenceResponse<T> getSuccessDataMessage(T data, String message) {
        return new SilenceResponse<T>(SilenceStatus.SUCCESS.getCode(), message, data);
    }
    
    /**
     * 当需要表示请求失败或错误时，调用此方法
     * @version 1.0.1 
     * @param status
     * @param message
     * @return 返回携带status和message的ResponseMessage对象
     */
    public static <T> SilenceResponse<T> getError(int status, String message) {
        return new SilenceResponse<>(status, message);
    }
    
    /**
     * 当需要表示请求失败或错误时，调用此方法
     * @version 1.0.1 
     * @param status
     * @param message
     * @return 返回携带SilenceException异常信息的ResponseMessage对象
     */
    public static <T> SilenceResponse<T> getError(SilenceException exception) {
        return new SilenceResponse<>(exception.getStatus(), exception.getMessage());
    }
    
    /**
     * 当需要表示请求失败或错误时，调用此方法
     * @version 1.0.1 
     * @param code
     * @return 返回携带ResponseCode信息的ResponseMessage对象
     */
    public static <T> SilenceResponse<T> getError(SilenceStatus code) {
        return new SilenceResponse<>(code.getCode(), code.getDesc());
    }
    
    /**
     * 当需要表示请求失败或错误时，调用此方法
     * @version 1.0.1 
     * @param code
     * @return 返回携带ResponseCode信息的ResponseMessage对象
     */
    public static <T> SilenceResponse<T> getError(SilenceStatus code, String message) {
        return new SilenceResponse<>(code.getCode(), message);
    }
    
    /**
     * 当需要表示请求失败或错误时，调用此方法
     * @version 1.0.1 
     * @return 返回携带FAILED状态码和状态信息的ResponseMessage对象
     */
    public static <T> SilenceResponse<T> getErrorFailed() {
        return new SilenceResponse<>(SilenceStatus.FAILED.getCode(), SilenceStatus.FAILED.getDesc());
    }
    
    /**
     * 当需要表示请求失败或错误时，调用此方法
     * @version 1.0.1 
     * @param message
     * @return 返回携带FAILED状态码和message的ResponseMessage对象
     */
    public static <T> SilenceResponse<T> getErrorFailed(String message) {
        return new SilenceResponse<>(SilenceStatus.FAILED.getCode(), message);
    }
    
    /**
     * 当请求的参数非法时，调用此方法
     * @version 1.0.1 
     * @return 返回携带ILLEGAL_ARGUMENT状态码和状态信息的ResponseMessage对象
     */
    public static <T> SilenceResponse<T> getErrorIllegalArgument() {
        return new SilenceResponse<>(SilenceStatus.ILLEGAL_ARGUMENT.getCode(), SilenceStatus.ILLEGAL_ARGUMENT.getDesc());
    }
    
    /**
     * 当请求的参数非法时，调用此方法
     * @version 1.0.1 
     * @return 返回携带ILLEGAL_ARGUMENT状态码和message的ResponseMessage对象
     */
    public static <T> SilenceResponse<T> getErrorIllegalArgument(String message) {
        return new SilenceResponse<>(SilenceStatus.ILLEGAL_ARGUMENT.getCode(), message);
    }
    
    /**
     * 当请求需要登录而未登录时，调用此方法
     * @version 1.0.1 
     * @return 返回携带NEED_LOGIN状态码和状态信息的ResponseMessage对象
     */
    public static <T> SilenceResponse<T> getErrorNeedLogin() {
        return new SilenceResponse<>(SilenceStatus.NEED_LOGIN.getCode(), SilenceStatus.NEED_LOGIN.getDesc());
    }
}

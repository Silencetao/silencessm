package com.silencetao.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 文件上传进度VO类
 * @author Silence
 * create time 2017年8月30日 下午1:43:06
 * @version 1.0.1
 */
public class ProgressVO implements Serializable {
    private static final long serialVersionUID = -5303482574145515921L;

    /**
     * 文件总大小
     */
    private Long contentLength;
    
    /**
     * 到目前为止读取文件大小
     */
    private Long bytesRead;
    
    /**
     * 目前正在读取第几个文件
     */
    private Integer item;
    
    /**
     * 百分比
     */
    private BigDecimal percent;
    
    /**
     * 正在读取文件的标记
     */
    private String sign;
    
    public ProgressVO() {}

    public ProgressVO(String sign) {
        this.sign = sign;
    }

    public Long getContentLength() {
        return contentLength;
    }

    public void setContentLength(Long contentLength) {
        this.contentLength = contentLength;
    }

    public Long getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead(Long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "ProgressVO [contentLength=" + contentLength + ", bytesRead=" + bytesRead + ", item=" + item
                + ", percent=" + percent + ", sign=" + sign + "]";
    }
}

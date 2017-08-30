package com.silencetao.listener;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

import com.silencetao.vo.ProgressVO;

public class SilenceProgressListener implements ProgressListener {

    private HttpSession session;
    
    private ProgressVO progressVO;
    
    public SilenceProgressListener(HttpSession session, String sign) {
        this.session = session;
        this.progressVO = new ProgressVO(sign);
    }
    
    @Override
    public void update(long pBytesRead, long pContentLength, int pItems) {
        progressVO.setBytesRead(pBytesRead);
        progressVO.setContentLength(pContentLength);
        progressVO.setItem(pItems);
        
        BigDecimal byteRead = new BigDecimal(Long.toString(pBytesRead));
        BigDecimal contentLength = new BigDecimal(Long.toString(pContentLength));
        progressVO.setPercent(byteRead.divide(contentLength, 2, BigDecimal.ROUND_HALF_DOWN));
        
        session.setAttribute("progress", progressVO);
    }
}

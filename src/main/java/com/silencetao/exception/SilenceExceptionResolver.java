package com.silencetao.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.silencetao.common.SilenceInfo;
import com.silencetao.common.SilenceStatus;
import com.silencetao.common.SilenceResponse;
import com.silencetao.util.StringUtils;

/**
 * 系统统一异常
 * @author Silence
 * create time 2017年8月9日 下午6:53:42
 * @version 1.0.1
 */
public class SilenceExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception exception) {
        /*
         * 判断是否为ajax请求
         */
        if (!(request.getHeader("accept").indexOf("application/json") > -1 || 
                (request.getHeader("X-Requested-With") != null && 
                request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
            //如果不是ajax请求，以JSP格式返回
            Map<String, String> map = Maps.newHashMap();
            
            if (exception instanceof SilenceException) {
                map.put("message", exception.getMessage());
            } else {
                map.put("message", "您要访问的页面好像出错了");
            }
            
            return new ModelAndView("error/500", map);
        } else {
            //如果是ajax请求，以JSON格式返回
            try {
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                SilenceResponse<String> message = null;
                
                if (exception instanceof SilenceException) {
                    SilenceException ex = (SilenceException) exception;
                    message = SilenceResponse.getError(ex);
                } else {
                    message = SilenceResponse.getError(SilenceStatus.SYSTEM_ERROR.getCode(), SilenceInfo.SYSTEM_ERROR);
                }
                
                writer.write(StringUtils.toJson(message));
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }
}

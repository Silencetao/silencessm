package com.silencetao.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.silencetao.common.SilenceInfo;
import com.silencetao.common.SilenceResponse;
import com.silencetao.common.SilenceStatus;
import com.silencetao.util.SessionUtils;
import com.silencetao.util.StringUtils;

/**
 * 系统拦截器
 * @author Silence
 * create time 2017年8月11日 上午10:26:42
 * @version 1.0.1
 */
public class SilenceInterceptor implements HandlerInterceptor {
    private static final String[] LOGIN_AUTH = {};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String url = request.getRequestURI();
        
        for (String str : LOGIN_AUTH) {
            if (url.indexOf(str) >= 0 && !SessionUtils.isLogin(request)) {
                /*
                 * 判断是否为ajax请求
                 */
                if (!(request.getHeader("accept").indexOf("application/json") > -1 || 
                        (request.getHeader("X-Requested-With") != null && 
                        request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter writer = response.getWriter();
                    
                    writer.write("<title>" + SilenceInfo.NEED_LOGIN + "</title>");
                    writer.write("<script type=\"text/javascript\" src=\"/resources/js/common/jquery-1.8.3.min.js\"></script>");
                    writer.write("<script></script>");
                } else {
                    response.setContentType("application/json;charset=UTF-8");
                    PrintWriter writer = response.getWriter();
                    
                    writer.write(StringUtils.toJson(SilenceResponse.getError(SilenceStatus.NEED_LOGIN, SilenceInfo.NEED_LOGIN)));
                    writer.flush();
                    writer.close();
                }
                
                return false;
            }
        }
        
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

}

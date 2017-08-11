package com.silencetao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silencetao.common.SilenceResponse;
import com.silencetao.entity.User;
import com.silencetao.service.UserService;
import com.silencetao.util.EmailUtils;

/**
 * User实体Controller层实现
 * @author Silence
 * create time 2017年7月28日 下午2:44:39
 * @version 1.0.1
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {
    
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @version 1.0.1 
     * @param user
     * @return
     */
    @RequestMapping("register")
    @ResponseBody
    public SilenceResponse<String> register(User user) {
        return userService.register(user);
    }
    
    /**
     * 邮件发送测试
     * @version 1.0.1 
     * @param toEmail
     * @return
     */
    @RequestMapping("sendEmail")
    @ResponseBody
    public SilenceResponse<String> sendEmail(String subject, String content, String toEmail) {
        EmailUtils.sendEmail(toEmail, subject, content);
        
        return SilenceResponse.getSuccess();
    }
    
    @RequestMapping("createSession")
    @ResponseBody
    public SilenceResponse<String> createSession(HttpServletRequest request, HttpSession session) {
        session.setAttribute("message", "你好，nginx");
        
        return SilenceResponse.getSuccess();
    }
    
    @RequestMapping("showSession")
    @ResponseBody
    public SilenceResponse<String> showSession(HttpServletRequest request, HttpSession session) {
        String message = (String) session.getAttribute("message");
        
        System.out.println(message);
        
        return SilenceResponse.getSuccessMessage(message);
    }
}

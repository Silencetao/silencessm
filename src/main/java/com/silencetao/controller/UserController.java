package com.silencetao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silencetao.common.SilenceResponse;
import com.silencetao.entity.User;
import com.silencetao.service.UserService;

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
}

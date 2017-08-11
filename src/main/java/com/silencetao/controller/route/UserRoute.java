package com.silencetao.controller.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户模块页面跳转代理
 * @author Silence
 * create time 2017年8月11日 下午3:56:49
 * @version 1.0.1
 */
@Controller
@RequestMapping("user")
public class UserRoute {

    @RequestMapping(value = "{action}", method = RequestMethod.GET)
    public String to(@PathVariable("action") String action) {
        return "user/" + action;
    }
}

package com.silencetao.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.silencetao.common.SilenceResponse;
import com.silencetao.entity.User;
import com.silencetao.service.UserService;
import com.silencetao.util.FileUtils;
import com.silencetao.vo.ProgressVO;

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
    
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public SilenceResponse<String> upload(String title,
            @RequestParam(value = "image", required = false) MultipartFile image) {
        String result =  FileUtils.upload(image, "/silencessm/image/");
        return SilenceResponse.getSuccessDataMessage(result, "上传成功");
    }
    
    @RequestMapping(value = "getprogress", method = RequestMethod.GET)
    @ResponseBody
    public SilenceResponse<ProgressVO> getProgress(HttpSession session) {
        ProgressVO progressVO = (ProgressVO) session.getAttribute("progress");
        
        return SilenceResponse.getSuccessData(progressVO);
    }
}

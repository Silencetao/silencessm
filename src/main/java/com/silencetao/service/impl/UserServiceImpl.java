package com.silencetao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silencetao.common.ResponseMessage;
import com.silencetao.common.UserConst;
import com.silencetao.dao.UserMapper;
import com.silencetao.entity.User;
import com.silencetao.service.UserService;
import com.silencetao.util.EmailUtils;
import com.silencetao.util.StringUtils;

/**
 * User实体Service层接口实现
 * @author Silence
 * create time 2017年7月28日 下午2:52:28
 * @version 1.0.1
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseMessage<String> register(User user) {
        if (StringUtils.isBlank(user.getUsername())) {
            return ResponseMessage.getErrorIllegalArgument("用户名不能为空");
        } else if (isRepeat(user.getUsername(), 1)) {
            return ResponseMessage.getErrorIllegalArgument("用户名已存在");
        }
        
        if (StringUtils.isBlank(user.getEmail())) {
            return ResponseMessage.getErrorIllegalArgument("邮箱不能为空");
        } else if (!EmailUtils.isEmail(user.getEmail())) {
            return ResponseMessage.getErrorIllegalArgument("邮箱格式不正确");
        } else if (isRepeat(user.getEmail(), 2)) {
            return ResponseMessage.getErrorIllegalArgument("邮箱已注册");
        }
        
        if (StringUtils.isBlank(user.getPassword())) {
            return ResponseMessage.getErrorIllegalArgument("密码不能为空");
        } else if (user.getPassword().length() < 6 || user.getPassword().length() > 16) {
            return ResponseMessage.getErrorIllegalArgument("密码长度为6~16");
        }
        
        user.setPassword(StringUtils.getMd5(user.getPassword(), UserConst.PASSWORD_SALT));
        
        int rowCount = userMapper.insertUser(user);
        if (rowCount > 0) {
            return ResponseMessage.getSuccessMessage("注册成功");
        }
        
        return ResponseMessage.getErrorFailed("注册失败");
    }
    
    /**
     * 查询用户名或邮箱是否重复
     * @version 1.0.1 
     * @param target username或email
     * @param mode mode为1时表示要判断的时username，mode为2时表示要判断的时email
     * @return ture表示重复，false表示不重复
     */
    private boolean isRepeat(String target, int mode) {
        int result = 0;
        
        if (mode == 1) {
            result = userMapper.checkUsernameEmail(target, null);
        } else if (mode == 2) {
            result = userMapper.checkUsernameEmail(null, target);
        }
        
        return result != 0;
    }
}

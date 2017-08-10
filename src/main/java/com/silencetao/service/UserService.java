package com.silencetao.service;

import com.silencetao.common.SilenceResponse;
import com.silencetao.entity.User;

/**
 * User实体Service层接口
 * @author Silence
 * create time 2017年7月28日 下午2:49:26
 * @version 1.0.1
 */
public interface UserService {

    SilenceResponse<String> register(User user);
}

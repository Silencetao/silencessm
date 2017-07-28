package com.silencetao.service;

import com.silencetao.common.ResponseMessage;
import com.silencetao.entity.User;

/**
 * User实体Service层接口
 * @author Silence
 * create time 2017年7月28日 下午2:49:26
 * @version 1.0.1
 */
public interface UserService {

    ResponseMessage<String> register(User user);
}

package com.silencetao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.silencetao.entity.User;

/**
 * User实体Dao层Mapper接口
 * @author Silence
 * create time 2017年7月28日 上午11:10:18
 * @version 1.0.1
 */
public interface UserMapper {

    /**
     * 保存一条用户信息
     * @version 1.0.1 
     * @param user
     * @return 返回添加记录的条数
     */
    int insertUser(User user);
    
    /**
     * 删除一条用户信息
     * @version 1.0.1 
     * @param userId
     * @return 返回删除记录的条数
     */
    int deleteUser(Long id);
    
    /**
     * 修改用户信息
     * @version 1.0.1 
     * @param user
     * @return 返回修改记录的条数
     */
    int updateUser(User user);
    
    /**
     * 从offset开始查询limit条用户信息
     * @version 1.0.1 
     * @param offset 查询开始的位置
     * @param limit 查询的条数
     * @return
     */
    List<User> getUserList(@Param("offset") int offset, @Param("limit") int limit);
    
    /**
     * 根据id查询用户信息
     * @version 1.0.1 
     * @param id
     * @return
     */
    User getUserById(Long id);
    
    /**
     * 查询用户名或邮箱是否重复
     * @version 1.0.1 
     * @param username
     * @param email
     * @return
     */
    int checkUsernameEmail(@Param("username") String username, @Param("email") String email);
}

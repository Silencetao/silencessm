package com.silencetao.dao;

import java.util.List;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.silencetao.entity.User;

/**
 * UserMapper Junit测试类
 * @author Silence
 * create time 2017年7月28日 下午12:08:02
 * @version 1.0.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserMapperTest {
    
    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("小涛涛");
        user.setPassword("1228714091");
        user.setSex(1);
        user.setBirthday(new Date());
        user.setPhone("18770814753");
        user.setEmail("taogu2010@yeah.net");
        user.setDescription("嗯。");
        int rowCount = userMapper.insertUser(user);
        System.out.println(rowCount);
    }
    
    @Test
    public void testDeleteUser() {
        int rowCount = userMapper.deleteUser(10001L);
        System.out.println(rowCount);
    }
    
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(10001L);
        user.setUsername("小涛涛");
        user.setPassword("1228714091chen");
        user.setSex(0);
        user.setBirthday(new Date());
        user.setPhone("18770813015");
        user.setEmail("1228714091@qq.com");
        user.setDescription("嗯哼。");
        user.setRole(2);
        user.setFlag(1);
        int rowCount = userMapper.updateUser(user);
        System.out.println(rowCount);
    }
    
    @Test
    public void testGetUserList() {
        List<User> userList = userMapper.getUserList(0, 10);
        for (User user : userList) {
            System.out.println(user);
        }
    }
    
    @Test
    public void testGetUserById() {
        User user = userMapper.getUserById(10000L);
        System.out.println(user);
    }
}

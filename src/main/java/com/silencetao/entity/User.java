package com.silencetao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * @author Silence
 * create time 2017年7月28日 上午10:52:20
 * @version 1.0.1
 */
public class User implements Serializable {
    private static final long serialVersionUID = -1288875721589701874L;

    /**
     * 用户id
     */
    private Long id;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 性别，0表示女性，1表示男性
     */
    private Integer sex;
    
    /**
     * 生日
     */
    private Date birthday;
    
    
    /**
     * 电话号码
     */
    private String phone;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 个人简介
     */
    private String description;
    
    /**
     * 用户角色：1表示普通用户，2表示管理员
     */
    private Integer role;
    
    /**
     * 标识数据是否被删除：0表示删除，1表示未被删除
     */
    private Integer flag;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 修改时间
     */
    private Date updateTime;
    
    public User() {}
    
    public User(String username, String password, Integer sex, Date birthday, String phone, String email,
            String description) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", birthday="
                + birthday + ", phone=" + phone + ", email=" + email + ", description=" + description + ", role=" + role
                + ", flag=" + flag + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
    }
}

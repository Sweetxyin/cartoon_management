package com.example.cartoon_management.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Admin {


    private Integer id;
    private String username;//用户名
    private String password;//密码
    private String name;//网名
    private String sex;//性别
    private String email;//邮箱
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;//创建时间

    /**
     * 构造方法
     * @param id
     */
    public Admin(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

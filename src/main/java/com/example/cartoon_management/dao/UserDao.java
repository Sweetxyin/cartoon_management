package com.example.cartoon_management.dao;

import com.example.cartoon_management.model.User;

import java.util.List;
/*
 * 该接口用来与mybatis的对应映射文件对接
 */
public interface UserDao {


    /**
     * 返回所有集合
     * @return
     */
    List<User> getUserList();

    /**
     * 添加一条数据
     * @param user
     * @return
     */
    int userAdd(User user);

    /**
     * 修改
     * @param user
     * @return
     */
    int userUpdate(User user);

    /**
     * 根据标识符获取id
     * @param id
     * @return
     */
   User getUser(Integer id);

    /**
     * 根据id删除账号
     * @param id
     * @return
     */
    int userDelete(Integer id);



}

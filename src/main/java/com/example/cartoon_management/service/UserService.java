package com.example.cartoon_management.service;



import com.example.cartoon_management.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


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
    boolean userAdd(User user);

    /**
     * 修改一条数据
     * @param user
     * @return
     */
    boolean userUpdate(User user);

    /**
     * 根据标识符获取ID
     * @param id
     * @return
     */
    User getUser(Integer id);

    /**
     *根据id删除账号
     * @param id
     * @return
     */
    boolean userDelete(Integer id);



}

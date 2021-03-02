package com.example.cartoon_management.service;

import com.example.cartoon_management.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    /**
     * 管理员登录功能
     * @param username
     * @param password
     * @return
     */
    Admin login(String username,String password);

    /**
     * 返回管理员所有集合
     * @return
     */
    List<Admin> AdminList();

    /**
     * 添加一条数据
     * @param admin
     * @return
     */
    boolean adminAdd(Admin admin);

    /**
     * 修改一条数据
     * @param admin
     * @return
     */
    boolean adminUpdate(Admin admin);

    /**
     * 根据标识符获取ID
     * @param id
     * @return
     */
    Admin getAdminId(Integer id);

    /**
     *根据id删除账号
     * @param id
     * @return
     */
    boolean adminDelete(Integer id);

    /**
     *查找在数据库中和指定用户名重名的个数
     * @param username
     * @return 返回个数，0表示不重名
     */
    boolean existsAdmin(String username);

}

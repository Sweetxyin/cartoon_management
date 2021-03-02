package com.example.cartoon_management.dao;

import com.example.cartoon_management.model.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    /**
     *   管理员登录功能
     * @param username 用户名
     * @param password 密码
     * @return
     */
    Admin login(@Param("username") String username, @Param("password") String password);

    /**
     * 返回所有集合
     * @return
     */
    List<Admin> AdminList();

    /**
     * 添加一条数据
     * @param admin
     * @return
     */
    int adminAdd(Admin admin);

    /**
     * 修改管理员
     * @param admin
     * @return
     */
    int adminUpdate(Admin admin);

    /**
     * 根据标识符获取id
     * @param id
     * @return
     */
    Admin getAdminId(Integer id);

    /**
     * 根据id删除管理员账号
     * @param id
     * @return
     */
    int adminDelete(Integer id);

    /**
     * 查找在数据库中用户名重名的个数
     * @param username
     * @return 返回个数，0表示不重名
     */
    Admin existsAdmin(@Param(value = "username") String username);

}

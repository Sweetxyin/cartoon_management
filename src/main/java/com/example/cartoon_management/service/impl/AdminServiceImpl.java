package com.example.cartoon_management.service.impl;

import com.example.cartoon_management.dao.AdminDao;
import com.example.cartoon_management.model.Admin;
import com.example.cartoon_management.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDao adminDao;

    @Override
    public Admin login(String username, String password) {
        return adminDao.login(username,password);
    }

    @Override
    public List<Admin> AdminList() {
        return adminDao.AdminList();
    }

    @Override
    public boolean adminAdd(Admin admin) {
        boolean strtus=false;
        admin.setCreateTime(new Date());//系统当前时间为创建日期
        if (adminDao.adminAdd(admin)==1){
            strtus=true;
        }else{
            strtus=false;
        }
        return strtus;
    }

    @Override
    public boolean adminUpdate(Admin admin) {
        boolean status=false;
        if (adminDao.existsAdmin(admin.getUsername())==null){//如果不重名
            if (adminDao.adminUpdate(admin)==1){
                status=true;
            }else {
                status=false;
            }
        }
        return status;
    }

    @Override
    public Admin getAdminId(Integer id) {
        Admin admin=null;
        if (id!=null){
            admin=adminDao.getAdminId(id);
        }
        return admin;
    }

    @Override
    public boolean adminDelete(Integer id) {
        boolean status=false;
        if (id!=null){
//            if (adminId!=id.intValue()){//如果不是自己删自己
                int n=adminDao.adminDelete(id);
                if (n==1){
                    status=true;
                }
//            }
        }
        return status;
    }

    @Override
    public boolean existsAdmin(String username) {
        if (adminDao.existsAdmin(username)==null){
            return true;
        }else {
            return false;
        }
    }
}

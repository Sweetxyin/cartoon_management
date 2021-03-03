package com.example.cartoon_management.service.impl;



import com.example.cartoon_management.dao.UserDao;
import com.example.cartoon_management.model.ResourceMan;
import com.example.cartoon_management.model.User;
import com.example.cartoon_management.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public boolean userAdd(User user) {
        boolean strtus=false;
        if (userDao.userAdd(user)==1){
            strtus=true;
        }else{
            strtus=false;
        }
        return strtus;
    }

    @Override
    public boolean userUpdate(User user) {
        boolean status=false;
        if (userDao.userUpdate(user)==1){
            status=true;
        }else {
            status=false;
        }
        return status;
    }

    @Override
    public User getUser(Integer id) {
        User user=null;
        if (id!=null){
            user=userDao.getUser(id);
        }
        return user;
    }

    @Override
    public boolean userDelete(Integer id) {
        boolean status=false;
        if (id!=null){
            int n=userDao.userDelete(id);
            if (n==1){
                status=true;
            }
        }
        return status;
    }
}

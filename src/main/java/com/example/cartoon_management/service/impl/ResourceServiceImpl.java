package com.example.cartoon_management.service.impl;


import com.example.cartoon_management.dao.ResourceDao;

import com.example.cartoon_management.model.ResourceMan;
import com.example.cartoon_management.service.ResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Resource
    private ResourceDao resourceDao;



    @Override
    public List<ResourceMan> getResourceList() {
        return resourceDao.getResourceList();
    }

    @Override
    public boolean resourceAdd(ResourceMan resourceMan) {
        boolean strtus=false;
        resourceMan.setCreateTime(new Date());//系统当前时间为创建日期
        if (resourceDao.resourceAdd(resourceMan)==1){
            strtus=true;
        }else{
            strtus=false;
        }
        return strtus;
    }

    @Override
    public boolean resourceUpdate(ResourceMan resourceMan) {
        boolean status=false;
            if (resourceDao.resourceUpdate(resourceMan)==1){
                status=true;
            }else {
                status=false;
            }
        return status;
    }

    @Override
    public ResourceMan getResource(Integer id) {
        ResourceMan resourceMan=null;
        if (id!=null){
            resourceMan=resourceDao.getResource(id);
        }
        return resourceMan;
    }

    @Override
    public boolean resourceDelete(Integer id) {
        boolean status=false;
        if (id!=null){
            int n=resourceDao.resourceDelete(id);
            if (n==1){
                status=true;
            }
        }
        return status;
    }


}

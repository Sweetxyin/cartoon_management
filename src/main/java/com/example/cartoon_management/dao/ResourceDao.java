package com.example.cartoon_management.dao;

import com.example.cartoon_management.model.Admin;
import com.example.cartoon_management.model.ResourceMan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceDao {


    /**
     * 返回所有集合
     * @return
     */
    List<ResourceMan> getResourceList();

    /**
     * 添加一条数据
     * @param resourceMan
     * @return
     */
    int resourceAdd(ResourceMan resourceMan);

    /**
     * 修改
     * @param resourceMan
     * @return
     */
    int resourceUpdate(ResourceMan resourceMan);

    /**
     * 根据标识符获取id
     * @param id
     * @return
     */
    ResourceMan getResourceId(Integer id);

    /**
     * 根据id删除账号
     * @param id
     * @return
     */
    int resourceDelete(Integer id);



}

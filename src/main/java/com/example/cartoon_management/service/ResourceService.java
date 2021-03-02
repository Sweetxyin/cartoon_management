package com.example.cartoon_management.service;


import com.example.cartoon_management.model.ResourceMan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResourceService {


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
    boolean resourceAdd(ResourceMan resourceMan);

    /**
     * 修改一条数据
     * @param resourceMan
     * @return
     */
    boolean resourceUpdate(ResourceMan resourceMan);

    /**
     * 根据标识符获取ID
     * @param id
     * @return
     */
    ResourceMan getresourceId(Integer id);

    /**
     *根据id删除账号
     * @param id
     * @return
     */
    boolean resourceDelete(Integer id);



}

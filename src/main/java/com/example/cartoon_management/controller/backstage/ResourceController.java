package com.example.cartoon_management.controller.backstage;

import com.example.cartoon_management.model.Admin;
import com.example.cartoon_management.model.ResourceMan;
import com.example.cartoon_management.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags="资源管理模块")
@RestController
@RequestMapping(value = "api/backstage/resourcemanage")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 获取数据库全部信息
     * @param request
     * @return 返回0表示获取成功
     */
    @ApiOperation(value = "读取全部资源信息")
    @GetMapping
    public Map<String,Object> toResourceList(HttpServletRequest request){
        Map<String,Object> map=new HashMap<String,Object>();
        List<ResourceMan> list=resourceService.getResourceList();
        map.put("total",list.size());
        map.put("data",list);
        map.put("code",0);
        return map;
    }

    /**
     * 删除资源操作
     * @param id
     * @param session
     * @return 返回0表示删除成功
     */
    @ApiOperation(value = "删除资源操作")
    @DeleteMapping("/deletes/{id}")
    public Map<String,Object> doDeleteResource(@PathVariable Integer id,HttpSession session){
        Map<String,Object> map=new HashMap<String,Object>();
        ResourceMan resourceMan=(ResourceMan)session.getAttribute("resourceMan");
        resourceService.resourceDelete(id);
        map.put("code",0);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * 修改资源信息
     * @param resourceMan
     * @return 返回0表示修改成功，返回1表示修改失败
     */
    @ApiOperation(value = "修改资源信息")
    @PutMapping
    public Map<String,Object> doUpdateResource(@RequestBody ResourceMan resourceMan){
        Map<String,Object> map=new HashMap<String, Object>();
            if (resourceService.resourceUpdate(resourceMan)){
                map.put("code",0);
                map.put("msg","基本信息修改成功！");
            }else {
                map.put("code",1);
                map.put("msg","基本信息修改失败！");
            }
        return map;
    }

    /**
     * 添加管理员操作
     * @param resourceMan
     * @return
     */
    @ApiOperation(value = "添加账户",notes = "添加账户，id、createTime不传值")
    @ApiImplicitParam(name = "resourceMan",value = "管理资源信息，id、createTime不传值",paramType = "body",dataType = "ResourceMan",required = true)
    @PostMapping
    public Map<String,Object> doAddResource(@RequestBody ResourceMan resourceMan){
        Map<String,Object> map=new HashMap<String, Object>();
//           if (resourceService.existsAdmin(admin.getUsername())==true){
            if (resourceService.resourceAdd(resourceMan)==true){
                map.put("code",0);
                map.put("msg","账户添加成功！");
            }else {
                map.put("code",1);
                map.put("msg","账户添加失败！");
            }
//        }
        return map;
    }
    @ApiOperation(value = "读取指定账户", notes = "根据id的值读取指定账户")
    @ApiImplicitParam(name = "id", value = "要读取的账户id", paramType = "path",dataType="int", required = true,example="1")
    @GetMapping("/{id}")
    public Map<String, Object>  getResource(@PathVariable Integer id){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("code",0);
        map.put("data",resourceService.getResource(id));
        return map;
    }
}

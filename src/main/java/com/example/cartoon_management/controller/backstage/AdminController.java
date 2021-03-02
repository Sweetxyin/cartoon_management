package com.example.cartoon_management.controller.backstage;

import com.example.cartoon_management.model.Admin;
import com.example.cartoon_management.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags="后台管理员模块")
@RestController
@RequestMapping(value = "api/backstage/adminmanage")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 获取数据库全部信息
     * @param request
     * @return 返回0表示获取成功
     */
    @ApiOperation(value = "读取全部管理员信息")
    @GetMapping
    public Map<String,Object> toAdminList(HttpServletRequest request){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Admin> list=adminService.AdminList();
        map.put("total",list.size());
        map.put("data",list);
        map.put("code",0);
        return map;
    }

    /**
     * 删除管理员操作
     * @param id
     * @param session
     * @return 返回0表示删除成功
     */
    @ApiOperation(value = "删除管理员操作")
    @DeleteMapping("/deletes/{id}")
    public Map<String,Object> doDeleteAdmin( @PathVariable Integer id,HttpSession session){
        Map<String,Object> map=new HashMap<String,Object>();
        Admin admin=(Admin)session.getAttribute("admin");
        adminService.adminDelete(id);
        map.put("code",0);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * 修改管理员信息
     * @param admin
     * @return 返回0表示修改成功，返回1表示修改失败
     */
    @ApiOperation(value = "修改管理员信息")
    @PutMapping
    public Map<String,Object> doUpdateAdmin(@RequestBody Admin admin){
        Map<String,Object> map=new HashMap<String, Object>();
        if (admin.getUsername().equals("")){
            map.put("msg","账户名不能为空！");
        }else if (admin.getName().equals("")){
            map.put("msg","网名不能为空");
        }else if (adminService.existsAdmin(admin.getUsername())==false){
            map.put("msg","账户名重名！");
        }
        else {
            if (adminService.adminUpdate(admin)){
                map.put("code",0);
                map.put("msg","基本信息修改成功！");
            }else {
                map.put("code",1);
                map.put("msg","基本信息修改失败！");
            }
        }
        return map;
    }

    /**
     * 添加管理员操作
     * @param admin
     * @return
     */
    @ApiOperation(value = "添加账户",notes = "添加账户，要添加的管理账户对象，id、createTime不传值")
    @ApiImplicitParam(name = "admin",value = "管理账户信息，id、createTime不传值",paramType = "body",dataType = "Admin",required = true)
    @PostMapping
    public Map<String,Object> doAddAdmin(@RequestBody Admin admin){
        Map<String,Object> map=new HashMap<String, Object>();
//           if (adminService.existsAdmin(admin.getUsername())==true){
            if (adminService.adminAdd(admin)==true){
                map.put("code",0);
                map.put("msg","账户添加成功！");
            }else {
                map.put("code",1);
                map.put("msg","账户添加失败！");
            }
//        }
        return map;
    }
}

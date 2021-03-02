package com.example.cartoon_management.controller;


import com.example.cartoon_management.model.Admin;
import com.example.cartoon_management.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "管理员登录注销模块")
@RestController
@RequestMapping(value = "/api/backstage")
public class LoginConteoller {

    @Resource
    private AdminService adminService;

    /**
     * 管理员登录功能
     * @param username
     * @param password
     * @param session
     * @return
     */
   @ApiOperation(value = "管理员登录",notes = "根据账户名和密码登录")
   @ApiImplicitParams({
           @ApiImplicitParam(name = "username",value = "用户名",required = true,dataType = "string",example = "user"),
           @ApiImplicitParam(name = "password",value = "密码",required = true,dataType = "string",example = "123456"),
   })
   @GetMapping("/login")
   public Map<String,Object> login(String username,String password,HttpSession session){
       Map<String,Object> map=new HashMap<String,Object>();
       Admin admin=adminService.login(username,password);
       if (adminService.login(username,password)!=null){
           session.setAttribute("admin",admin);
           map.put("code",0);
           map.put("data",admin.getUsername());
           map.put("msg","登录成功");
       }else {
           map.put("code",1);
           map.put("msg","登录失败:请重新输入账户名或者密码!");
       }
       return map;
   }

    /**
     * 注销
     * @param session
     * @return
     */
    @ApiOperation(value = "注销")
    @GetMapping("/logout")
    public Map<String,Object> logout(HttpSession session){
        Map<String,Object> map=new HashMap<String, Object>();
        session.removeAttribute("admin");
        map.put("code",0);
        map.put("msg","成功注销用户");
        return map;
        }

}

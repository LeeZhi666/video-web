package com.qf.videos.controller;

import com.qf.videos.pojo.Admin;
import com.qf.videos.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
   @RequestMapping("login")
    public String login(Admin admin){

        if(adminService.login(admin)!=null){

            return "success";
        }
        return "false";
    }
}

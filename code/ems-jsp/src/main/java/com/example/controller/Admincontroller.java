package com.example.controller;

import com.example.bean.Admin;
import com.example.service.impl.Adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class Admincontroller {
    @Autowired
    Adminservice adminservice;
    @RequestMapping("/register")

    public String  register(@RequestBody Admin admin){
        System.out.println("1111111111");
        adminservice.register(admin);
        return "login";
    }
}

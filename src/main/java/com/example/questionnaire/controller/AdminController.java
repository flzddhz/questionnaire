package com.example.questionnaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("login")
    public String tologin(){
        return "admin/login";
    }

    @RequestMapping("dologin")
    public String login(){
        System.out.println("登录！");
        return "admin/login";
    }
}

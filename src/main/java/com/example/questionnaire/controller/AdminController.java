package com.example.questionnaire.controller;

import com.example.questionnaire.entity.Account;
import com.example.questionnaire.entity.Admin;
import com.example.questionnaire.service.AccountServicer;
import com.example.questionnaire.service.AdminServier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    @Resource
    public AdminServier adminServier;
    @Resource
    private AccountServicer accountServicer;

    @RequestMapping("login")
    public String tologin(){
        return "admin/login";
    }

    @RequestMapping("dologin")
    public String login(Admin admin, HttpServletRequest request){
//        System.out.println("登录！");
        Admin admin1 = adminServier.login(admin.getUsername());
        if (admin1 != null){
            if (admin1.getPassword().equals(admin.getPassword())){
                request.getSession().setAttribute("admin",admin1);
                return "admin/index";
            }else{
                request.setAttribute("username",admin.getUsername());
                request.setAttribute("loginflag","密码错误");
                return "admin/login";
            }
        }else{
            request.setAttribute("loginflag","用户不存在");
            return "admin/login";
        }
    }

    @RequestMapping("index")            //方便测试
    public String toindex(){
        return "admin/index";
    }

    @RequestMapping("towelcome")
    public String towelcome(){
        return "admin/welcome";
    }
    @RequestMapping("tocustomer")
    public String tocustomer( Integer currPage, HttpServletRequest request){
        if (currPage == null ||currPage == 0 || currPage < 0){
            currPage = 1;
        }
        int page1 = (currPage -1) * 10;
        List<Account> accountList = accountServicer.queryAccount(page1,10,"");
        int accLine = accountServicer.accCount("");
        int allPage = (int) Math.ceil(accLine/10);
        request.setAttribute("pageInfo","1/" + allPage);
        request.getSession().setAttribute("currPage",1);
        request.setAttribute("aList",accountList);
        return "admin/member-list";
    }
    @RequestMapping("toquertion")
    public String toquertion(){
        return "admin/member-list1";
    }
    @RequestMapping("tomemberadd")
    public String tomemberadd(){
        return "admin/member-add";
    }
    @RequestMapping("tomemberedit")
    public String tomemberedit(Integer id,HttpServletRequest request){
        request.setAttribute("id",id);
        return "admin/member-edit";
    }
}

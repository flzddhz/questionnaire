package com.example.questionnaire.controller;

import com.example.questionnaire.entity.Account;
import com.example.questionnaire.service.AccountServicer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AccountController {

    @Resource
    private AccountServicer accountServicer;

    @RequestMapping("queryAcc")
    public String selectAccount(String fg,String custName, HttpServletRequest request){
        if (custName == null){
            custName = (String) request.getSession().getAttribute("custName");
            if (custName == null){
                custName = "";

            }
        }
        request.getSession().setAttribute("custName",custName);
        if (request.getSession().getAttribute("currPage") == null){
            request.getSession().setAttribute("currPage",1);
        }
        int currPage = (int) request.getSession().getAttribute("currPage");
        int page1 = (currPage -1) * 10;
        int accLine = accountServicer.accCount(custName);
        int allPage = (int) Math.ceil(accLine/10);

        if ("syy".equals(fg) && currPage > 1){
            currPage = currPage - 1;
        }else if("xyy".equals(fg) && currPage < allPage){
            currPage = currPage + 1;
        }
        List<Account> accountList = accountServicer.queryAccount(page1,10,custName);
        request.setAttribute("pageInfo",currPage + "/" + allPage);
        request.getSession().setAttribute("currPage",currPage);
        request.setAttribute("aList",accountList);
        return "admin/member-list";
    }

    @ResponseBody
    @RequestMapping("addAccount")
    public void addAccount(Account account){
        int i = accountServicer.insert(account);
    }
    @ResponseBody
    @RequestMapping("editAccount")
    public void editAccount(Account account){
        int i = accountServicer.update(account);
    }
    @ResponseBody
    @RequestMapping("delAccount")
    public void delAccount(Account account){
        int i = accountServicer.delAccount(account);
    }
    @ResponseBody
    @RequestMapping("delAllAccount")
    public void delAllAccount(String ids){
        for(int i = 0;i < ids.split(",").length;i++){
            Account account = new Account();
            account.setId(Integer.valueOf(ids.split(",")[i]));
            accountServicer.delAccount(account);
        }
    }
}

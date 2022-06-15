package com.example.questionnaire.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.questionnaire.entity.Account;

import java.util.List;

public interface AccountMapper extends BaseMapper<Account> {

    List<Account> queryAccount(int page1,int page2,String custName);

    int accCount(String custName);

}

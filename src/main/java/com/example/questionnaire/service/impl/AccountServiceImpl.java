package com.example.questionnaire.service.impl;

import com.example.questionnaire.dao.AccountMapper;
import com.example.questionnaire.entity.Account;
import com.example.questionnaire.service.AccountServicer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountServicer {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public int insert(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public int update(Account account) {
        return accountMapper.updateById(account);
    }

    @Override
    public List<Account> queryAccount(int page1, int page2,String custName) {
        return accountMapper.queryAccount(page1,page2,custName);
    }

    @Override
    public int accCount(String custName) {
        return accountMapper.accCount(custName);
    }

    @Override
    public int delAccount(Account account) {
        return accountMapper.deleteById(account.getId());
    }

}

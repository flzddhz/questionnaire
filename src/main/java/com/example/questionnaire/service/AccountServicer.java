package com.example.questionnaire.service;

import com.example.questionnaire.entity.Account;

import java.util.List;

public interface AccountServicer {

    int insert(Account account);

    int update(Account account);

    List<Account> queryAccount(int page1, int page2,String custName);

    int accCount(String custName);

    int delAccount(Account account);

    List<Account> queryAllAccount();

}

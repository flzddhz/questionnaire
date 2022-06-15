package com.example.questionnaire.service.impl;

import com.example.questionnaire.dao.AdminMapper;
import com.example.questionnaire.entity.Admin;
import com.example.questionnaire.service.AdminServier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminServier {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username) {
        return adminMapper.login(username);
    }
}

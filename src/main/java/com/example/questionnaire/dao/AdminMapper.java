package com.example.questionnaire.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.questionnaire.entity.Admin;

public interface AdminMapper extends BaseMapper<Admin> {

    Admin login(String username);
}

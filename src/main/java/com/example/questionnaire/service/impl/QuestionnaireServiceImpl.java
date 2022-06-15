package com.example.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.questionnaire.dao.QuestionnaireMapper;
import com.example.questionnaire.entity.Questionnaireinvestigation;
import com.example.questionnaire.service.QuestionnaireService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionnaireServiceImpl extends ServiceImpl<QuestionnaireMapper, Questionnaireinvestigation> implements QuestionnaireService {

    @Resource
    private QuestionnaireMapper questionnaireMapper;

    @Override
    public int insert(Questionnaireinvestigation questionnaireinvestigation) {
        return questionnaireMapper.insert(questionnaireinvestigation);
    }

    @Override
    public Questionnaireinvestigation findAll() {
        return questionnaireMapper.selectById(1);
    }
}

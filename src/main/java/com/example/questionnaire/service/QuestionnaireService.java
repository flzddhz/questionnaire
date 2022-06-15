package com.example.questionnaire.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.questionnaire.entity.Questionnaireinvestigation;


public interface QuestionnaireService  extends IService<Questionnaireinvestigation> {

    int insert(Questionnaireinvestigation questionnaireinvestigation);

    Questionnaireinvestigation findAll();
}

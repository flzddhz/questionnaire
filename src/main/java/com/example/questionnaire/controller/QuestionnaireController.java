package com.example.questionnaire.controller;

import com.example.questionnaire.config.LogConfig;
import com.example.questionnaire.entity.Questionnaireinvestigation;
import com.example.questionnaire.service.QuestionnaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
public class QuestionnaireController {

    @Resource
    private QuestionnaireService questionnaireService;
    private static final Logger logger = LoggerFactory.getLogger(LogConfig.class);
//    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @RequestMapping("ces")
    public String ces(){
        try {
            questionnaireService.findAll();
            return "sc";
        }catch (Exception e){
            e.printStackTrace();
            return "err";
        }
    }

    @RequestMapping("/insertQu")
    public String insertQu(Questionnaireinvestigation questionnaireinvestigation, HttpServletRequest request){
        String[] bumen = request.getParameterValues("department");
        if (bumen.length > 1){
            if(bumen[1] == null || bumen[1].trim().length() == 0){
                questionnaireinvestigation.setDepartment(bumen[0]);
            }else{
                questionnaireinvestigation.setDepartment(bumen[1]);
            }
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        questionnaireinvestigation.setFilling_date(new Date(System.currentTimeMillis()));
        logger.info("提交" + questionnaireinvestigation);
        try {
            boolean save = questionnaireService.save(questionnaireinvestigation);
            if (save == true){
                logger.info("成功！");
            }else{
                logger.info("失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "test";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}

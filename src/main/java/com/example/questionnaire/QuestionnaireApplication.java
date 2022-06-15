package com.example.questionnaire;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.spi.LocaleServiceProvider;

@SpringBootApplication
@MapperScan("com.example.questionnaire.dao")
public class QuestionnaireApplication extends SpringBootServletInitializer {  //继承servlet

    public static void main(String[] args) {
        SpringApplication.run(QuestionnaireApplication.class, args);
    }

    //打war包重写configure方法
//    @Override
//    public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
//        return builder.sources(QuestionnaireApplication.class);
//    }

}

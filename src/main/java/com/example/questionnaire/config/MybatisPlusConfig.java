package com.example.questionnaire.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("QuestionnaireMapper.mapper")
public class MybatisPlusConfig {

    @Bean
    public OracleKeyGenerator KeyGenerator(){
        return new OracleKeyGenerator();
    }

}

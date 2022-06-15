package com.example.questionnaire.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Account {
    @TableId(value = "id" ,type = IdType.INPUT)
    private Integer id;
    private String customer;
    private String email;
    private String state;
}

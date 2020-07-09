package com.example.spring_boot_mybatis.controller;

import com.example.spring_boot_mybatis.bean.Money;
import com.example.spring_boot_mybatis.db2.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("money")
public class MoneyController {
    @Autowired
    MoneyService moneyService;

    @RequestMapping("query")
    public Money testQuery() {
        return moneyService.selectMoneyById(1);
    }
}

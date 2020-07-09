package com.example.spring_boot_mybatis.db2.service;

import com.example.spring_boot_mybatis.bean.Money;
import com.example.spring_boot_mybatis.db2.dao.MoneyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyService {
    @Autowired
    private MoneyDao moneyDao;

    public Money selectMoneyById(Integer id) {
        return moneyDao.findMoneyById(id);
    }
}

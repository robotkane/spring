package com.example.spring_boot_mybatis.db1.service;

import com.example.spring_boot_mybatis.bean.User;
import com.example.spring_boot_mybatis.db1.dao.User2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User2Service {
    @Autowired
    private User2Dao userDao;

    public User selectUserByName(String name) {
        return userDao.findUserByName(name);
    }
}

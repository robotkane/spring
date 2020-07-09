package com.example.spring_boot_mybatis.controller;

import com.example.spring_boot_mybatis.bean.User;
import com.example.spring_boot_mybatis.db1.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user2")
public class User2Controller {
    @Autowired
    private User2Service userService;

    @RequestMapping("/query")
    public User testQuery() {
        return userService.selectUserByName("xiao 1");
    }
}

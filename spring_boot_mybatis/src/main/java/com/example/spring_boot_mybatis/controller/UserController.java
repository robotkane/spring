package com.example.spring_boot_mybatis.controller;

import com.example.spring_boot_mybatis.bean.User;
import com.example.spring_boot_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/query")
    public User testQuery() {
        return userService.selectUserByName("xiao 1");
    }

    @RequestMapping("/insert")
    public List<User> testInsert() {
        userService.insertService();
        return userService.selectAllUser();
    }

    @RequestMapping("/changemoney")
    public List<User> testChangeMoney() {
        userService.updateMoney();
        return userService.selectAllUser();
    }

    @RequestMapping("/delete")
    public List<User> testDelete() {
        userService.deleteService(1);
        return userService.selectAllUser();
    }
}

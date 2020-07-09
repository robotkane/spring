package com.example.spring_boot_filter_interceptor.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorTestController {
    @RequestMapping(value = {"/", "/test"})
    public String test(Model model) {
        System.out.println("test");
        return "test";
    }

    @Deprecated
    @RequestMapping(value = {"/admin/oldLogin"})
    public String oldLogin(Model model) {
        System.out.println("oldLogin");
        return "oldLogin";
    }

    @RequestMapping(value = {"/admin/login"})
    public String login(Model model) {
        System.out.println("login");
        return "login";
    }
}

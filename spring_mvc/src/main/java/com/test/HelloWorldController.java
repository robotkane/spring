package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    /*
     * 1、@RequestMapping除了可以修饰方法还可以修饰类
     * 2、类定义处相对于根目录，方法定义处相对于类
     * */
    @RequestMapping("/helloWorld")
    public String helloWorld() {
        System.out.println("helloWorld");
        return "success";
    }
}
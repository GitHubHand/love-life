package com.example.userservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
public class userController {
    @GetMapping("/test")
    public void test(){
        System.out.println("路由测试");
    }
}

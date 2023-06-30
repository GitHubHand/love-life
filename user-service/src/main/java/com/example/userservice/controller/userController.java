package com.example.userservice.controller;

import com.example.userservice.entity.userEntity;
import com.example.userservice.entity.userOrderEntity;
import com.example.userservice.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService userService;

    @GetMapping("/listUserAllInfo")
    public List<userEntity> listUserAllInfo() {
        return userService.listUserAllInfo();
    }
    @GetMapping(value = {"/listUserAndOrederInfoByUid/{uid}","/listUserAndOrederInfoByUid"})
    public List<userOrderEntity> listUserAndOrederInfo(@PathVariable(value = "uid",required = false) String uid) {
        return userService.listUserAndOrederInfo(uid);
    }
}

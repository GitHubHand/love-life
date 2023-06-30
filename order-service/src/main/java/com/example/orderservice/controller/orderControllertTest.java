package com.example.orderservice.controller;

import com.example.sharedservices.openfegin.user.UserOpenfeginApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@RequestMapping("/order")
@Controller
public class orderControllertTest {

    @Autowired
    private UserOpenfeginApi userOpenfeginApi;

    @GetMapping("/order")
    public String order(){
        String date = userOpenfeginApi.getDate();
        return date+"order";
    }

}

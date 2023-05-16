package com.example.orderservice.controller;

import com.example.orderservice.config.OpenFeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@RequestMapping("/order")
@Controller
public class orderController {

    @Autowired
    private OpenFeginService openFeginService;

    @GetMapping("/order")
    public String order(){
        String date = openFeginService.getDate();
        return date+"order";
    }

}

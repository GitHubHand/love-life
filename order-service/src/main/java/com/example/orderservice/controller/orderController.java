package com.example.orderservice.controller;

import com.example.orderservice.entity.orderEntity;
import com.example.orderservice.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/order")
public class orderController {

    @Autowired
    private orderService orderService;

        @GetMapping("/listOrderAllInfo")
        public List<orderEntity> listOrderAllInfo(){
            return orderService.listOrderAllInfo();
        }
        @GetMapping("listOrderInfoByUserId/{userId}")
         public List<orderEntity> listOrderInfoByUserId(@PathVariable("userId") String userId){
            return orderService.listOrderInfoByUserId(userId);
        }
}

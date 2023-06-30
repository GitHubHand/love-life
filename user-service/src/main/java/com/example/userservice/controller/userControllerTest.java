package com.example.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/test")
@ResponseBody
public class userControllerTest {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${pattern.dateformat}")
    private String dateformat;

    @GetMapping("/restTemplate")
    public String test() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("localhost:8080/test/getDate", String.class);
        return forEntity.getBody();
    }
    @GetMapping("/getDate")
    public  String getDate(){
        Instant now = Instant.now();
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat))+"        "+now.toString();
    }

    @GetMapping("/get")
    public String get(){
        int a=10/0;
        return "hello world";
    }
}
